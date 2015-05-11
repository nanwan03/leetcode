Write a SQL query to find all numbers that appear at least three times consecutively.

+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.

# Write your MySQL query statement below
select distinct a.Num
from Logs a, Logs b, Logs c
where a.Id = b.Id + 1 and b.Id = c.Id + 1 and a.Num = b.Num  and b.Num = c.Num