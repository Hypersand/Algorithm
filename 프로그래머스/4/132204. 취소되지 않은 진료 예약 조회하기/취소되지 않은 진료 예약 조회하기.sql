-- PATIENT : 환자 정보
-- DOCTOR : 의사 정보
-- APPOINTMENT : 진료 예약목록
-- 2022년 4월 13일 취소되지 않은 CS 진료 예약 내역 조회
-- 조회 : 진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시
SELECT A.APNT_NO, P.PT_NAME, P.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD
FROM APPOINTMENT A
JOIN PATIENT P
ON A.PT_NO = P.PT_NO
JOIN DOCTOR D
ON A.MDDR_ID = D.DR_ID
WHERE TO_CHAR(A.APNT_YMD, 'YYYY-MM-DD') = '2022-04-13'
  AND A.APNT_CNCL_YN = 'N'
  AND A.MCDP_CD = 'CS'
ORDER BY A.APNT_YMD