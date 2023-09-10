# Write your MySQL query statement below
SELECT ROUND(SUM(tiv_2016), 2) AS 'TIV_2016'
FROM insurance i1
WHERE i1.tiv_2015 IN (SELECT i2.tiv_2015 FROM insurance i2 WHERE i1.pid != i2.pid)
AND (i1.lat, i1.lon) NOT IN 
(SELECT lat, lon FROM insurance i3 where i1.pid != i3.pid);
