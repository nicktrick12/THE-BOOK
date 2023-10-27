--! User Queries !--

insert into thebook_platform.user(id, name, username, email, password, age, cpf,
        situation, role) values ('1b185f9e-6c0f-4617-bd77-dd4620a41a0f'::uuid,
        'Nicole', 'nicole', 'nickel@yahho.com',
        '$2a$10$6ntpsnNIXuFuPkIU08EiueXZh2qu4cUZQ0McdaujdfZUgWjZ0JPGq', --! password !--
        17, '12345678901', 'LIVRE', 'ADMIN');

insert into thebook_platform.user(id, name, username, email, password, age, cpf,
    situation, role) values ('cc171e74-5dc3-4a38-9c86-5844ed673b5f'::uuid,
    'Kauã', 'kaua', 'kaua@yahoo.com',
    '$2a$10$LzzhmD5vaUQEe2nXvarWsOqpzxkrON9u20dooYrMTesQLk4zzBV5S', --! senha !--
    17, '12345678902', 'LIVRE', 'LEITOR');

--! Book Queries !--

insert into thebook_platform.book(id, pages, title, gender, author, classification, summary,
    date_add, id_user_add, status, average) values ('582c710f-849c-4a9f-a10f-0b68c784f240'::uuid,
    100, 'O Pequeno Príncipe', 'Infantil', 'Antoine de Saint-Exupéry', 10,
    'O Pequeno Príncipe é uma obra do escritor francês Antoine de Saint-Exupéry, ' ||
    'publicada em 1943 nos Estados Unidos. A princípio, aparentando ser um livro ' ||
    'para crianças, tem um grande teor poético e filosófico. A história é narrada ' ||
    'por um piloto que, após uma pane em seu avião, cai no deserto do Saara e ali ' ||
    'encontra uma criança loura e frágil. Ela diz vir de um pequeno planeta, onde ' ||
    'mora sozinha com uma rosa de grande beleza. A partir dessa história, o autor ' ||
    'escreve sobre valores humanos como a amizade, o amor e a responsabilidade.',
    '2020-06-02 08:00:00', '1b185f9e-6c0f-4617-bd77-dd4620a41a0f'::uuid, 'AUTENTICADO', 4.5);

insert into thebook_platform.book(id, pages, title, gender, author, classification, summary,
    date_add, id_user_add, status, average) values ('a0b0c0d0-e0f0-1a2b-3c4d-5e6f7a8b9c0d'::uuid,
    320, 'O Senhor dos Anéis', 'Fantasia', 'J. R. R. Tolkien', 12, 'O Senhor dos Anéis ' ||
    'é um romance de fantasia criado pelo escritor, professor e filólogo britânico J. R. R. ' ||
    'Tolkien. A história começa como sequência de um livro anterior de Tolkien, O Hobbit, e ' ||
    'logo se desenvolve numa história muito maior. Foi escrito entre 1937 e 1949, com muitas ' ||
    'partes criadas durante a Segunda Guerra Mundial. Embora Tolkien tenha planejado realizá-lo ' ||
    'em volume único, foi originalmente publicado em três volumes entre 1954 e 1955, e foi ' ||
    'assim, em três volumes, que se tornou popular. Desde então foi reimpresso várias vezes e ' ||
    'foi traduzido para mais de 40 línguas, tornando-se um dos trabalhos mais populares da ' ||
    'literatura do século XX. O Senhor dos Anéis narra o conflito contra o mal que se alastra ' ||
    'pela Terra-média, através da luta de várias raças - Humanos, Anões, Elfos, Ents e Hobbits ' ||
    '- contra Orcs, para evitar que o Anel do Poder volte às mãos de seu criador Sauron, o Senhor ' ||
    'do Escuro.', '2020-06-02 08:00:00', '1b185f9e-6c0f-4617-bd77-dd4620a41a0f'::uuid, 'AUTENTICADO', 4.9);

--! Reading Queries !--

insert into thebook_platform.reading(id, id_user, id_book, date_start, status, is_favorite, rating)
values ('1b185f9e-6c0f-4617-bd77-dd4620a41a0f'::uuid, 'cc171e74-5dc3-4a38-9c86-5844ed673b5f'::uuid,
    '582c710f-849c-4a9f-a10f-0b68c784f240'::uuid, '2020-06-02 08:00:00', 'LENDO', true, 3);

insert into thebook_platform.reading(id, id_user, id_book, date_start, status, is_favorite, rating)
values ('cc171e74-5dc3-4a38-9c86-5844ed673b5f'::uuid, 'cc171e74-5dc3-4a38-9c86-5844ed673b5f'::uuid,
    'a0b0c0d0-e0f0-1a2b-3c4d-5e6f7a8b9c0d'::uuid, '2020-06-02 08:00:00', 'LENDO', true, 5);

--! Comment Queries !--

insert into thebook_platform.comment(id, id_user, id_book, text)
values ('1b185f9e-6c0f-4617-bd77-dd4620a41a0f'::uuid, 'cc171e74-5dc3-4a38-9c86-5844ed673b5f'::uuid,
    '582c710f-849c-4a9f-a10f-0b68c784f240'::uuid, 'Muito bom!');

insert into thebook_platform.comment(id, id_user, id_book, text)
values ('cc171e74-5dc3-4a38-9c86-5844ed673b5f'::uuid, 'cc171e74-5dc3-4a38-9c86-5844ed673b5f'::uuid,
    'a0b0c0d0-e0f0-1a2b-3c4d-5e6f7a8b9c0d'::uuid, 'YOU SHALL NOT PASS!');