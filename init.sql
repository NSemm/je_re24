CREATE DATABASE notes;
CREATE TABLE notes(
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(40) NOT NULL UNIQUE,
                      description VARCHAR(40) NOT NULL,
                      ctime TIMESTAMP NOT NULL
);
INSERT INTO notes (name,description,ctime)
VALUES
('first','test note','2021-03-20'),
('second','test note 2','2021-03-20');