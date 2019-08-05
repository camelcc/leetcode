Create table If Not Exists Logs (Id int, Num int);
Truncate table Logs;
insert into Logs (Id, Num) values ('1', '1');
insert into Logs (Id, Num) values ('2', '1');
insert into Logs (Id, Num) values ('3', '1');
insert into Logs (Id, Num) values ('4', '2');
insert into Logs (Id, Num) values ('5', '1');
insert into Logs (Id, Num) values ('6', '2');
insert into Logs (Id, Num) values ('7', '2');


SELECT DISTINCT t.Num1 AS ConsecutiveNums
FROM (SELECT l1.Id AS Id, l1.Num AS Num1, l2.Num AS Num2, l3.Num AS Num3
      FROM Logs AS l1, Logs AS l2, Logs AS l3
      WHERE l1.Id = l2.Id - 1 AND l2.Id = l3.Id - 1) AS t
WHERE t.Num1 = t.Num2 AND t.Num2 = t.Num3

