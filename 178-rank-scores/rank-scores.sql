# Write your MySQL query statement below

# SELECT s1.score, (SELECT COUNT(DISTINCT s2.score)
#                  FROM Scores AS s2
#                  WHERE s2.score >= s1.score) AS `rank`
# FROM Scores AS s1
# ORDER BY s1.score DESC;

SELECT score, @rank := @rank + (@prev <> (@prev := score)) AS `rank`
FROM Scores, 
(SELECT @rank := 0, @prev := -1) AS new
ORDER BY score DESC;