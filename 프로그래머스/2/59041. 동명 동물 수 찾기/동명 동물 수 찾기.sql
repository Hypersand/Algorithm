-- 동물 보호소에 들어온 동물 이름 중 두번 이상 쓰인 이름과
-- 해당 이름이 쓰인 횟수 조회
SELECT NAME, COUNT(*) COUNT
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY NAME
HAVING COUNT(*) >= 2
ORDER BY NAME;