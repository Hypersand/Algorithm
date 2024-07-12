-- 입양을 간 동물 중 보호기간이 가장 길었던 동물 두 마리의 아이디와 이름 조회
-- 보호 기간 = 입양일 - 보호 시작일
SELECT * 
FROM (
    SELECT O.ANIMAL_ID, I.NAME
    FROM ANIMAL_OUTS O
    JOIN ANIMAL_INS I
    ON O.ANIMAL_ID = I.ANIMAL_ID
    ORDER BY (O.DATETIME - I.DATETIME) DESC
)
WHERE ROWNUM <= 2;

