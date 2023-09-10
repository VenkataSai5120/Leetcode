# Write your MySQL query statement below
SELECT requester_id AS id, SUM(friend) AS num
FROM (
    (SELECT requester_id, COUNT(requester_id) AS friend
    FROM RequestAccepted
    GROUP BY requester_id)
    UNION ALL
    (SELECT accepter_id, COUNT(accepter_id)
    FROM RequestAccepted
    GROUP BY accepter_id)
) AS frnds
GROUP BY id
ORDER BY num DESC
LIMIT 1;