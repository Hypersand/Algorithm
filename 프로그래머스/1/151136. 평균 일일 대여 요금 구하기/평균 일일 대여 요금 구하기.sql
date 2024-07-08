-- 자동차 종류가 SUV인 자동차들의 평균 일일 대여 요금 출력
-- 평균 일일 대여 요금은 소수 첫번째자리에서 반올림
SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV'
