# Write your MySQL query statement below
SELECT emp_uni.unique_id, emp.name
FROM Employees AS emp
LEFT JOIN
EmployeeUNI as emp_uni
ON emp.id = emp_uni.id;