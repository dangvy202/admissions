-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 24, 2023 lúc 07:09 AM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `admissions`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category_subject`
--

CREATE TABLE `category_subject` (
  `id_category` int(11) NOT NULL,
  `create_category` datetime(6) DEFAULT NULL,
  `modify_category` datetime(6) DEFAULT NULL,
  `name_subject` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_account`
--

CREATE TABLE `sch_account` (
  `id_account` bigint(20) NOT NULL,
  `create_account` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `identifier_code` varchar(255) DEFAULT NULL,
  `modify_account` datetime(6) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `verify` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_account`
--

INSERT INTO `sch_account` (`id_account`, `create_account`, `email`, `enable`, `identifier_code`, `modify_account`, `password`, `role`, `status`, `verify`) VALUES
(1, '2023-04-24 11:48:10.000000', 'dangvy202@gmailcom', 1, '079099015067', '2023-04-24 11:48:10.000000', '$2a$10$wjZvgA7EcX0E5fb4xlYsyO4ErJL8fAJaYGBESTGNd9V.3PP9Io1BC', 'USER', 1, '2c0e5277-d654-4b00-a38e-f9ee301751e4');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_application_form`
--

CREATE TABLE `sch_application_form` (
  `id_application` bigint(20) NOT NULL,
  `create_application` datetime(6) DEFAULT NULL,
  `modify_application` datetime(6) DEFAULT NULL,
  `id_account` bigint(20) NOT NULL,
  `id_enroll` bigint(20) NOT NULL,
  `id_class` bigint(20) NOT NULL,
  `id_option` bigint(20) NOT NULL,
  `id_report` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `id_subject` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_application_form`
--

INSERT INTO `sch_application_form` (`id_application`, `create_application`, `modify_application`, `id_account`, `id_enroll`, `id_class`, `id_option`, `id_report`, `id_user`, `id_subject`) VALUES
(1, '2023-04-24 11:51:12.000000', '2023-04-24 11:51:12.000000', 1, 1, 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_enroll_student`
--

CREATE TABLE `sch_enroll_student` (
  `id_enroll` bigint(20) NOT NULL,
  `create_enroll` datetime(6) DEFAULT NULL,
  `modify_enroll` datetime(6) DEFAULT NULL,
  `other_subject_1th` varchar(255) DEFAULT NULL,
  `other_subject_2th` varchar(255) DEFAULT NULL,
  `id_report` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_enroll_student`
--

INSERT INTO `sch_enroll_student` (`id_enroll`, `create_enroll`, `modify_enroll`, `other_subject_1th`, `other_subject_2th`, `id_report`) VALUES
(1, '2023-04-24 11:51:10.000000', '2023-04-24 11:51:10.000000', '[]', '[]', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_img_infomation`
--

CREATE TABLE `sch_img_infomation` (
  `id_img` bigint(20) NOT NULL,
  `name_img` varchar(255) DEFAULT NULL,
  `name_path_back` longblob DEFAULT NULL,
  `name_path_front` longblob DEFAULT NULL,
  `name_path_user` longblob DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `id_account` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_info_class`
--

CREATE TABLE `sch_info_class` (
  `id_class` bigint(20) NOT NULL,
  `conduct_certificate_6th` int(11) DEFAULT NULL,
  `conduct_certificate_7th` int(11) DEFAULT NULL,
  `conduct_certificate_8th` int(11) DEFAULT NULL,
  `conduct_certificate_9th` int(11) DEFAULT NULL,
  `create_info_class` datetime(6) DEFAULT NULL,
  `6th_grade` int(11) DEFAULT NULL,
  `7th_grade` int(11) DEFAULT NULL,
  `8th_grade` int(11) DEFAULT NULL,
  `9th_grade` int(11) DEFAULT NULL,
  `modify_info_class` datetime(6) DEFAULT NULL,
  `id_report` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_info_class`
--

INSERT INTO `sch_info_class` (`id_class`, `conduct_certificate_6th`, `conduct_certificate_7th`, `conduct_certificate_8th`, `conduct_certificate_9th`, `create_info_class`, `6th_grade`, `7th_grade`, `8th_grade`, `9th_grade`, `modify_info_class`, `id_report`) VALUES
(1, 0, 0, 0, 0, '2023-04-24 11:51:10.000000', 0, 0, 0, 0, '2023-04-24 11:51:10.000000', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_option_student`
--

CREATE TABLE `sch_option_student` (
  `id_option` bigint(20) NOT NULL,
  `biology` int(11) DEFAULT NULL,
  `biology_biology_ln` int(11) DEFAULT NULL,
  `biology_math_ln` int(11) DEFAULT NULL,
  `chemistry` int(11) DEFAULT NULL,
  `chemistry_chemistry_ln` int(11) DEFAULT NULL,
  `chemistry_math_ln` int(11) DEFAULT NULL,
  `create_option` datetime(6) DEFAULT NULL,
  `english` int(11) DEFAULT NULL,
  `english_ln` int(11) DEFAULT NULL,
  `informatics_informatics` int(11) DEFAULT NULL,
  `informatics_math` int(11) DEFAULT NULL,
  `literature` int(11) DEFAULT NULL,
  `literature_ln` int(11) DEFAULT NULL,
  `math` int(11) DEFAULT NULL,
  `math_ln` int(11) DEFAULT NULL,
  `modify_option` datetime(6) DEFAULT NULL,
  `physics_math` int(11) DEFAULT NULL,
  `physics_math_ln` int(11) DEFAULT NULL,
  `physics_physics` int(11) DEFAULT NULL,
  `physics_physics_ln` int(11) DEFAULT NULL,
  `id_report` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_option_student`
--

INSERT INTO `sch_option_student` (`id_option`, `biology`, `biology_biology_ln`, `biology_math_ln`, `chemistry`, `chemistry_chemistry_ln`, `chemistry_math_ln`, `create_option`, `english`, `english_ln`, `informatics_informatics`, `informatics_math`, `literature`, `literature_ln`, `math`, `math_ln`, `modify_option`, `physics_math`, `physics_math_ln`, `physics_physics`, `physics_physics_ln`, `id_report`) VALUES
(1, 0, 0, 0, 0, 0, 3, '2023-04-24 11:51:10.000000', 0, 0, 1, 2, 0, 0, 0, 0, '2023-04-24 11:51:10.000000', 0, 4, 0, 0, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_payment`
--

CREATE TABLE `sch_payment` (
  `id_payment` bigint(20) NOT NULL,
  `amount` double DEFAULT NULL,
  `create_payment` datetime(6) DEFAULT NULL,
  `modify_payment` datetime(6) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `id_account` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_payment`
--

INSERT INTO `sch_payment` (`id_payment`, `amount`, `create_payment`, `modify_payment`, `status`, `id_account`) VALUES
(1, 1800000, '2023-04-24 11:51:10.000000', '2023-04-24 11:51:10.000000', 0, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_student_report`
--

CREATE TABLE `sch_student_report` (
  `id_report` bigint(20) NOT NULL,
  `academic_ability` int(11) DEFAULT NULL,
  `create_report` datetime(6) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `modify_report` datetime(6) DEFAULT NULL,
  `name_class` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `school_address` varchar(255) DEFAULT NULL,
  `school_passed` varchar(255) DEFAULT NULL,
  `ward` varchar(255) DEFAULT NULL,
  `id_user` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_student_report`
--

INSERT INTO `sch_student_report` (`id_report`, `academic_ability`, `create_report`, `district`, `modify_report`, `name_class`, `province`, `school_address`, `school_passed`, `ward`, `id_user`) VALUES
(1, 0, '2023-04-24 11:51:10.000000', '', '2023-04-24 11:51:10.000000', '9A6', '', '', '', '', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_subject`
--

CREATE TABLE `sch_subject` (
  `id_subject` bigint(20) NOT NULL,
  `biology` int(11) DEFAULT NULL,
  `chemistry` int(11) DEFAULT NULL,
  `english` int(11) DEFAULT NULL,
  `informatics` int(11) DEFAULT NULL,
  `literature` int(11) DEFAULT NULL,
  `math` int(11) DEFAULT NULL,
  `physics` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_subject`
--

INSERT INTO `sch_subject` (`id_subject`, `biology`, `chemistry`, `english`, `informatics`, `literature`, `math`, `physics`) VALUES
(1, 0, 1, 0, 0, 0, 1, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_user`
--

CREATE TABLE `sch_user` (
  `id_user` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birthday` datetime(6) DEFAULT NULL,
  `create_account` datetime(6) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `ethnicity` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `identify_info` varchar(255) DEFAULT NULL,
  `landline_phone_number` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `modify_account` datetime(6) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `option_phone` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `place_of_birth` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `ward` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_user`
--

INSERT INTO `sch_user` (`id_user`, `address`, `birthday`, `create_account`, `district`, `ethnicity`, `first_name`, `identify_info`, `landline_phone_number`, `last_name`, `modify_account`, `nationality`, `option_phone`, `phone_number`, `place_of_birth`, `province`, `sex`, `ward`) VALUES
(1, '    ', NULL, '2023-04-24 11:51:10.000000', '', '', '', '0790990150672', '', '', '2023-04-24 11:51:10.000000', 'Vietnam', '', '', '', '', 0, '');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `category_subject`
--
ALTER TABLE `category_subject`
  ADD PRIMARY KEY (`id_category`);

--
-- Chỉ mục cho bảng `sch_account`
--
ALTER TABLE `sch_account`
  ADD PRIMARY KEY (`id_account`);

--
-- Chỉ mục cho bảng `sch_application_form`
--
ALTER TABLE `sch_application_form`
  ADD PRIMARY KEY (`id_application`),
  ADD KEY `FKps10c89ne3cvu0u3p0ythhvw4` (`id_account`),
  ADD KEY `FKjswhslaxanhryigbhpaun7dx5` (`id_enroll`),
  ADD KEY `FK78y0xhw6chpsarje9459obm51` (`id_class`),
  ADD KEY `FKc6umaiweuym12fq0y6voylgx1` (`id_option`),
  ADD KEY `FKfinesitehm8xb6wcaayh1skox` (`id_report`),
  ADD KEY `FK3jrd1i61y7aq4t4ikluxhk1w0` (`id_user`),
  ADD KEY `FK4wvn9jh3ymwhwfqf5ike6hedd` (`id_subject`);

--
-- Chỉ mục cho bảng `sch_enroll_student`
--
ALTER TABLE `sch_enroll_student`
  ADD PRIMARY KEY (`id_enroll`),
  ADD UNIQUE KEY `UK_exwx3k8a0qvr47novecil2od6` (`id_report`);

--
-- Chỉ mục cho bảng `sch_img_infomation`
--
ALTER TABLE `sch_img_infomation`
  ADD PRIMARY KEY (`id_img`),
  ADD UNIQUE KEY `UK_s2ywwlqrylxvytpuaie2x9y5q` (`id_account`);

--
-- Chỉ mục cho bảng `sch_info_class`
--
ALTER TABLE `sch_info_class`
  ADD PRIMARY KEY (`id_class`),
  ADD UNIQUE KEY `UK_glue84utgpja11si7h4ja34gi` (`id_report`);

--
-- Chỉ mục cho bảng `sch_option_student`
--
ALTER TABLE `sch_option_student`
  ADD PRIMARY KEY (`id_option`),
  ADD UNIQUE KEY `UK_kd95a7x37i2htu7tg1ss8mp03` (`id_report`);

--
-- Chỉ mục cho bảng `sch_payment`
--
ALTER TABLE `sch_payment`
  ADD PRIMARY KEY (`id_payment`),
  ADD UNIQUE KEY `UK_91q58luc2i1587flotf77s56q` (`id_account`);

--
-- Chỉ mục cho bảng `sch_student_report`
--
ALTER TABLE `sch_student_report`
  ADD PRIMARY KEY (`id_report`),
  ADD UNIQUE KEY `UK_hu8may0xoiu7krgwhaywipv08` (`id_user`);

--
-- Chỉ mục cho bảng `sch_subject`
--
ALTER TABLE `sch_subject`
  ADD PRIMARY KEY (`id_subject`);

--
-- Chỉ mục cho bảng `sch_user`
--
ALTER TABLE `sch_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `category_subject`
--
ALTER TABLE `category_subject`
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `sch_account`
--
ALTER TABLE `sch_account`
  MODIFY `id_account` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `sch_application_form`
--
ALTER TABLE `sch_application_form`
  MODIFY `id_application` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `sch_enroll_student`
--
ALTER TABLE `sch_enroll_student`
  MODIFY `id_enroll` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `sch_img_infomation`
--
ALTER TABLE `sch_img_infomation`
  MODIFY `id_img` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `sch_info_class`
--
ALTER TABLE `sch_info_class`
  MODIFY `id_class` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `sch_option_student`
--
ALTER TABLE `sch_option_student`
  MODIFY `id_option` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `sch_payment`
--
ALTER TABLE `sch_payment`
  MODIFY `id_payment` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `sch_student_report`
--
ALTER TABLE `sch_student_report`
  MODIFY `id_report` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `sch_subject`
--
ALTER TABLE `sch_subject`
  MODIFY `id_subject` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `sch_user`
--
ALTER TABLE `sch_user`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `sch_application_form`
--
ALTER TABLE `sch_application_form`
  ADD CONSTRAINT `FK3jrd1i61y7aq4t4ikluxhk1w0` FOREIGN KEY (`id_user`) REFERENCES `sch_user` (`id_user`),
  ADD CONSTRAINT `FK4wvn9jh3ymwhwfqf5ike6hedd` FOREIGN KEY (`id_subject`) REFERENCES `sch_subject` (`id_subject`),
  ADD CONSTRAINT `FK78y0xhw6chpsarje9459obm51` FOREIGN KEY (`id_class`) REFERENCES `sch_info_class` (`id_class`),
  ADD CONSTRAINT `FKc6umaiweuym12fq0y6voylgx1` FOREIGN KEY (`id_option`) REFERENCES `sch_option_student` (`id_option`),
  ADD CONSTRAINT `FKfinesitehm8xb6wcaayh1skox` FOREIGN KEY (`id_report`) REFERENCES `sch_student_report` (`id_report`),
  ADD CONSTRAINT `FKjswhslaxanhryigbhpaun7dx5` FOREIGN KEY (`id_enroll`) REFERENCES `sch_enroll_student` (`id_enroll`),
  ADD CONSTRAINT `FKps10c89ne3cvu0u3p0ythhvw4` FOREIGN KEY (`id_account`) REFERENCES `sch_account` (`id_account`);

--
-- Các ràng buộc cho bảng `sch_enroll_student`
--
ALTER TABLE `sch_enroll_student`
  ADD CONSTRAINT `FKopxc8o3t3c8cbfhfywxbfbs8v` FOREIGN KEY (`id_report`) REFERENCES `sch_student_report` (`id_report`);

--
-- Các ràng buộc cho bảng `sch_img_infomation`
--
ALTER TABLE `sch_img_infomation`
  ADD CONSTRAINT `FK5pmkttfgphgy3duqb8dju86cx` FOREIGN KEY (`id_account`) REFERENCES `sch_account` (`id_account`);

--
-- Các ràng buộc cho bảng `sch_info_class`
--
ALTER TABLE `sch_info_class`
  ADD CONSTRAINT `FK4uncqg5hk0phfbruf5wftdpet` FOREIGN KEY (`id_report`) REFERENCES `sch_student_report` (`id_report`);

--
-- Các ràng buộc cho bảng `sch_option_student`
--
ALTER TABLE `sch_option_student`
  ADD CONSTRAINT `FKqelcnrt1ie08y0p2tm1igg3yt` FOREIGN KEY (`id_report`) REFERENCES `sch_student_report` (`id_report`);

--
-- Các ràng buộc cho bảng `sch_payment`
--
ALTER TABLE `sch_payment`
  ADD CONSTRAINT `FKg9movs0cs4b5m8v1d0xcvsui1` FOREIGN KEY (`id_account`) REFERENCES `sch_account` (`id_account`);

--
-- Các ràng buộc cho bảng `sch_student_report`
--
ALTER TABLE `sch_student_report`
  ADD CONSTRAINT `FKs71l48l3ba0flni6n6qvg3h43` FOREIGN KEY (`id_user`) REFERENCES `sch_user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
