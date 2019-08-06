Create table If Not Exists Person (Id int, Email varchar(255));
Truncate table Person;
insert into Person (Id, Email) values ('1', 'a@b.com');
insert into Person (Id, Email) values ('2', 'c@d.com');
insert into Person (Id, Email) values ('3', 'a@b.com');

SELECT DISTINCT P1.Email
FROM Person AS P1 JOIN Person AS P2
WHERE P1.Id != P2.Id AND P1.Email = P2.Email
