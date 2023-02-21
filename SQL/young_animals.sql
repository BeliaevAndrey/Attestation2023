USE ZooDB;

-- Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет
DROP TABLE IF EXISTS YoungAnimals;
CREATE TABLE YoungAnimals(
    Animal_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Name VARCHAR(20) NOT NULL,
    BirthDay DATE NOT NULL,
    Age FLOAT
)
SELECT * FROM (SELECT Name, BirthDay, ROUND((YEAR(current_date()) - YEAR(Birthday)) + (MONTH(current_date() - MONTH(Birthday))/12),2) AS Age 
    FROM (
        SELECT * FROM AllSumpters UNION 
        SELECT * FROM Cats UNION 
        SELECT * FROM Dogs UNION
        SELECT * FROM Hamsters)
    AS t1)
AS t2 WHERE t2.Age < 3 and t2.Age > 1\p;

SELECT Name, Age FROM YoungAnimals;

