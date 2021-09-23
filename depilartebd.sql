-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 24, 2021 at 12:42 AM
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

--
-- Dumping data for table `depilarte_productos`
--

INSERT INTO `depilarte_productos` (`id_productos`, `Nombre`, `Proveedor`, `Cantidad`, `Especialista`, `Precio`, `Descripcion`, `fechaRegistro`) VALUES
(1, 'Producto 10', 'Productive', '3', 1, '45', NULL, '2021-09-04'),
(2, 'Producto 2', 'probandola', '3', 1, '45', 'Pagala', '2021-09-02'),
(3, 'Producto 4', 'Luis', '5', 1, '100', 'Este dminisn', NULL),
(4, 'Michi', 'Michi', '5', 2, '1', 'Este es michi', NULL);

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
  `ZonaTratamiento` int(11) DEFAULT NULL,
  `CantidadSesiones` varchar(5) DEFAULT NULL,
  `Asistencia` varchar(100) DEFAULT NULL,
  `ProductoUtilizado` int(11) DEFAULT NULL,
  `DisparosAntes` varchar(100) DEFAULT NULL,
  `DisparosDespues` varchar(100) DEFAULT NULL,
  `DiferenciaDisparos` varchar(100) DEFAULT NULL,
  `UserAtendio` int(11) DEFAULT NULL,
  `FormaPago` int(11) NOT NULL,
  `Abonado` varchar(100) NOT NULL,
  `PrecioTotal` varchar(100) NOT NULL,
  `Comision` varchar(100) NOT NULL,
  `Nota` varchar(600) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `RegisterUser` int(11) NOT NULL,
  `Referencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `depilarte_registros`
--

INSERT INTO `depilarte_registros` (`id`, `fechaAtendido`, `Nombre`, `Apellido`, `Cedula`, `Edad`, `Correo`, `FechaCumple`, `Direccion`, `Tratamiento`, `TipoTratamiento`, `ZonaTratamiento`, `CantidadSesiones`, `Asistencia`, `ProductoUtilizado`, `DisparosAntes`, `DisparosDespues`, `DiferenciaDisparos`, `UserAtendio`, `FormaPago`, `Abonado`, `PrecioTotal`, `Comision`, `Nota`, `Telefono`, `RegisterUser`, `Referencia`) VALUES
(4, '2021-09-11', 'Carlos', 'Zabala', '26900042', '22', 'carlos@gmai.com', '1998-12-21', 'Urb.Bosque', 5, 9, NULL, '5', '3', 2, NULL, NULL, NULL, 2, 1, '4455', '3434', '434', 'Pago', '04245555555', 1, 0),
(5, '2021-09-06', 'Jose', 'Perez', '35424654', '43', 'joseperez34@gmail.com', '2011-09-06', 'Trigal', 5, 9, 1, '4', '3', 1, '4', '2', '2', 2, 1, '34', '555', '4', 'Pagado', '0412-4323345', 1, 0),
(6, '2021-09-08', 'Juan', 'Zabala', '2324325', '32', 'juanpablozabala21@gmail.com', '2021-08-29', 'Urb. Bosque4', 5, 10, NULL, '5', '3', 2, NULL, NULL, NULL, 2, 2, '5', '33', '45', 'Pago', '423214345', 1, 0),
(7, '2021-09-08', 'Jefferson', 'Intento 2', '445435354', '33', 'jeffer@gmail.com', '2021-09-05', 'Jefferson', 5, 10, NULL, '5', '5', 1, NULL, NULL, NULL, 2, 2, '54', '32', '5', 'Pago', '4334676', 1, 0),
(8, '2021-09-08', 'Joselyn', 'Perez', '35424654', '43', 'joseperez34@gmail.com', '2011-09-06', 'Trigal', 5, 9, NULL, '4', '3', 1, NULL, NULL, NULL, 2, 1, '34', '555', '4', 'Pagado', '0412-4323345', 1, 0),
(9, '2021-09-08', 'Juan', 'Zabala', 'V26900042', '22', 'juanpablozabala21@gmail.com', '1998-12-21', 'Urb.Bosque', 5, 9, NULL, '5', '3', 2, NULL, NULL, NULL, 2, 1, '4455', '3434', '434', 'Pago', '0424-4563683', 1, 0),
(10, '2021-09-11', 'Alejandro 2', 'Perez', '345435', '32', 'alejandro@gmail.com', '2021-08-29', 'Alejandro ', 5, 10, NULL, '4', '3', 2, NULL, NULL, NULL, 2, 2, '100', '434', '3', '23', '034236666', 1, 0),
(11, '2021-09-08', 'Alejandro', 'Perez', '345435', '32', 'alejandro@gmail.com', '2021-08-29', 'Alejandro ', 5, 10, NULL, '4', '3', 2, NULL, NULL, NULL, 2, 2, '45', '434', '3', '23', '34325454', 1, 0),
(12, '2021-09-11', 'Anna', 'Vergani', '34234', '20', 'anna@gmail.com', '2021-02-09', 'Mañongo', 5, 9, NULL, '5', NULL, 1, NULL, NULL, NULL, 9, 1, '40', '20', '4', 'El paciente viene a menuda', '0414566666', 1, 0),
(13, '2021-09-11', 'Francis', 'Reyes', '342353', '30', 'Francis@gmail.com', '2021-09-15', 'Trigal sur', 5, 9, NULL, '3', NULL, 2, NULL, NULL, NULL, 10, 3, '50', '100', '80', 'Este presenta ', '4353453', 1, 0),
(14, '2021-09-13', 'Luis jose', 'Marcano', '34239423', '22', 'michi@gmail.com', '2021-11-09', 'Mexico Guadalajara', 5, 9, NULL, '1', NULL, 3, NULL, NULL, NULL, 9, 1, '0', '200', '90', 'Michi es gay', '04143636327', 1, 0),
(15, '2021-09-21', 'Luis Alejandro', 'MArino', '27188725', '23', 'luis@gmail.com', '2021-06-11', 'Trigal norte', 5, 9, NULL, '1', NULL, 1, NULL, NULL, NULL, 10, 3, '40', '50', '70', 'Francis', '04145810329', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `depilarte_tipotratamientos`
--

CREATE TABLE `depilarte_tipotratamientos` (
  `id_tipo` int(11) NOT NULL,
  `id_tratamientos` int(11) NOT NULL,
  `typeTreatment` varchar(50) NOT NULL,
  `typePrice` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `depilarte_tipotratamientos`
--

INSERT INTO `depilarte_tipotratamientos` (`id_tipo`, `id_tratamientos`, `typeTreatment`, `typePrice`) VALUES
(9, 5, 'Laser', 35),
(10, 5, '4D', 42),
(11, 27, 'Tratamiento', 24),
(12, 27, 'Tratamiento 2', 23),
(13, 29, 'Laser', 200),
(14, 29, 'Cera', 20),
(15, 30, 'Rostro-Superior', 3),
(16, 42, 'Rostroterciosuperior', 200),
(17, 44, 'Rostro Superior Alto', 55),
(18, 46, 'Paquete1', 100),
(19, 46, '5', 5),
(20, 47, 'Acido', 150),
(21, 47, 'Plasma', 100),
(22, 48, 'Bronceado piernas', 100);

-- --------------------------------------------------------

--
-- Table structure for table `depilarte_tratamientos`
--

CREATE TABLE `depilarte_tratamientos` (
  `id_tratamientos` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Especialista` int(11) NOT NULL,
  `CantidadSesiones` varchar(10) NOT NULL,
  `ComisionOperadora` varchar(10) NOT NULL,
  `DescripcionTratamiento` varchar(200) NOT NULL,
  `fechaRegistro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `depilarte_tratamientos`
--

INSERT INTO `depilarte_tratamientos` (`id_tratamientos`, `Nombre`, `Especialista`, `CantidadSesiones`, `ComisionOperadora`, `DescripcionTratamiento`, `fechaRegistro`) VALUES
(5, 'Depilación Laser', 1, '5', '2', 'Alta calidad', '2021-09-04'),
(27, 'Depilacion 34', 1, '34', '3', '32', NULL),
(30, 'Tratamiento 6', 1, '3', '4', 'adsd', NULL),
(40, 'Depilación', 1, '5', '2', 'Paga', NULL),
(41, 'Depilación', 1, '5', '2', 'Paga', NULL),
(42, 'Depilación', 1, '5', '2', 'Paga', NULL),
(44, 'Tratamiento 8', 1, '3', '4', 'Ahora si', NULL),
(46, 'Masaje', 2, '5', '2', 'Paquetes de promoción', NULL),
(47, 'Botox', 1, '3', '80', 'Botox es ', NULL),
(48, 'Bronceado', 2, '1', '60', 'Bronceado de piernas de Valen ', NULL);

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
-- Dumping data for table `depilarte_usuarios`
--

INSERT INTO `depilarte_usuarios` (`id_usuarios`, `Nombre`, `Apellido`, `Cedula`, `Direccion`, `Telefono`, `Email`, `Cargo`, `FechaIngreso`, `FechaNacimiento`, `Edad`) VALUES
(2, 'Josh', 'Zabala', 'V26900042', 'Urb. Bosque', '1998-12-21', 'juanpablozabala21@gmail.com', 1, '2021-09-09', '1998-12-21', '22'),
(9, 'Luis', 'Marino', '27188725', 'Trigal', '04145810329', 'luis@gmail.com', 1, '2021-09-11', '1998-06-11', '23'),
(10, 'Francis', 'Reyes', '18500193', 'Trigal', '04144263906', 'francisreyes11@gmail.com', 1, '2021-09-11', '2021-03-11', '36'),
(11, 'Luis', 'Marino', '27188725', 'Trigal', '04145810329', 'lamvkey98@gmail.com', 2, '2021-09-23', '2021-06-11', '23');

-- --------------------------------------------------------

--
-- Table structure for table `depilarte_zonatratamientos`
--

CREATE TABLE `depilarte_zonatratamientos` (
  `id_zona` int(11) NOT NULL,
  `id_tratamiento` int(11) NOT NULL,
  `ZonaNombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `depilarte_zonatratamientos`
--

INSERT INTO `depilarte_zonatratamientos` (`id_zona`, `id_tratamiento`, `ZonaNombre`) VALUES
(1, 5, 'Piernas'),
(2, 5, 'Estomago');

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
-- Indexes for table `depilarte_zonatratamientos`
--
ALTER TABLE `depilarte_zonatratamientos`
  ADD PRIMARY KEY (`id_zona`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `depilarte_tipotratamientos`
--
ALTER TABLE `depilarte_tipotratamientos`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `depilarte_tratamientos`
--
ALTER TABLE `depilarte_tratamientos`
  MODIFY `id_tratamientos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `depilarte_usuarios`
--
ALTER TABLE `depilarte_usuarios`
  MODIFY `id_usuarios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `depilarte_zonatratamientos`
--
ALTER TABLE `depilarte_zonatratamientos`
  MODIFY `id_zona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
