INSERT INTO USUARIO
VALUES
    ('1', 'Bruno', 'bruno@fiap.com', '01234567890'),
    ('2', 'Milton', 'milton@fiap.com', '01234567891'),
    ('3', 'Diego', 'diego@fiap.com', '01234567892'),
    ('4', 'Toquinho', 'toquinho@fiap.com', '01234567893'),
    ('5', 'Robson', 'robson@fiap.com', '01234567894');
INSERT INTO ENDERECO
VALUES
    ('1', 'Rua do teste', 'numero 0', 'complemento', 'bairro', 'cidade', 'SP','12345678');
INSERT INTO RESTAURANTE
    (id, capacidade, horaabertura, horafechamento, nome, tipocozinha, endereco_id)
VALUES
    (1, 100, '08:00', '23:59', 'restaurante morte lente', 'VEGETARIANA', 1);