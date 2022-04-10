--liquibase formatted sql

--changeset alekseev:hiber3

create table student
(
    id      bigserial not null
       constraint student_pkey
           primary key,
    name    varchar(30),
    contact bigint not null
        constraint uk_fssn53xm46dwlebtb74r1dreg
            unique
        constraint fkl5p15hxow1cyfe1rtf0wdt341
            references contact_info,
    s_group bigint
        constraint fk30v2pebft6khaq8dym3ki72h8
            references s_group
);

create table student_discipline
(
    student    bigint not null
        constraint fk2skkp8316ytf6eyqn4bwaar6f
            references student,
    discipline bigint not null
        constraint fkkncnse8b1kqishxrbfasw6lqo
            references discipline,
            constraint student_discipline_pkey
    primary key (student, discipline)
);

