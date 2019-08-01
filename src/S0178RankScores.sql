Create table If Not Exists Scores (Id int, Score DECIMAL(3,2))
Truncate table Scores
insert into Scores (Id, Score) values ('1', '3.5')
insert into Scores (Id, Score) values ('2', '3.65')
insert into Scores (Id, Score) values ('3', '4.0')
insert into Scores (Id, Score) values ('4', '3.85')
insert into Scores (Id, Score) values ('5', '4.0')
insert into Scores (Id, Score) values ('6', '3.65')

SELECT O.Score, CAST(R.Rank AS UNSIGNED) AS Rank
FROM (SELECT Score FROM Scores ORDER BY Score DESC) AS O,
     (SELECT Score, @rank := @rank+1 AS Rank FROM (SELECT DISTINCT Score FROM Scores ORDER BY Score DESC) AS T CROSS JOIN (SELECT @rank := 0) AS D) AS R
WHERE O.Score = R.Score

