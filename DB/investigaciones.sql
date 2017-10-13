-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-10-2017 a las 09:04:30
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `investigaciones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE `comentario` (
  `ID_COMENT` int(11) NOT NULL,
  `ID_MIEMBRO` int(11) DEFAULT NULL,
  `ID_TRABAJO` int(11) NOT NULL,
  `TEXTO` varchar(150) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comite`
--

CREATE TABLE `comite` (
  `ID_COMITE` int(11) NOT NULL,
  `ASIGNACION` date DEFAULT NULL,
  `DISOLUCION` date DEFAULT NULL,
  `OBSERVACION` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `miembro`
--

CREATE TABLE `miembro` (
  `ID_MIEMBRO` int(11) NOT NULL,
  `USERNAME_M` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `PASSWORD_M` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `FIRST_NAME_M` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `LAST_NAME_M` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `EMAIL_M` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `miembros`
--

CREATE TABLE `miembros` (
  `ID_COMITE` int(11) NOT NULL,
  `ID_MIEMBRO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajo`
--

CREATE TABLE `trabajo` (
  `ID_TRABAJO` int(11) NOT NULL,
  `ID_COMITE` int(11) DEFAULT NULL,
  `ID_USER` int(11) DEFAULT NULL,
  `TITLE` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `NAME_FILE` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `DESCRIPTION` varchar(100) COLLATE latin1_spanish_ci DEFAULT NULL,
  `ESTADO` varchar(20) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID_USER` int(11) NOT NULL,
  `USERNAME` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `PASSWORD` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `FIRST_NAME` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `LAST_NAME` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `EMAIL` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `UNIVERSITY` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`ID_COMENT`),
  ADD KEY `FK_COMENTAR_COMENTADO_MIEMBRO` (`ID_MIEMBRO`),
  ADD KEY `FK_COMENTAR_PUEDE_TEN_TRABAJO` (`ID_TRABAJO`);

--
-- Indices de la tabla `comite`
--
ALTER TABLE `comite`
  ADD PRIMARY KEY (`ID_COMITE`);

--
-- Indices de la tabla `miembro`
--
ALTER TABLE `miembro`
  ADD PRIMARY KEY (`ID_MIEMBRO`);

--
-- Indices de la tabla `miembros`
--
ALTER TABLE `miembros`
  ADD KEY `FK_MIEMBROS_CADA_UNO__MIEMBRO` (`ID_MIEMBRO`),
  ADD KEY `FK_MIEMBROS_TIENE_VAR_COMITE` (`ID_COMITE`);

--
-- Indices de la tabla `trabajo`
--
ALTER TABLE `trabajo`
  ADD PRIMARY KEY (`ID_TRABAJO`),
  ADD KEY `FK_TRABAJO_TIENE_USUARIO` (`ID_USER`),
  ADD KEY `FK_TRABAJO_TIENE_ASI_COMITE` (`ID_COMITE`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID_USER`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comentario`
--
ALTER TABLE `comentario`
  MODIFY `ID_COMENT` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `comite`
--
ALTER TABLE `comite`
  MODIFY `ID_COMITE` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `miembro`
--
ALTER TABLE `miembro`
  MODIFY `ID_MIEMBRO` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `trabajo`
--
ALTER TABLE `trabajo`
  MODIFY `ID_TRABAJO` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID_USER` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `FK_COMENTAR_COMENTADO_MIEMBRO` FOREIGN KEY (`ID_MIEMBRO`) REFERENCES `miembro` (`ID_MIEMBRO`),
  ADD CONSTRAINT `FK_COMENTAR_PUEDE_TEN_TRABAJO` FOREIGN KEY (`ID_TRABAJO`) REFERENCES `trabajo` (`ID_TRABAJO`);

--
-- Filtros para la tabla `miembros`
--
ALTER TABLE `miembros`
  ADD CONSTRAINT `FK_MIEMBROS_CADA_UNO__MIEMBRO` FOREIGN KEY (`ID_MIEMBRO`) REFERENCES `miembro` (`ID_MIEMBRO`),
  ADD CONSTRAINT `FK_MIEMBROS_TIENE_VAR_COMITE` FOREIGN KEY (`ID_COMITE`) REFERENCES `comite` (`ID_COMITE`);

--
-- Filtros para la tabla `trabajo`
--
ALTER TABLE `trabajo`
  ADD CONSTRAINT `FK_TRABAJO_TIENE_ASI_COMITE` FOREIGN KEY (`ID_COMITE`) REFERENCES `comite` (`ID_COMITE`),
  ADD CONSTRAINT `FK_TRABAJO_TIENE_USUARIO` FOREIGN KEY (`ID_USER`) REFERENCES `usuario` (`ID_USER`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
