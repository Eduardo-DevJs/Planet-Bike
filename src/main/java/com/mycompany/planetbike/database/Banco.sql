create database bd_planetbike;
use bd_planetbike;

create table admin(
Id int(11) primary key auto_increment not null,
login varchar(200) not null,
senha varchar(50) not null
);

create table funcionario(
Id int(11) primary key auto_increment not null,
login varchar(200) not null,
senha varchar(50) not null
);

create table clientes (
id_cliente int(10) primary key auto_increment not null,
nome varchar(100) not null,
celular varchar(50) not null,
email varchar(50) not null,
cpf varchar(50) not null,
cep varchar(50) not null,
endereco varchar(50) not null,
complemento varchar(50)
);