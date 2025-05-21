CREATE TABLE people
(
    id      UUID NOT NULL
        constraint pk_people primary key,
    name    varchar(255),
    surname varchar(255),
    age     integer,
    country varchar(255),
    constraint uk_people unique (name, surname)
);
