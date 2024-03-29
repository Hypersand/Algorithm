# 더 이상 업그레이드 할 수 없는 아이템의 정보 출력
SELECT ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO
WHERE ITEM_ID NOT IN (SELECT DISTINCT(II.ITEM_ID)
FROM ITEM_INFO II INNER JOIN ITEM_TREE IT
ON II.ITEM_ID = IT.PARENT_ITEM_ID)
ORDER BY ITEM_ID DESC;
