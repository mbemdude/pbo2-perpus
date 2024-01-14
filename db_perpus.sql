-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2024 at 02:16 PM
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
-- Database: `db_perpus`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jenis_kelamin` enum('Laki-Laki','Perempuan','','') NOT NULL,
  `telp` varchar(50) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`id`, `nama`, `jenis_kelamin`, `telp`, `alamat`) VALUES
(1, 'Udean', 'Laki-Laki', '0893743928', 'Jl. Kemajuan Nomor 4'),
(2, 'Bambang', 'Laki-Laki', '0928338942', 'Jl. Merdeka Nomor 1'),
(3, 'Hana', 'Perempuan', '0329483432', 'Jl. Jaya Bersama Nomor 9');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id` int(11) NOT NULL,
  `judul` varchar(200) NOT NULL,
  `tahun_terbit` date NOT NULL,
  `jumlah` int(11) NOT NULL,
  `idbn` varchar(200) NOT NULL,
  `pengarang_id` int(11) NOT NULL,
  `penerbit_id` int(11) NOT NULL,
  `rak_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `judul`, `tahun_terbit`, `jumlah`, `idbn`, `pengarang_id`, `penerbit_id`, `rak_id`) VALUES
(1, 'OOP For Monkee', '2024-01-04', 20, '92374-12398', 2, 1, 2),
(5, 'OOP For Monkee Part 2', '2020-03-02', 20, '92374-12398', 2, 1, 2),
(6, 'Java For Beginner', '2021-12-25', 25, '24912-23182-29', 1, 3, 1),
(7, 'Java For Beginner Part 2', '2014-01-01', 50, '213214-1234-24', 1, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id` int(11) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tenggat_pengembalian` date NOT NULL,
  `petugas_id` int(11) NOT NULL,
  `anggota_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id`, `tanggal_pinjam`, `tenggat_pengembalian`, `petugas_id`, `anggota_id`) VALUES
(4, '2024-01-05', '2024-01-12', 1, 1),
(5, '2024-01-01', '2024-01-08', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman_detail`
--

CREATE TABLE `peminjaman_detail` (
  `id` int(11) NOT NULL,
  `peminjaman_id` int(11) NOT NULL,
  `buku_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `peminjaman_detail`
--

INSERT INTO `peminjaman_detail` (`id`, `peminjaman_id`, `buku_id`) VALUES
(1, 4, 6),
(2, 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `penerbit`
--

CREATE TABLE `penerbit` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `telp` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penerbit`
--

INSERT INTO `penerbit` (`id`, `nama`, `telp`, `alamat`, `email`) VALUES
(1, 'Media Baca', '02934902348', 'Jl. Timur 8', 'medbaca@email.com'),
(2, 'Media Ilmu', '09384203948', 'Jl. Barat 5', 'medilmu@email.com'),
(3, 'Ilmu Dunia', '02983741', 'Jl. Utara', 'Ilmudunia@email.com');

-- --------------------------------------------------------

--
-- Table structure for table `pengarang`
--

CREATE TABLE `pengarang` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `telp` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengarang`
--

INSERT INTO `pengarang` (`id`, `nama`, `telp`, `email`) VALUES
(1, 'Ujang', '0729483248', 'ujang@email.com'),
(2, 'Bintangs', '02346384729', 'bintangs@email.com'),
(3, 'Hana', '02394391', 'hana@email.com');

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `id` int(11) NOT NULL,
  `tanggal_pengembalian` date NOT NULL,
  `denda` float NOT NULL,
  `peminjaman_id` int(11) NOT NULL,
  `petugas_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengembalian`
--

INSERT INTO `pengembalian` (`id`, `tanggal_pengembalian`, `denda`, `peminjaman_id`, `petugas_id`) VALUES
(2, '2024-01-10', 0, 4, 3);

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian_detail`
--

CREATE TABLE `pengembalian_detail` (
  `id` int(11) NOT NULL,
  `pengembalian_id` int(11) NOT NULL,
  `buku_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengembalian_detail`
--

INSERT INTO `pengembalian_detail` (`id`, `pengembalian_id`, `buku_id`) VALUES
(1, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jenis_kelamin` enum('Laki-Laki','Perempuan','','') NOT NULL,
  `telp` varchar(50) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id`, `nama`, `jenis_kelamin`, `telp`, `alamat`) VALUES
(1, 'Bunga', 'Perempuan', '00021434', 'Jl. Jalan Nomor 8'),
(3, 'Wahyu', 'Laki-Laki', '09283749823', 'Jl. Karangan');

-- --------------------------------------------------------

--
-- Table structure for table `rak`
--

CREATE TABLE `rak` (
  `id` int(11) NOT NULL,
  `kd_rak` varchar(50) NOT NULL,
  `lokasi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rak`
--

INSERT INTO `rak` (`id`, `kd_rak`, `lokasi`) VALUES
(1, 'A80', 'Lantai 1'),
(2, 'B21', 'Lantai 2'),
(3, 'A10', 'Lantai 1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pengarang_buku` (`pengarang_id`),
  ADD KEY `penerbit_buku` (`penerbit_id`),
  ADD KEY `rak_buku` (`rak_id`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id`),
  ADD KEY `petugas_peminjaman` (`petugas_id`),
  ADD KEY `anggota_peminjaman` (`anggota_id`);

--
-- Indexes for table `peminjaman_detail`
--
ALTER TABLE `peminjaman_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `peminjaman_id` (`peminjaman_id`),
  ADD KEY `buku_id` (`buku_id`);

--
-- Indexes for table `penerbit`
--
ALTER TABLE `penerbit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pengarang`
--
ALTER TABLE `pengarang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pengembalian_peminjaman` (`peminjaman_id`),
  ADD KEY `pengembalian_petugas` (`petugas_id`);

--
-- Indexes for table `pengembalian_detail`
--
ALTER TABLE `pengembalian_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pengembalian` (`pengembalian_id`),
  ADD KEY `pengembalian_buku` (`buku_id`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rak`
--
ALTER TABLE `rak`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anggota`
--
ALTER TABLE `anggota`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `peminjaman_detail`
--
ALTER TABLE `peminjaman_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `penerbit`
--
ALTER TABLE `penerbit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `pengarang`
--
ALTER TABLE `pengarang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `pengembalian`
--
ALTER TABLE `pengembalian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pengembalian_detail`
--
ALTER TABLE `pengembalian_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `petugas`
--
ALTER TABLE `petugas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `rak`
--
ALTER TABLE `rak`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `buku`
--
ALTER TABLE `buku`
  ADD CONSTRAINT `penerbit_buku` FOREIGN KEY (`penerbit_id`) REFERENCES `penerbit` (`id`),
  ADD CONSTRAINT `pengarang_buku` FOREIGN KEY (`pengarang_id`) REFERENCES `pengarang` (`id`),
  ADD CONSTRAINT `rak_buku` FOREIGN KEY (`rak_id`) REFERENCES `rak` (`id`);

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `anggota_peminjaman` FOREIGN KEY (`anggota_id`) REFERENCES `anggota` (`id`),
  ADD CONSTRAINT `petugas_peminjaman` FOREIGN KEY (`petugas_id`) REFERENCES `petugas` (`id`);

--
-- Constraints for table `peminjaman_detail`
--
ALTER TABLE `peminjaman_detail`
  ADD CONSTRAINT `buku_id` FOREIGN KEY (`buku_id`) REFERENCES `buku` (`id`),
  ADD CONSTRAINT `peminjaman_id` FOREIGN KEY (`peminjaman_id`) REFERENCES `peminjaman` (`id`);

--
-- Constraints for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD CONSTRAINT `pengembalian_peminjaman` FOREIGN KEY (`peminjaman_id`) REFERENCES `peminjaman` (`id`),
  ADD CONSTRAINT `pengembalian_petugas` FOREIGN KEY (`petugas_id`) REFERENCES `petugas` (`id`);

--
-- Constraints for table `pengembalian_detail`
--
ALTER TABLE `pengembalian_detail`
  ADD CONSTRAINT `pengembalian` FOREIGN KEY (`pengembalian_id`) REFERENCES `pengembalian` (`id`),
  ADD CONSTRAINT `pengembalian_buku` FOREIGN KEY (`buku_id`) REFERENCES `buku` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
