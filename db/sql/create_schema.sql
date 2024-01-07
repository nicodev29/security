--------------schema---------------
create table customers(
                      id bigserial primary key,
                      email varchar(50) not null,
                      password varchar(50) not null,
                      rol varchar (50) not null
);