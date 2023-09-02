# Write your MySQL query statement below
SELECT 
    DATE_FORMAT(trans_date, "%Y-%m") AS month, 
    country, 
    COUNT(*) AS trans_count, 
    SUM(IF (state = 1, 1, 0)) AS approved_count, 
    SUM(amount) AS trans_total_amount, 
    SUM(IF (state = 1, amount, 0)) AS approved_total_amount
FROM Transactions
GROUP BY DATE_FORMAT(trans_date, "%Y-%m"), country;