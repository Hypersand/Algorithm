# 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 한다,
# 0시부터 23시까지 각 시간대별로 입양이 몇 건이나 발생했는지 조회
WITH RECURSIVE A AS(
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR+1 FROM A
    WHERE HOUR < 23 
)

SELECT A.HOUR, COUNT(ANIMAL_ID) AS COUNT
FROM A LEFT OUTER JOIN ANIMAL_OUTS B ON
A.HOUR = HOUR(B.DATETIME)
GROUP BY A.HOUR
ORDER BY A.HOUR
