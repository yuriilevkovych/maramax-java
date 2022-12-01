drop table if exists users cascade;
create table users
(
    id          int8 not null,
    username varchar(255) not null,
    password varchar(255) not null,
    active boolean,
    primary key (id)
);