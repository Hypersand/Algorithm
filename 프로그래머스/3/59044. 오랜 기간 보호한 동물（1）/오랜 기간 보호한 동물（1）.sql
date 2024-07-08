-- 아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 정보 조회
-- 보호 시작일 순으로 조회
SELECT * 
FROM (
        SELECT I.NAME, I.DATETIME
        FROM ANIMAL_INS I
        LEFT OUTER JOIN ANIMAL_OUTS O
        ON I.ANIMAL_ID = O.ANIMAL_ID
        WHERE O.ANIMAL_ID IS NULL
        ORDER BY I.DATETIME
     )
WHERE ROWNUM <= 3;

