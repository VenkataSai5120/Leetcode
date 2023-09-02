# Write your MySQL query statement below
SELECT 
    DATE_FORMAT(trans_date, "%Y-%m") AS month, 
    country, 
    COUNT(*) AS trans_count, 
    SUM(CASE WHEN state = 1 THEN 1 ELSE 0 END) AS approved_count, 
    SUM(amount) AS trans_total_amount, 
    SUM(CASE WHEN state = 1 THEN amount ELSE 0 END) AS approved_total_amount
FROM Transactions
GROUP BY DATE_FORMAT(trans_date, "%Y-%m"), country;