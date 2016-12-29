-- instert scripts for 1.Hotel

insert into hotel (hotel_id, hotel_name, hotel_description) 
values (001, 'Marotti Berlin', 'Beautiful hotel just in the center of Berlin');

insert into hotel (hotel_id, hotel_name, hotel_description) 
values (021, 'Marotti M�nchen', 'Beautiful hotel in the center of M�nchen');

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

select * from room;

-- customer 

insert into customer (Customer_ID, customer_first_name, customer_last_name, account_number, birthdate)
  values(1, 'James', 'Bond', 123456789, '01-01-1970');
  
insert into customer (Customer_ID, customer_first_name, customer_last_name, account_number, birthdate)
  values(2, 'John', 'Doe', 987654321, '18-07-1990');
  
insert into customer (Customer_ID, customer_first_name, customer_last_name, account_number, birthdate)
  values(3, 'Jane', 'Doe', 347282923, '24-08-1995');
  
insert into customer (Customer_ID, customer_first_name, customer_last_name, account_number, birthdate)
  values(4, 'Jonny', 'Doe', 362718564, '09-02-2010');
  
select * from customer;

-- booking
insert into booking (booking_id, customer_id, check_in_date, check_out_date, booking_code)
  values(100, 1, '1.1.2016', '3.1.2016', 's3434dsd');
  
insert into booking (booking_id, customer_id, check_in_date, check_out_date, booking_code)
  values(101, 1, '21.5.2016', '26.5.2016', 's343se2sd');

select * from booking;

-- room booking
insert into roombooking (ROOM_ID, BOOKING_ID) values (001, 100);
insert into roombooking (ROOM_ID, BOOKING_ID) values (008, 101);

insert into roombooking (ROOM_ID, BOOKING_ID) values (007, 101);


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



