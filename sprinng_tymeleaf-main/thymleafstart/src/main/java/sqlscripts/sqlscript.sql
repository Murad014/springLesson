SHOW DATABASES;
CREATE DATABASE thymleaf;

USE thymleaf;
CREATE TABLE student(
                        id int PRIMARY KEY AUTO_INCREMENT,
                        first_name VARCHAR(100) NOT NULL,
                        last_name VARCHAR(100) NOT NULL,
                        email VARCHAR(50) NOT NULL UNIQUE,
                        phone VARCHAR(50) NOT NULL UNIQUE,
                        is_active bool DEFAULT 1
);

INSERT INTO student(FIRST_NAME, LAST_NAME, EMAIL, PHONE) VALUE
    #     ('Murad', 'Guliyev', 'quliyev.murad@yahoo.com', '+994514617033'),
    ('Anar', 'Memmedov', 'anar@yahoo.com', '+994586532541');



SELECT * FROM student;