# Criando estrutura

create database leadersofts;

use leadersofts;

CREATE TABLE `cliente` (
  `Id_cliente` int(10) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(18) NOT NULL,
  `peso` double NOT NULL,
  `uf` varchar(60) NOT NULL,
  PRIMARY KEY (`Id_cliente`)
) 
ENGINE=InnoDB DEFAULT CHARSET=latin1 