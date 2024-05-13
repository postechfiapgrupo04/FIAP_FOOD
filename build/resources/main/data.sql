INSERT INTO USUARIO
VALUES
    ('1', 'Bruno', 'bruno@fiap.com', '01234567890'),
    ('2', 'Milton', 'milton@fiap.com', '01234567891'),
    ('3', 'Diego', 'diego@fiap.com', '01234567892'),
    ('4', 'Toquinho', 'toquinho@fiap.com', '01234567893'),
    ('5', 'Robson', 'robson@fiap.com', '01234567894');

INSERT INTO ENDERECO (id, logradouro, numero, complemento, bairro, cidade, estado, cep)
VALUES
    ('1', 'Av. Nova Independência', '192', 'n/a', 'Brooklin', 'São Paulo', 'SP', '04570-000');

INSERT INTO RESTAURANTE (id, nome, tipocozinha, horaabertura, horafechamento, capacidade, endereco_id)
    VALUES
        ('1', 'Juca Alemão', 'OUTROS', '11:00:00', '21:00:00', '70', '1');

INSERT INTO RESERVA (id, idusuario, idrestaurante, datareserva, quantidadepessoas)
    VALUES
        ('1', '1', '1', ' 2023-05-13 18:00:00', '4');

INSERT INTO AVALIACAO (id, idusuario, idrestaurante, estrelas, descricao)
    VALUES
        ('1', '1', '1', 5, 'Melhor Strudel da região!');