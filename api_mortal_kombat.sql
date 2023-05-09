create database if not exists api_mortal_kombat;

use api_mortal_kombat;

create table if not exists usuarios(
id int primary key auto_increment,
nome_usuario varchar(30) not null unique key,
senha varchar(15) not null,
email varchar(50) not null unique key
);

create table if not exists arenas(
id tinyint primary key auto_increment,
nome_arena varchar(30) not null unique key,
localizacao varchar(30) not null,
aparencia varchar(30) not null,
aparicoes varchar(30) not null
);

create table if not exists personagens(
id tinyint primary key auto_increment,
nome_personagem varchar(30) not null,
genero varchar(15) not null,
especie varchar(20) not null,
estilo_de_luta varchar(20) not null,
idade smallint not null, 
arma varchar(20) not null
);

create table if not exists personagens_arenas(
arenas_id tinyint not null,
personagens_id tinyint not null,
constraint fk_arena foreign key (arenas_id) references arenas(id),
constraint fk_personagem foreign key (personagens_id) references personagens(id)
);

