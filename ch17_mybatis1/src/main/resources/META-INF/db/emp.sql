--dept.xml (id=deptList)
SELECT * FROM DEPT;
--emp.xml (id=empList)
SELECT * FROM EMP 
    WHERE ENAME LIKE '%' ||'A' ||'%'
    AND JOB LIKE '%' ||'A' ||'%'
    AND DEPTNO LIKE '%' ||'' ||'%';
