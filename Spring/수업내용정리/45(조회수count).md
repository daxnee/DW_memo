### 220526

### 조회수 count 기능 만들기
-- 컬럼을 추가, 수정, 삭제하고 싶을때 사용
alter table board add column cnt integer(4) default 0;
=> 조회수 count를 위해 cnt 컬럼을 생성