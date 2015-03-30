delete from Person where id not in (select c.id from (select min(o.Id) as id from Person o group by o.Email) as c)
