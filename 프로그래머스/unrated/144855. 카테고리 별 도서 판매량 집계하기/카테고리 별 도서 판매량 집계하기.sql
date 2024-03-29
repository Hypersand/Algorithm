-- 코드를 입력하세요
SELECT B.CATEGORY, SUM(BS.SALES) AS TOTAL_SALES
FROM BOOK AS B, BOOK_SALES AS BS
WHERE BS.SALES_DATE LIKE '2022-01%' AND B.BOOK_ID = BS.BOOK_ID
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY