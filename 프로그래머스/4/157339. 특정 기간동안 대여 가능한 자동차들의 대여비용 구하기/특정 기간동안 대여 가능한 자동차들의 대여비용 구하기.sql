-- CAR_RENTAL_COMPANY_CAR : 대여 중인 자동차들의 정보
-- CAR_RENTAL_COMPANY_RENTAL_HISTORY : 자동차 대여 기록 정보
-- CAR_RENTAL_COMPANY_DISCOUNT_PLAN : 자동차 종류 별 대여 기간 종류 별 할인 정책 정보
-- 자동차 종류가 '세단' 또는 'SUV'인 자동차 중 
-- 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고
-- 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대한 정보 출력
SELECT 
  CR.CAR_ID, 
  CR.CAR_TYPE,
  (CR.DAILY_FEE * 30 * (1 - (CRC.DISCOUNT_RATE / 100))) FEE
FROM CAR_RENTAL_COMPANY_CAR CR
JOIN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_CAR
    WHERE CAR_ID NOT IN (
      SELECT DISTINCT(CAR_ID)
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
      WHERE END_DATE >= TO_DATE('2022-11-01', 'YYYY-MM-DD')
        AND START_DATE <= TO_DATE('2022-11-30', 'YYYY-MM-DD')
      ) AND (CAR_TYPE = 'SUV' OR CAR_TYPE = '세단')
    ) CRH
ON CR.CAR_ID = CRH.CAR_ID
JOIN (
    SELECT CAR_TYPE, DISCOUNT_RATE
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE DURATION_TYPE LIKE '30%'
    ) CRC
ON CR.CAR_TYPE = CRC.CAR_TYPE
WHERE (CR.DAILY_FEE * 30 * (1 - (CRC.DISCOUNT_RATE / 100))) 
  BETWEEN 500000 AND 1999999
ORDER BY FEE DESC, CR.CAR_TYPE, CR.CAR_ID DESC;