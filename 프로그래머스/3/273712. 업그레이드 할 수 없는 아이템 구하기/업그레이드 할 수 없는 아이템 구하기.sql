-- 아이템 정보 테이블, 아이템 관계 테이블
-- 각 아이템들은 오직 하나의 부모 아이템을 가진다.
-- 루트 아이템의 부모 아이템 아이디는 null
-- 더 이상 업그레이드할 수 없는 아이템의 아이템 정보 출력
WITH A AS (
    SELECT T1.ITEM_ID
    FROM ITEM_TREE T1
    JOIN ITEM_TREE T2
    ON T1.ITEM_ID = T2.PARENT_ITEM_ID
)

SELECT DISTINCT(I.ITEM_ID), I.ITEM_NAME, I.RARITY
FROM A
RIGHT JOIN ITEM_INFO I
ON A.ITEM_ID = I.ITEM_ID
WHERE A.ITEM_ID IS NULL
ORDER BY I.ITEM_ID DESC;


