# Write your MySQL query statement below
# SELECT s.name FROM SalesPerson AS s 
# WHERE s.sales_id NOT IN (
#     SELECT o.sales_id 
#     FROM Orders AS o 
#     LEFT JOIN Company AS c 
#     ON c.com_id = o.com_id 
#     WHERE c.name = "RED"
# );

 SELECT name FROM SalesPerson 
WHERE sales_id NOT IN(
    SELECT sales_id FROM Orders WHERE com_id IN (
            SELECT com_id FROM Company WHERE name="RED" )
);