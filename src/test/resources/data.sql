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

INSERT INTO
    book (id, max_loan_days, isbn, title)
VALUES
    (61, 30, '5927765584910', 'Harry Potter'),
    (62, 21, '9782302140136', 'The Odyssey'),
    (63, 14, '9780012340084', 'To Kill a Mockingbird'),
    (64, 28, '9780306777671', 'The Road'),
    (65, 30, '9780553546790', 'A Game of Thrones');

INSERT INTO
    book_loan (id, book_id, borrower_id, loan_date, due_date, returned)
VALUES
    (60, 61, 11, '2025-07-01', '2025-07-30', false),
    (61, 62, 22, '2025-06-15', '2025-07-06', false),
    (62, 63, 33, '2025-06-10', '2025-06-24', true),
    (63, 64, 44, '2025-06-20', '2025-07-18', false),
    (64, 65, 55, '2025-06-01', '2025-07-01', true);