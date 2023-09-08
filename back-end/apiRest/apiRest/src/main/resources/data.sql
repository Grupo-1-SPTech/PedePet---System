insert into usuario (nome, email, cpf, telefone, senha, tipo_usuario, autenticado)
values
('ruy', 'ruy@gmail.com', '22973980003', '11922766147', 'Sptech10@', 2, true),
('vanessa', 'vanessa@gmail.com', '42322226424', '11965728908', 'Sptech10@', 1, true),
('julia', 'julia@gmail.com', '56426751090', '13932880784', 'Sptech10@', 2, true);

insert into endereco (cep, rua, numero, complemento, bairro, cidade, estado, fk_usuario)
values
(04143010, 'Avenida 1', 478, 'Perto da drogaria', 'Jabaquara', 'São paulo', 'SP', 1),
(04342011, 'Rua Varista', 32, 'Casa de esquina', 'Saúde', 'São paulo', 'SP', 2),
(04342011, 'Rua Batata', 771, 'Ao lado do mercado', 'Saúde', 'São paulo', 'SP', 3);

insert into formulario (tipo_moradia, qtd_comodos, qtd_moradores, qtd_horas_casa, possui_pet, status_forms, fk_usuario)
values
('Casa', '1 a 5', '6 ou mais', '7 a 12', 1, 1, 2);

insert into ninhada (raca_mae, idade_mae, porte_mae, pedigree_mae, vacina_mae, raca_pai, idade_pai, porte_pai, pedigree_pai, vacina_pai, foto_pet, visualizacoes, qtd_filhotes, descricao, fk_usuario)
values
(4, 5, 'Pequeno', 1, 1, 4, 4, 'Pequeno', 1, 1,'fotoPet', 1, 6, '6 lindos filhotes', 1),
(18, 8, 'Grande', 1, 1, 18, 9, 'Grande', 1, 1,'fotoPet', 1, 3, '3 lindos filhotes', 3);

insert into filhote (tempo_espera, preco, disponivel, vacina_filhote, data_criacao, fk_ninhada)
values
('9 semanas (63 dias)', 1199.99, true, 1, NOW(), 1),
('9 semanas (63 dias)', 1199.99, true, 1, NOW(), 1),
('9 semanas (63 dias)', 1199.99, true, 1, NOW(), 1),
('9 semanas (63 dias)', 1199.99, true, 1, NOW(), 1),
('9 semanas (63 dias)', 1199.99, true, 1, NOW(), 1),
('9 semanas (63 dias)', 1199.99, true, 1, NOW(), 1),
('9 semanas (63 dias)', 2000.99, true, 1, NOW(), 2),
('9 semanas (63 dias)', 2000.99, true, 1, NOW(), 2),
('9 semanas (63 dias)', 2000.99, true, 1, NOW(), 2);
