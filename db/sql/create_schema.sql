--------------schema---------------
create table customers(
                      id bigserial primary key,
                      email varchar(50) not null,
                      password varchar(50) not null

);

create table roles(
                      id bigserial primary key,
                      role_name varchar(50),
                      description varchar(100),
                      id_customer bigint,
                      constraint fk_customer foreign key (id_customer) references customers(id)
);