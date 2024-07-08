-- 보호소에 들어올 당시에는 중성화 되지 않았지만,
-- 보호소를 나갈 당시에는 중성화된 동물 정보 조회
SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM ANIMAL_INS I
JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.SEX_UPON_INTAKE != O.SEX_UPON_OUTCOME
ORDER BY I.ANIMAL_ID;
