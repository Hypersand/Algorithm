SELECT 
    UGB.TITLE TITLE, 
    UGB.BOARD_ID BOARD_ID, 
    UGR.REPLY_ID REPLY_ID, 
    UGR.WRITER_ID WRITER_ID,
    UGR.CONTENTS CONTENTS,
    TO_CHAR(UGR.CREATED_DATE, 'YYYY-MM-DD') CREATED_DATE
FROM USED_GOODS_BOARD UGB
JOIN USED_GOODS_REPLY UGR
ON UGB.BOARD_ID = UGR.BOARD_ID
WHERE TO_CHAR(UGB.CREATED_DATE, 'YYYY-MM') = '2022-10'
ORDER BY UGR.CREATED_DATE, UGB.TITLE;
