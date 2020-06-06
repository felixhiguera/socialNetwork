-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 06, 2020 at 12:32 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `red_social`
--

-- --------------------------------------------------------

--
-- Table structure for table `mensajes`
--

CREATE TABLE `mensajes` (
  `id_mensaje` int(10) NOT NULL,
  `id_usuario` int(6) NOT NULL,
  `mensaje` varchar(280) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mensajes`
--

INSERT INTO `mensajes` (`id_mensaje`, `id_usuario`, `mensaje`, `fecha`) VALUES
(1, 2, 'hola mundo, mi primer mensaje', '2019-11-07 14:54:13'),
(3, 2, 'ola k ase', '2019-11-07 14:58:16'),
(4, 2, 'probando mi red social', '2019-11-07 14:59:12'),
(5, 1, 'hola santiago', '2019-11-07 15:02:46'),
(6, 7, 'hola como estas?', '2020-04-01 17:57:24');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(7) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `clave` varchar(32) NOT NULL,
  `nombre_completo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `correo`, `clave`, `nombre_completo`) VALUES
(1, 'usuario2@gmail.com', 'aca0c4983f0e917afae1929ee75c1cc1', 'luisa osorio'),
(2, 'exactlimon@gmail.com', '9adb7bea5c8e4350f5151cd135ab3042', 'santi bernal'),
(7, 'felix@gmail.com', '4d186321c1a7f0f354b297e8914ab240', 'felix '),
(8, 'iky@gmail.com', '4d186321c1a7f0f354b297e8914ab240', 'iky'),
(9, 'felix@gmail.com', '202cb962ac59075b964b07152d234b70', 'felix'),
(10, 'alonso@gmail.com', 'felix', '25779f8829ab7a7650e85a4cc871e6ac'),
(11, 'iky@gmail.com', '202cb962ac59075b964b07152d234b70', 'pui yee'),
(12, 'jelix@mail.com', 'jelix', '202cb962ac59075b964b07152d234b70');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mensajes`
--
ALTER TABLE `mensajes`
  ADD PRIMARY KEY (`id_mensaje`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mensajes`
--
ALTER TABLE `mensajes`
  MODIFY `id_mensaje` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mensajes`
--
ALTER TABLE `mensajes`
  ADD CONSTRAINT `mensajes_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
