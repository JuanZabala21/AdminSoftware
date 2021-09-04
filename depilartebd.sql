-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-09-2021 a las 21:54:01
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

--
-- Volcado de datos para la tabla `depilarte_metodopagos`
--

INSERT INTO `depilarte_metodopagos` (`id_pagos`, `metodoPago`) VALUES
(3, 'Efectivo'),
(2, 'Pago Móvil '),
(1, 'Zelle');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depilarte_productos`
--

CREATE TABLE `depilarte_productos` (
  `id_productos` int(11) NOT NULL,
  `id_tratamientos` int(11) NOT NULL,
  `Proveedor` varchar(100) NOT NULL,
  `Cantidad` varchar(100) NOT NULL,
  `Especialista` int(11) NOT NULL,
  `Precio` varchar(159) NOT NULL,
  `Descripcion` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `depilarte_productos`
--

INSERT INTO `depilarte_productos` (`id_productos`, `id_tratamientos`, `Proveedor`, `Cantidad`, `Especialista`, `Precio`, `Descripcion`) VALUES
(1, 5, 'Productive', '3', 1, '45', NULL),
(2, 5, 'probandola', '3', 1, '45', 'Pagala');

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
  `RegisterUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `depilarte_registros`
--

INSERT INTO `depilarte_registros` (`id`, `fechaAtendido`, `Nombre`, `Apellido`, `Cedula`, `Edad`, `Correo`, `FechaCumple`, `Direccion`, `Tratamiento`, `TipoTratamiento`, `ZonaTratamiento`, `CantidadSesiones`, `Asistencia`, `ProductoUtilizado`, `DisparosAntes`, `DisparosDespues`, `DiferenciaDisparos`, `UserAtendio`, `FormaPago`, `Abonado`, `PrecioTotal`, `Comision`, `Nota`, `Telefono`, `RegisterUser`) VALUES
(4, '2021-09-04', 'Juan Pablo', 'Zabala', 'V26900042', '22', 'juanpablozabala21@gmail.com', '1998-12-21', 'Urb.Bosque', 5, 9, 1, '5', '3', 2, NULL, NULL, NULL, NULL, 1, '4455', '3434', '434', 'Pago', '0424-4563683', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depilarte_tipotratamientos`
--

CREATE TABLE `depilarte_tipotratamientos` (
  `id_tipo` int(11) NOT NULL,
  `id_tratamientos` int(11) NOT NULL,
  `nombreTipo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `depilarte_tipotratamientos`
--

INSERT INTO `depilarte_tipotratamientos` (`id_tipo`, `id_tratamientos`, `nombreTipo`) VALUES
(9, 5, 'Laser'),
(10, 5, '4D');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depilarte_tratamientos`
--

CREATE TABLE `depilarte_tratamientos` (
  `id_tratamientos` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Especialista` int(11) NOT NULL,
  `CantidadSesiones` varchar(10) NOT NULL,
  `PrecioTratamiento` varchar(10) NOT NULL,
  `ComisionOperadora` varchar(10) NOT NULL,
  `DescripcionTratamiento` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `depilarte_tratamientos`
--

INSERT INTO `depilarte_tratamientos` (`id_tratamientos`, `Nombre`, `Especialista`, `CantidadSesiones`, `PrecioTratamiento`, `ComisionOperadora`, `DescripcionTratamiento`) VALUES
(5, 'Depilación Laser', 1, '5', '300', '2', 'Alta calidad');

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
  `Cargo` int(11) NOT NULL,
  `FechaIngreso` date NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Edad` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `depilarte_usuarios`
--

INSERT INTO `depilarte_usuarios` (`id_usuarios`, `Nombre`, `Apellido`, `Cedula`, `Direccion`, `Telefono`, `Email`, `Cargo`, `FechaIngreso`, `FechaNacimiento`, `Edad`) VALUES
(2, 'Juan', 'Zabala', 'V26900042', 'Urb. Bosque', '0424-4563683', 'juanpablozabala21@gmail.com', 1, '2021-09-04', '1998-12-21', '22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depilarte_zonatratamientos`
--

CREATE TABLE `depilarte_zonatratamientos` (
  `id_zona` int(11) NOT NULL,
  `id_tratamiento` int(11) NOT NULL,
  `ZonaNombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `depilarte_zonatratamientos`
--

INSERT INTO `depilarte_zonatratamientos` (`id_zona`, `id_tratamiento`, `ZonaNombre`) VALUES
(1, 5, 'Piernas'),
(2, 5, 'Estomago');

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
-- Indices de la tabla `depilarte_productos`
--
ALTER TABLE `depilarte_productos`
  ADD PRIMARY KEY (`id_productos`);

--
-- Indices de la tabla `depilarte_registros`
--
ALTER TABLE `depilarte_registros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FormaPago` (`FormaPago`);

--
-- Indices de la tabla `depilarte_tipotratamientos`
--
ALTER TABLE `depilarte_tipotratamientos`
  ADD PRIMARY KEY (`id_tipo`);

--
-- Indices de la tabla `depilarte_tratamientos`
--
ALTER TABLE `depilarte_tratamientos`
  ADD PRIMARY KEY (`id_tratamientos`);

--
-- Indices de la tabla `depilarte_usuarios`
--
ALTER TABLE `depilarte_usuarios`
  ADD PRIMARY KEY (`id_usuarios`);

--
-- Indices de la tabla `depilarte_zonatratamientos`
--
ALTER TABLE `depilarte_zonatratamientos`
  ADD PRIMARY KEY (`id_zona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `depilarte_metodopagos`
--
ALTER TABLE `depilarte_metodopagos`
  MODIFY `id_pagos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `depilarte_productos`
--
ALTER TABLE `depilarte_productos`
  MODIFY `id_productos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `depilarte_registros`
--
ALTER TABLE `depilarte_registros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `depilarte_tipotratamientos`
--
ALTER TABLE `depilarte_tipotratamientos`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `depilarte_tratamientos`
--
ALTER TABLE `depilarte_tratamientos`
  MODIFY `id_tratamientos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `depilarte_usuarios`
--
ALTER TABLE `depilarte_usuarios`
  MODIFY `id_usuarios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `depilarte_zonatratamientos`
--
ALTER TABLE `depilarte_zonatratamientos`
  MODIFY `id_zona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
