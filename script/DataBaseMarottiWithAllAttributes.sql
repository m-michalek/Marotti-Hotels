/*==============================================================*/
/* DBMS name:      ORACLE Version 12c                           */
/* Created on:     18.12.2016 15:41:37                          */
/*==============================================================*/


alter table BOOKING
   drop constraint FK_BOOKING_CUSTOMERB_CUSTOMER;

alter table ROOM
   drop constraint FK_ROOM_HOTELROOM_HOTEL;

alter table ROOM
   drop constraint FK_ROOM_RCATEGORY_RCATEGOR;

alter table ROOMBOOKING
   drop constraint FK_ROOMBOOK_ROOMBOOKI_ROOM;

alter table ROOMBOOKING
   drop constraint FK_ROOMBOOK_ROOMBOOKI_BOOKING;

drop index CUSTOMERBOOKING_FK;

drop table BOOKING cascade constraints;

drop table CUSTOMER cascade constraints;

drop table HOTEL cascade constraints;

drop table RCATEGORY cascade constraints;

drop index RCATEGORYROOM_FK;

drop index HOTELROOM_FK;

drop table ROOM cascade constraints;

drop index ROOMBOOKING2_FK;

drop index ROOMBOOKING_FK;

drop table ROOMBOOKING cascade constraints;

/*==============================================================*/
/* Table: BOOKING                                               */
/*==============================================================*/
create table BOOKING (
   BOOKING_ID           NUMBER(10)            not null,
   CUSTOMER_ID          NUMBER(10)            not null,
   CHECK_IN_DATE        DATE,
   CHECK_OUT_DATE       DATE,
   BOOKING_CODE         VARCHAR2(10),
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
/* Table: RCATEGORY                                             */
/*==============================================================*/
create table RCATEGORY (
   RCATEGORY_ID         NUMBER(3)             not null,
   RCATEGORY_NAME       VARCHAR2(30),
   NUMBER_OF_BEDS       NUMBER(2),
   PRICE                NUMBER(6),
   ROOM_DESCRIPTION     VARCHAR2(300),
   ROOM_SIZE            NUMBER(4),
   constraint PK_RCATEGORY primary key (RCATEGORY_ID)
);

/*==============================================================*/
/* Table: ROOM                                                  */
/*==============================================================*/
create table ROOM (
   ROOM_ID              NUMBER(2)             not null,
   HOTEL_ID             NUMBER(10)            not null,
   RCATEGORY_ID         NUMBER(3)             not null,
   ROOM_NUMBER          NUMBER(5),
   constraint PK_ROOM primary key (ROOM_ID)
);

/*==============================================================*/
/* Index: HOTELROOM_FK                                          */
/*==============================================================*/
create index HOTELROOM_FK on ROOM (
   HOTEL_ID ASC
);

/*==============================================================*/
/* Index: RCATEGORYROOM_FK                                      */
/*==============================================================*/
create index RCATEGORYROOM_FK on ROOM (
   RCATEGORY_ID ASC
);

/*==============================================================*/
/* Table: ROOMBOOKING                                           */
/*==============================================================*/
create table ROOMBOOKING (
   ROOM_ID              NUMBER(2)             not null,
   BOOKING_ID           NUMBER(10)            not null,
   constraint PK_ROOMBOOKING primary key (ROOM_ID, BOOKING_ID)
);

/*==============================================================*/
/* Index: ROOMBOOKING_FK                                        */
/*==============================================================*/
create index ROOMBOOKING_FK on ROOMBOOKING (
   ROOM_ID ASC
);

/*==============================================================*/
/* Index: ROOMBOOKING2_FK                                       */
/*==============================================================*/
create index ROOMBOOKING2_FK on ROOMBOOKING (
   BOOKING_ID ASC
);

alter table BOOKING
   add constraint FK_BOOKING_CUSTOMERB_CUSTOMER foreign key (CUSTOMER_ID)
      references CUSTOMER (CUSTOMER_ID);

alter table ROOM
   add constraint FK_ROOM_HOTELROOM_HOTEL foreign key (HOTEL_ID)
      references HOTEL (HOTEL_ID);

alter table ROOM
   add constraint FK_ROOM_RCATEGORY_RCATEGOR foreign key (RCATEGORY_ID)
      references RCATEGORY (RCATEGORY_ID);

alter table ROOMBOOKING
   add constraint FK_ROOMBOOK_ROOMBOOKI_ROOM foreign key (ROOM_ID)
      references ROOM (ROOM_ID);

alter table ROOMBOOKING
   add constraint FK_ROOMBOOK_ROOMBOOKI_BOOKING foreign key (BOOKING_ID)
      references BOOKING (BOOKING_ID);

