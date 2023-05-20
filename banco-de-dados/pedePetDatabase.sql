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
fk_usuario INT,
FOREIGN KEY (fk_usuario) REFERENCES usuario(id),
cep CHAR(8) NULL,
rua VARCHAR(45) NULL,
numero INT NULL,
complemento VARCHAR(45) NULL,
bairro VARCHAR(30) NULL,
cidade VARCHAR(30) NULL,
estado CHAR(2) NULL
);

CREATE TABLE IF NOT EXISTS formulario(
id INT PRIMARY KEY AUTO_INCREMENT,
fk_usuario INT,
FOREIGN KEY (fk_usuario) REFERENCES usuario(id),
tipo_moradia VARCHAR(15) NULL,
qtd_comodos INT NULL,
qtd_moradores INT NULL,
qtd_horas_casa INT NULL,
possui_pet INT NULL
);

CREATE TABLE IF NOT EXISTS ninhada(
id INT PRIMARY KEY AUTO_INCREMENT,
fk_usuario INT,
FOREIGN KEY (fk_usuario) REFERENCES usuario(id),
titulo VARCHAR(45) NULL,
raca_mae VARCHAR(20) NULL,
idade_mae INT NULL,
porte_mae VARCHAR(10) NULL,
vacina_mae INT NULL,
pedigree_mae INT NULL,
raca_pai VARCHAR(20) NULL,
idade_pai INT NULL,
porte_pai VARCHAR(10) NULL,
vacina_pai INT NULL,
pedigree_pai INT NULL,
visualizacoes INT NULL,
qtd_filhotes INT NULL,
foto_pet VARCHAR(100) NULL,
descricao VARCHAR(240) NULL
);

CREATE TABLE IF NOT EXISTS filhote(
id INT PRIMARY KEY AUTO_INCREMENT,
fk_ninhada INT,
FOREIGN KEY (fk_ninhada) REFERENCES ninhada(id),
tempo_espera INT NULL,
preco DECIMAL(7,2) NULL,
data_criacao TIMESTAMP NULL,
disponivel BIT(1) NULL
);

/*
CREATE TABLE IF NOT EXISTS lista_espera(
id_lista_espera INT PRIMARY KEY AUTO_INCREMENT,
fk_filhote INT,
FOREIGN KEY (fk_filhotes) REFERENCES filhote(id_filhote),
fkUsuario INT,
FOREIGN KEY (fkUsuario) REFERENCES usuario(idUsuario),
status_teste VARCHAR(15),
posicao_fila INT,
data_hora DATETIME
);
*/
-- Inserção de dados:

select * from usuario;
select * from endereco;
select * from formulario;
select * from ninhada;
select * from filhote;
