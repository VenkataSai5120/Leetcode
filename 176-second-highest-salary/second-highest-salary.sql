# Write your MySQL query statement below

# SELECT MAX(salary) AS SecondHighestSalary
# FROM Employee
# WHERE salary <> (SELECT MAX(salary) FROM Employee);

SELECT IFNULL(
  (SELECT DISTINCT Salary
  FROM Employee
  ORDER BY Salary DESC
  LIMIT 1 OFFSET 1),
  NULL) AS SecondHighestSalary;