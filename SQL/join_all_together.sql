USE ZooDB;

-- Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.

DROP TABLE IF EXISTS AllAnimals;

CREATE TABLE AllAnimals(
    Animal_id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(20),
    BirthDay DATE,
    OldTable VARCHAR(20)
)
SELECT Name, BirthDay, Subtype AS OldTable FROM
(SELECT Name, BirthDay, Pets.Animal_type AS Subtype FROM
(SELECT * FROM Cats UNION SELECT * FROM Dogs UNION SELECT * FROM Hamsters) AS t1
JOIN Animals ON t1.A_type=Animals.type_id
JOIN Pets ON t1.A_subtype=Pets.Type_id) AS t2 
UNION SELECT * FROM
(SELECT Name, BirthDay, Sumpters.Animal_type AS Subtype
FROM AllSumpters
JOIN Animals ON AllSumpters.A_type=Animals.type_id
JOIN Sumpters ON AllSumpters.A_subtype=Sumpters.Type_id) AS t3;
