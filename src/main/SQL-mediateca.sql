-- Eliminar tablas si existen (para empezar limpio)
DROP TABLE IF EXISTS libros;
DROP TABLE IF EXISTS revistas;
DROP TABLE IF EXISTS cds_audio;
DROP TABLE IF EXISTS dvds;

-- Tabla para LIBROS
CREATE TABLE libros (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(10) UNIQUE NOT NULL,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(100),
    num_paginas INT,
    editorial VARCHAR(100),
    isbn VARCHAR(20),
    anio_publicacion INT,
    unidades_disponibles INT DEFAULT 1
);

-- Tabla para REVISTAS (con autor y num_paginas como tiene la clase)
CREATE TABLE revistas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(10) UNIQUE NOT NULL,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(100),
    num_paginas INT,
    editorial VARCHAR(100),
    periodicidad VARCHAR(50),
    fecha_publicacion DATE,
    unidades_disponibles INT DEFAULT 1
);

-- Tabla para CDs de AUDIO
CREATE TABLE cds_audio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(10) UNIQUE NOT NULL,
    titulo VARCHAR(200) NOT NULL,
    artista VARCHAR(100),
    genero VARCHAR(50),
    duracion INT,
    num_canciones INT,
    unidades_disponibles INT DEFAULT 1
);

-- Tabla para DVDs
CREATE TABLE dvds (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(10) UNIQUE NOT NULL,
    titulo VARCHAR(200) NOT NULL,
    director VARCHAR(100),
    genero VARCHAR(50),
    duracion INT,
    unidades_disponibles INT DEFAULT 1
);