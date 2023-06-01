CREATE DATABASE PedePet;
USE PedePet;


CREATE TABLE IF NOT EXISTS usuario(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45) NULL,
email VARCHAR(50) NULL,
cpf CHAR(11) NULL,
telefone CHAR(16) NULL,
senha VARCHAR(30) NULL,
tipo_usuario INT NULL,
autenticado BIT(1)
);

CREATE TABLE IF NOT EXISTS endereco(
id INT PRIMARY KEY AUTO_INCREMENT,
cep CHAR(8) NULL,
rua VARCHAR(45) NULL,
numero INT NULL,
complemento VARCHAR(45) NULL,
bairro VARCHAR(30) NULL,
cidade VARCHAR(30) NULL,
estado CHAR(2) NULL,
fk_usuario INT NULL,
FOREIGN KEY (fk_usuario) REFERENCES usuario(id)
);

CREATE TABLE IF NOT EXISTS formulario(
id INT PRIMARY KEY AUTO_INCREMENT,
tipo_moradia VARCHAR(15) NULL,
qtd_comodos VARCHAR(15) NULL,
qtd_moradores VARCHAR(15) NULL,
qtd_horas_casa VARCHAR(15) NULL,
possui_pet INT NULL,
fk_usuario INT NULL,
FOREIGN KEY (fk_usuario) REFERENCES usuario(id)
);

CREATE TABLE IF NOT EXISTS ninhada(
id INT PRIMARY KEY AUTO_INCREMENT,
raca_mae INT NULL,
idade_mae INT NULL,
porte_mae VARCHAR(10) NULL,
vacina_mae INT NULL,
pedigree_mae INT NULL,
raca_pai INT NULL,
idade_pai INT NULL,
porte_pai VARCHAR(10) NULL,
vacina_pai INT NULL,
pedigree_pai INT NULL,
visualizacoes INT NULL,
qtd_filhotes INT NULL,
foto_pet VARCHAR(100) NULL,
descricao VARCHAR(240) NULL,
fk_usuario INT NULL,
FOREIGN KEY (fk_usuario) REFERENCES usuario(id)
);

CREATE TABLE IF NOT EXISTS filhote(
id INT PRIMARY KEY AUTO_INCREMENT,
tempo_espera INT NULL,
preco DECIMAL(7,2) NULL,
data_criacao TIMESTAMP NULL,
disponivel BIT(1) NULL,
fk_ninhada INT NULL,
FOREIGN KEY (fk_ninhada) REFERENCES ninhada(id)
);

/*
CREATE TABLE IF NOT EXISTS dados_pagamento(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(45) NULL,
numero_cartao CHAR(16) NULL,
validade DATE NULL,
cvv CHAR(3) NULL,
fk_usuario INT NULL,
FOREIGN KEY (fk_usuario) REFERENCES usuario(id)
);
*/

/*
CREATE TABLE IF NOT EXISTS lista_espera(
id INT PRIMARY KEY AUTO_INCREMENT,
status_lista VARCHAR(15),
posicao_fila INT,
data_hora TIMESTAMP NULL,
fk_filhote INT,
FOREIGN KEY (fk_filhotes) REFERENCES filhote(id),
fk_usuario INT,
FOREIGN KEY (fk_usuario) REFERENCES usuario(id)
);
*/

/*
CREATE TABLE IF NOT EXISTS historico_venda(
id INT PRIMARY KEY AUTO_INCREMENT,
fk_filhote INT,
FOREIGN KEY (fk_filhotes) REFERENCES filhote(id),
fk_comprador INT,
FOREIGN KEY (fk_comprador) REFERENCES usuario(id),
fk_vendedor INT,
FOREIGN KEY (fk_vendedor) REFERENCES usuario(id),
fk_dados_paramento INT,
FOREIGN KEY (fk_dados_paramento) REFERENCES dados_pagamento(id),
nota INT NULL,
data_venda TIMESTAMP NULL,
preco DECIMAL(7,2) NULL,
tipo_pagamento VARCHAR(10)
);
*/




-- Inserção de dados:

-- COMPRADOR
insert into usuario (nome, email, cpf, telefone, senha, tipo_usuario, autenticado) values 
('Luigi Ceolin', 'luigi@gmail.com', '0188418457', '(11) 97252-7483', 'sptech10@', 1, 1);

insert into endereco (cep, rua, numero, complemento, bairro, cidade, estado, fk_usuario) values
('09580330', 'Rua 1', 77, 'Ao lado do mercado Extra', 'Maua', 'São Paulo', 'SP', 1);

insert into formulario (tipo_moradia, qtd_comodos, qtd_moradores, qtd_horas_casa, possui_pet, fk_usuario) values
('Apartamento', '1 a 5', '1 a 5', '7 a 12', 1, 1); 

-- VENDEDOR

select * from usuario;
select * from endereco;
select * from formulario;
select * from ninhada;
select * from filhote;
