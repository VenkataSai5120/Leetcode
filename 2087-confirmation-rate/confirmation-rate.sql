# Write your MySQL query statement below
SELECT s.user_id, ROUND(AVG(IF(c.action = 1, 1, 0)), 2) AS confirmation_rate
FROM Signups AS s
LEFT JOIN 
Confirmations AS c
USING(user_id)
GROUP BY s.user_id;