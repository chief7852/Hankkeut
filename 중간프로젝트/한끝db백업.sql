--------------------------------------------------------
--  파일이 생성됨 - 월요일-2월-22-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BACKMUSIC
--------------------------------------------------------

  CREATE TABLE "ADMIN"."BACKMUSIC" 
   (	"BACKMUSIC_NO" VARCHAR2(20 BYTE), 
	"BACKMUSICNAME" VARCHAR2(20 BYTE), 
	"ROOM_NUM" VARCHAR2(20 BYTE), 
	"BACKMUSICFILE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BLACKLIST
--------------------------------------------------------

  CREATE TABLE "ADMIN"."BLACKLIST" 
   (	"BLACK_NUM" NUMBER, 
	"MEM_ID" VARCHAR2(20 BYTE), 
	"MANAGER_ID" VARCHAR2(20 BYTE), 
	"BLACK_DATE" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CHARACTERS
--------------------------------------------------------

  CREATE TABLE "ADMIN"."CHARACTERS" 
   (	"CHAR_NICKNAME" VARCHAR2(20 BYTE), 
	"MEM_ID" VARCHAR2(39 BYTE), 
	"CHAR_LEVEL" NUMBER, 
	"CHAR_EXP" NUMBER, 
	"CHAR_WIN" NUMBER, 
	"CHAR_LOSE" NUMBER DEFAULT 0, 
	"CHAR_ABOUT" VARCHAR2(60 BYTE), 
	"CHAR_POINT" NUMBER DEFAULT 0, 
	"CHAR_RANK" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"   NO INMEMORY ;
--------------------------------------------------------
--  DDL for Table COMMENTS
--------------------------------------------------------

  CREATE TABLE "ADMIN"."COMMENTS" 
   (	"MEM_ID" VARCHAR2(39 BYTE), 
	"CO_DATE" DATE DEFAULT sysdate, 
	"CO_CONTENTS" VARCHAR2(20 BYTE), 
	"BOARD_NO" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table EVENTBOARD
--------------------------------------------------------

  CREATE TABLE "ADMIN"."EVENTBOARD" 
   (	"E_BOARD_NUM" NUMBER, 
	"E_BOARD_TITLE" VARCHAR2(20 BYTE), 
	"E_BOARD_CONTENTS" VARCHAR2(20 BYTE), 
	"E_BOARD_DATE" VARCHAR2(20 BYTE), 
	"E_BOARD_IMG" VARCHAR2(20 BYTE), 
	"E_BOARD_VIEWS" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table FREEBOARD
--------------------------------------------------------

  CREATE TABLE "ADMIN"."FREEBOARD" 
   (	"F_BOARD_NO" NUMBER, 
	"F_BOARD_TITLE" VARCHAR2(60 BYTE), 
	"F_MEM_ID" VARCHAR2(39 BYTE), 
	"F_BOARD_DATE" DATE, 
	"F_BOARD_VIEWS" NUMBER DEFAULT 0, 
	"F_BOARD_CONTENTS" VARCHAR2(20 BYTE), 
	"F_BOARD_IMG" BLOB, 
	"CATEGORY" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" 
 LOB ("F_BOARD_IMG") STORE AS SECUREFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192
  NOCACHE LOGGING  NOCOMPRESS  KEEP_DUPLICATES ) ;
--------------------------------------------------------
--  DDL for Table FRIEND
--------------------------------------------------------

  CREATE TABLE "ADMIN"."FRIEND" 
   (	"MEM_ID" VARCHAR2(20 BYTE), 
	"FRIEND_ID" VARCHAR2(20 BYTE), 
	"FRIEND_NUM" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table FRIEND_TARGET
--------------------------------------------------------

  CREATE TABLE "ADMIN"."FRIEND_TARGET" 
   (	"MEM_ID" VARCHAR2(20 BYTE), 
	"TARGET_ID" VARCHAR2(20 BYTE), 
	"TARGET_DATE" DATE, 
	"TARGET_NUM" NUMBER, 
	"TARGET_ALLOW" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table INQUIRYBOARD
--------------------------------------------------------

  CREATE TABLE "ADMIN"."INQUIRYBOARD" 
   (	"I_BOARD_NUM" NUMBER, 
	"MEM_ID" VARCHAR2(20 BYTE), 
	"I_BOARD_DATE" DATE, 
	"I_BOARD_CONTENTS" VARCHAR2(20 BYTE), 
	"I_BOARD_IMG" VARCHAR2(20 BYTE), 
	"I_BOARD_TITLE" VARCHAR2(20 BYTE), 
	"I_BOARD_VIEWS" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table INVENTORY
--------------------------------------------------------

  CREATE TABLE "ADMIN"."INVENTORY" 
   (	"CHAR_NICKNAME" VARCHAR2(20 BYTE), 
	"IN_HEAD" BLOB, 
	"IN_CLOTH" BLOB, 
	"IN_BACK" BLOB, 
	"IN_COLOR" BLOB
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"   NO INMEMORY 
 LOB ("IN_HEAD") STORE AS SECUREFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192
  NOCACHE LOGGING  NOCOMPRESS  KEEP_DUPLICATES ) 
 LOB ("IN_CLOTH") STORE AS SECUREFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192
  NOCACHE LOGGING  NOCOMPRESS  KEEP_DUPLICATES ) 
 LOB ("IN_BACK") STORE AS SECUREFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192
  NOCACHE LOGGING  NOCOMPRESS  KEEP_DUPLICATES ) 
 LOB ("IN_COLOR") STORE AS SECUREFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192
  NOCACHE LOGGING  NOCOMPRESS  KEEP_DUPLICATES ) ;
--------------------------------------------------------
--  DDL for Table MANAGER
--------------------------------------------------------

  CREATE TABLE "ADMIN"."MANAGER" 
   (	"MANAGER_ID" VARCHAR2(20 BYTE), 
	"MANAGER_PASS" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "ADMIN"."MEMBER" 
   (	"MEM_ID" VARCHAR2(60 BYTE), 
	"MEM_PASS" VARCHAR2(120 BYTE), 
	"GENDER" VARCHAR2(12 BYTE), 
	"MEM_BIR" DATE, 
	"MEM_MAIL" VARCHAR2(120 BYTE), 
	"MEM_ADD1" VARCHAR2(180 BYTE), 
	"MEM_ADD2" VARCHAR2(180 BYTE), 
	"ZIP_CODE" VARCHAR2(20 BYTE), 
	"MEM_HP" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table NOTICEBOARD
--------------------------------------------------------

  CREATE TABLE "ADMIN"."NOTICEBOARD" 
   (	"N_BOARD_NUM" NUMBER, 
	"N_BOARD_TITLE" VARCHAR2(20 BYTE), 
	"N_BOARD_CONTENTS" VARCHAR2(20 BYTE), 
	"N_BOARD_DATE" VARCHAR2(20 BYTE), 
	"N_BOARD_VIEWS" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table RANKING
--------------------------------------------------------

  CREATE TABLE "ADMIN"."RANKING" 
   (	"RANK_NUM" NUMBER, 
	"MEM_ID" VARCHAR2(20 BYTE), 
	"NICKNAME" VARCHAR2(20 BYTE), 
	"EXP" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ROOM
--------------------------------------------------------

  CREATE TABLE "ADMIN"."ROOM" 
   (	"ROOM_NO" NUMBER, 
	"ROOM_PASS" VARCHAR2(20 BYTE), 
	"ROOM_ROUND" NUMBER, 
	"ROOM_THEME" VARCHAR2(20 BYTE), 
	"ROOM_NAME" VARCHAR2(20 BYTE), 
	"NICKNAME" VARCHAR2(20 BYTE), 
	"ALLOW_NO" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SHOP
--------------------------------------------------------

  CREATE TABLE "ADMIN"."SHOP" 
   (	"SHOP_CODE" VARCHAR2(20 BYTE), 
	"SHOP_IMG" BLOB, 
	"SHOP_NAME" VARCHAR2(20 BYTE), 
	"SHOP_POINT" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" 
 LOB ("SHOP_IMG") STORE AS SECUREFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192
  NOCACHE LOGGING  NOCOMPRESS  KEEP_DUPLICATES ) ;
--------------------------------------------------------
--  DDL for Table TOTAL
--------------------------------------------------------

  CREATE TABLE "ADMIN"."TOTAL" 
   (	"NICKNAME" VARCHAR2(20 BYTE), 
	"TOTAL_WIN" NUMBER, 
	"TOTAL_LOSE" NUMBER, 
	"TOTAL_RANK" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table WORD
--------------------------------------------------------

  CREATE TABLE "ADMIN"."WORD" 
   (	"WORD" VARCHAR2(60 BYTE), 
	"W_NO" NUMBER
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into ADMIN.BACKMUSIC
SET DEFINE OFF;
REM INSERTING into ADMIN.BLACKLIST
SET DEFINE OFF;
REM INSERTING into ADMIN.CHARACTERS
SET DEFINE OFF;
REM INSERTING into ADMIN.COMMENTS
SET DEFINE OFF;
REM INSERTING into ADMIN.EVENTBOARD
SET DEFINE OFF;
REM INSERTING into ADMIN.FREEBOARD
SET DEFINE OFF;
REM INSERTING into ADMIN.FRIEND
SET DEFINE OFF;
REM INSERTING into ADMIN.FRIEND_TARGET
SET DEFINE OFF;
REM INSERTING into ADMIN.INQUIRYBOARD
SET DEFINE OFF;
REM INSERTING into ADMIN.INVENTORY
SET DEFINE OFF;
REM INSERTING into ADMIN.MANAGER
SET DEFINE OFF;
REM INSERTING into ADMIN.MEMBER
SET DEFINE OFF;
Insert into ADMIN.MEMBER (MEM_ID,MEM_PASS,GENDER,MEM_BIR,MEM_MAIL,MEM_ADD1,MEM_ADD2,ZIP_CODE,MEM_HP) values ('asf123as','fsfasd','male',to_date('21/02/21','RR/MM/DD'),'assf@naver.com','대전 유성구 문화원로47번길','3',null,'01046867852');
Insert into ADMIN.MEMBER (MEM_ID,MEM_PASS,GENDER,MEM_BIR,MEM_MAIL,MEM_ADD1,MEM_ADD2,ZIP_CODE,MEM_HP) values ('asfasfsa','asfasf124124','male',to_date('21/02/20','RR/MM/DD'),'wnahd7852@naver.com','대전 유성구 문화원로47번길','3',null,'01046867852');
Insert into ADMIN.MEMBER (MEM_ID,MEM_PASS,GENDER,MEM_BIR,MEM_MAIL,MEM_ADD1,MEM_ADD2,ZIP_CODE,MEM_HP) values ('asfㅇㄴㄻㄴ','asdf','male',to_date('21/02/21','RR/MM/DD'),'wnahd7852@naver.com','대전 유성구 문화원로47번길','3',null,'01046867852');
Insert into ADMIN.MEMBER (MEM_ID,MEM_PASS,GENDER,MEM_BIR,MEM_MAIL,MEM_ADD1,MEM_ADD2,ZIP_CODE,MEM_HP) values ('asfas','asfas',null,to_date('21/02/20','RR/MM/DD'),'asfas','asfas','asfas','asfas','asfas');
Insert into ADMIN.MEMBER (MEM_ID,MEM_PASS,GENDER,MEM_BIR,MEM_MAIL,MEM_ADD1,MEM_ADD2,ZIP_CODE,MEM_HP) values ('asggsagasg','asfsf','male',to_date('21/02/21','RR/MM/DD'),'wnahd7852@naver.com','대전 유성구 문화원로47번길','3',null,'01046867852');
Insert into ADMIN.MEMBER (MEM_ID,MEM_PASS,GENDER,MEM_BIR,MEM_MAIL,MEM_ADD1,MEM_ADD2,ZIP_CODE,MEM_HP) values ('asfasfsaaaa','dsafs','male',to_date('21/02/21','RR/MM/DD'),'@naver.comasfgsf@dsfsaf.comnull','대전 유성구 문화원로47번길','3',null,'01046867852');
REM INSERTING into ADMIN.NOTICEBOARD
SET DEFINE OFF;
REM INSERTING into ADMIN.RANKING
SET DEFINE OFF;
REM INSERTING into ADMIN.ROOM
SET DEFINE OFF;
REM INSERTING into ADMIN.SHOP
SET DEFINE OFF;
REM INSERTING into ADMIN.TOTAL
SET DEFINE OFF;
REM INSERTING into ADMIN.WORD
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index BACKMUSIC_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."BACKMUSIC_PK" ON "ADMIN"."BACKMUSIC" ("BACKMUSIC_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index BLACKLIST_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."BLACKLIST_PK" ON "ADMIN"."BLACKLIST" ("BLACK_NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index CHARACTERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."CHARACTERS_PK" ON "ADMIN"."CHARACTERS" ("CHAR_NICKNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index EVENTBOARD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."EVENTBOARD_PK" ON "ADMIN"."EVENTBOARD" ("E_BOARD_NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index COMMUNITY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."COMMUNITY_PK" ON "ADMIN"."FREEBOARD" ("F_BOARD_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index FRIEND_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."FRIEND_PK" ON "ADMIN"."FRIEND" ("FRIEND_NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index FRIEND_TARGET_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."FRIEND_TARGET_PK" ON "ADMIN"."FRIEND_TARGET" ("TARGET_NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index INQUIRYBOARD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."INQUIRYBOARD_PK" ON "ADMIN"."INQUIRYBOARD" ("I_BOARD_NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MANAGER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."MANAGER_PK" ON "ADMIN"."MANAGER" ("MANAGER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index MEMBER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."MEMBER_PK" ON "ADMIN"."MEMBER" ("MEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index NOTICEBOARD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."NOTICEBOARD_PK" ON "ADMIN"."NOTICEBOARD" ("N_BOARD_NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index RANKING_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."RANKING_PK" ON "ADMIN"."RANKING" ("RANK_NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index ROOM_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."ROOM_PK" ON "ADMIN"."ROOM" ("ROOM_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SHOP_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."SHOP_PK" ON "ADMIN"."SHOP" ("SHOP_CODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index WORD_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."WORD_PK" ON "ADMIN"."WORD" ("W_NO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table BACKMUSIC
--------------------------------------------------------

  ALTER TABLE "ADMIN"."BACKMUSIC" ADD CONSTRAINT "BACKMUSIC_PK" PRIMARY KEY ("BACKMUSIC_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."BACKMUSIC" MODIFY ("BACKMUSIC_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BLACKLIST
--------------------------------------------------------

  ALTER TABLE "ADMIN"."BLACKLIST" ADD CONSTRAINT "BLACKLIST_PK" PRIMARY KEY ("BLACK_NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."BLACKLIST" MODIFY ("BLACK_NUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CHARACTERS
--------------------------------------------------------

  ALTER TABLE "ADMIN"."CHARACTERS" ADD CONSTRAINT "CHARACTERS_PK" PRIMARY KEY ("CHAR_NICKNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."CHARACTERS" MODIFY ("CHAR_NICKNAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EVENTBOARD
--------------------------------------------------------

  ALTER TABLE "ADMIN"."EVENTBOARD" ADD CONSTRAINT "EVENTBOARD_PK" PRIMARY KEY ("E_BOARD_NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."EVENTBOARD" MODIFY ("E_BOARD_NUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FREEBOARD
--------------------------------------------------------

  ALTER TABLE "ADMIN"."FREEBOARD" ADD CONSTRAINT "COMMUNITY_PK" PRIMARY KEY ("F_BOARD_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."FREEBOARD" MODIFY ("F_BOARD_NO" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."FREEBOARD" MODIFY ("F_BOARD_CONTENTS" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."FREEBOARD" MODIFY ("F_BOARD_DATE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."FREEBOARD" MODIFY ("F_MEM_ID" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."FREEBOARD" MODIFY ("F_BOARD_TITLE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FRIEND
--------------------------------------------------------

  ALTER TABLE "ADMIN"."FRIEND" ADD CONSTRAINT "FRIEND_PK" PRIMARY KEY ("FRIEND_NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."FRIEND" MODIFY ("FRIEND_NUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FRIEND_TARGET
--------------------------------------------------------

  ALTER TABLE "ADMIN"."FRIEND_TARGET" ADD CONSTRAINT "FRIEND_TARGET_PK" PRIMARY KEY ("TARGET_NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."FRIEND_TARGET" MODIFY ("TARGET_NUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table INQUIRYBOARD
--------------------------------------------------------

  ALTER TABLE "ADMIN"."INQUIRYBOARD" ADD CONSTRAINT "INQUIRYBOARD_PK" PRIMARY KEY ("I_BOARD_NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."INQUIRYBOARD" MODIFY ("I_BOARD_NUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MANAGER
--------------------------------------------------------

  ALTER TABLE "ADMIN"."MANAGER" ADD CONSTRAINT "MANAGER_PK" PRIMARY KEY ("MANAGER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."MANAGER" MODIFY ("MANAGER_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "ADMIN"."MEMBER" ADD CONSTRAINT "MEMBER_PK" PRIMARY KEY ("MEM_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."MEMBER" MODIFY ("MEM_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table NOTICEBOARD
--------------------------------------------------------

  ALTER TABLE "ADMIN"."NOTICEBOARD" ADD CONSTRAINT "NOTICEBOARD_PK" PRIMARY KEY ("N_BOARD_NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."NOTICEBOARD" MODIFY ("N_BOARD_NUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RANKING
--------------------------------------------------------

  ALTER TABLE "ADMIN"."RANKING" ADD CONSTRAINT "RANKING_PK" PRIMARY KEY ("RANK_NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."RANKING" MODIFY ("RANK_NUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ROOM
--------------------------------------------------------

  ALTER TABLE "ADMIN"."ROOM" ADD CONSTRAINT "ROOM_PK" PRIMARY KEY ("ROOM_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."ROOM" MODIFY ("ROOM_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SHOP
--------------------------------------------------------

  ALTER TABLE "ADMIN"."SHOP" ADD CONSTRAINT "SHOP_PK" PRIMARY KEY ("SHOP_CODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."SHOP" MODIFY ("SHOP_CODE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TOTAL
--------------------------------------------------------

  ALTER TABLE "ADMIN"."TOTAL" MODIFY ("TOTAL_RANK" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WORD
--------------------------------------------------------

  ALTER TABLE "ADMIN"."WORD" MODIFY ("WORD" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."WORD" ADD CONSTRAINT "WORD_PK" PRIMARY KEY ("W_NO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."WORD" MODIFY ("W_NO" NOT NULL ENABLE);
