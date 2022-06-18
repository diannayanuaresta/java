-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 18, 2022 at 04:58 AM
-- Server version: 5.7.33
-- PHP Version: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dianna06425`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang06425`
--

CREATE TABLE `barang06425` (
  `kode` varchar(5) NOT NULL,
  `nama` varchar(40) DEFAULT NULL,
  `hrgbeli` int(12) DEFAULT NULL,
  `hrgjual` int(12) DEFAULT NULL,
  `jumlah` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang06425`
--

INSERT INTO `barang06425` (`kode`, `nama`, `hrgbeli`, `hrgjual`, `jumlah`) VALUES
('11111', 'Buku Tulis ABC 40', 5000, 5500, 97),
('11112', 'Pulpen Standard Basic', 1000, 1500, 195),
('11113', 'Buku Gambar A3', 5000, 6000, 30),
('11114', 'Spidol Snowman Hitam', 2000, 2800, 92),
('11115', 'Buku Paket Matematika', 25000, 30000, 16),
('11116', 'Buku Cetak Bahasa Inggri SMP', 40000, 50000, 12);

-- --------------------------------------------------------

--
-- Table structure for table `jual06425`
--

CREATE TABLE `jual06425` (
  `notransaksi` int(5) DEFAULT NULL,
  `kode` varchar(5) DEFAULT NULL,
  `harga` int(12) DEFAULT NULL,
  `jumlah` int(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jual06425`
--

INSERT INTO `jual06425` (`notransaksi`, `kode`, `harga`, `jumlah`) VALUES
(21001, '11111', 5500, 3),
(21001, '11113', 6000, 8),
(21002, '11115', 30000, 9),
(21002, '11116', 50000, 1),
(21003, '11114', 2800, 2),
(21003, '11113', 6000, 7),
(21004, '11114', 2800, 6);

-- --------------------------------------------------------

--
-- Table structure for table `pegawai06425`
--

CREATE TABLE `pegawai06425` (
  `nip` varchar(10) NOT NULL,
  `nama` char(50) NOT NULL,
  `bagian` varchar(15) NOT NULL,
  `jeniskel` varchar(10) NOT NULL,
  `password` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai06425`
--

INSERT INTO `pegawai06425` (`nip`, `nama`, `bagian`, `jeniskel`, `password`) VALUES
('11111', 'Dianna Yanaresta', 'Pemasaran', 'Perempuan', NULL),
('11112', 'Dianna Yanuaresta', 'Keuangan', 'Perempuan', NULL),
('11113', 'Dianna yaa', 'Keuangan', 'Perempuan', NULL),
('11114', 'Dianna Yanuar', 'Finansial', 'Perempuan', NULL),
('11115', 'Andyna Rossa', 'TSI', 'Perempuan', NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
