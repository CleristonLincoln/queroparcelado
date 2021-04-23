ALTER TABLE cliente
    ADD senha VARCHAR(255) NOT NULL AFTER email;


CREATE TABLE grupo_permissao
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(75)
) ENGINE = InnoDB;

CREATE TABLE cliente_x_grupo_permissao
(
    id_cliente         BIGINT,
    id_grupo_permissao INT,

    FOREIGN KEY (id_cliente) REFERENCES cliente (id),
    FOREIGN KEY (id_grupo_permissao) REFERENCES grupo_permissao (id)
) ENGINE InnoDB;

CREATE TABLE grupo_x_permissao
(
    id_grupo     INT,
    id_permissao BIGINT,

    FOREIGN KEY (id_grupo) REFERENCES grupo_permissao (id),
    FOREIGN KEY (id_permissao) REFERENCES permissao (id)
) ENGINE InnoDB;

