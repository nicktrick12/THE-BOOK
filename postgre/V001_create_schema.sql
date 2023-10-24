CREATE SCHEMA thebook_platform;

ALTER SCHEMA thebook_platform OWNER TO "thebook";

DROP TYPE IF EXISTS thebook_platform.situation CASCADE;

CREATE TYPE thebook_platform.situation AS ENUM (
    'LIVRE',
    'SUSPENSO',
    'BANIDO'
);

ALTER TYPE thebook_platform.situation OWNER TO "thebook";

DROP TYPE IF EXISTS thebook_platform.role CASCADE;

CREATE TYPE thebook_platform.role AS ENUM (
    'ADMIN',
    'LEITOR'
);

ALTER TYPE thebook_platform.role OWNER TO "thebook";

DROP  TABLE IF EXISTS thebook_platform.user CASCADE;

CREATE TABLE thebook_platform.user (
    id uuid NOT NULL,
    nome varchar NOT NULL,
    username varchar NOT NULL UNIQUE,
    email varchar NOT NULL UNIQUE,
    senha varchar NOT NULL,
    data_nasc timestamp NOT NULL,
    CPF varchar,
    data_entr timestamp,
    situacao thebook_platform.situation NOT NULL,
    papel thebook_platform.role NOT NULL
);

ALTER TABLE thebook_platform.user OWNER TO "thebook";

ALTER TABLE thebook_platform.user
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);

DROP TYPE IF EXISTS thebook_platform.livro_status CASCADE;

CREATE TYPE thebook_platform.livro_status AS ENUM (
    'AUTENTICADO',
    'NAO AUTENTICADO'
);

ALTER TYPE thebook_platform.livro_status OWNER TO "thebook";

DROP TABLE IF EXISTS thebook_platform.livro CASCADE;

CREATE TABLE thebook_platform.livro (
    id uuid NOT NULL,
    paginas int NOT NULL,
    titulo varchar NOT NULL,
    genero varchar NOT NULL,
    autor varchar NOT NULL,
    classificacao int NOT NULL,
    resumo varchar NOT NULL,
    data_add timestamp NOT NULL,
    id_user_add uuid,
    status thebook_platform.livro_status,
    media_aval INT
);

ALTER TABLE thebook_platform.livro OWNER TO "thebook";

ALTER TABLE thebook_platform.livro
    ADD CONSTRAINT livro_pkey PRIMARY KEY (id);

ALTER TABLE thebook_platform.livro
    ADD CONSTRAINT livro_id_user_add_fkey FOREIGN KEY (id_user_add)
        REFERENCES thebook_platform.user(id) ON DELETE CASCADE;

DROP TYPE IF EXISTS thebook_platform.leitura_status CASCADE;

CREATE TYPE thebook_platform.leitura_status AS ENUM (
    'LIDO',
    'LENDO',
    'ABANDONADO'
);

ALTER TYPE thebook_platform.leitura_status OWNER TO "thebook";

DROP TABLE IF EXISTS thebook_platform.leitura CASCADE;

CREATE TABLE thebook_platform.leitura (
    id uuid NOT NULL,
    id_user uuid NOT NULL,
    id_livro uuid NOT NULL,
    data_inicio timestamp NOT NULL,
    status thebook_platform.leitura_status NOT NULL,
    favoritado boolean NOT NULL,
    avaliacao int
);

ALTER TABLE thebook_platform.leitura OWNER TO "thebook";

ALTER TABLE thebook_platform.leitura
    ADD CONSTRAINT leitura_pkey PRIMARY KEY (id);

ALTER TABLE thebook_platform.leitura
    ADD CONSTRAINT leitura_id_user_fkey FOREIGN KEY (id_user)
        REFERENCES thebook_platform.user(id) ON DELETE CASCADE;

ALTER TABLE thebook_platform.leitura
    ADD CONSTRAINT leitura_id_livro_fkey FOREIGN KEY (id_livro)
        REFERENCES thebook_platform.livro(id) ON DELETE CASCADE;

DROP TABLE IF EXISTS thebook_platform.comment CASCADE;

CREATE TABLE thebook_platform.comment (
    id uuid NOT NULL,
    id_user uuid NOT NULL,
    id_livro uuid NOT NULL,
    texto varchar NOT NULL
);

ALTER TABLE thebook_platform.comment OWNER TO "thebook";

ALTER TABLE thebook_platform.comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (id);

ALTER TABLE thebook_platform.comment
    ADD CONSTRAINT comment_id_user_fkey FOREIGN KEY (id_user)
        REFERENCES thebook_platform.user(id) ON DELETE CASCADE;

ALTER TABLE thebook_platform.comment
    ADD CONSTRAINT comment_id_livro_fkey FOREIGN KEY (id_livro)
        REFERENCES thebook_platform.livro(id) ON DELETE CASCADE;