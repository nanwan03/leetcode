Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+

# Write your MySQL query statement below
select ifnull(
(select distinct Salary from Employee order by Salary desc limit 1, 1), null)