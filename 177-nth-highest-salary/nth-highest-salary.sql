CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
SET N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      IFNULL((SELECT DISTINCT(salary) 
      FROM Employee 
      ORDER BY salary DESC
      LIMIT N , 1), NULL)
  );
END