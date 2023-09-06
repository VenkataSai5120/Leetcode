# Write your MySQL query statement below

SELECT mgr.employee_id, mgr.name, COUNT(mgr.employee_id) AS reports_count, 
ROUND(AVG(emp.age)) AS average_age
FROM employees AS emp, employees AS mgr
WHERE emp.reports_to = mgr.employee_id
GROUP BY employee_id
ORDER BY employee_id;