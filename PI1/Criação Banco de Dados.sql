CREATE DATABASE buscapreco;

CREATE TABLE usuarios (  
	id INT NOT NULL AUTO_INCREMENT,      
	nome VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE mercados (  
	id INT NOT NULL AUTO_INCREMENT,      
	nome_mercado VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE compras (  
	id INT NOT NULL AUTO_INCREMENT,      
	data_mercado DATE NOT NULL,
	valor_total DECIMAL(9,2) NOT NULL, 
	forma_pagamento VARCHAR(15) NOT NULL, 
    PRIMARY KEY (id)    
);

CREATE TABLE produtos (  
	id INT NOT NULL AUTO_INCREMENT,      
	nome_produto VARCHAR(45) NOT NULL,
	marca VARCHAR(45) NOT NULL, 
	preco DECIMAL(9,2) NOT NULL, 
    quantidade INT NOT NULL,
    data_compra DATE NOT NULL,
    PRIMARY KEY (id)
    );