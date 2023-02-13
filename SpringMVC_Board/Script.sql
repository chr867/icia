DROP TABLE MEMBER  CASCADE CONSTRAINTS;

--회원테이블;

CREATE TABLE "MEMBER"(
    "M_ID" VARCHAR2(20) ,	
    "M_PW" VARCHAR2(100) NOT NULL ENABLE, --비번 암호화
    "M_NAME" NVARCHAR2(5) NOT NULL ENABLE,
    "M_BIRTH" CHAR(8) NOT NULL ENABLE, --고정문자열이 속도가 빠름
    "M_ADDR" NVARCHAR2(50) NOT NULL ENABLE,
    "M_PHONE" VARCHAR2(13) NOT NULL ENABLE,
    "M_POINT" NUMBER(4,0) --9999까지
    );
   
--컬럼 재정의
  ALTER TABLE MEMBER
   MODIFY M_POINT DEFAULT 0;
--동의어는 DML에서만 사용
CREATE SYNONYM M FOR MEMBER;

ALTER TABLE MEMBER
DROP CONSTRAINT PK_M_ID CASCADE;

--PK 제약조건 추 가
ALTER TABLE MEMBER
ADD CONSTRAINT PK_M_ID PRIMARY KEY(M_ID);

SELECT * FROM M ;

INSERT INTO M(M_ID,M_PW,M_NAME,M_BIRTH,M_ADDR,M_PHONE,M_POINT)
VALUES ('CHOI','1111','최형로','19970313','인천 미추홀구','010-9137-1193','10')

INSERT INTO M(M_ID,M_PW,M_NAME,M_BIRTH,M_ADDR,M_PHONE,M_POINT)
VALUES ('guets','1111','손님','19971013','인천 남동구','010-1111-2222',DEFAULT)

SELECT * FROM M;
COMMIT;

UPDATE "MEMBER" SET M_POINT = 100 WHERE M_ID ='CHOI';

--회원등급 테이블
CREATE TABLE GRADE(
	G_CODE NCHAR(1) NOT NULL, --PK, 가,나 A,B
	G_NAME NVARCHAR2(10) NOT NULL --골드, 실버
);

--컬럼 추가
ALTER  TABLE GRADE ADD G_LOWPOINT NUMBER; 
ALTER  TABLE GRADE ADD G_HIPOINT NUMBER; 

DROP SYNONYM G;
CREATE SYNONYM G FOR GRADE;
--기본키 설정
ALTER TABLE GRADE ADD CONSTRAINT PK_G_CODE PRIMARY KEY(G_CODE);

--DUMMY DATA INSERT
INSERT INTO G VALUES('A','다이아몬드',31,999);
INSERT INTO G VALUES('B','골드',21,30);
INSERT INTO G VALUES('C','실버',11,20);
INSERT INTO G VALUES('D','브론즈',0,10);

SELECT * FROM G;

CREATE OR REPLACE VIEW MINFO
AS SELECT M.M_ID , M.M_NAME , M.M_POINT, G.G_NAME M_GRADE FROM M JOIN G 
ON M.M_POINT BETWEEN G.G_LOWPOINT AND G.G_HIPOINT ;

SELECT * FROM MINFO ;


--원글 게시판(1)
CREATE TABLE BOARD(
	B_NUM NUMBER NOT NULL,
	B_TITLE NVARCHAR2(50) NOT NULL,
	B_CONTENTS NCLOB NOT NULL, --문자 무한대 (CHARCTER LOT OF BLOCK)
	B_ID VARCHAR2(20) NOT NULL, --FK, 부모(M)테이블의 M_ID 참조
	B_DATE DATE DEFAULT SYSDATE,
	B_VIEWS NUMBER DEFAULT 0 NOT NULL,
	CONSTRAINT PK_B_NUM PRIMARY KEY(B_NUM),
	CONSTRAINT FK_B_ID FOREIGN KEY(B_ID) REFERENCES MEMBER (M_ID)
);

--글 번호 시퀀스 생성
CREATE SEQUENCE B_SEQ; --1부터 1씩 증가
CREATE SYNONYM B FOR BOARD;
SELECT B_SEQ.NEXTVAL FROM DUAL;
SELECT B_SEQ.CURRVAL FROM DUAL;
ALTER SEQUENCE B_SEQ INCREMENT BY 1; --NEXTVAL을 이용해 초기화 가능
--더미 데이터 추가
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글1','무궁화 꽃이 피었습니다.','CHOI',DEFAULT,DEFAULT);
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글2','무궁화 꽃이 피었습니다.','GUEST',DEFAULT,DEFAULT);
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글3','무궁화 꽃이 피었습니다.','CHOI',DEFAULT,DEFAULT);
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글4','무궁화 꽃이 피었습니다.','GUEST',DEFAULT,DEFAULT);
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글5','무궁화 꽃이 피었습니다.','CHOI',DEFAULT,DEFAULT);
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글6','무궁화 꽃이 피었습니다.','GUEST',DEFAULT,DEFAULT);
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글7','무궁화 꽃이 피었습니다.','CHOI',DEFAULT,DEFAULT);
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글8','무궁화 꽃이 피었습니다.','GUEST',DEFAULT,DEFAULT);
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글9','무궁화 꽃이 피었습니다.','CHOI',DEFAULT,DEFAULT);
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글10','무궁화 꽃이 피었습니다.','GUEST',DEFAULT,DEFAULT);
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글11','무궁화 꽃이 피었습니다.','CHOI',DEFAULT,DEFAULT);
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글12','무궁화 꽃이 피었습니다.','GUEST',DEFAULT,DEFAULT);
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글13','무궁화 꽃이 피었습니다.','CHOI',DEFAULT,DEFAULT);
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글14','무궁화 꽃이 피었습니다.','GUEST',DEFAULT,DEFAULT);
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글15','무궁화 꽃이 피었습니다.','CHOI',DEFAULT,DEFAULT);
INSERT INTO B VALUES (B_SEQ.NEXTVAL,'게시글16','무궁화 꽃이 피었습니다.','GUEST',DEFAULT,DEFAULT);

SELECT * FROM B;

--댓글 게시판(0~N)
CREATE TABLE REPLY(
	R_NUM NUMBER NOT NULL, --PK
	R_BNUM NUMBER NOT NULL, --FK 부모(B)테이블의 B_NUM 참조
	R_CONTENTES NVARCHAR2(200) NOT NULL,
	R_ID VARCHAR2(20) NOT NULL,--FK 부모(M)테이블의 M_ID 참조
	R_DATE DATE DEFAULT SYSDATE NOT NULL
);
--기본키
ALTER TABLE REPLY ADD CONSTRAINT PK_R_NUM PRIMARY KEY(R_NUM);
--외래키
ALTER TABLE REPLY 
ADD CONSTRAINT FK_R_BNUM FOREIGN KEY(R_BNUM) REFERENCES BOARD (B_NUM);
ALTER TABLE REPLY 
ADD CONSTRAINT FK_R_ID FOREIGN KEY(R_ID) REFERENCES MEMBER (M_ID);

--시퀀스 생성
CREATE SEQUENCE REPLY_SEQ;
CREATE SYNONYM R FOR REPLY;

--더미 데이터 추가
INSERT INTO R VALUES (REPLY_SEQ.NEXTVAL, 5,'댓글1','CHOI',DEFAULT);
INSERT INTO R VALUES (REPLY_SEQ.NEXTVAL, 5,'댓글2','GUEST',DEFAULT);
INSERT INTO R VALUES (REPLY_SEQ.NEXTVAL, 6,'댓글3','CHOI',DEFAULT);
INSERT INTO R VALUES (REPLY_SEQ.NEXTVAL, 6,'댓글4','GUEST',DEFAULT);

--최신순으로 원글 출력 VIEW 생성
CREATE OR REPLACE VIEW NEW_BLIST
AS
SELECT ROWNUM AS RN,
B.B_NUM,
B.B_TITLE,
B.B_ID,
B.B_DATE,
B.B_VIEWS
FROM (SELECT * FROM B ORDER BY B.B_NUM DESC) B;

--최신순으로 댓글 출력 VIEW 생성
CREATE OR REPLACE VIEW NEW_RLIST
AS
SELECT * FROM R
ORDER BY R_DATE DESC;

--자바
SELECT * FROM NEW_BLIST WHERE RN BETWEEN 11 AND 20; --2페이지만 불러오기
SELECT * FROM NEW_RLIST WHERE R_BNUM = 6; --게시글 번호가 6인 게시글의 댓글만

SELECT * FROM G;
SELECT * FROM M;
SELECT * FROM R;

COMMIT;


SELECT * FROM MEMBER WHERE m_id='CHOI' AND M_PW = 1111;
SELECT * FROM MEMBER;