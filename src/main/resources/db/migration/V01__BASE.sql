CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(75),
    cpf CHAR(11),
    fone CHAR(11),
    email VARCHAR(75),
    data_cadastro TIMESTAMP
)ENGINE = InnoDB;

CREATE TABLE permissao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(20),
    descricao CHAR(55)
)ENGINE = InnoDB;

CREATE TABLE configuracao (
    id SMALLINT AUTO_INCREMENT PRIMARY KEY,
    n_parcela TINYINT,
    percentual DECIMAL(19,2)
)ENGINE = InnoDB;

CREATE TABLE venda_cliente (
    id SMALLINT AUTO_INCREMENT PRIMARY KEY,
    valor DECIMAL(19,2),
    n_parcelas TINYINT,
    percentual DECIMAL(19,2),
    data_transacao DATETIME,

    id_cliente BIGINT,

    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
)ENGINE = InnoDB;

