-- Inserir registros na tabela conta_biblioteca
insert into conta_biblioteca (id, login, senha, saldo, logado) values (1, 'johndoe1', 'senhaJd@123', 100, false);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (2, 'mariaoliveira2', 'senhaMo@456', 100, true);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (3, 'pedroalmeida3', 'senhaPa@789', 100, false);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (4, 'lucasrodrigues4', 'senhaLu@321', 100, true);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (5, 'carolinasilva5', 'senhaCa@654', 100, false);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (6, 'franciscocosta6', 'senhaFc@987', 100, true);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (7, 'beatrizsantos7', 'senhaBs@654', 100, false);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (8, 'josefaria8', 'senhaJf@987', 100, true);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (9, 'marciapereira9', 'senhaMp@123', 100, false);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (10, 'renatobarbosa10', 'senhaRb@456', 100, true);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (11, 'alinedosanjos11', 'senhaAd@789', 100, false);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (12, 'gustavocosta12', 'senhaGc@321', 100, true);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (13, 'larissamelo13', 'senhaLm@654', 100, false);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (14, 'brunojunior14', 'senhaBj@987', 100, true);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (15, 'leticiagomes15', 'senhaLg@123', 100, false);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (16, 'fabianelima16', 'senhaFl@456', 100, true);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (17, 'marceloalves17', 'senhaMa@789', 100, false);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (18, 'alineoliveira18', 'senhaAo@321', 100, true);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (19, 'emiliamelo19', 'senhaEm@654', 100, false);
insert into conta_biblioteca (id, login, senha, saldo, logado) values (20, 'victormartins20', 'senhaVm@987', 100, true);

-- Inserir registros na tabela pessoa
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('John Doe', 28, '123.456.789-01', 1);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Maria Oliveira', 34, '234.567.890-12', 2);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Pedro Almeida', 25, '345.678.901-23', 3);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Lucas Rodrigues', 30, '456.789.012-34', 4);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Carolina Silva', 22, '567.890.123-45', 5);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Francisco Costa', 27, '678.901.234-56', 6);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Beatriz Santos', 24, '789.012.345-67', 7);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('José Faria', 33, '890.123.456-78', 8);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Márcia Pereira', 29, '901.234.567-89', 9);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Renato Barbosa', 31, '012.345.678-90', 10);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Aline dos Anjos', 26, '123.456.789-11', 11);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Gustavo Costa', 28, '234.567.890-12', 12);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Larissa Melo', 32, '345.678.901-23', 13);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Bruno Junior', 35, '456.789.012-34', 14);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Letícia Gomes', 23, '567.890.123-45', 15);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Fabiane Lima', 30, '678.901.234-56', 16);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Marcelo Alves', 27, '789.012.345-67', 17);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Aline Oliveira', 25, '890.123.456-78', 18);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Emília Melo', 24, '901.234.567-89', 19);
insert into pessoa (nome, idade, cpf, conta_biblioteca_id) values ('Victor Martins', 29, '012.345.678-90', 20);
-- Inserir registros na tabela livro
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('George Orwell', '1984', 1949, '9780451524935', 328, 120);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('J.K. Rowling', 'Harry Potter e a Pedra Filosofal', 1997, '9780747532699', 223, 150);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('Harper Lee', 'O Sol é para Todos', 1960, '9780061120084', 281, 85);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('F. Scott Fitzgerald', 'O Grande Gatsby', 1925, '9780743273565', 180, 95);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('J.R.R. Tolkien', 'O Senhor dos Anéis', 1954, '9780261103573', 1137, 200);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('Paulo Coelho', 'O Alquimista', 1988, '9780061122415', 208, 110);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('Gabriel García Márquez', 'Cem Anos de Solidão', 1967, '9780307389732', 417, 75);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('Albert Camus', 'O Estrangeiro', 1942, '9788535916344', 158, 80);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('Jane Austen', 'Orgulho e Preconceito', 1813, '9781503290563', 279, 130);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('George R.R. Martin', 'A Guerra dos Tronos', 1996, '9780553103540', 694, 100);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('Isaac Asimov', 'Fundação', 1951, '9780553293357', 296, 90);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('Markus Zusak', 'A Menina que Roubava Livros', 2005, '9780375842207', 584, 115);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('Leo Tolstoy', 'Guerra e Paz', 1869, '9781853260629', 1225, 50);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('Orson Scott Card', 'Ender’s Game', 1985, '9780812550702', 324, 105);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('Dante Alighieri', 'A Divina Comédia', 1320, '9788501054565', 752, 60);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('Emily Brontë', 'O Morro dos Ventos Uivantes', 1847, '9781851245182', 416, 85);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('Franz Kafka', 'A Metamorfose', 1915, '9788578271069', 128, 95);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('Oscar Wilde', 'O Retrato de Dorian Gray', 1890, '9780141439570', 254, 120);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('E. L. James', 'Cinquenta Tons de Cinza', 2009, '9780307580537', 514, 130);
insert into livro (nome_autor, titulo, ano_publicacao, isnb, numero_paginas, quantidade_de_emprestimos) values ('Dan Brown', 'O Código Da Vinci', 2003, '9780307474278', 454, 140);

