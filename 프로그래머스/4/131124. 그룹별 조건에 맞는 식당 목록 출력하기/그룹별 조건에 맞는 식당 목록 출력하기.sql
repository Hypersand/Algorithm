-- 고객정보 테이블, 식당 리뷰 정보 테이블
-- 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회
WITH A AS (SELECT * 
            FROM (
                SELECT M.MEMBER_ID, M.MEMBER_NAME
                FROM MEMBER_PROFILE M
                JOIN REST_REVIEW R
                ON M.MEMBER_ID = R.MEMBER_ID
                GROUP BY M.MEMBER_ID, M.MEMBER_NAME
                ORDER BY COUNT(R.REVIEW_ID) DESC
            )
            WHERE ROWNUM <= 1
)

SELECT A.MEMBER_NAME, R.REVIEW_TEXT, TO_CHAR(R.REVIEW_DATE, 'YYYY-MM-dd') REVIEW_DATE
FROM A
JOIN REST_REVIEW R
ON A.MEMBER_ID = R.MEMBER_ID
ORDER BY R.REVIEW_DATE, R.REVIEW_TEXT;