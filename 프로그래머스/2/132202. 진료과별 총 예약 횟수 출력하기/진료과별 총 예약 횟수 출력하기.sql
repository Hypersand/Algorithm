-- 2022년 5월에 예약한 환자 수를 진료과코드 별로 조회
-- 진료과별 예약한 환자 수 오름차순, 진료과 코드 오름차순
WITH PATIENTS AS (
    SELECT MCDP_CD, COUNT(DISTINCT(PT_NO)) AS PS
    FROM APPOINTMENT
    GROUP BY MCDP_CD
)

SELECT A.MCDP_CD "진료과코드", COUNT(A.APNT_NO) "5월예약건수"
FROM APPOINTMENT A
JOIN PATIENTS P
ON A.MCDP_CD = P.MCDP_CD
WHERE TO_CHAR(A.APNT_YMD, 'YYYYMM') = '202205'
GROUP BY A.MCDP_CD, P.PS
ORDER BY "5월예약건수", A.MCDP_CD;