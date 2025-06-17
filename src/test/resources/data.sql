INSERT INTO
    details (id, birth_date, email, name)
VALUES
    (10, '1996-07-18', 'olivia.martin@example.com', 'Olivia Martin'),
    (20, '1982-10-02', 'william.harris@example.com', 'William Harris'),
    (30, '1991-05-28', 'ava.garcia@example.com', 'Ava Garcia'),
    (40, '1972-08-15', 'james.davis@example.com', 'James Davis'),
    (50, '1994-03-08', 'isabella.miller@example.com', 'Isabella Miller');

INSERT INTO
    app_user (id, password, reg_date, username, user_details_id)
VALUES
    (11, 'password789', '2023-06-01', 'olimar',10),
    (22, 'letmein123', '2022-08-01', 'wilhar',20),
    (33, 'qwertyuiop', '2024-04-01', 'avagar',30),
    (44, 'helloagain', '2023-02-01', 'jamedav',40),
    (55, 'abc456def', '2022-11-01', 'isamil',50);