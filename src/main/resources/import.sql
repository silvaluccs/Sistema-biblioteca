-- Inserindo registros na tabela ContaBiblioteca
INSERT INTO contaBiblioteca (id, login, senha, saldo, logado) VALUES
(1, 'lucasoliveira', 'password1', 100.0, true),
(2, 'mariasilva', 'password2', 200.0, false),
(3, 'joaosantos', 'password3', 300.0, true);

-- Inserindo registros na tabela Pessoa
INSERT INTO Pessoa (id, nome, idade, cpf, conta_biblioteca_id) VALUES
(1, 'Lucas Oliveira', 25, '12345678901', 1),
(2, 'Maria Silva', 30, '23456789012', 2),
(3, 'João Santos', 28, '34567890123', 3);
