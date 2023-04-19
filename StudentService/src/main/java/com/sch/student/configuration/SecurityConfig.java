package com.sch.student.configuration;

import com.sch.student.entity.UserDetail;
import com.sch.student.repository.AccountRepository;
import com.sch.student.security.JwtTokenAuthenticationFilter;
import com.sch.student.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain springWebFilterChain(HttpSecurity http,
                                             JwtTokenProvider tokenProvider) throws Exception {
        return http
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(c -> c.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(c -> c.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .authorizeHttpRequests(authorize -> authorize
//                       ACCOUNT DONT NEED TOKEN
                        .requestMatchers(HttpMethod.POST,"/account/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/account/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/register/verify").permitAll()
                        //NEED TOKEN
                        .requestMatchers(HttpMethod.POST, "/admission/**").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/admission/**").hasRole("USER")
//                        .requestMatchers(HttpMethod.GET, "/admission/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new JwtTokenAuthenticationFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    UserDetailsService customUserDetailsService(AccountRepository users) {
        return
                (username) -> (UserDetails) users.findIdentifierCodeAccount(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager customAuthenticationManager(UserDetailsService userDetailsService, PasswordEncoder encoder) {
//    AuthenticationManager customAuthenticationManager(UserDetailsService userDetailsService) {
        return authentication -> {
            String username = authentication.getPrincipal() + "";
            String password = (String) authentication.getCredentials();

            UserDetails user = userDetailsService.loadUserByUsername(username);

            //check password
            if (!encoder.matches(password,user.getPassword())) {
                throw new BadCredentialsException("Bad credentials");
            }

            //check enable
            if (((UserDetail) user).getAccount().getEnable() == 0) {
                throw new DisabledException("User account is not active");
            }

            //check status
            if(((UserDetail) user).getAccount().getStatus() == 0){
                throw new DisabledException("User account is not active");
            }

            return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
        };
    }
}
