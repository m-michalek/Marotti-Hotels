/*==============================================================*/
/* DBMS name:      ORACLE Version 12c                           */
/* Created on:     09.12.2016 15:09:45                          */
/*==============================================================*/


alter table BOOKING
   drop constraint FK_BOOKING_BOOKINGCU_CUSTOMER;

alter table ROOM
   drop constraint FK_ROOM_HOTELROOM_HOTEL;

alter table ROOM
   drop constraint FK_ROOM_ROOMBOOKI_BOOKING;

alter table ROOM
   drop constraint FK_ROOM_ROOM_CATE_ROOM_CAT;

drop index BOOKINGCUSTOMER_FK;

drop table BOOKING cascade constraints;

drop table CUSTOMER cascade constraints;

drop table HOTEL cascade constraints;

drop index ROOMBOOKING_FK;

drop index ROOM_CATEGORYROOM_FK;

drop index HOTELROOM_FK;

drop table ROOM cascade constraints;

drop table ROOM_CATEGORY cascade constraints;

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
/* Index: BOOKINGCUSTOMER_FK                                    */
/*==============================================================*/
create index BOOKINGCUSTOMER_FK on BOOKING (
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

/*==============================================================*/
/* Table: HOTEL                                                 */
/*==============================================================*/
create table HOTEL (
   HOTEL_ID             NUMBER(10)            not null,
   HOTEL_NAME           VARCHAR2(40),
   HOTEL_DESCRIPTION    VARCHAR2(300),
   constraint PK_HOTEL primary key (HOTEL_ID)
);

/*==============================================================*/
/* Table: ROOM                                                  */
/*==============================================================*/
create table ROOM (
   ROOM_CATEGORY_ID     CHAR(10)              not null,
   BOOKING_ID           NUMBER(10),
   HOTEL_ID             NUMBER(10)            not null,
   ROOM_ID              NUMBER(4)
);

/*==============================================================*/
/* Index: HOTELROOM_FK                                          */
/*==============================================================*/
create index HOTELROOM_FK on ROOM (
   HOTEL_ID ASC
);

/*==============================================================*/
/* Index: ROOM_CATEGORYROOM_FK                                  */
/*==============================================================*/
create index ROOM_CATEGORYROOM_FK on ROOM (
   ROOM_CATEGORY_ID ASC
);

/*==============================================================*/
/* Index: ROOMBOOKING_FK                                        */
/*==============================================================*/
create index ROOMBOOKING_FK on ROOM (
   BOOKING_ID ASC
);

/*==============================================================*/
/* Table: ROOM_CATEGORY                                         */
/*==============================================================*/
create table ROOM_CATEGORY (
   ROOM_CATEGORY_ID     CHAR(10)              not null,
   ROOM_SIZE            NUMBER(3),
   NUMBER_OF_BEDS       NUMBER(2),
   PRICE                NUMBER(4),
   _ROOM_DESCRIPTION    VARCHAR2(300),
   constraint PK_ROOM_CATEGORY primary key (ROOM_CATEGORY_ID)
);

alter table BOOKING
   add constraint FK_BOOKING_BOOKINGCU_CUSTOMER foreign key (CUSTOMER_ID)
      references CUSTOMER (CUSTOMER_ID);

alter table ROOM
   add constraint FK_ROOM_HOTELROOM_HOTEL foreign key (HOTEL_ID)
      references HOTEL (HOTEL_ID);

alter table ROOM
   add constraint FK_ROOM_ROOMBOOKI_BOOKING foreign key (BOOKING_ID)
      references BOOKING (BOOKING_ID);

alter table ROOM
   add constraint FK_ROOM_ROOM_CATE_ROOM_CAT foreign key (ROOM_CATEGORY_ID)
      references ROOM_CATEGORY (ROOM_CATEGORY_ID);

