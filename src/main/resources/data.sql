
CREATE TABLE tb_user_profile(
     user_id bigint NOT NULL,
     profile_id bigint NOT NULL
);


ALTER TABLE TB_VIDEO add FOREIGN KEY(categoria_id) REFERENCES TB_CATEGORIA(categoria_id);

INSERT INTO TB_USER(username, email, password_user) VALUES('Aluno', 'aluno@email.com', '$2a$10$ScxWIRKjc4MAX4czBWFC1.A2BjxMdflbo3dgMmqdY8a.MirR2OPVS');

INSERT INTO TB_CATEGORIA(categoria_id, titulo, cor) VALUES(1,'Comedia', 'Amarelo');
INSERT INTO TB_CATEGORIA(categoria_id, titulo, cor) VALUES(2,'Livre', 'Branco');

INSERT INTO TB_VIDEO(video_id, titulo, descricao, url, categoria_id) VALUES(1,'Curso de Java- Iniciando', 'Curso de Java para iniciantes', 'http://testewa.com.br', 1);
INSERT INTO TB_VIDEO(video_id, titulo, descricao, url, categoria_id) VALUES(2,'Curso de Python- Iniciando', 'Curso de Python para iniciantes', 'http://testewa.com.br', 2);

insert into tb_profile values(1,'ADMIN');

insert into tb_profile values(2,'USER');

insert into tb_user_profile values(1,1);


