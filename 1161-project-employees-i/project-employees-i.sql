# Write your MySQL query statement below
SELECT p.project_id, ROUND(AVG(e.experience_years), 2) AS average_years
FROM Employee as e,
Project AS p
WHERE e.employee_id = p.employee_id
GROUP BY p.project_id;