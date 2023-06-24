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

CREATE TABLE users(
	id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled tinyint DEFAULT 1
);
DROP TABLE users;
INSERT INTO users(username, password) VALUES
	("murad", "{bcrypt}$2a$12$yjT/UtFWaiO8.RiuIec/FOCXLR.CEg5BI.D9Ld/3qqbepSThsU.8O"),
    ("admin", "{bcrypt}$2a$12$h1rCvGGkZqVnGP5h3RZyVOvagcWV5uMtKM7kSx2PdQSUeG6muk3ne");
SELECT * FROM users;



CREATE TABLE authorities(
	id INT PRIMARY KEY AUTO_INCREMENT,
    authority VARCHAR(50) NOT NULL,
    username VARCHAR(30) NOT NULL,
    enabled tinyint DEFAULT 1,
    FOREIGN KEY (username) REFERENCES users(username)
);
DROP TABLE authorities;
INSERT INTO authorities(authority, username) VALUES
    ("ROLE_STUDENT", "admin");
SELECT * FROM authorities;
DELETE FROM authorities WHERE id = 4;


SELECT * FROM student;