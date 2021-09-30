-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-10-2021 a las 01:41:20
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
(2, 'Producto 2', 'probandola', '3', 1, '45', 'Pagala', '2021-09-02'),
(3, 'Producto 4', 'Luis', '5', 1, '100', 'Este dminisn', NULL),
(4, 'Michi', 'Michi', '5', 2, '1', 'Este es michi', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depilarte_referencia`
--

CREATE TABLE `depilarte_referencia` (
  `id_ref` int(11) NOT NULL,
  `nombre_ref` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `depilarte_referencia`
--

INSERT INTO `depilarte_referencia` (`id_ref`, `nombre_ref`) VALUES
(1, 'Instagram'),
(2, 'Referidos'),
(3, 'Otros');

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
  `ProductoUtilizado` varchar(20) DEFAULT NULL,
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
-- Volcado de datos para la tabla `depilarte_registros`
--

INSERT INTO `depilarte_registros` (`id`, `fechaAtendido`, `Nombre`, `Apellido`, `Cedula`, `Edad`, `Correo`, `FechaCumple`, `Direccion`, `Tratamiento`, `TipoTratamiento`, `ZonaTratamiento`, `CantidadSesiones`, `Asistencia`, `ProductoUtilizado`, `DisparosAntes`, `DisparosDespues`, `DiferenciaDisparos`, `UserAtendio`, `FormaPago`, `Abonado`, `PrecioTotal`, `Comision`, `Nota`, `Telefono`, `RegisterUser`, `Referencia`) VALUES
(4, '2021-09-27', 'Carlos', 'Zabala', '26900042', '22', 'carlos@gmai.com', '1998-12-21', 'Urb.Bosque', 5, 9, NULL, '5', '3', '2', NULL, NULL, NULL, 2, 1, '4455', '56', '434', 'Pago', '04245555555', 1, 1),
(5, '2021-09-06', 'Jose', 'Perez', '35424654', '43', 'joseperez34@gmail.com', '2011-09-06', 'Trigal', 5, 9, 1, '4', '3', '1', '4', '2', '2', 2, 1, '34', '555', '4', 'Pagado', '0412-4323345', 1, 0),
(6, '2021-09-08', 'Juan', 'Zabala', '2324325', '32', 'juanpablozabala21@gmail.com', '2021-08-29', 'Urb. Bosque4', 5, 10, NULL, '5', '3', '2', NULL, NULL, NULL, 2, 2, '5', '33', '45', 'Pago', '423214345', 1, 0),
(7, '2021-09-08', 'Jefferson', 'Intento 2', '445435354', '33', 'jeffer@gmail.com', '2021-09-05', 'Jefferson', 5, 10, NULL, '5', '5', '1', NULL, NULL, NULL, 2, 2, '54', '32', '5', 'Pago', '4334676', 1, 0),
(8, '2021-09-08', 'Joselyn', 'Perez', '35424654', '43', 'joseperez34@gmail.com', '2011-09-06', 'Trigal', 5, 9, NULL, '4', '3', '1', NULL, NULL, NULL, 2, 1, '34', '555', '4', 'Pagado', '0412-4323345', 1, 0),
(9, '2021-09-08', 'Juan', 'Zabala', 'V26900042', '22', 'juanpablozabala21@gmail.com', '1998-12-21', 'Urb.Bosque', 5, 9, NULL, '5', '3', '2', NULL, NULL, NULL, 2, 1, '4455', '3434', '434', 'Pago', '0424-4563683', 1, 0),
(10, '2021-09-11', 'Alejandro 2', 'Perez', '345435', '32', 'alejandro@gmail.com', '2021-08-29', 'Alejandro ', 5, 10, NULL, '4', '3', '2', NULL, NULL, NULL, 2, 2, '100', '434', '3', '23', '034236666', 1, 0),
(11, '2021-09-08', 'Alejandro', 'Perez', '345435', '32', 'alejandro@gmail.com', '2021-08-29', 'Alejandro ', 5, 10, NULL, '4', '3', '2', NULL, NULL, NULL, 2, 2, '45', '434', '3', '23', '34325454', 1, 0),
(12, '2021-09-11', 'Anna', 'Vergani', '34234', '20', 'anna@gmail.com', '2021-02-09', 'Mañongo', 5, 9, NULL, '5', NULL, '1', NULL, NULL, NULL, 9, 1, '40', '20', '4', 'El paciente viene a menuda', '0414566666', 1, 0),
(13, '2021-09-11', 'Francis', 'Reyes', '342353', '30', 'Francis@gmail.com', '2021-09-15', 'Trigal sur', 5, 9, NULL, '3', NULL, '2', NULL, NULL, NULL, 10, 3, '50', '100', '80', 'Este presenta ', '4353453', 1, 0),
(14, '2021-09-13', 'Luis jose', 'Marcano', '34239423', '22', 'michi@gmail.com', '2021-11-09', 'Mexico Guadalajara', 5, 9, NULL, '1', NULL, '3', NULL, NULL, NULL, 9, 1, '0', '200', '90', 'Michi es gay', '04143636327', 1, 0),
(15, '2021-09-21', 'Luis Alejandro', 'MArino', '27188725', '23', 'luis@gmail.com', '2021-06-11', 'Trigal norte', 5, 9, NULL, '1', NULL, '1', NULL, NULL, NULL, 10, 3, '40', '50', '70', 'Francis', '04145810329', 1, 1),
(16, '2021-09-23', 'Jefferson', 'Gutierrez', '344545', '22', 'ddffddfs', '2021-09-07', '4545', 30, 15, NULL, '455', NULL, '2', NULL, NULL, NULL, 9, 3, '564', '3', '45', '45', '44544545', 1, 1),
(17, '2021-09-23', 'Pedro', 'Perez', '3455354', '23', 'Pedrop@gmail.com', '2021-09-07', 'Pedro', 5, 9, NULL, '34', NULL, '2', NULL, NULL, NULL, 9, 3, '45', '35', '4', '454', '3454543', 1, 2),
(18, '2021-09-27', 'fdsfdsfd', 'dfsdsffds', '45454', '44', 'dfdsffds', '2021-09-13', 'pdsdjsdf', 5, 10, NULL, NULL, NULL, '2', '45', '45', NULL, 12, 3, '45', '68', '54', 'Pago', '454545', 2, 1),
(19, '2021-09-27', 'Juan Jose', 'Guitierrez', '453455', '32', 'JuanJ@gmail.com', '2021-09-07', 'Villa', 5, 9, NULL, NULL, NULL, NULL, '345', '34', NULL, 12, 3, '43', '56', '53', 'Pagala', '434543543', 2, 2),
(20, '2021-09-29', 'Jefferson', 'Yakitory', '343245', '32', 'jefferson@gmail.com', '2021-09-06', 'sddsasa', 5, 9, NULL, NULL, NULL, NULL, '56', '3', NULL, 12, 2, '56', '56', '45', 'dfsds', '3435354', 2, 1),
(21, '2021-09-29', 'sadsda', 'sdadsadsa', '343443', '43', 'dsdsdfsfd', '2021-09-07', 'dsaasdssa', 27, 12, NULL, NULL, NULL, NULL, '54', '3', NULL, 12, 3, '45', '23', '43', 'dssa', '4543543', 2, 2),
(22, '2021-09-29', 'Pedro', 'Perez', '343553', '22', 'PedroPerez34@gmail.com', '2021-08-29', 'Valencia', 5, 37, NULL, NULL, NULL, NULL, '10', '9', '1', 12, 3, '100', '100', '3', 'Pago ', '2324324234', 2, 2),
(23, '2021-09-29', 'Ferdinand', 'Yohanderson', '324324', '32', 'adsdasds', '2021-09-27', '434343', 5, 10, NULL, NULL, NULL, NULL, '250', '30', '220', 11, 2, '4343', '68', '434', 'add', '3443434', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depilarte_tipotratamientos`
--

CREATE TABLE `depilarte_tipotratamientos` (
  `id_tipo` int(11) NOT NULL,
  `id_tratamientos` int(11) NOT NULL,
  `typeTreatment` varchar(50) NOT NULL,
  `typePrice` int(11) DEFAULT NULL,
  `comission` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `depilarte_tipotratamientos`
--

INSERT INTO `depilarte_tipotratamientos` (`id_tipo`, `id_tratamientos`, `typeTreatment`, `typePrice`, `comission`) VALUES
(9, 5, 'Estupido', 56, NULL),
(10, 5, 'Vamoss', 68, NULL),
(11, 27, 'Tratamiento 7', 23, NULL),
(12, 27, 'Tratamiento 7', 23, NULL),
(13, 29, 'Laser', 200, NULL),
(14, 29, 'Cera', 20, NULL),
(15, 30, 'Rostro-Superior', 3, NULL),
(16, 42, 'Rostroterciosuperior', 200, NULL),
(17, 44, 'Rostro Superior Alto', 55, NULL),
(18, 46, 'Paquete1', 100, NULL),
(19, 46, '5', 5, NULL),
(20, 47, 'Acido', 150, NULL),
(21, 47, 'Plasma', 100, NULL),
(37, 5, 'Tipo 238', 100, NULL),
(38, 49, 'Caree', 32, '10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depilarte_tratamientos`
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
-- Volcado de datos para la tabla `depilarte_tratamientos`
--

INSERT INTO `depilarte_tratamientos` (`id_tratamientos`, `Nombre`, `Especialista`, `CantidadSesiones`, `DescripcionTratamiento`, `fechaRegistro`) VALUES
(5, 'Depilacion Laser', 1, '5', 'Alta calidad', '2021-09-04'),
(27, 'Depilacion 34', 1, '34', '32', NULL),
(30, 'Tratamiento 6', 1, '3', 'adsd', NULL),
(40, 'Depilación', 1, '5', 'Paga', NULL),
(41, 'Depilación', 1, '5', 'Paga', NULL),
(42, 'Depilación', 1, '5', 'Paga', NULL),
(44, 'Tratamiento 8', 1, '3', 'Ahora si', NULL),
(46, 'Masaje', 2, '5', 'Paquetes de promoción', NULL),
(47, 'Botox', 1, '3', 'Botox es ', NULL),
(48, 'Bronceado', 2, '1', 'Bronceado de piernas de Valen ', NULL),
(49, 'Botoxito', 1, '15', 'Prueba', NULL);

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
(2, 'Josh', 'Zabala', 'V26900042', 'Urb. Bosque', '1998-12-21', 'juanpablozabala21@gmail.com', 1, '2021-09-09', '1998-12-21', '22'),
(9, 'Luis', 'Marino', '27188725', 'Trigal', '04145810329', 'luis@gmail.com', 1, '2021-09-11', '1998-06-11', '23'),
(10, 'Francis', 'Reyes', '18500193', 'Trigal', '04144263906', 'francisreyes11@gmail.com', 1, '2021-09-11', '2021-03-11', '36'),
(11, 'Luis', 'Marino', '27188725', 'Trigal', '04145810329', 'lamvkey98@gmail.com', 2, '2021-09-23', '2021-06-11', '23'),
(12, 'Juan Fernando', 'Sanchez', '4343245432', 'Valencia', '433535', 'juanfer@gmail.com', 2, '2021-09-27', '2021-09-08', '32');

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
-- Indices de la tabla `depilarte_referencia`
--
ALTER TABLE `depilarte_referencia`
  ADD PRIMARY KEY (`id_ref`);

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
  MODIFY `id_productos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `depilarte_referencia`
--
ALTER TABLE `depilarte_referencia`
  MODIFY `id_ref` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `depilarte_registros`
--
ALTER TABLE `depilarte_registros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `depilarte_tipotratamientos`
--
ALTER TABLE `depilarte_tipotratamientos`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de la tabla `depilarte_tratamientos`
--
ALTER TABLE `depilarte_tratamientos`
  MODIFY `id_tratamientos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT de la tabla `depilarte_usuarios`
--
ALTER TABLE `depilarte_usuarios`
  MODIFY `id_usuarios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

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
