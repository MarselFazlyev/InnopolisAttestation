create table onetoone.school
(
    id  integer generated by default as identity primary key,
    number integer not null,
    director_id integer unique references onetoone.director(id) on delete cascade
);

create table director
(
    id   integer generated by default as identity primary key,
    name varchar(200) not null,
    age  integer
        constraint director_age_check
            check (age > 0)
);