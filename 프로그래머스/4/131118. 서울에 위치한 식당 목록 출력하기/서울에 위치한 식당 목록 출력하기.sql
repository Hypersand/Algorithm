-- 서울에 위치한 식당들의 정보 조회
-- 리뷰 평균점수는 소수점 셋째 자리에서 반올림
SELECT I.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS, 
    ROUND(AVG(R.REVIEW_SCORE), 2) SCORE
FROM REST_INFO I
JOIN REST_REVIEW R
ON I.REST_ID = R.REST_ID
WHERE I.ADDRESS LIKE '서울%'
GROUP BY I.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS
ORDER BY SCORE DESC, I.FAVORITES DESC;