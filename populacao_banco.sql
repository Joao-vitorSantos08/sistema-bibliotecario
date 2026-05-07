-- Script de População do Banco (README)
USE sistema_bibliotecario;

-- 1. Limpeza de dados
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE livro_autor;
TRUNCATE TABLE detalhes_livro;
TRUNCATE TABLE livro;
TRUNCATE TABLE autor;
TRUNCATE TABLE editora;
SET FOREIGN_KEY_CHECKS = 1;

-- 2. Configurações iniciais
SET SQL_SAFE_UPDATES = 0;
ALTER TABLE livro MODIFY detalhes_id bigint NULL;

-- 3. Autores
INSERT INTO autor (nome) VALUES 
('Machado de Assis'), ('Antoine de Saint-Exupéry'), ('George Orwell'), ('Jane Austen'), 
('J.R.R. Tolkien'), ('J.K. Rowling'), ('Dan Brown'), ('Paulo Coelho');

-- 4. Editoras
INSERT INTO editora (editora) VALUES 
('Garnier'), ('Reynal & Hitchcock'), ('Secker & Warburg'), ('T. Egerton'), 
('George Allen & Unwin'), ('Bloomsbury'), ('Doubleday'), ('Rocco');

-- 5. Livros (24 obras)
INSERT INTO livro (titulo, ano_publicacao, editora_id) VALUES
('Dom Casmurro', 1899, 1), ('O Pequeno Príncipe', 1943, 2), ('1984', 1949, 3),
('Orgulho e Preconceito', 1813, 4), ('O Hobbit', 1937, 5), ('Harry Potter e a Pedra Filosofal', 1997, 6),
('A Revolução dos Bichos', 1945, 3), ('O Senhor dos Anéis: A Sociedade do Anel', 1954, 5), ('Código Da Vinci', 2003, 7),
('O Alquimista', 1988, 8), ('Quincas Borba', 1891, 1), ('Emma', 1815, 4),
('O Silmarillion', 1977, 5), ('Anjos e Demônios', 2000, 7), ('Brida', 1990, 8),
('Memórias Póstumas de Brás Cubas', 1881, 1), ('Persuasão', 1817, 4), ('O Inferno', 2013, 7),
('Maktub', 1994, 8), ('Harry Potter e a Câmara Secreta', 1998, 6), ('Caminho Suave', 1948, 2),
('Contos de Escola', 1896, 1), ('A Mansão de Mansfield', 1814, 4), ('Ponto de Impacto', 2001, 7);

-- 6. Detalhes dos Livros (Vinculados aos IDs 1 a 24)
INSERT INTO detalhes_livro (detalhes, isbn, npaginas) VALUES
('Romance clássico brasileiro', '9788572326975', 256), ('Fábula filosófica vida', '9788595081512', 96),
('Distopia sobre vigilância', '9788535914849', 328), ('Romance clássico amor', '9788537811016', 424),
('Fantasia jornada Bilbo', '9788595084742', 336), ('Fantasia jovem bruxo', '9788532530783', 264),
('Sátira regimes políticos', '9788535909555', 152), ('Fantasia épica anel', '9788533613379', 576),
('Suspense símbolos religião', '9788575421134', 480), ('Jornada espiritual busca', '9788576653725', 208),
('Realismo machadiano', '9788572326976', 220), ('Costumes da alta sociedade', '9788537811017', 400),
('Mitos da Terra Média', '9788595084743', 450), ('Conspiração no Vaticano', '9788575421135', 520),
('A busca pela alma gêmea', '9788576653726', 280), ('Narrada por um defunto', '9788572326977', 180),
('Amor e segundas chances', '9788537811018', 350), ('Mistério baseado em Dante', '9788575421136', 460),
('Ensinamentos de vida', '9788576653727', 190), ('Mistérios em Hogwarts', '9788532530784', 288),
('Alfabetização clássica', '9788595081513', 120), ('Contos clássicos Realismo', '9788572326978', 150),
('Drama e família inglesa', '9788537811019', 430), ('Tecnologia e suspense NASA', '9788575421137', 410);

-- 7. Detalhes Adicionais (Sem vínculo direto no front)
INSERT INTO detalhes_livro (detalhes, isbn, npaginas) VALUES
('Crônicas inéditas encontradas em manuscritos antigos', '9788572326990', 145),
('Ensaio sobre a evolução da literatura fantástica', '9788595081520', 210),
('Biografia autorizada com fotos e cartas exclusivas', '9788535909560', 380);

-- 8. Relacionamentos
UPDATE livro SET detalhes_id = id;

INSERT INTO livro_autor (livro_id, autor_id) VALUES
(1,1), (2,2), (3,3), (4,4), (5,5), (6,6), (7,3), (8,5), (9,7), (10,8),
(11,1), (12,4), (13,5), (14,7), (15,8), (16,1), (17,4), (18,7), (19,8), (20,6),
(21,2), (22,1), (23,4), (24,7);

SET SQL_SAFE_UPDATES = 1;
