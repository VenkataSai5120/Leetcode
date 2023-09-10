# Write your MySQL query statement below
SELECT (CASE
        WHEN MOD(id, 2) = 1 AND total_seats = id THEN id
        WHEN MOD(id, 2) = 1 AND total_seats <> id THEN id + 1
        ELSE id - 1
    END) AS id, student
FROM Seat, (SELECT COUNT(*) AS total_seats FROM Seat) AS count_seats
ORDER BY id;
