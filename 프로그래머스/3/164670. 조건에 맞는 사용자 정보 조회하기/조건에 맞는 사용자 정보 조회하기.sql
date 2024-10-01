-- 중고 거래 게시물을 3건 이상 등록한 사용자의 정보 조회
-- 전체 주소 : 시, 도로명 주소, 상세 주소 함께 출력
-- 전화번호 : 하이폰 문자열 삽입해서 출력
SELECT U.USER_ID, 
    U.NICKNAME, 
    (U.CITY || ' ' || U.STREET_ADDRESS1 || ' ' || U.STREET_ADDRESS2) "전체주소",
    substr(U.TLNO, 1, 3) || '-' || substr(U.TLNO, 4, 4) || '-' || substr(U.TLNO, 8, 4) "전화번호"
FROM USED_GOODS_BOARD B
JOIN USED_GOODS_USER U
ON B.WRITER_ID = U.USER_ID
GROUP BY U.USER_ID, U.NICKNAME, U.CITY, U.STREET_ADDRESS1, U.STREET_ADDRESS2, TLNO
HAVING COUNT(U.USER_ID) >= 3
ORDER BY U.USER_ID DESC;