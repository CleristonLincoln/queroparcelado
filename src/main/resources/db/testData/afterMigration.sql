set foreign_key_checks = 0;

delete FROM cliente where id >=1;
delete from permissao where id >=1;
delete from configuracao where id >=1;
delete from venda_cliente where id >=1;


set foreign_key_checks = 1;

alter table cliente auto_increment = 1;
alter table permissao auto_increment = 1;
alter table configuracao auto_increment = 1;
alter table venda_cliente auto_increment = 1;


insert into cliente (nome, cpf, fone, email, data_cadastro) values
    ('Cicera Oliveira da Silva',            '00435534351', '98979797979', 'afeerw@eger.com', now()),
    ('Cleriston Lincoln da Silva Lopes',    '26316160062', '43234323432', 'ahrthw@eger.com', now()),
    ('Foquinha Oliveira da Silva',          '24209298026', '58494947777', 'hrrw@erhrtyr.com', now()),
    ('Maria Zuleda da Silva Lopes',         '01430502061', '96544674576', 'ngfey6yy@hrhryhcng.com', now()),
    ('Clovis Lincoln Camurca Lopes',        '01217008012', '98976556734', 'yhtgerv@exwxasa.com', now()),
    ('Maria Jupira da Silva',               '65388141071', '98564565456', 'cedcrefer@ceerer.com', now());

insert into configuracao (n_parcela, percentual) VALUES
    (0, 2),
    (1, 2.3),
    (2, 3.3),
    (3, 4.3),
    (4, 4.5),
    (5, 5.23),
    (6, 5.85),
    (7, 6.34),
    (8, 6.77),
    (9, 7.11),
    (10,7.46),
    (11, 8.6),
    (12, 8.99);


insert into venda_cliente (valor, n_parcelas, percentual, id_cliente, data_transacao) VALUES
    (918.29	,   5   ,	 5.23	,	2, now()),
    (864.57	,	6	,	 5.85	,	2, now()),
    (999.85	,	4	,	 4.5	,	6, now()),
    (609.49	,	12	,	 8.99	,	2, now()),
    (178.4	,	3	,	 4.37	,	1, now()),
    (946.33	,	4	,	 4.5	,	5, now()),
    (132.09	,	8	,	 6.77	,	1, now()),
    (516.62	,	1	,	 2.33	,	5, now()),
    (577.37	,	7	,	 6.34	,	2, now()),
    (294.19	,	3	,	 4.37	,	2, now()),
    (594.68	,	5	,	 5.23	,	5, now()),
    (528.71	,	11	,	 8.6	,	2, now()),
    (532.32	,	1	,	 2.33	,	5, now()),
    (289.45	,	3	,	 4.37	,	2, now()),
    (735.66	,	6	,	 5.85	,	6, now()),
    (140.93	,	9	,	 7.11	,	3, now()),
    (223.56	,	11	,	 8.6	,	6, now()),
    (643.98	,	11	,	 8.6	,	1, now()),
    (297.53	,	10	,	7.46	,	6, now()),
    (717.53	,	10	,	7.46	,	6, now()),
    (992.87	,	5	,	 5.23	,	4, now()),
    (420	,	7	,	 6.34	,	3, now()),
    (566.22	,	12	,	 8.99	,	4, now());
