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
