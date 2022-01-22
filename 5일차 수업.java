##MYSQL 복습
MYSQL > 데이터베이스 > table > 데이터
1. 데이터를 저장하는 프로그램을 배우는 것! => 데이터베이스
2. 데이터베이스에 쌓인 것을 직접 가져올 수 없으니까 SQL이라는 문법을 통해 데이터들을 가져오는 것임

##SQL 문법
SELECT
컬럼이름, 
컬럼이름
...n
from 
테이블 이름,
테이블 이름, => (어디서, 테이블이름)
where => (조건, 원하는 데이터만 필터링 하는 기능)
조건

##컬럼 명칭
MGR 사수이름
COMM 보너스
hiredate 고용날짜
SAL 월급
DEPTNO 부서번호

ex) 

select  (구하시오)
	JOB,
	HIREDATE
from emp (~파일에서)
where job(컬럼명) = 'clerk' (데이터명) (뭐를)

※오타주의! 에러나면 오타부터 먼저 보고 , 셀렉트 콤마 잘 확인하기

##관계연산자
=>, > , < , <= , =
!= (다르다)


문제1. 급여가 1000달러 이상인 
사람의 이름과 직업을
모두 조회(select)하시오
select 
	ename,
	job
from emp
where sal >= 1000 

문제2. 급여가 1000달러 이상인 
사람의 수를
모두 조회(select)하시오
select 
	count(*)
from emp
where sal >= 1000 

문제3. 월급이 1000달러 이상인 사람의 인원수를 구하시오(as 사용)
*as = 별칭. 컬럼명의 애칭을 정하는 것
select 
	count(*) as '총합'
from emp
where sal >= 1000 

문제4. 입사날짜 870123인 사람의 이름, 직업, 사원이름 (각각 as사용) 
select 
	ename as  "이름",
	job as "직업",
	DEPTNO as "사원 이름"
from emp
where hiredate <= '1982-01-23'

##논리연산자★★
and, or 
and : 조건 2개 이상일 때 두 개가 다 맞아야 true
or : " 조건이 1개만 맞아도 true




문제1. 입사날짜 810220부터 811203까지 입사한 사람중
select 
	ename as  "이름",
	job as "직업",
	DEPTNO as "부서 번호"
from emp
where hiredate >= '1981-02-20' 
and 
hiredate <= '1981-12-03'


##정렬 

문제1. 내림차순으로 구하시오 
select 
	ename,
	sal
from emp
order by SAL desc 

desc => 내림차순 
asc => 오름차순 (얘가 디폴트임. 따로 입력 불필요)

*정렬은 쿼리문 맨 뒤에 옴
★★★DB가 읽는 순서 : from -> where -> select -> order by 
but, order by 많이 쓰면 부하가 많이 일어남


##null = 데이터를 입력하지 않은 상태

문제1. comm이 null인 사람을 조회하시오
select 
DEPTNO,
job,
max(sal),
count(*),
min(sal)
from emp
where deptno != '10'
having count(*) <= '3'
order by count(*)

문제2. comm이 null이 아닌 사람을 조회하시오
select 
	ename,
	SAL,
	comm
from emp
where comm is not null
order by SAl

※null은 되도록 조회하지 말기(데이터 많은 경우엔)

## 이름 조회
*실무땐 관계연산자를 잘 안쓴다
문제1. 이름이 스미스인 사람의 직업을 구하시오
select 
JOB 
from emp
where ENAME like 'smith'
**like 단어의 특정 글자를 찾을 때 사용함

알쓸신잡 : like는 구글 검색할때 연관검색어에 적용됨


Q. 만약 이름이 allen이나 admas인 사람을 조회하고 싶다면? (동명이인)
문제1. JOB 
from emp
where ENAME = 'allen'
or ename = 'adams'

그러나, 중복된 코드는 좋지 않다.

문제2. 이름이 A로 시작하는 사람 조회
select 
ename,
JOB 
from emp
where ENAME like 'a%'

문제3. L이 두번 들어간 사람의 이름을 조회
select 
ename,
JOB 
from emp
where ENAME like '%l%l%'

##insert into : 어디 테이블에 저장할거야?
*순서대로 나열하기 ex) empno는 8000, ename은 양다은
위쪽 컬럼과 아래쪽 데이터가 잘 매치가 됐는지 확인해야함

문제1. 양다은 입사자를 컬럼에 맞게 명단에 추가하기
insert into emp
(empno, ename, job, mgr, HIREDATE, sal, comm, deptno)
values
(8000, '양다은', 'salesman', 7369, '2022-01-06', 5000, 1000, 20)

새로고침 f5 누르기 - 오른쪽 데이터에 내 명단 추가되었음

문제2. 길동이가 입사했는데 보너스가 없음(null) 얘를 명단에 추가시키기 
insert into emp
(empno,ename,job,mgr,HIREDATE,sal,deptno)
values
(8001, '홍길동', 'salesman', 7369, '2022-01-06', 5000, 20)

※ 명단에 추가했는데 쿼리문 한번 더 실행하면 오류남

##update => 말이 update지 사실 delete하고 update하는 것임
문제1. 명단 안 이름의 홍길동 -> 정우성으로 바꿔라 
update emp
set ename = '정우성'
where empno = 8001;

※★★★★★where절 꼭 써줘야 함. 안쓰면 모든 데이터가 다 하나로 바껴서 큰일남!!
(update지 사실 delete하고 update하는 것임)


문제2. 우성이가 직업하고 월급 변경요청 (두 개의 데이터를 바꾸는)
update emp
set 
job = 'manager',
sal = 8000
where empno = 8001;

##함수 연산하기
문제1. 
select 
sum(comm) as '보너스 총 합'
from emp

문제2. 
select 
avg(comm) as '보너스 총 평균'
from emp


문제3. 제일 높은 급여가 얼마인지
select 
max(sal)
from emp

문제4. 
select 
min(sal)
from emp

문제5. 직업이 manager 사람들의 급여 평균을 조회하시오.
select 
avg(sal) as'급여 평균'
from emp
where job = 'manager'

문제6. 입사날짜가 1987-06-28 이상인 사람들의 수와 급여 평균을 조회하시오.
select 
avg(sal) as'급여 평균',
count(*) as'인원수'
from emp
where HIREDATE >= '1987-06-28' 

문제7. 직업이 CLERK인 사원 중 최소급여를 받고있는 사원의 이름과 입사날짜를 조회하시오
select
ename as'이름',
HIREDATE as'입사날짜',
min(sal)
from emp
where job = 'clerk'  

문제8. -COMM이 NULL이 아니고, 
-직업이 SALESMAN 그리고 입사날짜가 1981-02-22 이후에 들어온 사원의 COMM 총합을 조회하시오
select 
sum(comm) as '총합'
from emp
where JOB = 'salesman' and 
hiredate >= '1981-02-22'
and comm is not null


##문자열 연산자
like 


## group by, 그루핑 :  중복된 데이터를 제거해서 하나씩 보여주기/ 
문제1. 
select
job
from emp 
group by job


문제2. 
select
job,
sum(sal) as '월급 총합'
from emp 
group by job



문제3. 
select
job,
sum(sal) as '월급 총합'
from emp 
group by job
having sum(sal) > 6000

#having : 그룹핑한 애들을 필터링 할때 (where와 좀 다름)

*where는 그룹핑된 쿼리문에는 사용할 수 없다.

문제4. 각 부서별 그룹화 하여 최고로 급여가 높은 사람의 이름과 직업을 나타내시오.
select
max(sal),
ename,
JOB 
from emp 
group by DEPTNO

문제5. 직업이 매니저이면서 그룹에서 가장 연봉을 많이 받는 사람의 이름, 직업, 금액을 쓰시오
select
max(sal),
ename,
JOB 
from emp 
where job = 'manager'
group by DEPTNO
having max(sal) >= 5000

★★★DB가 읽는 순서 (두번째 정리) : from -> where->  group by -> having -> select ※order by는 무조건 마지막
★★★★★입력 순서 틀리면 답 안나옴
그룹핑은 되는 애들끼리만 해줘야 데이터가 출력됨

last 문제6. 각 부서번호별 평균급여, 총 인원, 최고 급여, 최소 급여를 구하시오
select
DEPTNO, 
avg(SAL),
count(*),
max(sal),
min(sal)
from emp 
group by DEPTNO



##꽈배기 문제
문제1. 부서별 직책별 최대급여와 인원수, 최소급여를 추출
단, 10번 부서는 제외하고, 인원수는 3명 이하인 것으로 인원수가 적은 순서대로 추출 
select 
DEPTNO,
job,
max(sal),
count(*),
min(sal)
from emp
where deptno != 10
group by DEPTNO, job -> 부서별, 직책별 두개면 콤마로 이어주기
having count(*) <= 3
order by count(*);



문제2. 부서별로 급여 합계 (hint 한 사람의 부서는 한개다)
단, 10,30번 부서와 급여합계가 5000이상인 부서만 추출
select 
DEPTNO, 
sum(sal)
from emp 
where DEPTNO = 10 or
 DEPTNO = 30
group by DEPTNO 
having sum(sal) >= 5000;


문제3. 직책별로 급여합계와 평균급여를 추출 단, mananger는 제외하고 평균 sal가 1000이상인 것만 추출
--1) 직책별 
--2) 급여합계, 평균급여 조회
--3) job이 manager는 제외
--4) 평균 sal이 1000이상

select
job,
avg(sal),
sum(sal)
from emp
where job != 'manager'
group by job
having avg(sal) >= 1000;
