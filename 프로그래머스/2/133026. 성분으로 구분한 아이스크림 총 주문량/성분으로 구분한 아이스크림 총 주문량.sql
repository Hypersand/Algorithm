-- 코드를 입력하세요
# 테이블 : 아이스크림 가게의 상반기 주문 정보 테이블, 아이스크림 성분에 대한 정보 테이블
# 상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총 주문량
SELECT I.INGREDIENT_TYPE, SUM(TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF FH INNER JOIN ICECREAM_INFO I
ON FH.FLAVOR = I.FLAVOR
GROUP BY I.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER;

