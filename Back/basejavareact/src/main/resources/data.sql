DROP TABLE IF EXISTS persons;

CREATE TABLE persons (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL
);
 
INSERT INTO persons (first_name, last_name) VALUES
  ('Wes', 'Bos'),
  ('Luis', 'Herrera'),
  ('Ivan', 'Equihua'),
  ('Dan', 'Abramov');