package com.sch.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "sch_img_infomation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ImgInfomationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_img")
    private Long id;

    @Column(name = "name_path_front" , columnDefinition = "LONGBLOB")
    @Lob
    private byte[] namePathFront;

    @Column(name = "name_path_back", columnDefinition = "LONGBLOB")
    @Lob
    private byte[] namePathBack;

    @Column(name = "name_path_user", columnDefinition = "LONGBLOB")
    @Lob
    private byte[] namePathUser;

    @Column(name = "type")
    private String type;

    @Column(name = "name_img")
    private String nameImg;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_account" , nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JsonUnwrapped
    private AccountEntity account;
}
