-- FIRST_HALF : 아이스크림 가게의 상반기 주문 정보
-- ICECREAM_INFO : 아이스크림 성분에 대한 정보
-- 상반기 아이스크림 총주문량이 3000보다 높으면서
-- 아이스크림 주 성분이 과일인 아이스크림의 맛
-- 총주문량이 큰 순서대로 조회
SELECT F.FLAVOR
FROM FIRST_HALF F
JOIN ICECREAM_INFO I
ON F.FLAVOR = I.FLAVOR
WHERE F.TOTAL_ORDER > 3000
AND I.INGREDIENT_TYPE = 'fruit_based'
ORDER BY F.TOTAL_ORDER DESC;