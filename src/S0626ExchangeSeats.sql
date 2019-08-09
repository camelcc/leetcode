Create table If Not Exists seat(id int, student varchar(255));
Truncate table seat;
insert into seat (id, student) values ('1', 'Abbot');
insert into seat (id, student) values ('2', 'Doris');
insert into seat (id, student) values ('3', 'Emerson');
insert into seat (id, student) values ('4', 'Green');
insert into seat (id, student) values ('5', 'Jeames');


SELECT s1.id, s2.student
FROM seat AS s1, seat AS s2
WHERE (s1.id%2 = 1 AND s1.id+1 = s2.id) OR
      (s1.id%2 = 0 AND s1.id-1 = s2.id) OR
      (s1.id = (SELECT COUNT(s1.id) FROM seat) AND s1.id%2 = 1 AND s1.id = s2.id)
ORDER BY s1.id
