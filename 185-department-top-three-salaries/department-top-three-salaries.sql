# Write your MySQL query statement below

SELECT d.name AS Department, e1.name As Employee, e1.salary AS Salary
FROM Employee AS e1
INNER JOIN
Department AS d
ON d.id = e1.departmentId
WHERE 3 > (
    SELECT COUNT(DISTINCT e2.salary)
    FROM Employee AS e2
    WHERE e2.salary > e1.salary AND e1.departmentId = e2.departmentId
);
