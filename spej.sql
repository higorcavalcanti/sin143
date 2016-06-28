-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 29, 2016 at 01:56 AM
-- Server version: 5.6.25
-- PHP Version: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spej`
--

-- --------------------------------------------------------

--
-- Table structure for table `atividade`
--

CREATE TABLE IF NOT EXISTS `atividade` (
  `id` int(11) NOT NULL,
  `ponto_id` int(11) NOT NULL,
  `relatorio` text NOT NULL,
  `observacao` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atividade`
--

INSERT INTO `atividade` (`id`, `ponto_id`, `relatorio`, `observacao`) VALUES
(1, 1, 'Não sei oque foi feito', NULL),
(2, 3, '....', NULL),
(3, 4, '...........', NULL),
(4, 5, 'Atividade 1', NULL),
(5, 6, 'Atividade 2\n', NULL),
(6, 7, 'at 3\n', NULL),
(7, 8, 'at 4\n', NULL),
(8, 9, 'at 5', NULL),
(9, 10, 'atividade leticia', NULL),
(10, 11, 'Relatorio 2 leticia', NULL),
(11, 13, 'sdadas', NULL),
(12, 15, 'asda', NULL),
(13, 16, 'Oque eu fiz hoje', NULL),
(14, 17, 'brilhou', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `departamentos`
--

CREATE TABLE IF NOT EXISTS `departamentos` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departamentos`
--

INSERT INTO `departamentos` (`id`, `nome`) VALUES
(1, 'Presidência'),
(2, 'Vice-Presidência'),
(3, 'Administrativo Financeiro'),
(4, 'Gestão de Pessoas'),
(5, 'Projetos...'),
(6, 'Qualidade'),
(7, 'Relações Publicas e Marketing'),
(8, 'Novo departamento');

-- --------------------------------------------------------

--
-- Table structure for table `ponto`
--

CREATE TABLE IF NOT EXISTS `ponto` (
  `id` int(11) NOT NULL,
  `usuario_matricula` int(11) NOT NULL,
  `entrada` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `saida` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ponto`
--

INSERT INTO `ponto` (`id`, `usuario_matricula`, `entrada`, `saida`) VALUES
(1, 3621, '2016-06-19 16:37:23', '2016-06-19 20:37:25'),
(2, 3634, '2016-06-19 22:22:25', '2016-06-19 22:22:38'),
(3, 3621, '2016-06-20 17:04:15', '2016-06-20 17:04:17'),
(4, 3621, '2016-06-20 17:14:16', '2016-06-20 17:14:18'),
(5, 3621, '2016-06-20 22:33:26', '2016-06-20 22:33:27'),
(6, 3621, '2016-06-20 22:33:31', '2016-06-20 22:33:32'),
(7, 3621, '2016-06-20 22:33:36', '2016-06-20 22:33:36'),
(8, 3621, '2016-06-20 22:33:41', '2016-06-20 22:33:42'),
(9, 3621, '2016-06-20 22:33:45', '2016-06-20 22:33:45'),
(10, 3634, '2016-06-20 23:11:43', '2016-06-20 23:11:45'),
(11, 3634, '2016-06-20 23:23:22', '2016-06-20 23:23:24'),
(12, 3621, '2016-06-23 12:13:57', '2016-06-23 12:13:58'),
(13, 3621, '2016-06-23 16:50:32', '2016-06-23 16:53:17'),
(14, 0, '2016-06-23 16:50:35', '2016-06-23 16:50:37'),
(15, 3621, '2016-06-23 17:23:15', '2016-06-23 17:23:18'),
(16, 1, '2016-06-23 17:45:47', '2016-06-23 17:45:54'),
(17, 3621, '2016-06-24 05:24:37', '2016-06-24 05:24:52');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `matricula` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `nome` varchar(50) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `departamento` int(11) NOT NULL,
  `password` varchar(32) DEFAULT NULL,
  `nascimento` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `admin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`matricula`, `username`, `nome`, `cargo`, `departamento`, `password`, `nascimento`, `email`, `admin`) VALUES
(0, 'admin', 'Administrador', 'Administrador', 1, 'admin', '0000-00-00', '', 1),
(1, NULL, 'Nome', 'Cargo', 3, NULL, '1990-05-10', 'asd@asd.com', 0),
(3620, NULL, 'Daniel Araújo Silva', 'Gerente de Desenvolvimento', 5, NULL, '2016-01-01', 'daniel...', 0),
(3621, NULL, 'Higor Daniel Cavalcanti Silva', 'Diretor de Projetos', 5, NULL, '1996-05-14', 'higordaniell@live.com', 0),
(3634, NULL, 'Letícia Lopes Moreira', 'Diretora de Qualidade', 6, NULL, '1996-01-27', 'leticiamoreira.ml@gmail.com', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `atividade`
--
ALTER TABLE `atividade`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ponto`
--
ALTER TABLE `ponto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`matricula`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `atividade`
--
ALTER TABLE `atividade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `departamentos`
--
ALTER TABLE `departamentos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `ponto`
--
ALTER TABLE `ponto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
