/*==============================================================*/
/* DBMS name:      ORACLE Version 12c                           */
/* Created on:     02.12.2016 13:22:26                          */
/*==============================================================*/


alter table BOOKING
   drop constraint FK_BOOKING_CUSTOMERB_CUSTOMER;

drop index CUSTOMERBOOKING_FK;

drop table BOOKING cascade constraints;

drop table CUSTOMER cascade constraints;

/*==============================================================*/
/* Table: BOOKING                                               */
/*==============================================================*/
create table BOOKING (
   BOOKING_ID           NUMBER(10)            not null,
   CUSTOMER_ID          NUMBER(10)            not null,
   CHECK_IN_DATE        DATE,
   CHECK_OUT_DATE       DATE,
   BOOKINGCODE          VARCHAR2(10),
   constraint PK_BOOKING primary key (BOOKING_ID)
);

/*==============================================================*/
/* Index: CUSTOMERBOOKING_FK                                    */
/*==============================================================*/
create index CUSTOMERBOOKING_FK on BOOKING (
   CUSTOMER_ID ASC
);

/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
create table CUSTOMER (
   CUSTOMER_ID          NUMBER(10)            not null,
   CUSTOMER_FIRST_NAME  VARCHAR2(20),
   CUSTOMER_LAST_NAME   VARCHAR2(50),
   ACCOUNT_NUMBER       NUMBER(30),
   BIRTHDATE            DATE,
   constraint PK_CUSTOMER primary key (CUSTOMER_ID)
);

alter table BOOKING
   add constraint FK_BOOKING_CUSTOMERB_CUSTOMER foreign key (CUSTOMER_ID)
      references CUSTOMER (CUSTOMER_ID);

