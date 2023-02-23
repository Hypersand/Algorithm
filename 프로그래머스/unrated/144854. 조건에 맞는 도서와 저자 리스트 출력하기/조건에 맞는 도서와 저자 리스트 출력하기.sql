-- 코드를 입력하세요
SELECT BK.BOOK_ID,AR.AUTHOR_NAME,DATE_FORMAT(BK.PUBLISHED_DATE,'%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK AS BK, AUTHOR AS AR
WHERE BK.AUTHOR_ID = AR.AUTHOR_ID AND BK.CATEGORY = '경제'
ORDER BY PUBLISHED_DATE