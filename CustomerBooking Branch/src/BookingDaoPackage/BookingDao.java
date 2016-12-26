package BookingDaoPackage;

import java.util.List;

public interface BookingDao {

	Booking getBooking(int booking_id);

	List<Booking> getAllBookings();

	boolean addBooking(Booking b);

	boolean updateBooking(Booking b);


}
