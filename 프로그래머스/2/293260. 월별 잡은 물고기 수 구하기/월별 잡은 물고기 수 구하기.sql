-- 월별 잡은 물고기의 수와 월을 출력
SELECT COUNT(ID) FISH_COUNT, MONTH(TIME) MONTH
FROM FISH_INFO
GROUP BY MONTH(TIME)
ORDER BY MONTH;