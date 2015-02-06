select e.name from Employee e,Employee m where e.managerId=m.id and e.salary>m.salary;
