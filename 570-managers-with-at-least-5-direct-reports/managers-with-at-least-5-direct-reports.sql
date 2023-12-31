# Write your MySQL query statement below
SELECT e.name 
FROM employee AS e
WHERE e.id IN (SELECT managerId 
  FROM Employee AS emp
  GROUP BY emp.managerId
  HAVING COUNT(emp.managerId) >= 5); 

# SELECT name 
# FROM employee 
# WHERE id IN 
# (SELECT managerId 
# FROM Employee
# GROUP BY managerId
# HAVING COUNT(managerId)>=5);