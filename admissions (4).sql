-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 06, 2023 lúc 07:02 PM
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
  `id_category` bigint(20) NOT NULL,
  `name_subject` varchar(50) NOT NULL,
  `create_category` datetime NOT NULL,
  `modify_category` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `category_subject`
--

INSERT INTO `category_subject` (`id_category`, `name_subject`, `create_category`, `modify_category`) VALUES
(1, 'Toán', '2023-04-05 10:35:11', '2023-04-05 10:35:11'),
(2, 'Văn', '2023-04-05 10:35:11', '2023-04-05 10:35:11'),
(3, 'Tin', '2023-04-05 10:35:11', '2023-04-05 10:35:11'),
(4, 'Lý', '2023-04-05 10:35:11', '2023-04-05 10:35:11'),
(5, 'Hóa', '2023-04-05 10:35:11', '2023-04-05 10:35:11'),
(6, 'Sinh', '2023-04-05 10:35:11', '2023-04-05 10:35:11'),
(7, 'Anh', '2023-04-05 10:35:11', '2023-04-05 10:35:11'),
(8, 'Khoa học tự nhiên & Công nghệ', '2023-04-05 10:35:11', '2023-04-05 10:35:11'),
(9, 'Khoa học xã hội', '2023-04-05 10:35:11', '2023-04-05 10:35:11');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_account`
--

CREATE TABLE `sch_account` (
  `id_account` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT 0,
  `verify` varchar(255) DEFAULT NULL,
  `identifier_code` varchar(255) NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT 0,
  `role` varchar(50) NOT NULL DEFAULT 'USER',
  `create_account` datetime NOT NULL,
  `modify_account` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_account`
--

INSERT INTO `sch_account` (`id_account`, `email`, `password`, `status`, `verify`, `identifier_code`, `enable`, `role`, `create_account`, `modify_account`) VALUES
(2, 'dangvy22202@gmail.com', '{bcrypt}$2a$10$.NogaUgBeeG4WZvO8oOsNu/fE28s5emDsjX7N0KfV85BBvnqN8Ine', 0, '21c01cbb-5710-466b-9c06-c36bd52dbfcf', '079099015065', 0, 'USER', '2023-04-06 23:22:03', '2023-04-06 23:22:03'),
(3, 'dangvy2032@gmail.com', '{bcrypt}$2a$10$T6/7cniscCPlmq2uVe4WWett25SsU6ufr.znSdOMgwHZ5G6cEjGN2', 0, '1ba7a59a-d69f-45f0-b3f2-b9a0065078a6', '079099015067z', 0, 'USER', '2023-04-06 23:40:54', '2023-04-06 23:40:54'),
(4, 'dangvy202@gmail.comasda', '{bcrypt}$2a$10$MkBPg2Mo/Oob3cIcxcZ0ouLoaP13tvqsb8EMRAgKNYGMdRX4yQL/i', 0, '5a2ebc59-5d9b-4047-ade9-39d9984a42bc', '079099015067asdad', 0, 'USER', '2023-04-06 23:45:55', '2023-04-06 23:45:55'),
(5, 'dangvy202@gmail.com', '{bcrypt}$2a$10$WrSMc.xZOOz2EiBebN8PQeeUsl9xzzsMmlS85L9KwOUN1kWpkKlDG', 0, '57dee8d4-d48b-48eb-975b-7fc7c55b38ca', '079099015067', 0, 'USER', '2023-04-06 23:52:05', '2023-04-06 23:52:05');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_application_form`
--

CREATE TABLE `sch_application_form` (
  `id_application` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `id_report` bigint(20) NOT NULL,
  `id_option` bigint(20) NOT NULL,
  `id_class` bigint(20) NOT NULL,
  `id_enroll` bigint(20) NOT NULL,
  `create_application` datetime NOT NULL,
  `modify_application` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_application_form`
--

INSERT INTO `sch_application_form` (`id_application`, `id_user`, `id_report`, `id_option`, `id_class`, `id_enroll`, `create_application`, `modify_application`) VALUES
(1, 1, 1, 1, 1, 1, '2023-04-06 08:53:41', '2023-04-06 08:53:41'),
(2, 2, 2, 2, 2, 2, '2023-04-06 09:15:35', '2023-04-06 09:15:35'),
(3, 3, 3, 3, 3, 3, '2023-04-06 09:20:17', '2023-04-06 09:20:17'),
(4, 4, 4, 4, 4, 4, '2023-04-06 09:24:31', '2023-04-06 09:24:31'),
(5, 5, 5, 5, 5, 5, '2023-04-06 09:24:31', '2023-04-06 09:24:31'),
(6, 6, 6, 6, 6, 6, '2023-04-06 14:25:10', '2023-04-06 14:25:10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_enroll_student`
--

CREATE TABLE `sch_enroll_student` (
  `id_enroll` bigint(20) NOT NULL,
  `math` tinyint(1) NOT NULL DEFAULT 1,
  `literature` tinyint(1) NOT NULL DEFAULT 1,
  `english` tinyint(1) NOT NULL DEFAULT 1,
  `other_subject_1th` text NOT NULL,
  `other_subject_2th` text NOT NULL,
  `id_report` bigint(20) NOT NULL,
  `create_enroll` datetime NOT NULL,
  `modify_enroll` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_enroll_student`
--

INSERT INTO `sch_enroll_student` (`id_enroll`, `math`, `literature`, `english`, `other_subject_1th`, `other_subject_2th`, `id_report`, `create_enroll`, `modify_enroll`) VALUES
(1, 1, 1, 1, '[Toan, Ly1]', '[Anh, Cong Nghe2]', 1, '2023-04-05 16:27:41', '2023-04-05 16:27:41'),
(2, 1, 1, 1, '[Toan, Ly1]', '[Anh, Cong Nghe2]', 2, '2023-04-05 21:46:42', '2023-04-05 21:46:42'),
(3, 1, 1, 1, '[Toan, Ly1]', '[Anh, Cong Nghe2]', 3, '2023-04-06 14:19:43', '2023-04-06 14:19:43'),
(4, 1, 1, 1, '[Toan, Ly1]', '[Anh, Cong Nghe2]', 4, '2023-04-06 14:20:36', '2023-04-06 14:20:36'),
(5, 1, 1, 1, '[Toan, Ly1]', '[Anh, Cong Nghe2]', 5, '2023-04-06 14:21:50', '2023-04-06 14:21:50'),
(6, 1, 1, 1, '[Toan, Ly1]', '[Anh, Cong Nghe2]', 6, '2023-04-06 14:25:10', '2023-04-06 14:25:10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_info_class`
--

CREATE TABLE `sch_info_class` (
  `id_class` bigint(20) NOT NULL,
  `6th_grade` tinyint(1) NOT NULL,
  `7th_grade` tinyint(1) NOT NULL,
  `8th_grade` tinyint(1) NOT NULL,
  `9th_grade` tinyint(1) NOT NULL,
  `conduct_certificate` tinyint(1) NOT NULL,
  `id_report` bigint(20) NOT NULL,
  `create_info_class` datetime NOT NULL,
  `modify_info_class` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_info_class`
--

INSERT INTO `sch_info_class` (`id_class`, `6th_grade`, `7th_grade`, `8th_grade`, `9th_grade`, `conduct_certificate`, `id_report`, `create_info_class`, `modify_info_class`) VALUES
(1, 1, 1, 1, 0, 1, 1, '2023-04-05 16:27:41', '2023-04-05 16:27:41'),
(2, 1, 1, 1, 0, 1, 2, '2023-04-05 21:46:42', '2023-04-05 21:46:42'),
(3, 1, 1, 1, 0, 1, 3, '2023-04-06 14:19:43', '2023-04-06 14:19:43'),
(4, 1, 1, 1, 0, 1, 4, '2023-04-06 14:20:36', '2023-04-06 14:20:36'),
(5, 1, 1, 1, 0, 1, 5, '2023-04-06 14:21:49', '2023-04-06 14:21:49'),
(6, 1, 1, 1, 0, 1, 6, '2023-04-06 14:25:10', '2023-04-06 14:25:10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_option_student`
--

CREATE TABLE `sch_option_student` (
  `id_option` bigint(20) NOT NULL,
  `aspiration_1th` text NOT NULL,
  `aspiration_2th` text NOT NULL,
  `aspiration_3th` text NOT NULL,
  `aspiration_4th` text NOT NULL,
  `aspiration_5th` text NOT NULL,
  `id_report` bigint(20) NOT NULL,
  `create_option` datetime NOT NULL,
  `modify_option` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_option_student`
--

INSERT INTO `sch_option_student` (`id_option`, `aspiration_1th`, `aspiration_2th`, `aspiration_3th`, `aspiration_4th`, `aspiration_5th`, `id_report`, `create_option`, `modify_option`) VALUES
(1, 'Toán', 'Văn', 'Lý', 'Anh', 'Khoa học xã hội', 1, '2023-04-05 16:27:45', '2023-04-05 16:27:45'),
(2, 'Toán', 'Văn', 'Lý', 'Anh', 'Khoa học xã hội', 2, '2023-04-05 21:48:14', '2023-04-05 21:48:14'),
(3, 'Toán', 'Văn', 'Lý', 'Anh', 'Khoa học xã hội', 3, '2023-04-06 14:19:47', '2023-04-06 14:19:47'),
(4, 'Toán', 'Văn', 'Lý', 'Anh', 'Khoa học xã hội', 4, '2023-04-06 14:20:38', '2023-04-06 14:20:38'),
(5, 'Toán', 'Văn', 'Lý', 'Anh', 'Khoa học xã hội', 5, '2023-04-06 14:21:50', '2023-04-06 14:21:50'),
(6, 'Toán', 'Văn', 'Lý', 'Anh', 'Khoa học xã hội', 6, '2023-04-06 14:25:10', '2023-04-06 14:25:10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_student_report`
--

CREATE TABLE `sch_student_report` (
  `id_report` bigint(20) NOT NULL,
  `school_passed` text NOT NULL,
  `school_address` text NOT NULL,
  `academic_ability` tinyint(1) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `create_report` datetime NOT NULL,
  `modify_report` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_student_report`
--

INSERT INTO `sch_student_report` (`id_report`, `school_passed`, `school_address`, `academic_ability`, `id_user`, `create_report`, `modify_report`) VALUES
(1, 'Phu Nhua3n', 'Phu Nhua3n', 1, 1, '2023-04-05 16:27:41', '2023-04-05 16:27:41'),
(2, 'Phu Nhua3n', 'Phu Nhua3n', 1, 2, '2023-04-05 21:46:42', '2023-04-05 21:46:42'),
(3, 'Phu Nhua3n', 'Phu Nhua3n', 1, 3, '2023-04-06 14:19:43', '2023-04-06 14:19:43'),
(4, 'Phu Nhua3n', 'Phu Nhua3n', 1, 4, '2023-04-06 14:20:36', '2023-04-06 14:20:36'),
(5, 'Phu Nhua3n', 'Phu Nhua3n', 1, 5, '2023-04-06 14:21:49', '2023-04-06 14:21:49'),
(6, 'Phu Nhua3n', 'Phu Nhua3n', 1, 6, '2023-04-06 14:25:10', '2023-04-06 14:25:10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_user`
--

CREATE TABLE `sch_user` (
  `id_user` bigint(20) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `address` text NOT NULL,
  `birthday` date NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `ethnicity` varchar(100) NOT NULL,
  `identify_info` varchar(150) NOT NULL,
  `nationality` varchar(100) NOT NULL,
  `phone_number` varchar(150) NOT NULL,
  `landline_phone_number` varchar(150) NOT NULL,
  `option_phone` varchar(50) NOT NULL,
  `create_account` datetime NOT NULL,
  `modify_account` datetime NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `verify` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_user`
--

INSERT INTO `sch_user` (`id_user`, `first_name`, `last_name`, `address`, `birthday`, `sex`, `ethnicity`, `identify_info`, `nationality`, `phone_number`, `landline_phone_number`, `option_phone`, `create_account`, `modify_account`, `email`, `password`, `verify`) VALUES
(1, 'test32', 'testto32', '1123423532/45454 le van si2', '1999-02-20', 1, 'Kinh2', '0790990150672', 'vietNam2', '07085178562', '09085178562', 'dad2', '2023-04-05 16:27:41', '2023-04-05 16:27:41', NULL, NULL, NULL),
(2, 'test32', 'testto32', '1123423532/45454 le van si2', '1999-02-20', 1, 'Kinh2', '0790990150672', 'vietNam2', '07085178562', '09085178562', 'dad2', '2023-04-05 21:46:42', '2023-04-05 21:46:42', NULL, NULL, NULL),
(3, 'test32', 'testto32', '1123423532/45454 le van si2', '1999-02-20', 1, 'Kinh2', '0790990150672', 'vietNam2', '07085178562', '09085178562', 'dad2', '2023-04-06 14:19:43', '2023-04-06 14:19:43', NULL, NULL, NULL),
(4, 'test32', 'testto32', '1123423532/45454 le van si2', '1999-02-20', 1, 'Kinh2', '0790990150672', 'vietNam2', '07085178562', '09085178562', 'dad2', '2023-04-06 14:20:36', '2023-04-06 14:20:36', NULL, NULL, NULL),
(5, 'test32', 'testto32', '1123423532/45454 le van si2', '1999-02-20', 1, 'Kinh2', '0790990150672', 'vietNam2', '07085178562', '09085178562', 'dad2', '2023-04-06 14:21:38', '2023-04-06 14:21:38', NULL, NULL, NULL),
(6, 'test32', 'testto32', '1123423532/45454 le van si2', '1999-02-20', 1, 'Kinh2', '0790990150672', 'vietNam2', '07085178562', '09085178562', 'dad2', '2023-04-06 14:25:10', '2023-04-06 14:25:10', NULL, NULL, NULL);

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
  ADD KEY `application_user` (`id_user`),
  ADD KEY `application_report` (`id_report`),
  ADD KEY `application_option` (`id_option`),
  ADD KEY `application_class` (`id_class`),
  ADD KEY `application_enroll` (`id_enroll`);

--
-- Chỉ mục cho bảng `sch_enroll_student`
--
ALTER TABLE `sch_enroll_student`
  ADD PRIMARY KEY (`id_enroll`),
  ADD KEY `enroll_report` (`id_report`);

--
-- Chỉ mục cho bảng `sch_info_class`
--
ALTER TABLE `sch_info_class`
  ADD PRIMARY KEY (`id_class`),
  ADD KEY `class_report` (`id_report`);

--
-- Chỉ mục cho bảng `sch_option_student`
--
ALTER TABLE `sch_option_student`
  ADD PRIMARY KEY (`id_option`),
  ADD KEY `option_report` (`id_report`);

--
-- Chỉ mục cho bảng `sch_student_report`
--
ALTER TABLE `sch_student_report`
  ADD PRIMARY KEY (`id_report`),
  ADD KEY `report_user` (`id_user`);

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
  MODIFY `id_category` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `sch_account`
--
ALTER TABLE `sch_account`
  MODIFY `id_account` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `sch_application_form`
--
ALTER TABLE `sch_application_form`
  MODIFY `id_application` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `sch_enroll_student`
--
ALTER TABLE `sch_enroll_student`
  MODIFY `id_enroll` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `sch_info_class`
--
ALTER TABLE `sch_info_class`
  MODIFY `id_class` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `sch_option_student`
--
ALTER TABLE `sch_option_student`
  MODIFY `id_option` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `sch_student_report`
--
ALTER TABLE `sch_student_report`
  MODIFY `id_report` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `sch_user`
--
ALTER TABLE `sch_user`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `sch_application_form`
--
ALTER TABLE `sch_application_form`
  ADD CONSTRAINT `application_class` FOREIGN KEY (`id_class`) REFERENCES `sch_info_class` (`id_class`),
  ADD CONSTRAINT `application_enroll` FOREIGN KEY (`id_enroll`) REFERENCES `sch_enroll_student` (`id_enroll`),
  ADD CONSTRAINT `application_option` FOREIGN KEY (`id_option`) REFERENCES `sch_option_student` (`id_option`),
  ADD CONSTRAINT `application_report` FOREIGN KEY (`id_report`) REFERENCES `sch_student_report` (`id_report`),
  ADD CONSTRAINT `application_user` FOREIGN KEY (`id_user`) REFERENCES `sch_user` (`id_user`);

--
-- Các ràng buộc cho bảng `sch_enroll_student`
--
ALTER TABLE `sch_enroll_student`
  ADD CONSTRAINT `enroll_report` FOREIGN KEY (`id_report`) REFERENCES `sch_student_report` (`id_report`);

--
-- Các ràng buộc cho bảng `sch_info_class`
--
ALTER TABLE `sch_info_class`
  ADD CONSTRAINT `class_report` FOREIGN KEY (`id_report`) REFERENCES `sch_student_report` (`id_report`);

--
-- Các ràng buộc cho bảng `sch_option_student`
--
ALTER TABLE `sch_option_student`
  ADD CONSTRAINT `option_report` FOREIGN KEY (`id_report`) REFERENCES `sch_student_report` (`id_report`);

--
-- Các ràng buộc cho bảng `sch_student_report`
--
ALTER TABLE `sch_student_report`
  ADD CONSTRAINT `report_user` FOREIGN KEY (`id_user`) REFERENCES `sch_user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
