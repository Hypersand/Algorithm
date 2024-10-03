-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛 조회
WITH A AS (
    SELECT *
    FROM FIRST_HALF F
    UNION
    SELECT *
    FROM JULY J
)

SELECT *
FROM (SELECT FLAVOR
FROM A
GROUP BY FLAVOR
ORDER BY SUM(TOTAL_ORDER) DESC)
WHERE ROWNUM <= 3;


