-- 2022년 1월의 도서 판매 데이터를 기준으로 저자 별, 카테고리 별 매출액 구하기
SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(S.SALES * B.PRICE) TOTAL_SALES
FROM BOOK B
JOIN AUTHOR A
ON B.AUTHOR_ID = A.AUTHOR_ID
JOIN BOOK_SALES S
ON B.BOOK_ID = S.BOOK_ID
WHERE TO_CHAR(S.SALES_DATE, 'YYYY-MM') = '2022-01'
GROUP BY A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY
ORDER BY A.AUTHOR_ID, B.CATEGORY DESC;