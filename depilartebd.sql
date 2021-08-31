-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-08-2021 a las 03:07:07
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `depilartebd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depilarte_metodopagos`
--

CREATE TABLE `depilarte_metodopagos` (
  `id_pagos` int(11) NOT NULL,
  `metodoPago` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depilarte_registros`
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
  `Tratamiento` int(11) NOT NULL,
  `TipoTratamiento` int(11) NOT NULL,
  `ZonaTratamiento` int(11) NOT NULL,
  `CantidadSesiones` varchar(5) NOT NULL,
  `Asistencia` varchar(100) NOT NULL,
  `ProductoUtilizado` int(11) NOT NULL,
  `DisparosAntes` varchar(100) NOT NULL,
  `DisparosDespues` varchar(100) NOT NULL,
  `DiferenciaDisparos` varchar(100) NOT NULL,
  `Operadora` int(11) NOT NULL,
  `Doctora` int(11) NOT NULL,
  `FormaPago` int(11) NOT NULL,
  `Abonado` varchar(100) NOT NULL,
  `PrecioTotal` varchar(100) NOT NULL,
  `Comision` varchar(100) NOT NULL,
  `Nota` varchar(600) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depilarte_usuarios`
--

CREATE TABLE `depilarte_usuarios` (
  `id_usuarios` int(11) NOT NULL,
  `Nombre` varchar(200) NOT NULL,
  `Apellido` varchar(200) NOT NULL,
  `Cedula` varchar(20) NOT NULL,
  `Direccion` varchar(300) NOT NULL,
  `Telefono` varchar(15) NOT NULL,
  `Email` varchar(250) NOT NULL,
  `Cargo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `depilarte_metodopagos`
--
ALTER TABLE `depilarte_metodopagos`
  ADD PRIMARY KEY (`id_pagos`),
  ADD KEY `metodoPago` (`metodoPago`);

--
-- Indices de la tabla `depilarte_registros`
--
ALTER TABLE `depilarte_registros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FormaPago` (`FormaPago`);

--
-- Indices de la tabla `depilarte_usuarios`
--
ALTER TABLE `depilarte_usuarios`
  ADD PRIMARY KEY (`id_usuarios`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `depilarte_metodopagos`
--
ALTER TABLE `depilarte_metodopagos`
  MODIFY `id_pagos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `depilarte_registros`
--
ALTER TABLE `depilarte_registros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `depilarte_usuarios`
--
ALTER TABLE `depilarte_usuarios`
  MODIFY `id_usuarios` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `depilarte_registros`
--
ALTER TABLE `depilarte_registros`
  ADD CONSTRAINT `depilarte_registros_ibfk_1` FOREIGN KEY (`FormaPago`) REFERENCES `depilarte_metodopagos` (`id_pagos`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
