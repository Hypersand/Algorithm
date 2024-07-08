-- FIRST_HALF : 아이스크림 가게의 상반기 주문 정보
-- JULY : 7월의 아이스크림 주문 정보
-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 
-- 큰 순서대로 상위 3개의 맛을 조회
SELECT *
FROM (
    SELECT F.FLAVOR
    FROM FIRST_HALF F
    JOIN (
        SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER
        FROM JULY
        GROUP BY FLAVOR
    ) J
    ON F.FLAVOR = J.FLAVOR
    ORDER BY (F.TOTAL_ORDER + J.TOTAL_ORDER) DESC
    )
WHERE ROWNUM <= 3;



