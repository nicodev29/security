-----------data-------------

insert into customers (email, password) VALUES
                            ('Admin@gmail.com', 'password'),
                            ('User@gmail.com','password');


insert into roles (role_name, description, id_customer) VALUES
                            ('VIEW_ACCOUNT', 'you cant see this endpoint',1),
                            ('VIEW_LOANS','you cant see this endpoint' ,1),
                            ('VIEW_BALANCE', 'you cant see this endpoint',2),
                            ('VIEW_CARDS','you cant see this endpoint' ,2);