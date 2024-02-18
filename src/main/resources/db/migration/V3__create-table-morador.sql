CREATE TABLE IF NOT EXISTS MORADORES (

    id_morador SERIAL PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    apartamento_id int NOT NULL,
    usuario_id int NOT NULL,

    FOREIGN KEY (apartamento_id) REFERENCES APARTAMENTOS(id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (usuario_id) REFERENCES USERS(id) ON UPDATE CASCADE ON DELETE CASCADE

);