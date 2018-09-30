create database paises;
use paises;

create table if not exists pais
(
	id int auto_increment not null,
    nome varchar(100),
    populacao bigint,
    area decimal(15,2),
    primary key(id)
);

create table if not exists usuario
(
	id int auto_increment not null,
    usuario varchar(20),
    senha varchar(40),
    primary key(id)
);

insert into pais(nome, populacao, area) values('Russia', 140300000, 17.07);
insert into pais(nome, populacao, area) values('Canada', 33800000, 9.97);
insert into pais(nome, populacao, area) values('China', 1300000000, 9.59);
insert into pais(nome, populacao, area) values('Estados Unidos', 317600000, 9.36);
insert into pais(nome, populacao, area) values('Argentina', 40600000, 2.27);
insert into pais(nome, populacao, area) values('Brasil', 19070000, 8.51);
select * from usuario;