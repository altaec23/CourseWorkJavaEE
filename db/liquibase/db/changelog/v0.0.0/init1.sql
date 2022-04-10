--liquibase formatted sql

--changeset alekseev:hiber1

create table contact_info
(
    id               bigserial not null
        constraint contact_info_pkey
        primary key,
    email            varchar(20) not null,
    telephone_number varchar(20) not null
);

create table discipline
(
    id          bigserial
        primary key,
    code        integer      not null,
    description varchar(100) not null
);

