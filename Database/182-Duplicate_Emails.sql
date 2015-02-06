select m.e from (select count(Email) as c,Email as e from Person group by Email) m where m.c>1;
