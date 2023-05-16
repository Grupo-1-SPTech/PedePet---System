CREATE DATABASE PedePet;
USE PedePet;

CREATE TABLE IF NOT EXISTS perfil(
idPerfil INT PRIMARY KEY,
tipo VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS usuario(
idUsuario INT PRIMARY KEY AUTO_INCREMENT,
fkPerfil INT,
FOREIGN KEY (fkPerfil) REFERENCES perfil(idPerfil),
nome VARCHAR(45),
email VARCHAR(50),
cpf CHAR(11),
telefone CHAR(16),
senha VARCHAR(30),
foto_perfil VARCHAR(100),
autenticado BIT(0)
);

CREATE TABLE IF NOT EXISTS endereco(
idEndereco INT PRIMARY KEY AUTO_INCREMENT,
fkUsuario INT,
FOREIGN KEY (fkUsuario) REFERENCES usuario(idUsuario),
cep CHAR(8),
rua VARCHAR(45),
numero INT,
complemento VARCHAR(30) NULL,
bairro VARCHAR(30),
estado VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS ninhada(
idNinhada INT PRIMARY KEY AUTO_INCREMENT,
fkUsuario INT,
FOREIGN KEY (fkUsuario) REFERENCES usuario(idUsuario),
titulo VARCHAR(45),
raca_mae VARCHAR(20),
idade_mae INT,
porte_mae INT,
vacina_mae INT,
pedigree_mae INT,
raca_pai VARCHAR(20),
idade_pai INT,
porte_pai INT,
vacina_pai INT,
pedigree_pai INT,
visualizacoes INT NULL,
qtd_filhotes INT,
foto_casal VARCHAR(100),
descricao VARCHAR(240)
);

CREATE TABLE IF NOT EXISTS filhote(
idFilhote INT PRIMARY KEY AUTO_INCREMENT,
fkNinhada INT,
FOREIGN KEY (fkNinhada) REFERENCES ninhada(idNinhada),
tempo_espera INT,
preco DECIMAL(7,2),
data_criacao DATETIME
);

CREATE TABLE IF NOT EXISTS lista_espera(
idLista_espera INT PRIMARY KEY AUTO_INCREMENT,
fkFilhote INT,
FOREIGN KEY (fkFilhotes) REFERENCES filhote(idFilhote),
fkUsuario INT,
FOREIGN KEY (fkUsuario) REFERENCES usuario(idUsuario),
status_teste VARCHAR(15),
posicao_fila INT,
data_hora DATETIME
);