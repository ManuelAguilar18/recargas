-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-12-2023 a las 07:14:56
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `recargas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora`
--

CREATE TABLE `bitacora` (
  `id` int(11) NOT NULL,
  `idPlan` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `monto` double NOT NULL,
  `fechaPago` date NOT NULL,
  `fechaProceso` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bitacora`
--

INSERT INTO `bitacora` (`id`, `idPlan`, `numero`, `monto`, `fechaPago`, `fechaProceso`) VALUES
(1, 5, 1234567891, 50, '2023-12-10', '2023-12-10'),
(2, 5, 1234567891, 50, '2023-12-10', '2023-12-10'),
(3, 5, 1234567891, 50, '2023-12-10', '2023-12-10'),
(4, 5, 1234567891, 50, '2023-12-10', '2023-12-10'),
(5, 5, 1234567891, 50, '2023-12-10', '2023-12-10'),
(6, 5, 1234567892, 50, '2023-12-11', '2023-12-11');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historico_pagos`
--

CREATE TABLE `historico_pagos` (
  `id` int(11) NOT NULL,
  `numeroCelular` int(11) NOT NULL,
  `monto` double NOT NULL,
  `idPlan` int(11) NOT NULL,
  `fechaPago` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historico_pagos`
--

INSERT INTO `historico_pagos` (`id`, `numeroCelular`, `monto`, `idPlan`, `fechaPago`) VALUES
(1, 1234567890, 50, 5, '2023-12-09 00:00:00'),
(2, 1234567891, 50, 5, '2023-12-09 05:27:00'),
(3, 1234567891, 50, 5, '2023-12-10 15:03:15'),
(4, 1234567891, 50, 5, '2023-12-10 15:18:53'),
(5, 1234567891, 50, 5, '2023-12-10 15:37:22'),
(6, 1234567891, 50, 5, '2023-12-10 19:07:11'),
(7, 1234567891, 50, 5, '2023-12-10 20:45:47'),
(8, 1234567892, 50, 5, '2023-12-11 00:13:03');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plan`
--

CREATE TABLE `plan` (
  `id` int(11) NOT NULL,
  `nombreCompania` varchar(250) NOT NULL,
  `nombreCorto` varchar(250) NOT NULL,
  `estatus` int(11) NOT NULL,
  `idPlan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `plan`
--

INSERT INTO `plan` (`id`, `nombreCompania`, `nombreCorto`, `estatus`, `idPlan`) VALUES
(1, 'TELCEL', 'TL', 1, 1),
(2, 'UNEFON', 'UF', 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_plan`
--

CREATE TABLE `tipo_plan` (
  `id` int(11) NOT NULL,
  `idPlan` int(11) NOT NULL,
  `compania` varchar(250) NOT NULL,
  `detallePlan` varchar(250) NOT NULL,
  `costo` int(11) NOT NULL,
  `vigencia` varchar(250) NOT NULL,
  `nombrePlan` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_plan`
--

INSERT INTO `tipo_plan` (`id`, `idPlan`, `compania`, `detallePlan`, `costo`, `vigencia`, `nombrePlan`) VALUES
(1, 1, 'telcel', 'Gigas Sin Frontera 2, \r\nMinutos y SMS Sin Frontera\r\nIlimitados\r\nMéxico / E.U.A. / Canadá\r\nMensajería Sin Frontera\r\nIlimitado\r\nMéxico / E.U.A. / Canadá\r\nwhatsapp\r\nRedes Sociales Nacionales', 150, '26 días\r\n', 'Paquete Amigo Sin Límite 150'),
(2, 1, 'telcel', 'Megas Sin Frontera\r\n50\r\nMéxico / E.U.A. / Canadá*\r\nMinutos y SMS Sin Frontera\r\nIlimitados\r\nMéxico / E.U.A. / Canadá\r\nMensajería Sin Frontera\r\nIlimitados\r\nMéxico / E.U.A. / Canad', 10, '1 día', 'Paquete Amigo Sin Límite 10'),
(3, 1, 'telcel', 'Megas Sin Frontera\r\n100\r\nMéxico / E.U.A. / Canadá*\r\nMinutos y SMS Sin Frontera\r\nIlimitados\r\nMéxico / E.U.A. / Canadá\r\nMensajería Sin Frontera\r\nIlimitados\r\nMéxico / E.U.A. / Canadá\r\nwhatsapp\r\nRedes Sociales Nacionales\r\n200 MB', 20, '2', 'Paquete Amigo Sin Límite 20'),
(4, 1, 'telcel', 'Megas Sin Frontera\r\n160\r\nMéxico / E.U.A. / Canadá*\r\nMinutos y SMS Sin Frontera\r\nIlimitados\r\nMéxico / E.U.A. / Canadá\r\nMensajería Sin Frontera\r\nIlimitados\r\nMéxico / E.U.A. / Canadá\r\nwhatsapp\r\nRedes Sociales Nacionales\r\n300 MB', 30, '3 días', 'Paquete Amigo Sin Límite 30'),
(5, 2, 'unefon', '300 MB Tú decides, usa tus megas en todas tus redes sociales y apps favoritas', 30, '30 días', 'Plan $30'),
(6, 2, 'unefon', '600 MB Tú decides, usa tus megas en todas tus redes sociales y apps favoritas', 50, '7 días', 'Plan $50'),
(7, 2, 'unefon', '1.2 GB Tú decides, usa tus megas en todas tus redes sociales y apps favoritas', 100, '17 días', 'Plan $100'),
(8, 2, 'unefon', '2 GB Tú decides, usa tus megas en todas tus redes sociales y apps favoritas', 150, '28 días', 'Plan $150'),
(9, 2, 'unefon', '2.6 GB Tú decides, usa tus megas en todas tus redes sociales y apps favoritas', 200, '35 días', 'Plan $200');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bitacora`
--
ALTER TABLE `bitacora`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `historico_pagos`
--
ALTER TABLE `historico_pagos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `plan`
--
ALTER TABLE `plan`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_plan`
--
ALTER TABLE `tipo_plan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bitacora`
--
ALTER TABLE `bitacora`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `historico_pagos`
--
ALTER TABLE `historico_pagos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
