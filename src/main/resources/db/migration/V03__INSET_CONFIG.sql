Alter table configuracao DROP COLUMN valor_minimo;
Alter table configuracao DROP COLUMN valor_maximo;

insert into configuracao (id, taxa_cartao, taxa_administrativa, qtd_parcela) VALUES
(1 , 1, 1.1, 0 ),
(2 , 1, 1.6, 1 ),
(3 , 1, 1.8, 2 ),
(4 , 1, 1.9, 3 ),
(5 , 1, 2.5, 4 ),
(6 , 1, 2.8, 5 ),
(7 , 1, 3.9, 6 ),
(8 , 1, 4.5, 7),
(9 , 1, 4.9, 8),
(10, 1, 5.3, 9),
(11, 1, 5.9, 10),
(12, 1, 6.0, 11);

