create database bd_planetbike;
use bd_planetbike;

create table usuario(
Id int(11) primary key auto_increment not null,
login varchar(200) not null,
senha varchar(50) not null,
perfil varchar(50)
);

INSERT INTO usuario (login, senha) VALUES ('admin', '12345');

/* CLIENTES */
create table clientes (
    id_cliente int(10) primary key auto_increment not null,
    nome varchar(100) not null,
    celular varchar(50) not null,
    email varchar(50) not null,
    cpf varchar(50) unique not null,
    cep varchar(50) not null,
    endereco varchar(50) not null,
    complemento varchar(50)
);

INSERT INTO clientes (nome, celular, email, cpf, cep, endereco, complemento)
VALUES
('João Silva', '123456789', 'joao.silva@email.com', '123.456.789-01', '12345-678', 'Rua A, 123', 'Apto 101'),
('Maria Oliveira', '987654321', 'maria.oliveira@email.com', '987.654.321-02', '54321-876', 'Avenida B, 456', 'Casa 202'),
('Carlos Santos', '111222333', 'carlos.santos@email.com', '111.222.333-03', '98765-432', 'Travessa C, 789', 'Sala 303'),
('Ana Pereira', '444555666', 'ana.pereira@email.com', '444.555.666-04', '87654-321', 'Rua D, 987', 'Apartamento 404'),
('Pedro Souza', '999888777', 'pedro.souza@email.com', '999.888.777-05', '23456-789', 'Avenida E, 654', 'Lote 505');


/* ORDENS */
create table ordens (
    os int primary key auto_increment,
    data_os timestamp default current_timestamp,
    servico text,
    defeito text,
    pecas text,
    valor_total DECIMAL(10, 2),
    observacoes TEXT,
    id_cliente int not null,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

SELECT * FROM bd_planetbike.ordens;
describe ordens;
-- A linha abaixo altera a tabela adicionando u mcampo em uma determinada posicao
alter table ordens add tipo varchar(15) not null after data_os;
alter table ordens add situacao varchar(20) not null after tipo;
alter table ordens add funcionario varchar(200) not null after situacao;

TRUNCATE TABLE ordens;
select * from ordens;
select os,date_format(data_os, '%d/%m/%Y - %H:%i'), tipo, situacao, funcionario, modelo, cor, descricao, valor_total, id_cliente from ordens where os=4;


/* PRODUTOS */

create table produtos(
    id_produto int(10) primary key auto_increment not null,
    nome varchar(100) not null,
    descricao varchar(50) not null,
    cfop int(50) not null,
    quantidade int(50) not null,
    valor_unitario double not null,
    total double
);

INSERT INTO produtos (nome, descricao, cfop, quantidade, valor_unitario, total)
VALUES
('Produto A', 'Descrição do Produto A', 5102, 100, 10.50, 1050.00),
('Produto B', 'Descrição do Produto B', 5403, 50, 20.75, 1037.50),
('Produto C', 'Descrição do Produto C', 6102, 75, 8.90, 667.50),
('Produto D', 'Descrição do Produto D', 7102, 30, 15.25, 457.50),
('Produto E', 'Descrição do Produto E', 8102, 120, 5.80, 696.00);
