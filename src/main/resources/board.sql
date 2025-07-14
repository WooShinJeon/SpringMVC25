-- 시퀀스 객체 생성
create sequence seq_board;

-- 시퀀스 삭제
drop sequence seq_board;

create table tbl_board(
	bno number(10, 0),					-- 게시물 번호
	title varchar2(200) not null,		-- 게시물 제목
	content varchar2(2000) not null,	-- 내용
	writer varchar2(50) not null,		-- 작성자 (차후에 member와 연동)
	regidate date default sysdate,		-- 작성일 (자동으로 DB날짜가 입력)
	updatedate date default sysdate		-- 수정일 (자동으로 DB날짜가 입력)
); -- board 테이블 생성

alter table tbl_board add constraint pk_board primary key (bno);
-- tbl_board 구조 변경(수정) 기본키를 bno로 지정함.

-- 더미데이터 입력하기

insert into tbl_board (bno, title, content, writer)
values (seq_board.nextval, '테스트제목1', '테스트내용1', 'user01');
insert into tbl_board (bno, title, content, writer)
values (seq_board.nextval, '테스트제목2', '테스트내용2', 'user02');
insert into tbl_board (bno, title, content, writer)
values (seq_board.nextval, '테스트제목3', '테스트내용3', 'user03');
insert into tbl_board (bno, title, content, writer)
values (seq_board.nextval, '테스트제목4', '테스트내용4', 'user04');
insert into tbl_board (bno, title, content, writer)
values (seq_board.nextval, '테스트제목5', '테스트내용5', 'user05');
insert into tbl_board (bno, title, content, writer)
values (seq_board.nextval, '테스트제목6', '테스트내용6', 'user06');
insert into tbl_board (bno, title, content, writer)
values (seq_board.nextval, '테스트제목7', '테스트내용7', 'user07');
insert into tbl_board (bno, title, content, writer)
values (seq_board.nextval, '테스트제목8', '테스트내용8', 'user08');


select * from TBL_BOARD;