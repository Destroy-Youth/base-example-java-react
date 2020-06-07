
CREATE TABLE IF NOT EXISTS persons (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  birthdate DATE,
  mail VARCHAR(30) NOT NULL,
  sex VARCHAR(1) NOT NULL,
  id_hobbie INT,
  FOREIGN KEY (id_hobbie) 
    REFERENCES hobbies(id)
);

CREATE TABLE IF NOT EXISTS hobbies (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);

 
INSERT INTO persons (id, first_name, last_name, mail, sex, id_hobbie) VALUES
  (1, 'Wes', 'Bos', 'wes.bos@mail.com', 'm', 1);

INSERT INTO hobbies (id, name) VALUES
  (1, 'Coding');