-- (2021년에 가입한 회원 중 상품을 구매한 회원 수/ 2021년에 가입한 전체 회원 수)
WITH USER_COUNT AS 
(
    SELECT COUNT(USER_ID) CNT
    FROM USER_INFO
    WHERE TO_CHAR(JOINED, 'YYYY') = '2021'
), USER_IDS AS
(
    SELECT USER_ID
    FROM USER_INFO
    WHERE TO_CHAR(JOINED, 'YYYY') = '2021'
)

SELECT 
  TO_CHAR(O.SALES_DATE, 'YYYY') YEAR, 
  TO_NUMBER(TO_CHAR(O.SALES_DATE, 'MM')) MONTH,
  COUNT(DISTINCT(U.USER_ID)) PURCHASED_USERS,
  ROUND(COUNT(DISTINCT(U.USER_ID)) / (
      SELECT COUNT(USER_ID) CNT
      FROM USER_INFO
      WHERE TO_CHAR(JOINED, 'YYYY') = '2021'
  ), 1) PURCHASED_RATIO
FROM ONLINE_SALE O
JOIN USER_IDS U
ON O.USER_ID = U.USER_ID
GROUP BY TO_CHAR(O.SALES_DATE, 'YYYY'), TO_CHAR(O.SALES_DATE, 'MM') 
ORDER BY YEAR, MONTH;