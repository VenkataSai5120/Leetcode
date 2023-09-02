# Write your MySQL query statement below

SELECT p.product_id, ROUND(SUM(us.units * p.price) / SUM(us.units), 2) as average_price
FROM Prices as p
INNER JOIN
UnitsSold as us
ON p.product_id=us.product_id AND us.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY product_id;