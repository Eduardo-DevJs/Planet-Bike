create database bd_planetbike;
use bd_planetbike;

create table usuario(
Id int(11) primary key auto_increment not null,
login varchar(200) not null,
senha varchar(50) not null,
perfil varchar(50)
);

INSERT INTO usuario (login, senha) VALUES ('admin', '12345');

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
('João Silva', '(11) 99999-1111', 'joao.silva@email.com', '123.456.789-01', '12345-678', 'Rua A, 123', 'Apto 456'),
('Maria Oliveira', '(22) 98765-4321', 'maria.oliveira@email.com', '987.654.321-09', '54321-876', 'Av. B, 456', 'Casa 789'),
('Carlos Pereira', '(33) 12345-6789', 'carlos.pereira@email.com', '234.567.890-12', '98765-432', 'Rua C, 789', NULL),
('Ana Santos', '(44) 55555-1234', 'ana.santos@email.com', '345.678.901-23', '56789-012', 'Av. D, 012', 'Sala 345'),
('Rodrigo Lima', '(55) 67890-5678', 'rodrigo.lima@email.com', '456.789.012-34', '21098-765', 'Rua E, 345', 'Apto 678'),
('Cristina Souza', '(66) 11223-4455', 'cristina.souza@email.com', '567.890.123-45', '87654-321', 'Av. F, 678', 'Loja 901'),
('Lucas Martins', '(77) 33445-6677', 'lucas.martins@email.com', '678.901.234-56', '43210-987', 'Rua G, 901', NULL),
('Fernanda Costa', '(88) 55667-8899', 'fernanda.costa@email.com', '789.012.345-67', '10987-654', 'Av. H, 234', 'Apto 567'),
('Ricardo Oliveira', '(99) 22334-5566', 'ricardo.oliveira@email.com', '890.123.456-78', '76543-210', 'Rua I, 567', 'Casa 890'),
('Juliana Pereira', '(10) 99999-9999', 'juliana.pereira@email.com', '901.234.567-89', '12345-678', 'Av. J, 890', 'Sala 123');


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


create table produtos(
id_produto int(10) primary key auto_increment not null,
nome varchar(100) not null,
descricao varchar(50) not null,
cfop int(50) not null,
quantidade int(50) not null,
valor_unitario double not null,
total double
);