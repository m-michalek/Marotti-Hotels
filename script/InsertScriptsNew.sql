-- instert scripts for 1.Hotel
 
insert into hotel (hotel_id, hotel_name, hotel_description)
values (001, 'Marotti Berlin', 'Beautiful hotel just in the center of Berlin');
 
insert into hotel (hotel_id, hotel_name, hotel_description)
values (021, 'Marotti M?nchen', 'Beautiful hotel in the center of M?nchen');
 
insert into hotel (hotel_id, hotel_name, hotel_description)
values (031, 'Marotti Köln', 'Beautiful hotel in the center of Köln');
 
update hotel
set hotel_name = 'Marotti Berlin'
where hotel_id = 001;
 
select * from hotel;
 
-- room categories
insert into rcategory (RCATEGORY_ID, RCATEGORY_NAME, NUMBER_OF_BEDS, PRICE, ROOM_DESCRIPTION,
ROOM_SIZE) values (001, 'Single room', 1, 50, 'Single room with beautiful view', 20);
 
insert into rcategory (RCATEGORY_ID, RCATEGORY_NAME, NUMBER_OF_BEDS, PRICE, ROOM_DESCRIPTION,
ROOM_SIZE) values (002, 'Double room', 2, 75, 'Double room with beautiful view', 30);
 
select * from rcategory;
 
-- rooms
insert into room (ROOM_ID, HOTEL_ID, RCATEGORY_ID, ROOM_NUMBER) values (001, 001, 001, 100);
 
insert into room (ROOM_ID, HOTEL_ID, RCATEGORY_ID, ROOM_NUMBER) values (002, 001, 001, 101);
 
insert into room (ROOM_ID, HOTEL_ID, RCATEGORY_ID, ROOM_NUMBER) values (003, 001, 001, 102);
 
insert into room (ROOM_ID, HOTEL_ID, RCATEGORY_ID, ROOM_NUMBER) values (004, 001, 002, 200);
 
insert into room (ROOM_ID, HOTEL_ID, RCATEGORY_ID, ROOM_NUMBER) values (005, 001, 002, 201);
 
insert into room (ROOM_ID, HOTEL_ID, RCATEGORY_ID, ROOM_NUMBER) values (006, 021, 001, 100);
 
insert into room (ROOM_ID, HOTEL_ID, RCATEGORY_ID, ROOM_NUMBER) values (007, 021, 001, 101);
 
insert into room (ROOM_ID, HOTEL_ID, RCATEGORY_ID, ROOM_NUMBER) values (008, 021, 002, 200);
 
insert into room (ROOM_ID, HOTEL_ID, RCATEGORY_ID, RENOVATION_ID, ROOM_NUMBER) values (009, 031, 002, 00001, 300);
 
select * from room;
 
--Max Query
 
select *
from ROOMRENOVATION
where (sysdate not between begin_date and end_date) and (sysdate <= end_date);
 
select *
from BOOKING
where (sysdate not between CHECK_IN_DATE and CHECK_OUT_DATE) and (sysdate <= CHECK_OUT_DATE);
 
select R.ROOM_NUMBER, RC.RCATEGORY_NAME, RC.ROOM_SIZE, B.CHECK_OUT_DATE
from BOOKING B
join roombooking RB
on B.BOOKING_ID=RB.BOOKING_ID
join room R
on r.ROOM_ID=RB.ROOM_ID
join rcategory RC
on RC.RCATEGORY_ID=R.RCATEGORY_ID
where sysdate LIKE B.CHECK_OUT_DATE;
--HOTEL MUSS NOCH HINTERLEGT WERDEN
 
select r.ROOM_NUMBER, swc.specialwishdescription
from ROOM r
NATURAL JOIN ROOMBOOKING rb
NATURAL JOIN BOOKING b
NATURAL JOIN SPECIALWISHES sw
NATURAL JOIN SPECIALWISHESCATEGORY swc;
--WHERE SPECIALWISHDATE LIKE SYSDATE DAS Auszuwählende Hotel muss noch integriert werden
 
-- RoomRenovation
insert into RoomRenovation (RENOVATION_ID, BEGIN_DATE, END_DATE) values (00001, '1-02-2017', '12-02-2017');
insert into RoomRenovation (RENOVATION_ID, BEGIN_DATE, END_DATE) values (00002, '1-01-2017', '12-02-2017');
insert into RoomRenovation (RENOVATION_ID, BEGIN_DATE, END_DATE) values (00003, '1-01-2016', '12-02-2016');
insert into RoomRenovation (RENOVATION_ID, BEGIN_DATE, END_DATE) values (00004, '4-01-2017', '4-01-2017');
 
select * from roomrenovation;
 
-- customer
 
insert into customer (Customer_ID, customer_first_name, customer_last_name, account_number, birthdate)
  values(1, 'James', 'Bond', 123456789, '01-01-1970');
 
insert into customer (Customer_ID, customer_first_name, customer_last_name, account_number, birthdate)
  values(2, 'John', 'Doe', 987654321, '18-07-1990');
 
insert into customer (Customer_ID, customer_first_name, customer_last_name, account_number, birthdate)
  values(3, 'Jane', 'Doe', 347282923, '24-08-1995');
 
insert into customer (Customer_ID, customer_first_name, customer_last_name, account_number, birthdate)
  values(4, 'Jonny', 'Doe', 362718564, '09-02-2010');
 
insert into customer (Customer_ID, customer_first_name, customer_last_name, account_number, birthdate)
  values(5, 'Max', 'Mustermann', 262838624, '09-05-1993');
 
select * from customer;
 
-- booking
insert into booking (booking_id, customer_id, check_in_date, check_out_date, booking_code)
  values(100, 1, '1.1.2016', '3.1.2016', 's3434dsd');
 
insert into booking (booking_id, customer_id, check_in_date, check_out_date, booking_code)
  values(101, 1, '21.5.2016', '26.5.2016', 's343se2sd');
 
insert into booking (booking_id, customer_id, check_in_date, check_out_date, booking_code)
  values(102, 5, '23.12.2016', '10.1.2017', 'fd23s42f1'); 
 
insert into booking (booking_id, customer_id, check_in_date, check_out_date, booking_code)
  values(103, 3, '1.1.2017', '6.1.2017', 'dd22d42s1');
 
insert into booking (booking_id, customer_id, check_in_date, check_out_date, booking_code)
  values(104, 3, '1.1.2017', '6.1.2017', 'd2sd4hrs1'); 
 
select * from booking;
 
-- room booking
insert into roombooking (ROOM_ID, BOOKING_ID) values (001, 100);
insert into roombooking (ROOM_ID, BOOKING_ID) values (008, 101);
insert into roombooking (ROOM_ID, BOOKING_ID) values (002, 104);
insert into roombooking (ROOM_ID, BOOKING_ID) values (007, 101);
insert into roombooking (ROOM_ID, BOOKING_ID) values (001, 102);
insert into roombooking (ROOM_ID, BOOKING_ID) values (003, 103);
 
-- special wishes category
insert into specialwishescategory (SPECIALWISH_ID, SPECIALWISHDESCRIPTION, SPECIALWISHPRICE)
values (001, 'Coffee', 5);
 
insert into specialwishescategory (SPECIALWISH_ID, SPECIALWISHDESCRIPTION, SPECIALWISHPRICE)
values (002, 'Extra bed', 15);
 
insert into specialwishescategory (SPECIALWISH_ID, SPECIALWISHDESCRIPTION, SPECIALWISHPRICE)
values (003, 'Special breakfast', 25);
 
-- special wishes
insert into specialwishes (ORDER_ID, SPECIALWISH_ID, BOOKING_ID)
values (001, 001, 100);
 
insert into specialwishes (ORDER_ID, SPECIALWISH_ID, BOOKING_ID)
values (002, 002, 100);
 
insert into specialwishes (ORDER_ID, SPECIALWISH_ID, BOOKING_ID)
values (003, 002, 101);
 
-- try to get info for the receipt
 
select rb.booking_id, r.room_id, r.hotel_id, r.RCATEGORY_ID
from roombooking rb
inner join room r
on rb.ROOM_ID = r.ROOM_ID;
 
-- receipt
 
select *
from customer c
join booking b
on c.customer_id=b.customer_id
join roombooking rb
on rb.booking_id=b.booking_id
join room r
on rb.room_id=r.room_id
join hotel h
on h.hotel_id=r.hotel_id
join rcategory rc
on rc.rcategory_id=r.rcategory_id
join specialwishes sw
on sw.booking_id=b.booking_id
join specialwishescategory swc
on swc.specialwish_id=sw.specialwish_id
where b.booking_id=100;
 
 
 
 
 
select c.customer_first_name, c.customer_last_name, b.booking_id,
b.check_in_date, b.check_out_date, b.booking_code, r.room_number, h.hotel_name,
rc.rcategory_name, rc.price, swc.specialwishdescription, swc.specialwishprice,
(b.check_out_date - b.check_in_date)*rc.price + swc.specialwishprice as total
from customer c
join booking b
on c.customer_id=b.customer_id
join roombooking rb
on rb.booking_id=b.booking_id
join room r
on rb.room_id=r.room_id
join hotel h
on h.hotel_id=r.hotel_id
join rcategory rc
on rc.rcategory_id=r.rcategory_id
join specialwishes sw
on sw.booking_id=b.booking_id
join specialwishescategory swc
on swc.specialwish_id=sw.specialwish_id
where b.booking_id=101;
 
 
 

select b.booking_id, sum(swc.specialwishprice) as total
from customer c
join booking b
on c.customer_id=b.customer_id
join specialwishes sw
on sw.booking_id=b.booking_id
join specialwishescategory swc
on swc.specialwish_id=sw.specialwish_id
where b.booking_id=100
group by b.booking_id;


-- LUCAS Inserts



-- Tariff
 
insert into tariff ( tariff_description, tariff_rate)
values( 'Seniorentarf',40);
 
insert into tariff ( tariff_description, tariff_rate)
values( 'Gruppentarif',50);
 

-- Customer
 

insert into customer (tariff_id, customer_first_name, customer_last_name,
account_number, customer_birthdate, bonus_points, password, loyalty_programme_member,
customer_country, customer_city, customer_post_index, customer_street)
values (null,'Peter','Schulz',1234, '20.01.1986', 2, 'asdf1234', '1,5', 'Germany', 'Brandenburg','16727','Eichelberge 56');
 
insert into customer (tariff_id, customer_first_name, customer_last_name,
account_number, customer_birthdate, bonus_points, password, loyalty_programme_member,
customer_country, customer_city, customer_post_index, customer_street)
values (1,'Kevin','Schach',2345, '20.01.1992', 20, 'qwer', '1,5', 'Germany', 'München','75689','Dammweg 5');
 
insert into customer (tariff_id, customer_first_name, customer_last_name,
account_number, customer_birthdate, bonus_points, password, loyalty_programme_member,
customer_country, customer_city, customer_post_index, customer_street)
values (null,'Justin','Mustermann',3456, '20.01.1996', 4, '3456', '1,5', 'Germany', 'Hamburg','45689','Kleptstraße 4a');
 
insert into customer (tariff_id, customer_first_name, customer_last_name,
account_number, customer_birthdate, bonus_points, password, loyalty_programme_member,
customer_country, customer_city, customer_post_index, customer_street)
values (2,'Klaus','Schulz',4567, '20.01.1986', 15, 'qwer1234', '1,5', 'Germany', 'Hamburg','16727','Rundstraße 90');
 
insert into customer (tariff_id, customer_first_name, customer_last_name,
account_number, customer_birthdate, bonus_points, password, loyalty_programme_member,
customer_country, customer_city, customer_post_index, customer_street)
values (2,'Angela','Wagner',8576, '20.01.1906', 3, 'qweij45', '1,3', 'Germany', 'Potsdam','85972','Hemptweg');
 
insert into customer (tariff_id, customer_first_name, customer_last_name,
account_number, customer_birthdate, bonus_points, password, loyalty_programme_member,
customer_country, customer_city, customer_post_index, customer_street)
values (1,'Petra','Richter',8244, '7.03.1985', 7, 'password', '1,5', 'Germany', 'Brandenburg','14689','Lutzastraße');
 
insert into customer (tariff_id, customer_first_name, customer_last_name,
account_number, customer_birthdate, bonus_points, password, loyalty_programme_member,
customer_country, customer_city, customer_post_index, customer_street)
values (null,'Hartmut','Bauer',4986, '5.12.1950',1 , 'oirtj2958', '1', 'Germany', 'NRW','55248','Ahornweg 3');
 
insert into customer (tariff_id, customer_first_name, customer_last_name,
account_number, customer_birthdate, bonus_points, password, loyalty_programme_member,
customer_country, customer_city, customer_post_index, customer_street)
values (null,'Lutz','Kaiser',2638, '1.01.1986', 2, 'pvorj', '4,5', 'Germany', 'Bremen','15684','Kumstraße');
 
insert into customer (tariff_id, customer_first_name, customer_last_name,
account_number, customer_birthdate, bonus_points, password, loyalty_programme_member,
customer_country, customer_city, customer_post_index, customer_street)
values (2, 'Rainer','Schmitz',4968, '10.02.1972', 8, 'ikzot984', '1,5', 'Germany', 'Brandenburg','25487','Thrustraße');
 
insert into customer (tariff_id, customer_first_name, customer_last_name,
account_number, customer_birthdate, bonus_points, password, loyalty_programme_member,
customer_country, customer_city, customer_post_index, customer_street)
values (null,'Laura','Schwarz',8522, '5.08.1994', 2, 'owiekrhq2', '6,5', 'Germany', 'Heidelberg','16976','Pollenweg');
 
insert into customer (tariff_id, customer_first_name, customer_last_name,
account_number, customer_birthdate, bonus_points, password, loyalty_programme_member,
customer_country, customer_city, customer_post_index, customer_street)
values (null,'Anika','Koch',5559, '8.04.1973', 2, 'wowuvos9', '3,5', 'Germany', 'Pforzheim','56487','Hartlerstraße');
 
insert into customer (tariff_id, customer_first_name, customer_last_name,
account_number, customer_birthdate, bonus_points, password, loyalty_programme_member,
customer_country, customer_city, customer_post_index, customer_street)
values (null,'Rüdiger','Wolf',7765, '25.06.2000', 2, 'owodf9', '4', 'Germany', 'Hessen','32658','Jutwegen');
 

-- booking
 

insert into booking (CUSTOMER_ID, check_in_date, check_out_date, booking_code)
values( 1, '20.01.2017', '25.03.2017', 'aftg897');
 
insert into booking (CUSTOMER_ID, check_in_date, check_out_date, booking_code)
values( 2, '1.11.2016', '20.12.2016', 'irut893');
 
insert into booking (CUSTOMER_ID, check_in_date, check_out_date, booking_code)
values( 3, '2.02.2017', '10.02.2017', 'owpe903');
 
insert into booking (CUSTOMER_ID, check_in_date, check_out_date, booking_code)
values( 4, '14.01.2017', '4.03.2017', 'jkfit83');
 
insert into booking (CUSTOMER_ID, check_in_date, check_out_date, booking_code)
values( 5, '28.04.2017', '5.05.2017', 'lopri48');
 
insert into booking (CUSTOMER_ID, check_in_date, check_out_date, booking_code)
values( 6, '15.01.2017', '15.02.2017', 'jugitk8');
 
insert into booking (CUSTOMER_ID, check_in_date, check_out_date, booking_code)
values( 7, '1.01.2017', '3.02.2017', 'khizo69');
 
insert into booking (CUSTOMER_ID, check_in_date, check_out_date, booking_code)
values( 8, '9.01.2017', '27.03.2017', 'jgitke3');
 
insert into booking (CUSTOMER_ID, check_in_date, check_out_date, booking_code)
values( 9, '21.01.2017', '12.02.2017', 'ajsudi3'); -- error "integrity constraint (%s.%s) violated - parent key not found"
 
insert into booking (CUSTOMER_ID, check_in_date, check_out_date, booking_code)
values( 10, '4.05.2017', '18.06.2017', 'qoepto9');
 
insert into booking (CUSTOMER_ID, check_in_date, check_out_date, booking_code)
values( 11, '24.12.2016', '28.12.2016', 'mhjgu82');
 
insert into booking (CUSTOMER_ID, check_in_date, check_out_date, booking_code)
values( 12, '20.06.2016', '5.11.2016', 'kgjrui4');
 
insert into booking (CUSTOMER_ID, check_in_date, check_out_date, booking_code)
values( 13, '18.02.2017', '25.03.2017', 'peotlz8');
 
 
 
-- FilledQuestionnaire
 
insert into filledquestionnaire (booking_id, questionid, answer)
values (3, 4, 'Wir konnten uns gut von unseren harten Tage in der Arbeit entspannen. Sauna und Pool fanden wir am besten!');
 
insert into filledquestionnaire (booking_id, questionid, answer)
values (10, 1, 'Die Ausstattung in den Zimmer ist super, aber die Sauberkeit ist manchmal nicht immer gewährleistet.');
 
insert into filledquestionnaire (booking_id, questionid, answer)
values (8, 5, 'Die Umgebung war super, deshalb würde ich hier gerne nochmal hin.');
 
insert into filledquestionnaire (booking_id, questionid, answer)
values (5, 3, 'Die Verkehrsanbindung ist super, man ist einfach immer mitten in der Stadt.');
 
insert into filledquestionnaire (booking_id, questionid, answer)
values (7, 2, 'The food was pretty good for what I have seen. I just love the german kitchen!');
 
-- Question
 
insert into question (questionde, questionen)
values('Wie gefällt Ihnen das Hotel?', 'How do you like the hotel?');
 
insert into question (questionde, questionen)
values('Wie fanden Sie die Auswahl und Qulität des Essens?', 'How do you like the selection and quality of the food?');
 
insert into question (questionde, questionen)
values('Wie gefällt Ihnen die Lage des Hotels?', 'How do you like the location of the hotel?');
 
insert into question (questionde, questionen)
values('Wie empfanden Sie die Möglichkeiten der Freizeitgestaltung und Entspannung?', 'How do you feel about the possibilities of leisure and relaxation?');
 
insert into question (questionde, questionen)
values('Würden Sie das Hotel ein zweites Mal buchen wollen?', 'Would you book the hotel again a second time?');
 
-- SpecialWishes
 
insert into specialwishes (special_wish_id, booking_id, sw_date)
values (4,3,'8.02.2017');
 
insert into specialwishes (special_wish_id, booking_id, sw_date)
values (2,1,'12.03.2017');
 
insert into specialwishes (special_wish_id, booking_id, sw_date)
values (5,8,'27.03.2017');
 
insert into specialwishes (special_wish_id, booking_id, sw_date)
values (3,10,'4.05.2017');
 
insert into specialwishes (special_wish_id, booking_id, sw_date)
values (1,9,'23.01.2017');
 

--SpecialWishesCategory
 
insert into specialwishescategory (SPECIAL_WISH_DESCRIPTION,SPECIAL_WISH_PRICE)
values ('Kaffee für bis zu drei Personen auf das Zimmer',7);
 
insert into specialwishescategory (SPECIAL_WISH_DESCRIPTION,SPECIAL_WISH_PRICE)
values ('Extra Kissen für zwei Betten',3);
 
insert into specialwishescategory (SPECIAL_WISH_DESCRIPTION,SPECIAL_WISH_PRICE)
values ('Extra Klappbett',50);
 
insert into specialwishescategory (SPECIAL_WISH_DESCRIPTION,SPECIAL_WISH_PRICE)
values ('Extra Kinderbett',20);
 
insert into specialwishescategory (SPECIAL_WISH_DESCRIPTION,SPECIAL_WISH_PRICE)
values ('Champagner für zwei Personen',40);
 
 






