# Write your MySQL query statement below
WITH info AS (
    SELECT id, visit_date, people, id - row_number() OVER() AS id_difference
    FROM Stadium
    WHERE people >= 100
)

SELECT id, visit_date, people
FROM info
WHERE id_difference IN 
(SELECT id_difference FROM info GROUP BY id_difference HAVING COUNT(*) >= 3)
ORDER BY visit_date;