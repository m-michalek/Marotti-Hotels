-- show the number of rooms in a hotel
select count(r.room_id)
from room r 
join hotel h
on h.hotel_id=r.hotel_id
join  rcategory rc
on rc.rcategory_id=r.rcategory_id
where h.hotel_id = 01 and  rc.rcategory_id=1;


select count(r.room_id) 
from room r 
join hotel h
on h.hotel_id=r.hotel_id 
join rcategory rc 
on rc.rcategory_id=r.rcategory_id
where h.hotel_name='Marotti Berlin' 
and rc.rcategory_id=1;
        

-- show the number of rooms booked depending on the dates the customer wants to check in and out and roomcategory
-- here: how many single rooms in Berlin hotel were booked in the timeframe between '14.03.16' and '03.06.16'

select count(r.room_id) as "rooms booked"
from roombooking rb
join booking b
on rb.booking_id=b.booking_id
join room r 
on r.room_id=rb.room_id
join hotel h
on h.hotel_id=r.hotel_id
join rcategory rc
on rc.rcategory_id=r.rcategory_id
where h.hotel_id = 01 and 
 (b.check_in_date between '14.03.16' and '03.06.16') and rc.rcategory_id=001;
 
 -- and then take the difference between the two to show the number of rooms available
