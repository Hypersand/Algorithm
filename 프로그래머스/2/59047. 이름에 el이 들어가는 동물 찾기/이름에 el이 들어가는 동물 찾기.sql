-- 할머니가 기르던 개는 이름에 el이 들어간다
-- 이름에 el 이 들어가는 개의 아이디와 이름 조회
-- 대소문자 구분 x
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE UPPER(NAME) LIKE '%EL%' AND ANIMAL_TYPE = 'Dog'
ORDER BY NAME;