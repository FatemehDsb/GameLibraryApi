
DROP TABLE IF EXISTS games;
DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS categories;

CREATE TABLE games(
 id INTEGER AUTO_INCREMENT PRIMARY KEY,
 title VARCHAR(255),
 genre VARCHAR(255),
 rating DOUBLE,
 release_year INTEGER,
 category_id INTEGER,
 FOREIGN KEY (category_id) REFERENCES categories(category_id);
 );



 CREATE TABLE categories(
 category_id INTEGER AUTO_INCREMENT PRIMARY KEY,
 category_name VARCHAR(255)
 );



