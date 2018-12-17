-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2018 at 10:08 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mecin_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `jawaban`
--

CREATE TABLE `jawaban` (
  `idJawaban` int(11) NOT NULL,
  `jawaban` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jawaban`
--

INSERT INTO `jawaban` (`idJawaban`, `jawaban`) VALUES
(1, 'Pelampung'),
(2, 'Sembunyi Dibawah Meja'),
(3, 'Gas Pemadam'),
(4, 'Tekan Pada Dada'),
(5, 'Semua benda bergerak'),
(6, 'Pingsan dan Kemasukan Air'),
(7, 'Luka Bakar'),
(8, 'Air, Tandu dan Lidah Buaya'),
(9, 'Obat dan Tandu'),
(10, 'Kayu'),
(11, 'Musim Hujan Yang Berkepanjangan'),
(12, 'Korsleting'),
(13, 'Jangan Membuang Sampah Di Sungai'),
(14, 'Jauhkan Benda Mudah Terbakar Dari Api');

-- --------------------------------------------------------

--
-- Table structure for table `pilihanganda`
--

CREATE TABLE `pilihanganda` (
  `idPilihanGanda` int(11) NOT NULL,
  `pilihanA` varchar(100) NOT NULL,
  `pilihanB` varchar(100) NOT NULL,
  `pilihanC` varchar(100) NOT NULL,
  `pilihanD` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pilihanganda`
--

INSERT INTO `pilihanganda` (`idPilihanGanda`, `pilihanA`, `pilihanB`, `pilihanC`, `pilihanD`) VALUES
(1, 'Pelampung', 'Botol', 'Sapu', 'pelepah pisang'),
(2, 'Lari Keluar Ruangan', 'Keluar Lewat Jendela', 'Mencari Tangga Darurat', 'Sembunyi Dibawah Meja'),
(3, 'Gas Pemadam', 'Air', 'Lap Basah', 'Lap Kering'),
(4, 'Tekan Pada Dada', 'Tekan Pada Kaki', 'Tekan Pada Lutut', 'Tekan Pada Tangan'),
(5, 'Semua benda bergerak', 'Air Laut Meluap', 'Air Masuk Ke Rumah', 'Ranting Pohon Berjatuhan'),
(6, 'Pingsan dan Luka-luka', 'Pingsan dan Kemasukan Air', 'Pingsan dan Patah Tulang', 'Pingsan dan Ceria'),
(7, 'Luka Bakar', 'Pingsan', 'Lecet', 'Sehat-sehat Saja'),
(8, 'Pasta gigi ', 'Es Batu', 'Air, Tandu dan Lidah Buaya', 'Hansaplast'),
(9, 'Obat', 'Obat dan Sapu', 'Obat dan Tandu', 'Tandu'),
(10, 'Besi', 'Kayu', 'Alumunium', 'Kaca'),
(11, 'Musim Kemarau', 'Pohon Tumbang', 'Musim Hujan Yang Berkepanjangan', 'Sampah Kering'),
(12, 'Rusak Kompor', 'Kompor Hidup', 'Api Unggun', 'Korsleting'),
(13, 'Membuang sampah sembarangan', 'Jangan Hujan', 'Jangan Tidur Kemalaman', 'Jangan Membuang Sampah Di Sungai'),
(14, 'Menjauhi Api', 'Jauhkan Benda Mudah Terbakar Dari Api', 'Jauhkan Diri Dari Api', 'Jauhkan Api Dan Air');

-- --------------------------------------------------------

--
-- Table structure for table `soal`
--

CREATE TABLE `soal` (
  `idSoal` int(11) NOT NULL,
  `Soal` varchar(255) NOT NULL,
  `idJawaban` int(11) NOT NULL,
  `idPilihanganda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `soal`
--

INSERT INTO `soal` (`idSoal`, `Soal`, `idJawaban`, `idPilihanganda`) VALUES
(1, 'Benda untuk melakukan pertolongan pertama pada korban banjir?', 1, 1),
(2, 'Pilihan yang tepat saat terjadi gempa?', 2, 2),
(3, 'Benda untuk memadamkan kebakaran?', 3, 3),
(4, 'Saat kemasukan air kita menyelamatkan korban dengan?', 4, 4),
(5, 'Saat terjadi gempa keadaan seperti apa yang sering terjadi?', 5, 5),
(6, 'Saat terjadi banjir, korban sering mengalami seperti apa?', 6, 6),
(7, 'Keadaan yang sering terjadi saat kebakaran?', 7, 7),
(8, 'Saat mengalami luka bakar, penanganan yang tepat dengan menggunakan?', 8, 8),
(9, 'Saat korban gempa bumi mengalami patah tulang penanganan yang tepat?', 9, 9),
(10, 'Barang yang mudah terbakar saat terjadi kebakaran adalah?', 10, 10),
(11, 'Penyebab terjadinya banjir adalah?', 11, 11),
(12, 'Kebakaran di ruangan sering terjadi karena?', 12, 12),
(13, 'Cara mengatasi agar tidak terjadi banjir?', 13, 13),
(14, 'Cara mengatasi agar tidak terjadi kebakaran?', 14, 14);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `level1` int(11) NOT NULL,
  `level2` int(11) NOT NULL,
  `level3` int(11) NOT NULL,
  `skortertinggi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`iduser`, `username`, `password`, `level1`, `level2`, `level3`, `skortertinggi`) VALUES
(18, 'c', 'c', 8, 4, 1, 80),
(20, 'faza', 'a', 4, 4, 1, 50);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jawaban`
--
ALTER TABLE `jawaban`
  ADD PRIMARY KEY (`idJawaban`);

--
-- Indexes for table `pilihanganda`
--
ALTER TABLE `pilihanganda`
  ADD PRIMARY KEY (`idPilihanGanda`);

--
-- Indexes for table `soal`
--
ALTER TABLE `soal`
  ADD PRIMARY KEY (`idSoal`),
  ADD KEY `idJawaban` (`idJawaban`,`idPilihanganda`),
  ADD KEY `idPilihanganda` (`idPilihanganda`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jawaban`
--
ALTER TABLE `jawaban`
  MODIFY `idJawaban` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `pilihanganda`
--
ALTER TABLE `pilihanganda`
  MODIFY `idPilihanGanda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `soal`
--
ALTER TABLE `soal`
  MODIFY `idSoal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `soal`
--
ALTER TABLE `soal`
  ADD CONSTRAINT `soal_ibfk_1` FOREIGN KEY (`idJawaban`) REFERENCES `jawaban` (`idJawaban`),
  ADD CONSTRAINT `soal_ibfk_2` FOREIGN KEY (`idPilihanganda`) REFERENCES `pilihanganda` (`idPilihanGanda`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
