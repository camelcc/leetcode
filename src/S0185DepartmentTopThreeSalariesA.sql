Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '85000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Max', '90000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('5', 'Janet', '69000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('6', 'Randy', '85000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('7', 'Will', '70000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');

SELECT Department.Name AS Department, OuterEmployee.Name AS Employee, OuterEmployee.Salary
FROM Department JOIN Employee as OuterEmployee
WHERE Department.Id = OuterEmployee.DepartmentId AND
      (SELECT COUNT(DISTINCT Salary) FROM Employee WHERE OuterEmployee.DepartmentId = Employee.DepartmentId AND Employee.Salary > OuterEmployee.Salary) < 3
ORDER BY Department.Name, OuterEmployee.Salary DESC


# SELECT Department.Name AS Department, S.Name AS Employee, S.Salary
# FROM Department,
#   (SELECT MAX(Employee.Salary) AS Salary, Employee.Name, Employee.DepartmentId
#    FROM Employee RIGHT OUTER JOIN
#      (SELECT MAX(Employee.Salary) AS Salary, Employee.Name, Employee.DepartmentId
#       FROM Employee RIGHT OUTER JOIN
#         (SELECT MAX(Employee.Salary) AS Salary, Employee.Name, Employee.DepartmentId
#          FROM Employee
#          GROUP BY Employee.DepartmentId) AS Highest
#       ON Employee.DepartmentId = Highest.DepartmentId AND Employee.Salary < Highest.Salary) AS Second
#    ON Employee.DepartmentId = Second.DepartmentId AND Employee.Salary < Second.Salary) AS S
# WHERE S.DepartmentId = Department.Id