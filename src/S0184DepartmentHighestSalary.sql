Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '70000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Jim', '90000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('5', 'Max', '90000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');

SELECT Department.Name AS Department, S.Name AS Employee, S.Salary
FROM (SELECT Employee.Name, Employee.Salary, Employee.DepartmentId
      FROM
      (SELECT Employee.DepartmentId, MAX(Employee.Salary) AS Salary
       FROM Employee
       GROUP BY Employee.DepartmentId) AS E JOIN Employee
      WHERE E.DepartmentId = Employee.DepartmentId AND E.Salary = Employee.Salary) AS S JOIN Department
WHERE S.DepartmentId = Department.Id
