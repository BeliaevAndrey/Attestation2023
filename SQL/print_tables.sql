USE ZooDB;

SELECT Name, BirthDay, Subtype, Category FROM
(SELECT Name, BirthDay, Pets.Animal_type AS Subtype, Animals.Animal_type AS Category FROM
(SELECT * FROM Cats UNION SELECT * FROM Dogs UNION SELECT * FROM Hamsters) AS t1
JOIN Animals ON t1.A_type=Animals.type_id
JOIN Pets ON t1.A_subtype=Pets.Type_id) AS t2 
UNION SELECT * FROM
(SELECT Name, BirthDay, Sumpters.Animal_type AS Subtype, Animals.Animal_type AS Category FROM
(SELECT * FROM Camels UNION SELECT * FROM Donkeys UNION SELECT * FROM Horses) AS t3
JOIN Animals ON t3.A_type=Animals.type_id
JOIN Sumpters ON t3.A_subtype=Sumpters.Type_id) AS t4;

