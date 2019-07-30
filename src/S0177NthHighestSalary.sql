Create table If Not Exists Employee (Id int, Salary int);
Truncate table Employee;
insert into Employee (Id, Salary) values ('1', '100');
insert into Employee (Id, Salary) values ('2', '200');
insert into Employee (Id, Salary) values ('3', '300');

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
  BEGIN
    DECLARE o INT;
    SET o = N-1;
    RETURN (
      # Write your MySQL query statement below.
      SELECT (
               SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT 1 OFFSET o
             ) AS SecondHighestSalary
    );
  END
