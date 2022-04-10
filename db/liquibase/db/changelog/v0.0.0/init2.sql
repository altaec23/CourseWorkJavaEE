--liquibase formatted sql

--changeset alekseev:hiber2

create table s_group
(
    id        bigserial not null
        constraint s_group_pkey
            primary key,
    direction varchar(50),
    name      varchar(20)
);

