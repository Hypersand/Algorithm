-- 코드를 입력하세요
SELECT UGU.USER_ID, UGU.NICKNAME, SUM(PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD UGB INNER JOIN USED_GOODS_USER UGU
ON UGB.WRITER_ID = UGU.USER_ID
WHERE UGB.STATUS = 'DONE'
GROUP BY WRITER_ID
HAVING TOTAL_SALES >= 700000
ORDER BY TOTAL_SALES;