select d.Name as Department, o.Name as Employee, o.Salary as Salary from (select a.Salary,a.DepartmentId,a.Name from (select max(Salary) as Salary,DepartmentId from Employee  group by DepartmentId) b, Employee a 
  where a.DepartmentId=b.DepartmentId and a.Salary=b.Salary) o,Department d where d.Id=o.DepartmentId;
