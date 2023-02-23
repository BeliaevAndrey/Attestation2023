USE ZooDB;


-- Удалить верблюдов
DELETE FROM Sumpters WHERE Animal_type='Camels'\p;
DROP TABLE Camels\p;


-- Создать объединённую таблицу лошадей и ослов
CREATE TABLE AllSumpters(
    sumpter_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Name VARCHAR(20) NOT NULL,
    BirthDay DATE NOT NULL,
    Command VARCHAR(20),
    A_subtype INT NOT NULL,
    A_type INT NOT NULL
)
SELECT Name, BirthDay, Command, A_subtype, A_type FROM
Horses UNION 
SELECT Name, BirthDay, Command, A_subtype, A_type FROM
Donkeys\p;

-- Удалить таблицы лошадей и ослов
DROP TABLE Horses\p;
DROP TABLE Donkeys\p;

-- Вывод объединенной таблицы на экран
SELECT Name, Birthday, Command, Sumpters.Animal_type AS Subtype, Animals.Animal_type AS Category
FROM AllSumpters
JOIN Sumpters ON AllSumpters.A_subtype=Sumpters.Type_id
JOIN Animals ON AllSumpters.A_type=Animals.Type_id;
