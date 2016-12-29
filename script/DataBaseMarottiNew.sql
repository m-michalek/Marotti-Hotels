/*==============================================================*/
/* DBMS name:      ORACLE Version 12c                           */
/* Created on:     29.12.2016 12:49:19                          */
/*==============================================================*/


alter table BOOKING
   drop constraint FK_BOOKING_CUSTOMERB_CUSTOMER;

alter table ROOM
   drop constraint FK_ROOM_HOTELROOM_HOTEL;

alter table ROOM
   drop constraint FK_ROOM_RCATEGORY_RCATEGOR;

alter table ROOM
   drop constraint FK_ROOM_RENOVATIO_ROOMRENO;

alter table ROOMBOOKING
   drop constraint FK_ROOMBOOK_ROOMBOOKI_ROOM;

alter table ROOMBOOKING
   drop constraint FK_ROOMBOOK_ROOMBOOKI_BOOKING;

alter table SPECIALWISHES
   drop constraint FK_SPECIALW_SPECIALWI_BOOKING;

alter table SPECIALWISHES
   drop constraint FK_SPECIALW_SWCATEGOR_SPECIALW;

drop index CUSTOMERBOOKING_FK;

drop table BOOKING cascade constraints;

drop table CUSTOMER cascade constraints;

drop table HOTEL cascade constraints;

drop table RCATEGORY cascade constraints;

drop index RENOVATIONROOM_FK;

drop index RCATEGORYROOM_FK;

drop index HOTELROOM_FK;

drop table ROOM cascade constraints;

drop index ROOMBOOKING2_FK;

drop index ROOMBOOKING_FK;

drop table ROOMBOOKING cascade constraints;

drop table ROOMRENOVATION cascade constraints;

drop index SWCATEGORYSW_FK;

drop index SPECIALWISHESBOOKING_FK;

drop table SPECIALWISHES cascade constraints;

drop table SPECIALWISHESCATEGORY cascade constraints;

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
   RENOVATION_ID        NUMBER(5),
   ROOM_NUMBER          NUMBER(5),
   ROOM_AVAILABLE       SMALLINT,
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
/* Index: RENOVATIONROOM_FK                                     */
/*==============================================================*/
create index RENOVATIONROOM_FK on ROOM (
   RENOVATION_ID ASC
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

/*==============================================================*/
/* Table: ROOMRENOVATION                                        */
/*==============================================================*/
create table ROOMRENOVATION (
   RENOVATION_ID        NUMBER(5)             not null,
   BEGIN_DATE           DATE,
   END_DATE             DATE,
   constraint PK_ROOMRENOVATION primary key (RENOVATION_ID)
);

/*==============================================================*/
/* Table: SPECIALWISHES                                         */
/*==============================================================*/
create table SPECIALWISHES (
   ORDER_ID             NUMBER(5)             not null,
   SPECIALWISH_ID       NUMBER(4)             not null,
   BOOKING_ID           NUMBER(10),
   constraint PK_SPECIALWISHES primary key (ORDER_ID)
);

/*==============================================================*/
/* Index: SPECIALWISHESBOOKING_FK                               */
/*==============================================================*/
create index SPECIALWISHESBOOKING_FK on SPECIALWISHES (
   BOOKING_ID ASC
);

/*==============================================================*/
/* Index: SWCATEGORYSW_FK                                       */
/*==============================================================*/
create index SWCATEGORYSW_FK on SPECIALWISHES (
   SPECIALWISH_ID ASC
);

/*==============================================================*/
/* Table: SPECIALWISHESCATEGORY                                 */
/*==============================================================*/
create table SPECIALWISHESCATEGORY (
   SPECIALWISH_ID       NUMBER(4)             not null,
   SPECIALWISHDESCRIPTION VARCHAR2(100),
   SPECIALWISHPRICE     NUMBER(6),
   constraint PK_SPECIALWISHESCATEGORY primary key (SPECIALWISH_ID)
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

alter table ROOM
   add constraint FK_ROOM_RENOVATIO_ROOMRENO foreign key (RENOVATION_ID)
      references ROOMRENOVATION (RENOVATION_ID);

alter table ROOMBOOKING
   add constraint FK_ROOMBOOK_ROOMBOOKI_ROOM foreign key (ROOM_ID)
      references ROOM (ROOM_ID);

alter table ROOMBOOKING
   add constraint FK_ROOMBOOK_ROOMBOOKI_BOOKING foreign key (BOOKING_ID)
      references BOOKING (BOOKING_ID);

alter table SPECIALWISHES
   add constraint FK_SPECIALW_SPECIALWI_BOOKING foreign key (BOOKING_ID)
      references BOOKING (BOOKING_ID);

alter table SPECIALWISHES
   add constraint FK_SPECIALW_SWCATEGOR_SPECIALW foreign key (SPECIALWISH_ID)
      references SPECIALWISHESCATEGORY (SPECIALWISH_ID);

