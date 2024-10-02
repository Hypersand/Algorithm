-- 부서별 평균 연봉 조회
SELECT D.DEPT_ID, D.DEPT_NAME_EN, ROUND(AVG(E.SAL)) AVG_SAL
FROM HR_DEPARTMENT D
JOIN HR_EMPLOYEES E
ON D.DEPT_ID = E.DEPT_ID
GROUP BY D.DEPT_ID
ORDER BY AVG_SAL DESC;