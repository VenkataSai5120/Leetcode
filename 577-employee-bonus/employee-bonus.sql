# Write your MySQL query statement below
SELECT emp.name, bon.bonus
FROM Employee AS emp
LEFT JOIN
BONUS AS bon
ON emp.empId = bon.empId
WHERE bon.bonus < 1000 OR bon.bonus IS NULL;
