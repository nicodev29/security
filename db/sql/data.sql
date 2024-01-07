-----------data-------------

insert into users (username, password, enabled) VALUES
                                                    ('admin', 'admin', true),
                                                    ('user', 'user', true);

insert into authorities (username, authority) VALUES
                                                  ('admin', 'admin'),
                                                  ('user', 'user');