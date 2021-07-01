insert into permissao (id, nome, descricao) VALUES
(1, 'ADMIN', 'administrador principal'),
(2, 'USER', 'usuario Comun');

insert into cliente (id, nome, cpf, fone, email, data_cadastro, senha, codigo_confirmacao, ativo, id_indicador) values
(1, 'Administrador do sistema','00435534351', '99999999999', 'admin@admin.com.br', current_timestamp,'admin', 1234, true, null);

insert into usuario (id, login, senha, data_cadastro, id_cliente, id_permissao) values
(1, 'admin@admin.com.br', '$2y$12$HgvR/knB0C/G63xxeA1dkOZojIreKwT176kvJDxd/0rDkiwGhnyOG', current_timestamp, 1, 1 )