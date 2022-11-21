drop table if exists product cascade;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start 1 increment 1;
create table product
(
    id          int8 not null,
    number      int4 not null,
    type varchar(255),
    description varchar(2048),
    primary key (id)
);

