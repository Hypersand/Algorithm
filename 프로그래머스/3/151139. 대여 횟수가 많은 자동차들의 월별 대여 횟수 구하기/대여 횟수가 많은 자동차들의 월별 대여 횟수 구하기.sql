-- 코드를 입력하세요
# 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차들에 대해서
# 해당 기간 동안의 월별, 자동차 ID 별 총 대여 횟수 리스트 출력
# 특정 월의 총 대여 횟수가 0인 경우에는 결과에서 제외
SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(HISTORY_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (
    SELECT DISTINCT(CAR_ID)
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY CAR_ID
    HAVING COUNT(HISTORY_ID) >= 5
) AND (START_DATE BETWEEN '2022-08-01' AND '2022-10-31')
GROUP BY MONTH(START_DATE), CAR_ID
ORDER BY MONTH, CAR_ID DESC;
