-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 11, 2023 lúc 11:04 AM
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
  `name_subject` varchar(255) DEFAULT NULL,
  `create_category` datetime(6) DEFAULT NULL,
  `modify_category` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `category_subject`
--

INSERT INTO `category_subject` (`id_category`, `name_subject`, `create_category`, `modify_category`) VALUES
(1, 'Toán', '2023-04-05 10:35:11.000000', '2023-04-05 10:35:11.000000'),
(2, 'Văn', '2023-04-05 10:35:11.000000', '2023-04-05 10:35:11.000000'),
(3, 'Tin', '2023-04-05 10:35:11.000000', '2023-04-05 10:35:11.000000'),
(4, 'Lý', '2023-04-05 10:35:11.000000', '2023-04-05 10:35:11.000000'),
(5, 'Hóa', '2023-04-05 10:35:11.000000', '2023-04-05 10:35:11.000000'),
(6, 'Sinh', '2023-04-05 10:35:11.000000', '2023-04-05 10:35:11.000000'),
(7, 'Anh', '2023-04-05 10:35:11.000000', '2023-04-05 10:35:11.000000'),
(8, 'LỚP TOÁN CS1', '2023-04-05 10:35:11.000000', '2023-04-05 10:35:11.000000'),
(9, 'LỚP VĂN CS1', '2023-04-05 10:35:11.000000', '2023-04-05 10:35:11.000000'),
(10, 'LỚP TIN CS1', NULL, NULL),
(11, 'LỚP LÝ CS1', NULL, NULL),
(12, 'LỚP HÓA CS1', NULL, NULL),
(13, 'LỚP SINH CS1', NULL, NULL),
(14, 'LỚP ANH CS1', NULL, NULL),
(15, 'LỚP TOÁN CS2', NULL, NULL),
(16, 'LỚP VĂN CS2', NULL, NULL),
(17, 'LỚP LÝ CS2', NULL, NULL),
(18, 'LỚP HÓA CS2', NULL, NULL),
(19, 'LỚP SINH CS2', NULL, NULL),
(20, 'LỚP ANH CS2', NULL, NULL),
(21, 'KHÔNG CHỌN NGUYỆN VỌNG NÀY', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_account`
--

CREATE TABLE `sch_account` (
  `id_account` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `verify` varchar(255) DEFAULT NULL,
  `identifier_code` varchar(255) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `create_account` datetime(6) DEFAULT NULL,
  `modify_account` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_account`
--

INSERT INTO `sch_account` (`id_account`, `email`, `password`, `status`, `verify`, `identifier_code`, `enable`, `role`, `create_account`, `modify_account`) VALUES
(2, 'dangvy22202@gmail.com', '{bcrypt}$2a$10$.NogaUgBeeG4WZvO8oOsNu/fE28s5emDsjX7N0KfV85BBvnqN8Ine', 0, '21c01cbb-5710-466b-9c06-c36bd52dbfcf', '0907521427', 0, 'USER', '2023-04-06 23:22:03.000000', '2023-04-06 23:22:03.000000'),
(3, 'dangvy2032@gmail.com', '{bcrypt}$2a$10$T6/7cniscCPlmq2uVe4WWett25SsU6ufr.znSdOMgwHZ5G6cEjGN2', 0, '1ba7a59a-d69f-45f0-b3f2-b9a0065078a6', '0795325182', 0, 'USER', '2023-04-06 23:40:54.000000', '2023-04-06 23:40:54.000000'),
(4, 'dangvy202@gmail.comasda', '{bcrypt}$2a$10$MkBPg2Mo/Oob3cIcxcZ0ouLoaP13tvqsb8EMRAgKNYGMdRX4yQL/i', 0, '5a2ebc59-5d9b-4047-ade9-39d9984a42bc', '0353252756', 0, 'USER', '2023-04-06 23:45:55.000000', '2023-04-06 23:45:55.000000'),
(5, 'dangvy202@gmail.com111', '{bcrypt}$2a$10$WrSMc.xZOOz2EiBebN8PQeeUsl9xzzsMmlS85L9KwOUN1kWpkKlDG', 0, '57dee8d4-d48b-48eb-975b-7fc7c55b38ca', '029324924', 0, 'USER', '2023-04-06 23:52:05.000000', '2023-04-06 23:52:05.000000'),
(6, 'dangvy202@gmail.comasdada', '{bcrypt}$2a$10$D.q5crp18TAKwYLYtGU0zOIAs1QM1rmrj8RcBh4l11eIaSBM78UoO', 0, '69c89567-1240-47ac-b54a-980873f3c42f', '56524212', 0, 'USER', '2023-04-07 08:47:16.000000', '2023-04-07 08:47:16.000000'),
(7, 'dangvy202@gmail.comasdadad', '{bcrypt}$2a$10$vJz4FJccdgB24hEEUUR1p.IPIPGApEHFwwoTPFz1HQWshCO/z6t5a', 0, 'ec8fd603-69f6-4ccb-ba0c-4f44664e05b1', '5210958125', 0, 'USER', '2023-04-07 10:15:52.000000', '2023-04-07 10:15:52.000000'),
(8, 'dangvy202@gmail.com', '{bcrypt}$2a$10$FfGcwdwxXadEdN5yZW1mtebKk6bNcafbCc8TSJ8idgRu5Kw9iVHTm', 1, 'f4e82a58-ae85-4d47-989e-b4e0692f72f7', '079099015067', 1, 'USER', '2023-04-07 10:25:02.000000', '2023-04-07 10:25:02.000000');

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
  `id_account` bigint(20) NOT NULL,
  `id_subject` bigint(20) NOT NULL,
  `create_application` datetime(6) DEFAULT NULL,
  `modify_application` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_application_form`
--

INSERT INTO `sch_application_form` (`id_application`, `id_user`, `id_report`, `id_option`, `id_class`, `id_enroll`, `id_account`, `id_subject`, `create_application`, `modify_application`) VALUES
(1, 1, 1, 1, 1, 1, 2, 1, '2023-04-06 08:53:41.000000', '2023-04-06 08:53:41.000000'),
(2, 2, 2, 2, 2, 2, 3, 2, '2023-04-06 09:15:35.000000', '2023-04-06 09:15:35.000000'),
(3, 3, 3, 3, 3, 3, 4, 3, '2023-04-06 09:20:17.000000', '2023-04-06 09:20:17.000000'),
(4, 4, 4, 4, 4, 4, 5, 4, '2023-04-06 09:24:31.000000', '2023-04-06 09:24:31.000000'),
(5, 5, 5, 5, 5, 5, 6, 5, '2023-04-06 09:24:31.000000', '2023-04-06 09:24:31.000000'),
(6, 6, 6, 6, 6, 6, 7, 6, '2023-04-06 14:25:10.000000', '2023-04-06 14:25:10.000000'),
(7, 7, 7, 7, 7, 7, 8, 7, '2023-04-10 09:50:54.000000', '2023-04-10 09:50:54.000000'),
(8, 8, 8, 8, 8, 8, 8, 8, '2023-04-10 19:19:21.000000', '2023-04-10 19:19:21.000000'),
(9, 9, 9, 9, 9, 9, 8, 9, '2023-04-11 15:55:23.000000', '2023-04-11 15:55:23.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_enroll_student`
--

CREATE TABLE `sch_enroll_student` (
  `id_enroll` bigint(20) NOT NULL,
  `math` tinyint(1) NOT NULL DEFAULT 1,
  `literature` tinyint(1) NOT NULL DEFAULT 1,
  `english` tinyint(1) NOT NULL DEFAULT 1,
  `other_subject_1th` varchar(255) DEFAULT NULL,
  `other_subject_2th` varchar(255) DEFAULT NULL,
  `id_report` bigint(20) NOT NULL,
  `create_enroll` datetime(6) DEFAULT NULL,
  `modify_enroll` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_enroll_student`
--

INSERT INTO `sch_enroll_student` (`id_enroll`, `math`, `literature`, `english`, `other_subject_1th`, `other_subject_2th`, `id_report`, `create_enroll`, `modify_enroll`) VALUES
(1, 1, 1, 1, '[Toan, Ly1]', '[Anh, Cong Nghe2]', 1, '2023-04-05 16:27:41.000000', '2023-04-05 16:27:41.000000'),
(2, 1, 1, 1, '[Toan, Ly1]', '[Anh, Cong Nghe2]', 2, '2023-04-05 21:46:42.000000', '2023-04-05 21:46:42.000000'),
(3, 1, 1, 1, '[Toan, Ly1]', '[Anh, Cong Nghe2]', 3, '2023-04-06 14:19:43.000000', '2023-04-06 14:19:43.000000'),
(4, 1, 1, 1, '[Toan, Ly1]', '[Anh, Cong Nghe2]', 4, '2023-04-06 14:20:36.000000', '2023-04-06 14:20:36.000000'),
(5, 1, 1, 1, '[Toan, Ly1]', '[Anh, Cong Nghe2]', 5, '2023-04-06 14:21:50.000000', '2023-04-06 14:21:50.000000'),
(6, 1, 1, 1, '[Toan, Ly1]', '[Anh, Cong Nghe2]', 6, '2023-04-06 14:25:10.000000', '2023-04-06 14:25:10.000000'),
(7, 1, 1, 1, '[Toan, Ly1]', '[Anh, Cong Nghe2]', 7, '2023-04-10 09:50:54.000000', '2023-04-10 09:50:54.000000'),
(8, 1, 1, 1, '[Toan, Ly1]', '[Anh, Cong Nghe2]', 8, '2023-04-10 19:19:20.000000', '2023-04-10 19:19:20.000000'),
(9, 1, 1, 1, '[Toan, Ly1]', '[Anh, Cong Nghe2]', 9, '2023-04-11 15:55:23.000000', '2023-04-11 15:55:23.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_info_class`
--

CREATE TABLE `sch_info_class` (
  `id_class` bigint(20) NOT NULL,
  `6th_grade` int(11) DEFAULT NULL,
  `7th_grade` int(11) DEFAULT NULL,
  `8th_grade` int(11) DEFAULT NULL,
  `9th_grade` int(11) DEFAULT NULL,
  `conduct_certificate_6th` int(11) DEFAULT NULL,
  `conduct_certificate_7th` int(11) DEFAULT NULL,
  `conduct_certificate_8th` int(11) DEFAULT NULL,
  `conduct_certificate_9th` int(11) DEFAULT NULL,
  `id_report` bigint(20) NOT NULL,
  `create_info_class` datetime(6) DEFAULT NULL,
  `modify_info_class` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_info_class`
--

INSERT INTO `sch_info_class` (`id_class`, `6th_grade`, `7th_grade`, `8th_grade`, `9th_grade`, `conduct_certificate_6th`, `conduct_certificate_7th`, `conduct_certificate_8th`, `conduct_certificate_9th`, `id_report`, `create_info_class`, `modify_info_class`) VALUES
(1, 1, 1, 1, 0, 1, 0, 0, 0, 1, '2023-04-05 16:27:41.000000', '2023-04-05 16:27:41.000000'),
(2, 1, 1, 1, 0, 1, 0, 0, 0, 2, '2023-04-05 21:46:42.000000', '2023-04-05 21:46:42.000000'),
(3, 1, 1, 1, 0, 1, 0, 0, 0, 3, '2023-04-06 14:19:43.000000', '2023-04-06 14:19:43.000000'),
(4, 1, 1, 1, 0, 1, 0, 0, 0, 4, '2023-04-06 14:20:36.000000', '2023-04-06 14:20:36.000000'),
(5, 1, 1, 1, 0, 1, 0, 0, 0, 5, '2023-04-06 14:21:49.000000', '2023-04-06 14:21:49.000000'),
(6, 1, 1, 1, 0, 1, 0, 0, 0, 6, '2023-04-06 14:25:10.000000', '2023-04-06 14:25:10.000000'),
(7, 1, 1, 1, 0, 0, 0, 0, 0, 7, '2023-04-10 09:50:54.000000', '2023-04-10 09:50:54.000000'),
(8, 1, 1, 1, 0, 0, 0, 0, 0, 8, '2023-04-10 19:19:20.000000', '2023-04-10 19:19:20.000000'),
(9, 1, 1, 1, 0, 1, 0, 0, 1, 9, '2023-04-11 15:55:23.000000', '2023-04-11 15:55:23.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_option_student`
--

CREATE TABLE `sch_option_student` (
  `id_option` bigint(20) NOT NULL,
  `math_cs1` int(11) DEFAULT NULL,
  `literature_cs1` varchar(255) DEFAULT NULL,
  `informatics_cs1` varchar(255) DEFAULT NULL,
  `physics_cs1` varchar(255) DEFAULT NULL,
  `chemistry_cs1` varchar(255) DEFAULT NULL,
  `biology_cs1` varchar(255) DEFAULT NULL,
  `english_cs1` varchar(255) DEFAULT NULL,
  `math_cs2` int(11) DEFAULT NULL,
  `literature_cs2` varchar(255) DEFAULT NULL,
  `informatics_cs2` varchar(255) DEFAULT NULL,
  `physics_cs2` varchar(255) DEFAULT NULL,
  `chemistry_cs2` varchar(255) DEFAULT NULL,
  `biology_cs2` varchar(255) DEFAULT NULL,
  `english_cs2` varchar(255) DEFAULT NULL,
  `id_report` bigint(20) NOT NULL,
  `create_option` datetime(6) DEFAULT NULL,
  `modify_option` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_option_student`
--

INSERT INTO `sch_option_student` (`id_option`, `math_cs1`, `literature_cs1`, `informatics_cs1`, `physics_cs1`, `chemistry_cs1`, `biology_cs1`, `english_cs1`, `math_cs2`, `literature_cs2`, `informatics_cs2`, `physics_cs2`, `chemistry_cs2`, `biology_cs2`, `english_cs2`, `id_report`, `create_option`, `modify_option`) VALUES
(1, 1, '2', '3', '4', '5', '6', '7', 8, '9', '8', '7', '0', '0', '0', 1, '2023-04-05 16:27:45.000000', '2023-04-05 16:27:45.000000'),
(2, 9, '8', '7', '6', '5', '4', '3', 2, '1', '0', '0', '7', '0', '0', 2, '2023-04-05 21:48:14.000000', '2023-04-05 21:48:14.000000'),
(3, 0, '0', '0', '0', '0', '0', '0', 0, '0', '0', '0', '0', '0', '0', 3, '2023-04-06 14:19:47.000000', '2023-04-06 14:19:47.000000'),
(4, 0, '0', '0', '0', '0', '0', '0', 0, '0', '0', '0', '0', '0', '0', 4, '2023-04-06 14:20:38.000000', '2023-04-06 14:20:38.000000'),
(5, 0, '0', '0', '0', '0', '0', '0', 0, '0', '0', '0', '0', '0', '0', 5, '2023-04-06 14:21:50.000000', '2023-04-06 14:21:50.000000'),
(6, 0, '0', '0', '0', '0', '0', '0', 0, '0', '0', '0', '0', '0', '0', 6, '2023-04-06 14:25:10.000000', '2023-04-06 14:25:10.000000'),
(7, 0, '0', '0', '0', '0', '0', '0', 0, '0', '0', '0', '0', '0', '0', 7, '2023-04-10 09:50:54.000000', '2023-04-10 09:50:54.000000'),
(8, 0, '0', '0', '0', '0', '0', '0', 0, '0', '0', '0', '0', '0', '0', 8, '2023-04-10 19:19:20.000000', '2023-04-10 19:19:20.000000'),
(9, 1, '2', '3', '4', '5', '0', '0', 0, '0', '0', '0', '1', '3', '9', 9, '2023-04-11 15:55:23.000000', '2023-04-11 15:55:23.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_student_report`
--

CREATE TABLE `sch_student_report` (
  `id_report` bigint(20) NOT NULL,
  `school_passed` varchar(255) DEFAULT NULL,
  `name_class` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `ward` varchar(255) DEFAULT NULL,
  `school_address` varchar(255) DEFAULT NULL,
  `academic_ability` int(11) DEFAULT NULL,
  `id_user` bigint(20) NOT NULL,
  `create_report` datetime(6) DEFAULT NULL,
  `modify_report` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_student_report`
--

INSERT INTO `sch_student_report` (`id_report`, `school_passed`, `name_class`, `province`, `district`, `ward`, `school_address`, `academic_ability`, `id_user`, `create_report`, `modify_report`) VALUES
(1, 'Han Thuyen', '9AC', 'Thành phố Hồ Chí Minh', '3', '12', '113/22', 1, 1, '2023-04-05 16:27:41.000000', '2023-04-05 16:27:41.000000'),
(2, 'Phu Nhuan', '9AB', 'Thành phố Hồ Chí Minh', 'Gò Vấp', '12', '66/2', 1, 2, '2023-04-05 21:46:42.000000', '2023-04-05 21:46:42.000000'),
(3, 'Nguyen Thi Dieu', '9A1', 'Tỉnh Đồng Nai', 'Pleku', '11', '2/77', 1, 3, '2023-04-06 14:19:43.000000', '2023-04-06 14:19:43.000000'),
(4, 'Ngo Tat To', '9AD', 'Tỉnh Đồng Nai', '8', '2', '1/67', 1, 4, '2023-04-06 14:20:36.000000', '2023-04-06 14:20:36.000000'),
(5, 'Nguyen Thi', '9AH', 'Tỉnh Đồng Nai', '9', '15', '667', 1, 5, '2023-04-06 14:21:49.000000', '2023-04-06 14:21:49.000000'),
(6, 'Doan Thi diem', '9AV', 'Thành Phố Long An', 'Đức Huệ', '12', '772', 1, 6, '2023-04-06 14:25:10.000000', '2023-04-06 14:25:10.000000'),
(7, 'Bach Dang4', '9AZ', 'Thành phố Bình Dương', '9', '13', '881/5', 1, 7, '2023-04-10 09:50:54.000000', '2023-04-10 09:50:54.000000'),
(8, 'Phu Nhua3n', '9AI', 'Thành phố Hà Nội', '5', '5', '1135', 1, 8, '2023-04-10 19:19:20.000000', '2023-04-10 19:19:20.000000'),
(9, 'Phu Nhua3n', '9A6 TEST NE', 'yaya', 'uyuy', 'test ne haa', 'Phu Nhua3n', 1, 9, '2023-04-11 15:55:23.000000', '2023-04-11 15:55:23.000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_subject`
--

CREATE TABLE `sch_subject` (
  `id_subject` bigint(20) NOT NULL,
  `math` int(11) DEFAULT NULL,
  `literature` int(11) DEFAULT NULL,
  `informatics` int(11) DEFAULT NULL,
  `physics` int(11) DEFAULT NULL,
  `chemistry` int(11) DEFAULT NULL,
  `biology` int(11) DEFAULT NULL,
  `english` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_subject`
--

INSERT INTO `sch_subject` (`id_subject`, `math`, `literature`, `informatics`, `physics`, `chemistry`, `biology`, `english`) VALUES
(1, 1, 0, 0, 0, 0, 0, 0),
(2, 0, 1, 0, 0, 0, 0, 0),
(3, 0, 0, 1, 0, 0, 0, 0),
(4, 0, 0, 0, 0, 0, 1, 0),
(5, 0, 0, 0, 0, 1, 0, 0),
(6, 0, 1, 0, 0, 0, 0, 0),
(7, 0, 0, 0, 1, 0, 0, 0),
(8, 1, 0, 0, 0, 0, 0, 0),
(9, 1, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sch_user`
--

CREATE TABLE `sch_user` (
  `id_user` bigint(20) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `place_of_birth` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `ward` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `ethnicity` varchar(255) DEFAULT NULL,
  `identify_info` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `landline_phone_number` varchar(255) DEFAULT NULL,
  `option_phone` varchar(255) DEFAULT NULL,
  `create_account` datetime(6) DEFAULT NULL,
  `modify_account` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sch_user`
--

INSERT INTO `sch_user` (`id_user`, `first_name`, `last_name`, `place_of_birth`, `province`, `district`, `ward`, `address`, `birthday`, `sex`, `ethnicity`, `identify_info`, `nationality`, `phone_number`, `landline_phone_number`, `option_phone`, `create_account`, `modify_account`) VALUES
(1, 'vy', 'tran', 'Hồ Chí Minh', 'Sài Gòn', 'Phú Nhuận', '13', '1123423532/45454 le van si2', '1999-02-20', 1, 'Kinh2', '0790990150672', 'vietNam2', '07085178562', '09085178562', 'dad2', '2023-04-05 16:27:41.000000', '2023-04-05 16:27:41.000000'),
(2, 'thanh', 'phan', 'Nam Định', 'Xuân Lộc', 'Xuân Hòa', 'Tuyên Quang', '1123423532/45454 le van si2', '1999-02-20', 0, 'Kinh2', '0790990150672', 'vietNam2', '07085178562', '09085178562', 'dad2', '2023-04-05 21:46:42.000000', '2023-04-05 21:46:42.000000'),
(3, 'vu', 'hoai', 'Hà Nội', 'Phố Cổ', '3', '3', '1123423532/45454 le van si2', '1999-02-20', 1, 'Kinh2', '0790990150672', 'vietNam2', '07085178562', '09085178562', 'dad2', '2023-04-06 14:19:43.000000', '2023-04-06 14:19:43.000000'),
(4, 'khanh', 'ling', 'Hội An', 'Khánh Hòa', 'Long An', 'Cần Giuoc', '1123423532/45454 le van si2', '1999-02-20', 1, 'Kinh2', '0790990150672', 'vietNam2', '07085178562', '09085178562', 'dad2', '2023-04-06 14:20:36.000000', '2023-04-06 14:20:36.000000'),
(5, 'meo', 'méo', 'Hồ Chí Minh', 'Gò Vấp', 'Sài Gòn', '3', '1123423532/45454 le van si2', '1999-02-20', 0, 'Kinh2', '0790990150672', 'vietNam2', '07085178562', '09085178562', 'dad2', '2023-04-06 14:21:38.000000', '2023-04-06 14:21:38.000000'),
(6, 'va', 'res', 'Cần Thơ', 'Bến Tre', '3', '3', '1123423532/45454 le van si2', '1999-02-20', 1, 'Kinh2', '0790990150672', 'vietNam2', '07085178562', '09085178562', 'dad2', '2023-04-06 14:25:10.000000', '2023-04-06 14:25:10.000000'),
(7, 'test32', 'testto32', 'Vũng Tàu', 'Thùy Vân', 'Phú Yên', 'Yên Bái', '1123423532/45454 le van si2', '1999-02-20', 1, 'Kinh2', '0790990150672', 'vietNam2', '07085178562', '09085178562', 'dad2', '2023-04-10 09:50:54.000000', '2023-04-10 09:50:54.000000'),
(8, 'test32', 'testto32', 'Bình Dương', 'Bình Dương', 'Bình Dương', 'Bình Dương2', '1123423532/45454 le van si2', '1999-02-20', 1, 'Kinh2', '0790990150672', '', '07085178562', '09085178562', 'dad2', '2023-04-10 19:19:20.000000', '2023-04-10 19:19:20.000000'),
(9, 'test32', 'testto32', 'HO CHI MINH TEST NE', 'phu nhuan testne', '3 tet ne', '12 test ne', '1123423532/45454 le van si2', '1999-02-20', 1, 'Kinh2', '0790990150672', 'vietNam2', '07085178562', '09085178562', 'dad2', '2023-04-11 15:55:23.000000', '2023-04-11 15:55:23.000000');

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
  ADD KEY `application_enroll` (`id_enroll`),
  ADD KEY `application_account` (`id_account`),
  ADD KEY `application_subject` (`id_subject`);

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
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT cho bảng `sch_account`
--
ALTER TABLE `sch_account`
  MODIFY `id_account` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `sch_application_form`
--
ALTER TABLE `sch_application_form`
  MODIFY `id_application` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `sch_enroll_student`
--
ALTER TABLE `sch_enroll_student`
  MODIFY `id_enroll` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `sch_info_class`
--
ALTER TABLE `sch_info_class`
  MODIFY `id_class` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `sch_option_student`
--
ALTER TABLE `sch_option_student`
  MODIFY `id_option` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `sch_student_report`
--
ALTER TABLE `sch_student_report`
  MODIFY `id_report` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `sch_subject`
--
ALTER TABLE `sch_subject`
  MODIFY `id_subject` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `sch_user`
--
ALTER TABLE `sch_user`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `sch_application_form`
--
ALTER TABLE `sch_application_form`
  ADD CONSTRAINT `application_account` FOREIGN KEY (`id_account`) REFERENCES `sch_account` (`id_account`),
  ADD CONSTRAINT `application_class` FOREIGN KEY (`id_class`) REFERENCES `sch_info_class` (`id_class`),
  ADD CONSTRAINT `application_enroll` FOREIGN KEY (`id_enroll`) REFERENCES `sch_enroll_student` (`id_enroll`),
  ADD CONSTRAINT `application_option` FOREIGN KEY (`id_option`) REFERENCES `sch_option_student` (`id_option`),
  ADD CONSTRAINT `application_report` FOREIGN KEY (`id_report`) REFERENCES `sch_student_report` (`id_report`),
  ADD CONSTRAINT `application_subject` FOREIGN KEY (`id_subject`) REFERENCES `sch_subject` (`id_subject`),
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
