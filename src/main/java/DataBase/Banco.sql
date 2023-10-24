create database bd_planetbike;
use bd_planetbike;

create table funcionario(
funcionarioId int(11) primary key auto_increment not null,
nome varchar(200) not null,
senha varchar(50) not null,
perfil varchar(50) not null
);

