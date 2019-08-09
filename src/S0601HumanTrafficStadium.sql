Create table If Not Exists stadium (id int, visit_date DATE NULL, people int);
Truncate table stadium;
insert into stadium (id, visit_date, people) values ('1', '2017-01-01', '10');
insert into stadium (id, visit_date, people) values ('2', '2017-01-02', '109');
insert into stadium (id, visit_date, people) values ('3', '2017-01-03', '150');
insert into stadium (id, visit_date, people) values ('4', '2017-01-04', '99');
insert into stadium (id, visit_date, people) values ('5', '2017-01-05', '145');
insert into stadium (id, visit_date, people) values ('6', '2017-01-06', '1455');
insert into stadium (id, visit_date, people) values ('7', '2017-01-07', '199');
insert into stadium (id, visit_date, people) values ('8', '2017-01-08', '188');

SELECT DISTINCT s1.*
FROM stadium AS s1, stadium AS s2, stadium AS s3
WHERE s1.people >= 100 AND s2.people >= 100 AND s3.people >= 100 AND
      ((s1.id+1 = s2.id AND s2.id+1 = s3.id) OR
       (s1.id-1 = s2.id AND s1.id+1 = s3.id) OR
       (s1.id-2 = s2.id AND s1.id-1 = s3.id))
ORDER BY s1.id
