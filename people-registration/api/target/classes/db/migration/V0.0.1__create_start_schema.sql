CREATE TABLE people
(
    id        UUID NOT NULL
        constraint pk_people primary key,
    nome      varchar(255),
    sobrenome varchar(255),
    idade     integer,
    pais      varchar(255),
    constraint uk_people unique (nome, sobrenome)
);
