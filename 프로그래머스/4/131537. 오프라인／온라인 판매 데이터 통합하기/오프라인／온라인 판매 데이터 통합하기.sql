-- 온라인 상품 판매 정보 테이블, 오프라인 상품 판매 정보 테이블
-- 2022년 3월의 오프라인/온라인 상품 판매 데이터 정보 출력
-- 오프라인 테이블의 판매 데이터의 user_id 는 Null로 표시
WITH A AS (
    SELECT TO_CHAR(SALES_DATE, 'YYYY-MM-dd') SALES_DATE, PRODUCT_ID, USER_ID, SUM(SALES_AMOUNT) SALES_AMOUNT
    FROM ONLINE_SALE
    WHERE TO_CHAR(SALES_DATE, 'YYYY-MM') = '2022-03'
    GROUP BY SALES_DATE, PRODUCT_ID, USER_ID
),

B AS (
    SELECT TO_CHAR(SALES_DATE, 'YYYY-MM-dd') SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SUM(SALES_AMOUNT) SALES_AMOUNT
    FROM OFFLINE_SALE
    WHERE TO_CHAR(SALES_DATE, 'YYYY-MM') = '2022-03'
    GROUP BY SALES_DATE, PRODUCT_ID
)

SELECT A.SALES_DATE SALES_DATE, A.PRODUCT_ID PRODUCT_ID, A.USER_ID USER_ID, A.SALES_AMOUNT
FROM A
UNION ALL
SELECT *
FROM B
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID;