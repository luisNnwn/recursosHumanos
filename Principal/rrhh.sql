-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-05-2025 a las 23:51:54
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `rrhh`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE `asistencia` (
  `id` int(11) NOT NULL,
  `empleado_id` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora_entrada` time DEFAULT NULL,
  `hora_salida` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `asistencia`
--

INSERT INTO `asistencia` (`id`, `empleado_id`, `fecha`, `hora_entrada`, `hora_salida`) VALUES
(7, 5, '2025-04-08', '17:12:45', '17:12:57'),
(8, 6, '2025-04-08', '17:34:34', '17:39:01'),
(9, 8, '2025-04-08', '20:06:38', '20:07:01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `fecha_ingreso` date DEFAULT NULL,
  `cargo` varchar(255) DEFAULT NULL,
  `salario` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id`, `nombre`, `apellido`, `correo`, `telefono`, `direccion`, `fecha_ingreso`, `cargo`, `salario`) VALUES
(5, 'Emmanuel', 'Escobar', 'emmanuelluna420@outlook.com', '22726659', 'Metrópolis Norte', '2025-04-27', 'Empleado', 1500),
(6, 'Cinthia', 'Rivera', 'cinthia@gmail.com', '77531032', 'Suchitoto', '2025-04-09', 'Empleado', 2000),
(8, 'Luis', 'Nelson', 'luis@gmail.com', '78459362', 'Santa Tecla', '2025-04-08', 'Gerente', 2500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluacion_desempeno`
--

CREATE TABLE `evaluacion_desempeno` (
  `id` int(11) NOT NULL,
  `empleado_id` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `evaluador` varchar(255) DEFAULT NULL,
  `puntuacion` int(11) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `evaluacion_desempeno`
--

INSERT INTO `evaluacion_desempeno` (`id`, `empleado_id`, `fecha`, `evaluador`, `puntuacion`, `observaciones`) VALUES
(2, 5, '2025-04-07', 'Andres', 10, 'Responsable'),
(4, 6, '2025-04-08', 'Andres', 3, 'Dormilona'),
(5, 8, '2025-04-08', 'Carlos', 7, 'No vino ayer');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permiso`
--

CREATE TABLE `permiso` (
  `id` int(11) NOT NULL,
  `empleado_id` int(11) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `motivo` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `permiso`
--

INSERT INTO `permiso` (`id`, `empleado_id`, `tipo`, `fecha_inicio`, `fecha_fin`, `motivo`, `estado`) VALUES
(4, 5, 'Enfermedad', '2025-04-05', '2025-04-06', 'Tiene COVID.', 'Aprobado'),
(5, 6, 'Enfermedad', '2025-04-08', '2025-04-09', 'Dolor de estomágo', 'Rechazado'),
(6, 8, 'Cirugia dental', '2025-04-08', '2025-04-15', 'Hemorragia e infección', 'Aprobado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `password`, `rol`, `username`) VALUES
(1, '1234', 'ADMIN', 'admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `empleado_id` (`empleado_id`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `evaluacion_desempeno`
--
ALTER TABLE `evaluacion_desempeno`
  ADD PRIMARY KEY (`id`),
  ADD KEY `empleado_id` (`empleado_id`);

--
-- Indices de la tabla `permiso`
--
ALTER TABLE `permiso`
  ADD PRIMARY KEY (`id`),
  ADD KEY `empleado_id` (`empleado_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `evaluacion_desempeno`
--
ALTER TABLE `evaluacion_desempeno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `permiso`
--
ALTER TABLE `permiso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `asistencia_ibfk_1` FOREIGN KEY (`empleado_id`) REFERENCES `empleado` (`id`);

--
-- Filtros para la tabla `evaluacion_desempeno`
--
ALTER TABLE `evaluacion_desempeno`
  ADD CONSTRAINT `evaluacion_desempeno_ibfk_1` FOREIGN KEY (`empleado_id`) REFERENCES `empleado` (`id`);

--
-- Filtros para la tabla `permiso`
--
ALTER TABLE `permiso`
  ADD CONSTRAINT `permiso_ibfk_1` FOREIGN KEY (`empleado_id`) REFERENCES `empleado` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
