DROP TABLE IF EXISTS persons;

CREATE TABLE persons (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  birthdate DATE,
  mail VARCHAR(30) NOT NULL,
  sex VARCHAR(1) NOT NULL,
  id_hobbie INT
);

CREATE TABLE hobbies (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);

ALTER TABLE persons
    ADD FOREIGN KEY (id_hobbie) 
    REFERENCES hobbies(id);
 
-- INSERT INTO persons (first_name, last_name) VALUES
--   ('Wes', 'Bos'),
--   ('Luis', 'Herrera'),
--   ('Ivan', 'Equihua'),
--   ('Dan', 'Abramov');