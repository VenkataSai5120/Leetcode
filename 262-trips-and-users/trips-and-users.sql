# Write your MySQL query statement below
# SELECT request_at AS Day, ROUND(SUM(IF(status = 'cancelled_by_driver' OR 
# status = 'cancelled_by_client', 1, 0)) /  COUNT(*), 2) AS `Cancellation Rate`
# FROM Trips
# WHERE client_id NOT IN (SELECT users_id FROM Users WHERE banned = "Yes") AND
# driver_id NOT IN (SELECT users_id FROM Users WHERE banned = "Yes") AND
# request_at BETWEEN "2013-10-01" AND "2013-10-03"
# GROUP BY request_at;

WITH info AS (
    SELECT request_at, t.status <> 'completed' AS is_cancelled
    FROM Trips AS t
    INNER JOIN Users AS c ON (t.client_id = c.users_id AND c.banned = "No")
    INNER JOIN Users AS d ON (t.driver_id = d.users_id AND d.banned = "No")
    WHERE request_at BETWEEN '2013-10-01' AND '2013-10-03'
)
SELECT request_at AS Day, ROUND(SUM(is_cancelled) / count(*), 2) AS
`Cancellation Rate`
FROM info
GROUP BY Day;