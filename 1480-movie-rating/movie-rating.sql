# Write your MySQL query statement below
(SELECT u.name AS results
FROM MovieRating AS mr
JOIN Users AS u ON mr.user_id = u.user_id
GROUP BY mr.user_id
ORDER BY COUNT(mr.user_id) DESC, u.name
LIMIT 1)
UNION ALL
(SELECT m.title
FROM MovieRating AS mr
JOIN Movies AS m ON mr.movie_id = m.movie_id
WHERE DATE_FORMAT(mr.created_at, "%m-%Y") = "02-2020"
GROUP BY mr.movie_id
ORDER BY AVG(rating) DESC, m.title
LIMIT 1);