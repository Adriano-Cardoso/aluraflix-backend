ALTER TABLE TB_VIDEO add FOREIGN KEY(categoria_id) REFERENCES TB_CATEGORIA(categoria_id);

INSERT INTO TB_CATEGORIA(categoria_id, titulo, cor) VALUES(1,'Amarelo', 'Comedia');
INSERT INTO TB_CATEGORIA(categoria_id, titulo, cor) VALUES(2,'Branco', 'Livre');

INSERT INTO TB_VIDEO(video_id, titulo, descricao, url, categoria_id) VALUES(1,'Curso de Java- Iniciando', 'Curso de Java para iniciantes', 'http://testewa.com.br', 1);
INSERT INTO TB_VIDEO(video_id, titulo, descricao, url, categoria_id) VALUES(2,'Curso de Python- Iniciando', 'Curso de Python para iniciantes', 'http://testewa.com.br', 2);
