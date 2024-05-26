-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-05-2024 a las 13:19:36
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectointegrador`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informacion`
--

CREATE TABLE `informacion` (
  `id_recurso` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `valoracion` int(11) NOT NULL,
  `disponibilidad` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `informacion`
--

INSERT INTO `informacion` (`id_recurso`, `descripcion`, `valoracion`, `disponibilidad`) VALUES
(1, 'Vehículo de Batman.', 4, 'Disponible'),
(2, 'Escudo del Capitán América.', 5, 'No disponible'),
(3, 'Suero de la Hormiga.', 3, 'Disponible'),
(4, 'Montura gigantesca.', 5, 'Disponible'),
(5, 'Telarañas de Spider-Man.', 4, 'No disponible'),
(6, 'Guantelete del Infinito.', 5, 'Disponible'),
(7, 'Máscara de Iron Man.', 4, 'Disponible'),
(8, 'Botas de Flash.', 3, 'No disponible');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localizacion`
--

CREATE TABLE `localizacion` (
  `id_localizacion` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `codigo_postal` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `localizacion`
--

INSERT INTO `localizacion` (`id_localizacion`, `nombre`, `codigo_postal`) VALUES
(1, 'Newport Beach', 92660),
(2, 'Austin', 78701),
(3, 'Seattle', 98101),
(4, 'Miami', 33101),
(5, 'Chicago', 60601),
(6, 'Los Ángeles', 90001),
(7, 'Denver', 80201),
(8, 'Nueva York', 10001),
(9, 'Torre', 38143),
(10, 'sda', 53171);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recursos`
--

CREATE TABLE `recursos` (
  `id_recurso` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fecha` varchar(20) NOT NULL,
  `codigo_postal` int(5) NOT NULL,
  `estadisticas` varchar(50) NOT NULL,
  `id_empresa` int(11) NOT NULL,
  `id_localizacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `recursos`
--

INSERT INTO `recursos` (`id_recurso`, `nombre`, `fecha`, `codigo_postal`, `estadisticas`, `id_empresa`, `id_localizacion`) VALUES
(1, 'Batmóvil', '2021-04-05', 92660, 'Velocidad máxima: 350 km/h', 1, 1),
(2, 'Escudo de Capitán América', '2024-04-05', 78701, 'Peso: 12 kg', 2, 2),
(3, 'Hormiga', '2022-08-03', 98101, 'Reducción de tamaño: 1,000x', 3, 3),
(4, 'Elefante', '2024-04-07', 33101, 'Velocidad de carga: 100 km/h', 4, 4),
(5, 'Telarañas', '2019-01-08', 60601, 'Capacidad de carga: 200 kg', 5, 5),
(6, 'Guantelete del Infinito', '2023-02-15', 90001, 'Control sobre el universo', 6, 6),
(7, 'Máscara de Iron Man', '2022-11-11', 80201, 'Inteligencia artificial integrada', 7, 7),
(8, 'Botas de Flash', '2023-08-20', 10001, 'Velocidad supersónica', 8, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `superempresa`
--

CREATE TABLE `superempresa` (
  `id_empresa` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `superempresa`
--

INSERT INTO `superempresa` (`id_empresa`, `nombre`) VALUES
(1, 'Tech Innovations Inc.'),
(2, 'Global Logistics Solutions'),
(3, 'Healthcare Dynamics Group'),
(4, 'Green Energy Corporation'),
(5, 'Creative Marketing Agency'),
(6, 'Fábrica de Robots Avanzados'),
(7, 'Consultoría de Seguridad Cibernética'),
(8, 'Estudio de Diseño Creativo'),
(9, 'Torrelodones'),
(10, 'sda');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  `contrasena2` varchar(45) NOT NULL,
  `pregunta_seguridad` varchar(200) NOT NULL,
  `respuesta_seguridad` varchar(200) NOT NULL,
  `superpoder` varchar(50) NOT NULL,
  `id_localizacion` int(11) NOT NULL,
  `id_recurso` int(11) NOT NULL,
  `admin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nickname`, `nombre`, `contraseña`, `contrasena2`, `pregunta_seguridad`, `respuesta_seguridad`, `superpoder`, `id_localizacion`, `id_recurso`, `admin`) VALUES
(1, 'laura_garcia', 'Laura García', 'contraseña', '', '¿Nombre de tu mejor amigo de la infancia?', 'Carlos', 'Superpoder 1', 0, 1, 0),
(2, 'david_martinez', 'David Martínez', 'contraseña', '', '¿Lugar de nacimiento de tu abuela?', 'Barcelona', 'Superpoder 2', 0, 2, 0),
(3, 'andrea_lopez', 'Andrea López', 'contraseña', '', '¿Nombre de tu profesor favorito?', 'González', 'Superpoder 3', 0, 3, 0),
(4, 'roberto_sanchez', 'Roberto Sánchez', 'contraseña', '', '¿Nombre de tu primera mascota?', 'Max', 'Superpoder 4', 0, 4, 0),
(5, 'carla_rodriguez', 'Carla Rodríguez', 'contraseña', '', '¿Comida favorita?', 'Pizza', 'Superpoder 5', 0, 5, 0),
(6, 'sergio_gomez', 'Sergio Gómez', 'contraseña', '', '¿Ciudad de nacimiento?', 'Madrid', 'Superpoder 6', 0, 6, 0),
(7, 'ana_perez', 'Ana Pérez', 'contraseña', '', '¿Nombre de soltera de tu madre?', 'González', 'Superpoder 7', 0, 7, 0),
(8, 'luis_hernandez', 'Luis Hernández', 'contraseña', '', '¿Nombre de tu abuelo paterno?', 'Juan', 'Superpoder 8', 0, 8, 0),
(9, 'Server1', 'Server1', 'Server1', 'Server1', 'Nombre de tu primera mascota?', 'Server1', 'Server1', 1, 1, 1),
(10, 'Server12', 'Server12', 'Server12', 'Server12', 'Nombre de tu primera mascota?', 'Server12', 'Server12', 1, 1, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `informacion`
--
ALTER TABLE `informacion`
  ADD PRIMARY KEY (`id_recurso`);

--
-- Indices de la tabla `localizacion`
--
ALTER TABLE `localizacion`
  ADD PRIMARY KEY (`id_localizacion`);

--
-- Indices de la tabla `recursos`
--
ALTER TABLE `recursos`
  ADD PRIMARY KEY (`id_recurso`),
  ADD KEY `fk_recursos_localizacion` (`id_localizacion`),
  ADD KEY `fk_recursos_empresa` (`id_empresa`);

--
-- Indices de la tabla `superempresa`
--
ALTER TABLE `superempresa`
  ADD PRIMARY KEY (`id_empresa`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_usuarios_recurso` (`id_recurso`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `informacion`
--
ALTER TABLE `informacion`
  MODIFY `id_recurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `informacion`
--
ALTER TABLE `informacion`
  ADD CONSTRAINT `fk_informacion_recurso` FOREIGN KEY (`id_recurso`) REFERENCES `recursos` (`id_recurso`);

--
-- Filtros para la tabla `recursos`
--
ALTER TABLE `recursos`
  ADD CONSTRAINT `fk_recursos_empresa` FOREIGN KEY (`id_empresa`) REFERENCES `superempresa` (`id_empresa`),
  ADD CONSTRAINT `fk_recursos_localizacion` FOREIGN KEY (`id_localizacion`) REFERENCES `localizacion` (`id_localizacion`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_usuarios_recurso` FOREIGN KEY (`id_recurso`) REFERENCES `recursos` (`id_recurso`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
