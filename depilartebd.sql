-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-09-2021 a las 17:05:27
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
-- Estructura de tabla para la tabla `depilarte_cargos`
--

CREATE TABLE `depilarte_cargos` (
  `id_cargo` int(11) NOT NULL,
  `nombreCargo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `depilarte_cargos`
--

INSERT INTO `depilarte_cargos` (`id_cargo`, `nombreCargo`) VALUES
(1, 'Doctora'),
(2, 'Operadora');

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
  `Nombre` varchar(100) NOT NULL,
  `Proveedor` varchar(100) NOT NULL,
  `Cantidad` varchar(100) NOT NULL,
  `Especialista` int(11) NOT NULL,
  `Precio` varchar(159) NOT NULL,
  `Descripcion` varchar(150) DEFAULT NULL,
  `fechaRegistro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `depilarte_productos`
--

INSERT INTO `depilarte_productos` (`id_productos`, `Nombre`, `Proveedor`, `Cantidad`, `Especialista`, `Precio`, `Descripcion`, `fechaRegistro`) VALUES
(1, 'Producto 10', 'Productive', '3', 1, '45', NULL, '2021-09-04'),
(2, 'Producto 2', 'probandola', '3', 1, '45', 'Pagala', '2021-09-02');

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
(4, '2021-09-08', 'Juan Pablo', 'Zabala', 'V26900042', '22', 'juanpablozabala21@gmail.com', '1998-12-21', 'Urb.Bosque', 5, 9, NULL, '5', '3', 2, NULL, NULL, NULL, 2, 1, '4455', '3434', '434', 'Pago', '0424-4563683', 1),
(5, '2021-09-06', 'Jose', 'Perez', '35424654', '43', 'joseperez34@gmail.com', '2011-09-06', 'Trigal', 5, 9, 1, '4', '3', 1, '4', '2', '2', 2, 1, '34', '555', '4', 'Pagado', '0412-4323345', 1),
(6, '2021-09-08', 'Juan', 'Zabala', '2324325', '32', 'juanpablozabala21@gmail.com', '2021-08-29', 'Urb. Bosque4', 5, 10, NULL, '5', '3', 2, NULL, NULL, NULL, 2, 2, '5', '33', '45', 'Pago', '423214345', 1),
(7, '2021-09-08', 'Jefferson', 'Intento 2', '445435354', '33', 'jeffer@gmail.com', '2021-09-05', 'Jefferson', 5, 10, NULL, '5', '5', 1, NULL, NULL, NULL, 2, 2, '54', '32', '5', 'Pago', '4334676', 1),
(8, '2021-09-08', 'Joselyn', 'Perez', '35424654', '43', 'joseperez34@gmail.com', '2011-09-06', 'Trigal', 5, 9, NULL, '4', '3', 1, NULL, NULL, NULL, 2, 1, '34', '555', '4', 'Pagado', '0412-4323345', 1),
(9, '2021-09-08', 'Juan', 'Zabala', 'V26900042', '22', 'juanpablozabala21@gmail.com', '1998-12-21', 'Urb.Bosque', 5, 9, NULL, '5', '3', 2, NULL, NULL, NULL, 2, 1, '4455', '3434', '434', 'Pago', '0424-4563683', 1),
(10, '2021-09-08', 'Alejandro 2', 'Perez', '345435', '32', 'alejandro@gmail.com', '2021-08-29', 'Alejandro ', 5, 10, NULL, '4', '3', 2, NULL, NULL, NULL, 2, 2, '45', '434', '3', '23', '34325454', 1),
(11, '2021-09-08', 'Alejandro', 'Perez', '345435', '32', 'alejandro@gmail.com', '2021-08-29', 'Alejandro ', 5, 10, NULL, '4', '3', 2, NULL, NULL, NULL, 2, 2, '45', '434', '3', '23', '34325454', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depilarte_tipotratamientos`
--

CREATE TABLE `depilarte_tipotratamientos` (
  `id_tipo` int(11) NOT NULL,
  `id_tratamientos` int(11) NOT NULL,
  `typeTreatment` varchar(50) NOT NULL,
  `typePrice` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `depilarte_tipotratamientos`
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
(17, 44, 'Rostro Superior Alto', 55);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depilarte_tratamientos`
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
-- Volcado de datos para la tabla `depilarte_tratamientos`
--

INSERT INTO `depilarte_tratamientos` (`id_tratamientos`, `Nombre`, `Especialista`, `CantidadSesiones`, `ComisionOperadora`, `DescripcionTratamiento`, `fechaRegistro`) VALUES
(5, 'Depilación Laser', 1, '5', '2', 'Alta calidad', '2021-09-04'),
(27, 'Depilacion 34', 1, '34', '3', '32', NULL),
(30, 'Tratamiento 6', 1, '3', '4', 'adsd', NULL),
(40, 'Depilación', 1, '5', '2', 'Paga', NULL),
(41, 'Depilación', 1, '5', '2', 'Paga', NULL),
(42, 'Depilación', 1, '5', '2', 'Paga', NULL),
(44, 'Tratamiento 8', 1, '3', '4', 'Ahora si', NULL);

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
(2, 'Josh', 'Zabala', 'V26900042', 'Urb. Bosque', '1998-12-21', 'juanpablozabala21@gmail.com', 1, '2021-09-09', '1998-12-21', '22');

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
-- Indices de la tabla `depilarte_cargos`
--
ALTER TABLE `depilarte_cargos`
  ADD PRIMARY KEY (`id_cargo`);

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
-- AUTO_INCREMENT de la tabla `depilarte_cargos`
--
ALTER TABLE `depilarte_cargos`
  MODIFY `id_cargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `depilarte_tipotratamientos`
--
ALTER TABLE `depilarte_tipotratamientos`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `depilarte_tratamientos`
--
ALTER TABLE `depilarte_tratamientos`
  MODIFY `id_tratamientos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

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
