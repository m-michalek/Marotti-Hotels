/*==============================================================*/
/* DBMS name:      ORACLE Version 12c                           */
/* Created on:     09.12.2016 16:34:54                          */
/*==============================================================*/


alter table BOOKING
   drop constraint FK_BOOKING_BOOKINGCU_CUSTOMER;

alter table ROOM
   drop constraint FK_ROOM_HOTELROOM_HOTEL;

alter table ROOM
   drop constraint FK_ROOM_ROOM_ROOM_ROOMCATE;

alter table ROOM_BOOKING
   drop constraint FK_ROOM_BOO_ROOM_BOOK_BOOKING;

alter table ROOM_BOOKING
   drop constraint FK_ROOM_BOO_ROOM_BOOK_ROOM;

drop index BOOKINGCUSTOMER_FK;

drop table BOOKING cascade constraints;

drop table CUSTOMER cascade constraints;

drop table HOTEL cascade constraints;

drop index ROOM_ROOMCATEGORY_FK;

drop index HOTELROOM_FK;

drop table ROOM cascade constraints;

drop table ROOMCATEGORY cascade constraints;

drop index ROOM_BOOKINGROOM_FK;

drop index ROOM_BOOKINGBOOKING_FK;

drop table ROOM_BOOKING cascade constraints;

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
   ROOM_ID              NUMBER(4)             not null,
   ROOM_CATEGORY_ID     NUMBER(3)             not null,
   HOTEL_ID             NUMBER(10)            not null,
   ROOM_NUMBER          NUMBER(3),
   constraint PK_ROOM primary key (ROOM_ID)
);

/*==============================================================*/
/* Index: HOTELROOM_FK                                          */
/*==============================================================*/
create index HOTELROOM_FK on ROOM (
   HOTEL_ID ASC
);

/*==============================================================*/
/* Index: ROOM_ROOMCATEGORY_FK                                  */
/*==============================================================*/
create index ROOM_ROOMCATEGORY_FK on ROOM (
   ROOM_CATEGORY_ID ASC
);

/*==============================================================*/
/* Table: ROOMCATEGORY                                          */
/*==============================================================*/
create table ROOMCATEGORY (
   ROOM_CATEGORY_ID     NUMBER(3)             not null,
   NUMBER_OF_BEDS       NUMBER(2),
   PRICE                NUMBER(4),
   ROOM_DESCRIPTION     VARCHAR2(300),
   ROOM_SIZE            NUMBER(3),
   constraint PK_ROOMCATEGORY primary key (ROOM_CATEGORY_ID)
);

/*==============================================================*/
/* Table: ROOM_BOOKING                                          */
/*==============================================================*/
create table ROOM_BOOKING (
   ID                   NUMBER(1000)          not null,
   BOOKING_ID           NUMBER(10)            not null,
   ROOM_ID              NUMBER(4)             not null,
   constraint PK_ROOM_BOOKING primary key (ID)
);

/*==============================================================*/
/* Index: ROOM_BOOKINGBOOKING_FK                                */
/*==============================================================*/
create index ROOM_BOOKINGBOOKING_FK on ROOM_BOOKING (
   BOOKING_ID ASC
);

/*==============================================================*/
/* Index: ROOM_BOOKINGROOM_FK                                   */
/*==============================================================*/
create index ROOM_BOOKINGROOM_FK on ROOM_BOOKING (
   ROOM_ID ASC
);

alter table BOOKING
   add constraint FK_BOOKING_BOOKINGCU_CUSTOMER foreign key (CUSTOMER_ID)
      references CUSTOMER (CUSTOMER_ID);

alter table ROOM
   add constraint FK_ROOM_HOTELROOM_HOTEL foreign key (HOTEL_ID)
      references HOTEL (HOTEL_ID);

alter table ROOM
   add constraint FK_ROOM_ROOM_ROOM_ROOMCATE foreign key (ROOM_CATEGORY_ID)
      references ROOMCATEGORY (ROOM_CATEGORY_ID);

alter table ROOM_BOOKING
   add constraint FK_ROOM_BOO_ROOM_BOOK_BOOKING foreign key (BOOKING_ID)
      references BOOKING (BOOKING_ID);

alter table ROOM_BOOKING
   add constraint FK_ROOM_BOO_ROOM_BOOK_ROOM foreign key (ROOM_ID)
      references ROOM (ROOM_ID);

