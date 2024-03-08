CREATE TABLE usuarios(
    id               BIGINT       NOT NULL AUTO_INCREMENT,
    nombre           VARCHAR(100) NOT NULL,
    apellido         VARCHAR(100) NOT NULL,
    email            VARCHAR(100) NOT NULL UNIQUE,
    telefono         VARCHAR(12)  NOT NULL UNIQUE,
    tarjetaDeCredito VARCHAR(100) NOT NULL UNIQUE,
    calle            VARCHAR(100) NOT NULL,
    numero           VARCHAR(20),
    colonia          VARCHAR(100) NOT NULL,
    ciudad           VARCHAR(100) NOT NULL,
    pais             VARCHAR(100) NOT NULL,
    complemento      VARCHAR(100),
    especialidad     VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

