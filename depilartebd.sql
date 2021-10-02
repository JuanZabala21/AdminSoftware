-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2021 at 06:01 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `depilartebd`
--

-- --------------------------------------------------------

--
-- Table structure for table `depilarte_cargos`
--

CREATE TABLE `depilarte_cargos` (
  `id_cargo` int(11) NOT NULL,
  `nombreCargo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `depilarte_cargos`
--

INSERT INTO `depilarte_cargos` (`id_cargo`, `nombreCargo`) VALUES
(1, 'Doctora'),
(2, 'Operadora');

-- --------------------------------------------------------

--
-- Table structure for table `depilarte_metodopagos`
--

CREATE TABLE `depilarte_metodopagos` (
  `id_pagos` int(11) NOT NULL,
  `metodoPago` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `depilarte_metodopagos`
--

INSERT INTO `depilarte_metodopagos` (`id_pagos`, `metodoPago`) VALUES
(3, 'Efectivo'),
(2, 'Pago Móvil '),
(1, 'Zelle');

-- --------------------------------------------------------

--
-- Table structure for table `depilarte_productos`
--

CREATE TABLE `depilarte_productos` (
  `id_productos` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Proveedor` varchar(100) NOT NULL,
  `Cantidad` varchar(100) NOT NULL,
  `Especialista` int(11) NOT NULL,
  `Precio` varchar(159) NOT NULL,
  `Descripcion` varchar(150) DEFAULT NULL,
  `fechaRegistro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `depilarte_referencia`
--

CREATE TABLE `depilarte_referencia` (
  `id_ref` int(11) NOT NULL,
  `nombre_ref` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `depilarte_referencia`
--

INSERT INTO `depilarte_referencia` (`id_ref`, `nombre_ref`) VALUES
(1, 'Instagram'),
(2, 'Referidos'),
(3, 'Otros');

-- --------------------------------------------------------

--
-- Table structure for table `depilarte_registros`
--

CREATE TABLE `depilarte_registros` (
  `id` int(11) NOT NULL,
  `fechaAtendido` date NOT NULL,
  `Nombre` varchar(200) NOT NULL,
  `Apellido` varchar(200) NOT NULL,
  `Cedula` varchar(20) NOT NULL,
  `Edad` varchar(3) NOT NULL,
  `Correo` varchar(150) NOT NULL,
  `FechaCumple` date NOT NULL,
  `Direccion` varchar(500) NOT NULL,
  `Tratamiento` int(11) DEFAULT NULL,
  `TipoTratamiento` int(11) DEFAULT NULL,
  `CantidadSesiones` varchar(5) DEFAULT NULL,
  `ProductoUtilizado` varchar(20) DEFAULT NULL,
  `DisparosAntes` varchar(100) DEFAULT NULL,
  `DisparosDespues` varchar(100) DEFAULT NULL,
  `DiferenciaDisparos` varchar(100) DEFAULT NULL,
  `UserAtendio` int(11) DEFAULT NULL,
  `FormaPago` int(11) NOT NULL,
  `Abonado` varchar(100) NOT NULL,
  `PrecioTotal` varchar(100) NOT NULL,
  `Comision` varchar(100) NOT NULL,
  `Nota` varchar(600) DEFAULT NULL,
  `Telefono` varchar(20) NOT NULL,
  `RegisterUser` int(11) NOT NULL,
  `Referencia` int(11) NOT NULL,
  `imgAfter` longblob DEFAULT NULL,
  `imgBefore` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `depilarte_tipotratamientos`
--

CREATE TABLE `depilarte_tipotratamientos` (
  `id_tipo` int(11) NOT NULL,
  `id_tratamientos` int(11) NOT NULL,
  `typeTreatment` varchar(50) NOT NULL,
  `typePrice` int(11) DEFAULT NULL,
  `comission` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `depilarte_tipotratamientos`
--

INSERT INTO `depilarte_tipotratamientos` (`id_tipo`, `id_tratamientos`, `typeTreatment`, `typePrice`, `comission`) VALUES
(41, 51, 'Rostro Tercio Superior', 100, '70'),
(42, 51, 'Axilas (Hiperhidrosis)', 150, '70'),
(43, 52, 'Labios', 150, '70'),
(44, 52, 'Ojeras', 150, '70'),
(45, 52, 'Perfilado Menton', 150, '70'),
(46, 52, 'Armonizacion ', 150, '70'),
(47, 52, 'Nariz', 150, '70'),
(48, 53, 'Electroporador', 30, '60'),
(49, 53, 'Dermapen', 30, '60'),
(50, 54, 'Electroporador', 30, '60'),
(51, 54, 'Dermapen', 30, '60'),
(52, 54, 'Paquete Plasma rico en plaquetas', 150, '60'),
(53, 54, 'Peeling Axilas', 150, '70'),
(54, 54, 'Peeling Rostro', 30, '70'),
(55, 54, 'Peeling Intimo', 180, '70'),
(56, 55, 'Basica', 20, '60'),
(57, 55, 'Profunda', 30, '60');

-- --------------------------------------------------------

--
-- Table structure for table `depilarte_tratamientos`
--

CREATE TABLE `depilarte_tratamientos` (
  `id_tratamientos` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Especialista` int(11) NOT NULL,
  `CantidadSesiones` varchar(10) NOT NULL,
  `DescripcionTratamiento` varchar(200) NOT NULL,
  `fechaRegistro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `depilarte_tratamientos`
--

INSERT INTO `depilarte_tratamientos` (`id_tratamientos`, `Nombre`, `Especialista`, `CantidadSesiones`, `DescripcionTratamiento`, `fechaRegistro`) VALUES
(51, 'Botox', 1, '1', 'Botox', NULL),
(52, 'Acido Hialuronico', 1, '1', 'Nulo', NULL),
(53, 'Plasma Rico en Plaquetas', 1, '1', 'Plasma rico en plaquetas', NULL),
(54, 'Plasma Rico en Plaquetas', 1, '1', 'Plasma rico en plaquetas', NULL),
(55, 'Limpieza Facial', 1, '1', 'Limpieza Facial', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `depilarte_usuarios`
--

CREATE TABLE `depilarte_usuarios` (
  `id_usuarios` int(11) NOT NULL,
  `Nombre` varchar(200) NOT NULL,
  `Apellido` varchar(200) NOT NULL,
  `Cedula` varchar(20) NOT NULL,
  `Direccion` varchar(300) NOT NULL,
  `Telefono` varchar(15) NOT NULL,
  `Email` varchar(250) NOT NULL,
  `Cargo` int(11) NOT NULL,
  `FechaIngreso` date NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Edad` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `depilarte_cargos`
--
ALTER TABLE `depilarte_cargos`
  ADD PRIMARY KEY (`id_cargo`);

--
-- Indexes for table `depilarte_metodopagos`
--
ALTER TABLE `depilarte_metodopagos`
  ADD PRIMARY KEY (`id_pagos`),
  ADD KEY `metodoPago` (`metodoPago`);

--
-- Indexes for table `depilarte_productos`
--
ALTER TABLE `depilarte_productos`
  ADD PRIMARY KEY (`id_productos`);

--
-- Indexes for table `depilarte_referencia`
--
ALTER TABLE `depilarte_referencia`
  ADD PRIMARY KEY (`id_ref`);

--
-- Indexes for table `depilarte_registros`
--
ALTER TABLE `depilarte_registros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FormaPago` (`FormaPago`);

--
-- Indexes for table `depilarte_tipotratamientos`
--
ALTER TABLE `depilarte_tipotratamientos`
  ADD PRIMARY KEY (`id_tipo`);

--
-- Indexes for table `depilarte_tratamientos`
--
ALTER TABLE `depilarte_tratamientos`
  ADD PRIMARY KEY (`id_tratamientos`);

--
-- Indexes for table `depilarte_usuarios`
--
ALTER TABLE `depilarte_usuarios`
  ADD PRIMARY KEY (`id_usuarios`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `depilarte_cargos`
--
ALTER TABLE `depilarte_cargos`
  MODIFY `id_cargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `depilarte_metodopagos`
--
ALTER TABLE `depilarte_metodopagos`
  MODIFY `id_pagos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `depilarte_productos`
--
ALTER TABLE `depilarte_productos`
  MODIFY `id_productos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `depilarte_referencia`
--
ALTER TABLE `depilarte_referencia`
  MODIFY `id_ref` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `depilarte_registros`
--
ALTER TABLE `depilarte_registros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `depilarte_tipotratamientos`
--
ALTER TABLE `depilarte_tipotratamientos`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `depilarte_tratamientos`
--
ALTER TABLE `depilarte_tratamientos`
  MODIFY `id_tratamientos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT for table `depilarte_usuarios`
--
ALTER TABLE `depilarte_usuarios`
  MODIFY `id_usuarios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `depilarte_registros`
--
ALTER TABLE `depilarte_registros`
  ADD CONSTRAINT `depilarte_registros_ibfk_1` FOREIGN KEY (`FormaPago`) REFERENCES `depilarte_metodopagos` (`id_pagos`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
