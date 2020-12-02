-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 18, 2020 at 02:13 AM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_citas`
--

-- --------------------------------------------------------

--
-- Table structure for table `citas`
--

CREATE TABLE `citas` (
  `CitNumero` int(10) NOT NULL,
  `CitFecha` date DEFAULT NULL,
  `CitHora` time(6) DEFAULT NULL,
  `CitObservaciones` varchar(255) DEFAULT NULL,
  `CitEstado` varchar(255) DEFAULT NULL,
  `MEDICOSMedIdentificacion` int(10) NOT NULL,
  `CONSULTORIOSConNumero` int(10) NOT NULL,
  `PACIENTESPacIdentificacion` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `consultorios`
--

CREATE TABLE `consultorios` (
  `ConNumero` int(10) NOT NULL,
  `ConNombre` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `medicos`
--

CREATE TABLE `medicos` (
  `MedIdentificacion` int(10) NOT NULL,
  `MedNombre` varchar(255) DEFAULT NULL,
  `MedApellidos` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pacientes`
--

CREATE TABLE `pacientes` (
  `PacIdentificacion` int(10) NOT NULL,
  `PacNombre` varchar(255) DEFAULT NULL,
  `PacApellido` varchar(255) DEFAULT NULL,
  `PacNacimiento` date DEFAULT NULL,
  `PacSexo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tratamientos`
--

CREATE TABLE `tratamientos` (
  `TraNumero` int(10) NOT NULL,
  `TraFechaAsignado` date DEFAULT NULL,
  `TraDescripcion` varchar(45) DEFAULT NULL,
  `TraFechaInicial` date DEFAULT NULL,
  `TraFechaFinal` date DEFAULT NULL,
  `TraObservaciones` varchar(45) DEFAULT NULL,
  `PACIENTESPacIdentificacion` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`CitNumero`),
  ADD KEY `FKCITAS280756` (`MEDICOSMedIdentificacion`),
  ADD KEY `FKCITAS381283` (`CONSULTORIOSConNumero`),
  ADD KEY `FKCITAS929742` (`PACIENTESPacIdentificacion`);

--
-- Indexes for table `consultorios`
--
ALTER TABLE `consultorios`
  ADD PRIMARY KEY (`ConNumero`);

--
-- Indexes for table `medicos`
--
ALTER TABLE `medicos`
  ADD PRIMARY KEY (`MedIdentificacion`);

--
-- Indexes for table `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`PacIdentificacion`);

--
-- Indexes for table `tratamientos`
--
ALTER TABLE `tratamientos`
  ADD PRIMARY KEY (`TraNumero`),
  ADD KEY `FKTRATAMIENT190788` (`PACIENTESPacIdentificacion`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `citas`
--
ALTER TABLE `citas`
  MODIFY `CitNumero` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `consultorios`
--
ALTER TABLE `consultorios`
  MODIFY `ConNumero` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `medicos`
--
ALTER TABLE `medicos`
  MODIFY `MedIdentificacion` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `PacIdentificacion` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tratamientos`
--
ALTER TABLE `tratamientos`
  MODIFY `TraNumero` int(10) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `FKCITAS280756` FOREIGN KEY (`MEDICOSMedIdentificacion`) REFERENCES `medicos` (`MedIdentificacion`),
  ADD CONSTRAINT `FKCITAS381283` FOREIGN KEY (`CONSULTORIOSConNumero`) REFERENCES `consultorios` (`ConNumero`),
  ADD CONSTRAINT `FKCITAS929742` FOREIGN KEY (`PACIENTESPacIdentificacion`) REFERENCES `pacientes` (`PacIdentificacion`);

--
-- Constraints for table `tratamientos`
--
ALTER TABLE `tratamientos`
  ADD CONSTRAINT `FKTRATAMIENT190788` FOREIGN KEY (`PACIENTESPacIdentificacion`) REFERENCES `pacientes` (`PacIdentificacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
