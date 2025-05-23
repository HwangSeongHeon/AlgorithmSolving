-- 코드를 입력하세요
WITH RECURSIVE hours AS (
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR + 1 FROM hours WHERE HOUR < 23
)
SELECT 
    h.HOUR,
    COALESCE(COUNT(a.ANIMAL_ID), 0) AS COUNT
FROM hours h
LEFT JOIN ANIMAL_OUTS a ON h.HOUR = HOUR(a.DATETIME)
GROUP BY h.HOUR
ORDER BY h.HOUR;