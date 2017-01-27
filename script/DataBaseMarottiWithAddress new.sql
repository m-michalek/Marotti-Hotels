/*==============================================================*/
/* DBMS name:      ORACLE Version 12c                           */
/* Created on:     27.01.2017 17:07:41                          */
/*==============================================================*/


alter table ANSWERS
   drop constraint FK_ANSWERS_QUESTIONS_QUESTION;

alter table BOOKING
   drop constraint FK_BOOKING_BOOKINGQU_QUESTION;

alter table BOOKING
   drop constraint FK_BOOKING_CUSTOMERB_CUSTOMER;

alter table CUSTOMER
   drop constraint FK_CUSTOMER_CORPORATE_CUSTOMER;

alter table CUSTOMER
   drop constraint FK_CUSTOMER_CUSTOMERT_TARIFF;

alter table CUSTOMER_ADDRESS
   drop constraint FK_CUSTOMER_CUSTOMER__CUSTOMER;

alter table QUESTIONNAIRE
   drop constraint FK_QUESTION_BOOKINGQU_BOOKING;

alter table ROOM
   drop constraint FK_ROOM_HOTELROOM_HOTEL;

alter table ROOM
   drop constraint FK_ROOM_RCATEGORY_ROOM_CAT;

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

drop index QUESTIONSANSWERS_FK;

drop table ANSWERS cascade constraints;

drop index BOOKINGQUESTIONNAIRE_FK;

drop index CUSTOMERBOOKING_FK;

drop table BOOKING cascade constraints;

drop index CORPORATECLIENT_FK;

drop index CUSTOMERTARIF_FK;

drop table CUSTOMER cascade constraints;

drop index CUSTOMER_ADDRESS_FK;

drop table CUSTOMER_ADDRESS cascade constraints;

drop table HOTEL cascade constraints;

drop index BOOKINGQUESTIONNAIRE2_FK;

drop table QUESTIONNAIRE cascade constraints;

drop index RENOVATIONROOM_FK;

drop index RCATEGORYROOM_FK;

drop index HOTELROOM_FK;

drop table ROOM cascade constraints;

drop index ROOMBOOKING2_FK;

drop index ROOMBOOKING_FK;

drop table ROOMBOOKING cascade constraints;

drop table ROOMRENOVATION cascade constraints;

drop table ROOM_CATEGORY cascade constraints;

drop index SWCATEGORYSW_FK;

drop index SPECIALWISHESBOOKING_FK;

drop table SPECIALWISHES cascade constraints;

drop table SPECIALWISHESCATEGORY cascade constraints;

drop table TARIFF cascade constraints;

/*==============================================================*/
/* Table: ANSWERS                                               */
/*==============================================================*/
create table ANSWERS (
   ANSWER_ID            NUMBER(10)           GENERATED AS IDENTITY not null,
   QUESTIONNAIRE_ID     NUMBER(2),
   ANSWER1              NUMBER(1),
   ANSWER2              NUMBER(1),
   ANSWER3              VARCHAR2(300),
   constraint PK_ANSWERS primary key (ANSWER_ID)
);

/*==============================================================*/
/* Index: QUESTIONSANSWERS_FK                                   */
/*==============================================================*/
create index QUESTIONSANSWERS_FK on ANSWERS (
   QUESTIONNAIRE_ID ASC
);

/*==============================================================*/
/* Table: BOOKING                                               */
/*==============================================================*/
create table BOOKING (
   BOOKING_ID           NUMBER(10)           GENERATED AS IDENTITY  not null,
   QUESTIONNAIRE_ID     NUMBER(2),
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
/* Index: BOOKINGQUESTIONNAIRE_FK                               */
/*==============================================================*/
create index BOOKINGQUESTIONNAIRE_FK on BOOKING (
   QUESTIONNAIRE_ID ASC
);

/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
create table CUSTOMER (
   CUSTOMER_ID          NUMBER(10)           GENERATED AS IDENTITY not null,
   TARIFF_ID            NUMBER(3),
   CUS_CUSTOMER_ID      NUMBER(10),
   CUSTOMER_FIRST_NAME  VARCHAR2(20),
   CUSTOMER_LAST_NAME   VARCHAR2(50),
   ACCOUNT_NUMBER       NUMBER(30),
   CUSTOMER_BIRTHDATE   DATE,
   BONUS_POINTS         NUMBER(10),
   PASSWORD             VARCHAR2(30),
   LOYALTY_PROGRAMME_MEMBER SMALLINT,
   FIRM_ID              NUMBER(10),
   constraint PK_CUSTOMER primary key (CUSTOMER_ID)
);

/*==============================================================*/
/* Index: CUSTOMERTARIF_FK                                      */
/*==============================================================*/
create index CUSTOMERTARIF_FK on CUSTOMER (
   TARIFF_ID ASC
);

/*==============================================================*/
/* Index: CORPORATECLIENT_FK                                    */
/*==============================================================*/
create index CORPORATECLIENT_FK on CUSTOMER (
   CUS_CUSTOMER_ID ASC
);

/*==============================================================*/
/* Table: CUSTOMER_ADDRESS                                      */
/*==============================================================*/
create table CUSTOMER_ADDRESS (
   CUSTOMER_ADDRESS_ID  NUMBER(10)          GENERATED AS IDENTITY  not null,
   CUSTOMER_ID          NUMBER(10)            not null,
   CUSTOMER_POSTAL_INDEX NUMBER(8),
   CUSTOMER_CITY        VARCHAR2(30),
   CUSTOMER_COUNTRY     VARCHAR2(20),
   CUSTOMER_STREET      VARCHAR2(50),
   CUSTOMER_HOUSE       VARCHAR2(4),
   constraint PK_CUSTOMER_ADDRESS primary key (CUSTOMER_ADDRESS_ID)
);

/*==============================================================*/
/* Index: CUSTOMER_ADDRESS_FK                                   */
/*==============================================================*/
create index CUSTOMER_ADDRESS_FK on CUSTOMER_ADDRESS (
   CUSTOMER_ID ASC
);

/*==============================================================*/
/* Table: HOTEL                                                 */
/*==============================================================*/
create table HOTEL (
   HOTEL_ID             NUMBER(10)         GENERATED AS IDENTITY   not null,
   HOTEL_NAME           VARCHAR2(40),
   HOTEL_DESCRIPTION    VARCHAR2(300),
   HOTEL_PLZ            NUMBER(5),
   HOTEL_STREET_HOUSENR VARCHAR2(60),
   constraint PK_HOTEL primary key (HOTEL_ID)
);

/*==============================================================*/
/* Table: QUESTIONNAIRE                                         */
/*==============================================================*/
create table QUESTIONNAIRE (
   QUESTIONNAIRE_ID     NUMBER(2)         GENERATED AS IDENTITY    not null,
   BOOKING_ID           NUMBER(10)            not null,
   QUESTION1            VARCHAR2(40),
   QUESTION2            VARCHAR2(40),
   QUESTION3            VARCHAR2(40),
   QUESTION4            VARCHAR2(40),
   constraint PK_QUESTIONNAIRE primary key (QUESTIONNAIRE_ID)
);

/*==============================================================*/
/* Index: BOOKINGQUESTIONNAIRE2_FK                              */
/*==============================================================*/
create index BOOKINGQUESTIONNAIRE2_FK on QUESTIONNAIRE (
   BOOKING_ID ASC
);

/*==============================================================*/
/* Table: ROOM                                                  */
/*==============================================================*/
create table ROOM (
   ROOM_ID              NUMBER(2)          GENERATED AS IDENTITY   not null,
   HOTEL_ID             NUMBER(10)            not null,
   ROOM_CATEGORY_ID     NUMBER(3)             not null,
   RENOVATION_ID        NUMBER(5),
   ROOM_NUMBER          NUMBER(5),
   ROOM_DESCRIPTION     VARCHAR2(300),
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
   ROOM_CATEGORY_ID ASC
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
   RENOVATION_ID        NUMBER(5)          GENERATED AS IDENTITY   not null,
   RENOVATION_BEGIN_DATE DATE,
   RENOVATION_END_DATE  DATE,
   constraint PK_ROOMRENOVATION primary key (RENOVATION_ID)
);

/*==============================================================*/
/* Table: ROOM_CATEGORY                                         */
/*==============================================================*/
create table ROOM_CATEGORY (
   ROOM_CATEGORY_ID     NUMBER(3)         GENERATED AS IDENTITY    not null,
   ROOM_CATEGORY_NAME   VARCHAR2(30),
   NUMBER_OF_BEDS       NUMBER(2),
   ROOM_PRICE           NUMBER(6),
   ROOM_CATEGORY_DESCRIPTION VARCHAR2(300),
   ROOM_SIZE            NUMBER(4),
   constraint PK_ROOM_CATEGORY primary key (ROOM_CATEGORY_ID)
);

/*==============================================================*/
/* Table: SPECIALWISHES                                         */
/*==============================================================*/
create table SPECIALWISHES (
   ORDER_ID             NUMBER(5)         GENERATED AS IDENTITY    not null,
   SPECIAL_WISH_ID      NUMBER(4)             not null,
   BOOKING_ID           NUMBER(10),
   SW_DATE              DATE,
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
   SPECIAL_WISH_ID ASC
);

/*==============================================================*/
/* Table: SPECIALWISHESCATEGORY                                 */
/*==============================================================*/
create table SPECIALWISHESCATEGORY (
   SPECIAL_WISH_ID      NUMBER(4)          GENERATED AS IDENTITY   not null,
   SPECIAL_WISH_DESCRIPTION VARCHAR2(100),
   SPECIAL_WISH_PRICE   NUMBER(6),
   constraint PK_SPECIALWISHESCATEGORY primary key (SPECIAL_WISH_ID)
);

/*==============================================================*/
/* Table: TARIFF                                                */
/*==============================================================*/
create table TARIFF (
   TARIFF_ID            NUMBER(3)        GENERATED AS IDENTITY     not null,
   TARIFF_DESCRIPTION   VARCHAR2(300),
   TARIFF_RATE          NUMBER(3),
   constraint PK_TARIFF primary key (TARIFF_ID)
);

alter table ANSWERS
   add constraint FK_ANSWERS_QUESTIONS_QUESTION foreign key (QUESTIONNAIRE_ID)
      references QUESTIONNAIRE (QUESTIONNAIRE_ID);

alter table BOOKING
   add constraint FK_BOOKING_BOOKINGQU_QUESTION foreign key (QUESTIONNAIRE_ID)
      references QUESTIONNAIRE (QUESTIONNAIRE_ID);

alter table BOOKING
   add constraint FK_BOOKING_CUSTOMERB_CUSTOMER foreign key (CUSTOMER_ID)
      references CUSTOMER (CUSTOMER_ID);

alter table CUSTOMER
   add constraint FK_CUSTOMER_CORPORATE_CUSTOMER foreign key (CUS_CUSTOMER_ID)
      references CUSTOMER (CUSTOMER_ID);

alter table CUSTOMER
   add constraint FK_CUSTOMER_CUSTOMERT_TARIFF foreign key (TARIFF_ID)
      references TARIFF (TARIFF_ID);

alter table CUSTOMER_ADDRESS
   add constraint FK_CUSTOMER_CUSTOMER__CUSTOMER foreign key (CUSTOMER_ID)
      references CUSTOMER (CUSTOMER_ID);

alter table QUESTIONNAIRE
   add constraint FK_QUESTION_BOOKINGQU_BOOKING foreign key (BOOKING_ID)
      references BOOKING (BOOKING_ID);

alter table ROOM
   add constraint FK_ROOM_HOTELROOM_HOTEL foreign key (HOTEL_ID)
      references HOTEL (HOTEL_ID);

alter table ROOM
   add constraint FK_ROOM_RCATEGORY_ROOM_CAT foreign key (ROOM_CATEGORY_ID)
      references ROOM_CATEGORY (ROOM_CATEGORY_ID);

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
   add constraint FK_SPECIALW_SWCATEGOR_SPECIALW foreign key (SPECIAL_WISH_ID)
      references SPECIALWISHESCATEGORY (SPECIAL_WISH_ID);

