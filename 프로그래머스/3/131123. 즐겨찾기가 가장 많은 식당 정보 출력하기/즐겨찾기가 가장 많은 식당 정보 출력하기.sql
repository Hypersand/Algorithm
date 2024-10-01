-- 음식종류별로 즐겨찾기수가 가장 많은 식당의 정보
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO
WHERE (FOOD_TYPE, FAVORITES) IN (
    SELECT R.FOOD_TYPE, MAX(R.FAVORITES)
    FROM REST_INFO R
    GROUP BY R.FOOD_TYPE
)
ORDER BY FOOD_TYPE DESC;