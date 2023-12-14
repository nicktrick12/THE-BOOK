CREATE SCHEMA thebook_platform;

ALTER SCHEMA thebook_platform OWNER TO "thebook";

-- rodar daqui --

DROP  TABLE IF EXISTS thebook_platform.user CASCADE;

CREATE TABLE thebook_platform.user (
    id uuid NOT NULL,
    name varchar NOT NULL,
    username varchar NOT NULL UNIQUE,
    email varchar NOT NULL UNIQUE,
    password varchar NOT NULL
);

ALTER TABLE thebook_platform.user OWNER TO "thebook";

ALTER TABLE thebook_platform.user
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);

DROP TYPE IF EXISTS thebook_platform.book_status CASCADE;

CREATE TYPE thebook_platform.book_status AS ENUM (
    'AUTENTICADO',
    'NAO_AUTENTICADO'
);

ALTER TYPE thebook_platform.book_status OWNER TO "thebook";

DROP TABLE IF EXISTS thebook_platform.book CASCADE;

CREATE TABLE thebook_platform.book (
    id uuid NOT NULL,
    pages int NOT NULL,
    title varchar NOT NULL,
    gender varchar NOT NULL,
    author varchar NOT NULL,
    classification int NOT NULL,
    summary varchar NOT NULL,
    date_add timestamp NOT NULL,
    id_user_add uuid,
    status thebook_platform.book_status,
    average INT
);

ALTER TABLE thebook_platform.book OWNER TO "thebook";

ALTER TABLE thebook_platform.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (id);

ALTER TABLE thebook_platform.book
    ADD CONSTRAINT book_id_user_add_fkey FOREIGN KEY (id_user_add)
        REFERENCES thebook_platform.user(id) ON DELETE CASCADE;

DROP TYPE IF EXISTS thebook_platform.reading_status CASCADE;

CREATE TYPE thebook_platform.reading_status AS ENUM (
    'LIDO',
    'LENDO',
    'ABANDONADO'
);

ALTER TYPE thebook_platform.reading_status OWNER TO "thebook";

DROP TABLE IF EXISTS thebook_platform.reading CASCADE;

CREATE TABLE thebook_platform.reading (
    id uuid NOT NULL,
    id_user uuid NOT NULL,
    id_book uuid NOT NULL,
    date_start timestamp NOT NULL,
    status thebook_platform.reading_status NOT NULL,
    is_favorite boolean NOT NULL,
    rating int
);

ALTER TABLE thebook_platform.reading OWNER TO "thebook";

ALTER TABLE thebook_platform.reading
    ADD CONSTRAINT reading_pkey PRIMARY KEY (id);

ALTER TABLE thebook_platform.reading
    ADD CONSTRAINT reading_id_user_fkey FOREIGN KEY (id_user)
        REFERENCES thebook_platform.user(id) ON DELETE CASCADE;

ALTER TABLE thebook_platform.reading
    ADD CONSTRAINT reading_id_book_fkey FOREIGN KEY (id_book)
        REFERENCES thebook_platform.book(id) ON DELETE CASCADE;

DROP TABLE IF EXISTS thebook_platform.chatroom CASCADE;

CREATE TABLE thebook_platform.chatroom(
    id uuid NOT NULL,
    id_user uuid NOT NULL,
    id_book uuid NOT NULL
);

ALTER TABLE thebook_platform.chatroom OWNER TO "thebook";

ALTER TABLE thebook_platform.chatroom
    ADD CONSTRAINT chatroom_pkey PRIMARY KEY (id);

ALTER TABLE thebook_platform.chatroom
    ADD CONSTRAINT chatroom_id_user_fkey FOREIGN KEY (id_user)
        REFERENCES thebook_platform.user(id) ON DELETE CASCADE;

ALTER TABLE thebook_platform.chatroom
    ADD CONSTRAINT comment_id_book_fkey FOREIGN KEY (id_book)
        REFERENCES thebook_platform.book(id) ON DELETE CASCADE;

DROP TABLE IF EXISTS thebook_platform.comment CASCADE;

CREATE TABLE thebook_platform.comment (
    id uuid NOT NULL,
    id_user uuid NOT NULL,
    id_chatroom uuid NOT NULL,
    text varchar NOT NULL
);

ALTER TABLE thebook_platform.comment OWNER TO "thebook";

ALTER TABLE thebook_platform.comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (id);

ALTER TABLE thebook_platform.comment
    ADD CONSTRAINT comment_id_user_fkey FOREIGN KEY (id_user)
        REFERENCES thebook_platform.user(id) ON DELETE CASCADE;

ALTER TABLE thebook_platform.comment
    ADD CONSTRAINT comment_id_chatroom_fkey FOREIGN KEY (id_chatroom)
        REFERENCES thebook_platform.chatroom(id) ON DELETE CASCADE;