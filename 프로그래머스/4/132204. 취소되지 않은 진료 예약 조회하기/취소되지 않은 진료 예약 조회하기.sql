-- 2022년 4월 13일 취소되지 않은 흉부외과(CS) 진료 예약 내역 조회
SELECT A.APNT_NO, P.PT_NAME, P.PT_NO, D.MCDP_CD, D.DR_NAME, A.APNT_YMD
FROM PATIENT P
JOIN APPOINTMENT A
ON P.PT_NO = A.PT_NO
JOIN DOCTOR D
ON A.MDDR_ID = D.DR_ID
WHERE TO_CHAR(A.APNT_YMD, 'YYYY-MM-dd') = '2022-04-13' and 
    A.MCDP_CD = 'CS' and
    A.APNT_CNCL_YMD IS NULL
ORDER BY A.APNT_YMD;