SELECT b.Name as Department, a.Name as Employee, a.Salary as Salary FROM Department b, 
(SELECT Name,Salary,@num :=if(@DepartmentId=DepartmentId,if(@Salary=salary,@num,@num+1),1) as number, @DepartmentId:=departmentId as DepartmentId,@Salary:=salary as psalary FROM Employee,(select @num := 0, @DepartmentId := '',@Salary := 0) m ORDER BY DepartmentId ASC, salary DESC ) a where a.DepartmentId=b.Id and a.number<=3;
