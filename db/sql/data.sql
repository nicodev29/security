-----------data-------------

insert into customers (email, password) VALUES
                            ('Admin@gmail.com', 'password'),
                            ('User@gmail.com','password');


insert into roles (role_name, description, id_customer) VALUES
                            ('ADMIN', 'you cant see this endpoint',1),
                            ('ADMIN','you cant see this endpoint' ,1),
                            ('USER', 'you cant see this endpoint',2),
                            ('USER','you cant see this endpoint' ,2);