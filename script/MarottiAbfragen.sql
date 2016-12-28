

--  getting the receipt
select rb.booking_id,r.hotel_id, r.rcategory_id, r.room_id
from ROOMBOOKING rb
join room r
on rb.ROOM_ID=r.ROOM_ID;


-- which costumer is in the 1. hotel // 2. .....

select c.customer_id, c.customer_last_name, c.customer_first_name, hotel_id
from CUSTOMER c
join BOOKING b
on b.customer_id=c.customer_id
join roombooking rb
on b.booking_id=rb.booking_id
join room r
on r.room_id=rb.room_id
where hotel_id=1; -- or ID 21 

-- getting the right room category for a certain number of costumers in 1. hotel

select r.room_id, r.room_number,room_size, price, hotel_id
from rcategory rc
join room r
on rc.rcategory_id=r.rcategory_id
where number_of_beds=1 AND hotel_id=1; -- or 2 beds and ID 21


-- 

 

