-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2023 at 06:21 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `building_material_company`
--

-- --------------------------------------------------------

--
-- Table structure for table `auth`
--

CREATE TABLE `auth` (
  `id` int(255) NOT NULL,
  `username` varchar(255) NOT NULL DEFAULT 'root',
  `password` varchar(255) NOT NULL DEFAULT 'root',
  `count` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `auth`
--

INSERT INTO `auth` (`id`, `username`, `password`, `count`) VALUES
(1, 'root', 'root', 0);

-- --------------------------------------------------------

--
-- Table structure for table `bon_count`
--

CREATE TABLE `bon_count` (
  `id` int(11) NOT NULL,
  `count` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `bon_count`
--

INSERT INTO `bon_count` (`id`, `count`) VALUES
(1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `dealers`
--

CREATE TABLE `dealers` (
  `id` int(255) NOT NULL,
  `dealer_type` varchar(1000) NOT NULL,
  `nome` varchar(1000) NOT NULL,
  `prenome` varchar(1000) NOT NULL,
  `ville` varchar(1000) NOT NULL,
  `num_telephone` varchar(1000) NOT NULL,
  `payments` float NOT NULL,
  `dues` float NOT NULL,
  `black_list` int(11) NOT NULL DEFAULT 0,
  `date` varchar(1000) NOT NULL,
  `time` varchar(1000) NOT NULL,
  `matricule` varchar(1000) NOT NULL,
  `received` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `dealers`
--

INSERT INTO `dealers` (`id`, `dealer_type`, `nome`, `prenome`, `ville`, `num_telephone`, `payments`, `dues`, `black_list`, `date`, `time`, `matricule`, `received`) VALUES
(1, 'Client', 'd', 'd', 'd', 'd', 50000, 50000, 1, '2023-11-26', '19:56:09', 'dD20231126195609', 1),
(2, 'Fourniseur', 'f', 'f', 's', 'ss', 40000, 29982, 0, '2023-11-26', '19:57:13', 'fF20231126195713', 1),
(3, 'Fourniseur', 'q', 'q', 'q', 'q', 6, 30016, 1, '2023-11-26', '20:00:35', 'qQ20231126200035', 1),
(4, 'Client', 'd', 'd', 'd', 'd', 55, 29945, 0, '2023-11-26', '20:09:49', 'DD20231126200949', 1),
(5, 'Client', 'f', 'f', 'f', 'f', 1, 98, 1, '2023-11-26', '20:13:42', 'FF20231126201342', 1),
(6, 'Client', 'sqfsqfqsd', 'fqsffqs', 'fqs', 'dqsfdqqs', 2, 988, 1, '2023-11-26', '20:19:11', 'SF20231126201911', 0),
(7, 'Fourniseur', 'f', 'f', 'f', 'f', 8, 91, 0, '2023-11-27', '00:28:00', 'FF20231127002800', 1),
(8, 'Client', 'sss', 'sss', 'sss', 'sss', 22, 110, 1, '2023-11-27', '00:32:51', 'SS20231127003251', 1),
(9, 'Client', 'sss', 'sss', 'sss', 'sss', 22, 110, 1, '2023-11-27', '00:32:51', 'SS20231127003251', 1),
(10, 'Client', 'sssss', 'ssssss', 'sss', 'sss', 22, 110, 1, '2023-11-27', '00:32:51', 'SS20231127003251', 1),
(11, 'Fourniseur', 'sssssssssssssssssss', 'ssssssssssssssssssssssssssss', 'sssssssssssssssssssssssssss', 'ssssssssssssssssssssssss', 22, 110, 1, '2023-11-27', '00:32:51', 'SS20231127003251', 1),
(15, 'Client', 'j', 'j', 'j', 'j', 121, 0, 1, '2023-11-28', '00:52:30', 'JJ20231128005230', 1),
(16, 'Client', 'marwan', 'marwan', 'marwan', '5555', 19, 3, 0, '2023-12-01', '05:30:36', 'MM20231201053036', 1),
(17, 'Client', 'h', 'h', 'h', '44', 2, 20, 1, '2023-12-01', '05:34:12', 'HH20231201053412', 1),
(18, 'Client', '6', '6', '6', '6', 6, 16, 0, '2023-12-01', '05:38:25', '6620231201053825', 1),
(19, 'Client', '2', '222222', '2', '22222222222222222', 2, 20, 1, '2023-12-01', '05:39:42', '2220231201053942', 1),
(20, 'Client', '4', '4', '4', '4', 4, 18, 0, '2023-12-01', '05:42:30', '4420231201054230', 1),
(21, 'Client', '0', '0', '0', '0', 0, 22, 0, '2023-12-01', '05:46:45', '0020231201054645', 1),
(22, 'Client', '3', '3', '3', '3', 33, 66, 0, '2023-12-01', '05:48:45', '3320231201054845', 1),
(23, 'Client', 'sd', 'sds', 'sd', 'sd', 5, 17, 0, '2023-12-01', '05:51:46', 'SS20231201055146', 1),
(24, 'Client', '1', '1', '1', '1', 1, 120, 0, '2023-12-01', '05:53:49', '1120231201055349', 1),
(25, 'Fourniseur', '22', '22', '22', '22', 22, 9978, 0, '2023-12-01', '05:54:40', '2220231201055440', 1),
(26, 'Fourniseur', 's', 's', 's', 's', 5, 17, 0, '2023-12-01', '06:13:54', 'SS20231201061354', 1);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(255) NOT NULL,
  `code` varchar(1000) NOT NULL,
  `designation` varchar(1000) NOT NULL,
  `prix_unitaire` float NOT NULL,
  `unite_de_mesure` varchar(1000) NOT NULL,
  `disponibility` int(11) NOT NULL DEFAULT 1,
  `type` varchar(1000) NOT NULL DEFAULT 'Export',
  `qte` float NOT NULL DEFAULT 1,
  `sum` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `code`, `designation`, `prix_unitaire`, `unite_de_mesure`, `disponibility`, `type`, `qte`, `sum`) VALUES
(7, 'aa', 'ss', 5, 'ss', 0, 'Import', 1, NULL),
(8, 'a', 'a', 22, 'a', 1, 'Import', 1, NULL),
(9, 'v', 'v', 10000, 'v', 1, 'Import', 1, NULL),
(10, 'j', 'j', 99, 'j', 1, 'Export', 1, NULL),
(11, 's', 'ss', 22, 'kg', 1, 'Export', 1, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `auth`
--
ALTER TABLE `auth`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bon_count`
--
ALTER TABLE `bon_count`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dealers`
--
ALTER TABLE `dealers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code` (`code`,`designation`) USING HASH;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `auth`
--
ALTER TABLE `auth`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `bon_count`
--
ALTER TABLE `bon_count`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `dealers`
--
ALTER TABLE `dealers`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
