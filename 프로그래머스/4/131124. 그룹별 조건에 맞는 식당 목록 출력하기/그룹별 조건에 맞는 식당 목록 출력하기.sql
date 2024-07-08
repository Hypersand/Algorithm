-- MEMBER_PROFILE : 고객 정보
-- REST_REVIEW : 식당 리뷰 정보
-- 리뷰를 가장 많이 작성한 회원의 리뷰들
SELECT 
  M.MEMBER_NAME, 
  R.REVIEW_TEXT, 
  TO_CHAR(REVIEW_DATE, 'YYYY-MM-DD') REVIEW_DATE
FROM MEMBER_PROFILE M
JOIN REST_REVIEW R
ON M.MEMBER_ID = R.MEMBER_ID
WHERE M.MEMBER_ID IN (
    SELECT MEMBER_ID
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    HAVING COUNT(REVIEW_ID) = (
        SELECT MAX(COUNT(REVIEW_ID))
        FROM REST_REVIEW
        GROUP BY MEMBER_ID
    )
)
ORDER BY R.REVIEW_DATE, R.REVIEW_TEXT;
