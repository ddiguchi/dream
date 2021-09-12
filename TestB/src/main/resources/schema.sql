DROP TABLE IF practice;

CREATE TABLE practice
(
   id INT NOT NULL AUTO_INCREMENT,
   issue VARCHAR(100),
   level VARCHAR(3),
   priority VARCHAR(3),
   PRIMARY KEY(id)
);