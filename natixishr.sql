-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 12-Dez-2017 às 10:36
-- Versão do servidor: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `natixishr`
--
CREATE DATABASE 'natixishr'
-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE `funcionarios` (
  `BI` int(9) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Data_Nascimento` date NOT NULL,
  `Morada` varchar(50) NOT NULL,
  `Categoria` varchar(50) NOT NULL,
  `Funcao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionarios`
--

INSERT INTO `funcionarios` (`BI`, `Nome`, `Data_Nascimento`, `Morada`, `Categoria`, `Funcao`) VALUES
(12345672, 'Alexandre T', '2000-12-08', 'Lisboa', 'Junior', 'Programador'),
(123456781, 'Leonardo Pinheiro', '1997-12-03', 'Mogofores', 'Junior', 'Programador'),
(123456789, 'Pedro Belchior', '1975-06-05', 'Rua Do Cimo, 6', 'Junior', 'Programador'),
(456789123, 'Nuno Santos', '1980-12-24', 'Santo Tirso', 'Junior', 'Programador'),
(987654321, 'Rui Mendes', '1998-12-18', 'Porto', 'Junior', 'Programador');

--
-- Indexes for dumped tables
--

UPDATE `funcionarios` SET `Nome` = 'Nuno' WHERE `funcionarios`.`BI` = 456789123;

DELETE FROM `funcionarios` WHERE `Nome` = 'Rui Mendes';
--
-- Indexes for table `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`BI`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
