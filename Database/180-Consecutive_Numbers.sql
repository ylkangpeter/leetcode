select distinct(a.Num) from Logs a, Logs b,Logs c where a.Id=b.Id+1 and a.Num=b.Num and b.Id=c.Id+1 and b.Num=c.Num
