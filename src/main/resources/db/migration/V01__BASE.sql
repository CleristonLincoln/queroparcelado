CREATE TABLE cliente
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome          VARCHAR(75) NOT NULL,
    cpf           CHAR(11)    NOT NULL,
    fone          CHAR(11)    NOT NULL,
    email         VARCHAR(75) NOT NULL,
    data_cadastro DATETIME,

    id_indicador  BIGINT,

    FOREIGN KEY (id_indicador) REFERENCES cliente (id)
) ENGINE = InnoDB;

CREATE TABLE permissao
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome      VARCHAR(20),
    descricao VARCHAR(55)
) ENGINE = InnoDB;

CREATE TABLE configuracao
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    taxa_cartao         DECIMAL(10, 6),
    taxa_administrativa DECIMAL(10, 6),
    qtd_parcela           TINYINT,
    valor_minimo        DECIMAL(7, 2),
    valor_maximo        DECIMAL(7, 2)
) ENGINE = InnoDB;

CREATE TABLE pedido
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo_barra        VARCHAR(100),
    valor               DECIMAL(10, 2),
    qtd_parcela          TINYINT,
    taxa_cartao         DECIMAL(10, 6),
    taxa_administrativa DECIMAL(10, 6),
    data_transacao      DATETIME,

    id_cliente          BIGINT,

    FOREIGN KEY (id_cliente) REFERENCES cliente (id)
) ENGINE = InnoDB;

CREATE TABLE parcela
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    ordem               TINYINT,
    valor               DECIMAL(10, 2),
    data_vencimento     DATETIME,

    id_pedido           BIGINT,

    FOREIGN KEY (id_pedido) REFERENCES pedido (id)
) ENGINE = InnoDB;

CREATE TABLE promocao
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo              CHAR(5),
    valor               DECIMAL(10, 2),
    qtd_parcela        TINYINT,
    taxa_cartao         DECIMAL(10, 6),
    taxa_administrativa DECIMAL(10, 6),
    data_cadastro       DATETIME,
    data_uso            DATETIME,
    ativo               BIT,

    id_pedido           BIGINT,
    id_cliente          BIGINT,

    FOREIGN KEY (id_pedido) REFERENCES pedido (id),
    FOREIGN KEY (id_cliente) REFERENCES cliente (id)
) ENGINE = InnoDB;

