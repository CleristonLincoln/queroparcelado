create table cliente (id bigint not null auto_increment, cpf varchar(255), data_cadastro datetime not null, email varchar(255), fone varchar(255), nome varchar(255), primary key (id)) engine=InnoDB
create table permissao (id bigint not null auto_increment, descricao varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=InnoDB
