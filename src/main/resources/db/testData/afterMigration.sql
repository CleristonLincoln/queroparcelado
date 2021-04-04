set foreign_key_checks = 0;

delete FROM cliente where id >=1;
delete from configuracao where id >=1;
delete from pedido where id >=1;
delete from promocao where id >=1;
delete from parcela where id >=1;


set foreign_key_checks = 1;

alter table cliente auto_increment = 1;
alter table configuracao auto_increment = 1;
alter table pedido auto_increment = 1;
alter table promocao auto_increment = 1;
alter table parcela auto_increment = 1;


insert into cliente (nome, cpf, fone, email, data_cadastro) values
    ('Cicera Oliveira da Silva',            '00435534351', '98979797979', 'afeerw@eger.com', '2021-01-05'),
    ('Cleriston Lincoln da Silva Lopes',    '26316160062', '43234323432', 'ahrthw@eger.com', '2021-01-07'),
    ('Foquinha Oliveira da Silva',          '24209298026', '58494947777', 'hrrw@erhrtyr.com', '2021-01-15'),
    ('Maria Zuleda da Silva Lopes',         '01430502061', '96544674576', 'ngfey6yy@hrhryhcng.com', '2021-01-19'),
    ('Clovis Lincoln Camurca Lopes',        '01217008012', '98976556734', 'yhtgerv@exwxasa.com', '2021-01-20'),
    ('Maria Jupira da Silva',               '65388141071', '98564565456', 'cedcrefer@ceerer.com', '2021-01-23');

insert into configuracao (id, taxa_cartao, taxa_administrativa, qtd_parcela, valor_minimo, valor_maximo) VALUES
    (1 , 2   , 2  , 0 ,  0.00, 10000),
    (2 , 2.3 , 2.6, 1 ,  0.00, 10000),
    (3 , 3.3 , 3.8, 2 , 50.00, 10000),
    (4 , 4.3 , 4.9, 3 , 50.00, 10000),
    (5 , 4.5 , 4.8, 4 , 50.00, 10000),
    (6 , 5.23, 5.8, 5 , 50.00, 10000),
    (7 , 5.85, 5.9, 6 , 50.00, 10000),
    (8 , 6.34, 6.8, 7 , 50.00, 10000),
    (9 , 6.77, 6.9, 8 , 50.00, 10000),
    (10 , 7.11, 7.8, 9 , 50.00, 10000),
    (11, 7.46, 7.9, 10, 50.00, 10000),
    (12, 8.6,  8.9, 11, 50.00, 10000),
    (13, 8.9,  8.0, 12, 50.00, 10000);


insert into pedido (codigo_barra, valor, qtd_parcela, taxa_cartao, taxa_administrativa, data_transacao, id_cliente) VALUES
    ('34191790010104351004791020150008785790026000' ,520.25 ,5  ,5.23   , 5.8   ,'2021-01-05',	 2),
    ('34191790010104351004791020150008785790026000' ,633.25	,6	,5.85	,4, '2021-01-06',  2),
    (null                                           ,132.09	,8	,6.77	,1, '2021-01-28',   1);

insert into parcela (ordem, valor, data_vencimento, id_pedido) VALUES
(1, 104.05, '2021-02-05',    1),
(2, 104.05, '2021-03-05',    1),
(3, 104.05, '2021-04-05',    1),
(4, 104.05, '2021-05-05',    1),
(5, 104.05, '2021-06-05',    1),
(1, 105.54, '2021-02-06',    2),
(2, 105.54, '2021-03-06',    2),
(3, 105.54, '2021-04-06',    2),
(4, 105.54, '2021-05-06',    2),
(5, 105.54, '2021-06-06',    2),
(6, 105.55, '2021-07-06',    2),
(1, 16.51, '2021-02-28',    3),
(1, 16.51, '2021-03-28',    3),
(1, 16.51, '2021-04-28',    3),
(1, 16.51, '2021-05-28',    3),
(1, 16.51, '2021-06-28',    3),
(1, 16.51, '2021-07-28',    3),
(1, 16.51, '2021-08-28',    3),
(1, 16.52, '2021-09-28',    3);

insert into promocao (codigo, valor, qtd_parcela, taxa_cartao, taxa_administrativa, data_cadastro, data_uso, ativo, id_pedido, id_cliente) VALUES
('s5e1d', 500.00, 3, 5.41, 3.2, now(), null, 1, null, null);

