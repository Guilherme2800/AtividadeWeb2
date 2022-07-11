INSERT INTO CLIENTE(cpf, nome, email, senha, telefone_contato) VALUES(111,'JãoZim minecraft', 'cliente@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq', '123456789');
INSERT INTO CLIENTE(cpf, nome, email, senha, telefone_contato) VALUES(222,'Gustavo manda chuva', 'moderador@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq', '123456789');

INSERT INTO PERFIL(id, nome) VALUES(1, 'ROLE_CLIENTE');
INSERT INTO PERFIL(id, nome) VALUES(2, 'ROLE_MODERADOR');

INSERT INTO CLIENTE_PERFIS(cliente_id, perfis_id) VALUES(1, 1);
INSERT INTO CLIENTE_PERFIS(cliente_id, perfis_id) VALUES(2, 2);

INSERT INTO PRATO(nome, descricao, preco) VALUES ('arroz mofado', 'Arroz cozinhado a 1 mes', '60');

INSERT INTO FORMA_PAGAMENTO(descricao) VALUES ('Cartão de crédito');