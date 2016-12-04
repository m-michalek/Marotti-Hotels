import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import dao.Booking;
import dao.BookingDao;
import dao.Customer;
import dao.CustomerDao;
import dao.DaoFactory;

public class App {

	public static void main(String[] args) {

		// just testing to check sourcetree from vm

		DaoFactory daoFactory = DaoFactory.getFactory(DaoFactory.ORACLE);
		CustomerDao cDao = daoFactory.createCustomerDao();
		BookingDao bDao = daoFactory.createBookingDao();

		// here is something wrong with other data of the customer
		System.out.println("Test 1.1: Customer data");

		Customer c1 = cDao.getCustomer(2);

		System.out.println("Customer first name: " + c1.getCustomer_first_name());
		System.out.println("Customer last name: " + c1.getCustomer_last_name());

		// problem here
		//System.out.println("Account number: " + c1.getAccount_number());
		//System.out.println(c1.getBirthdate());
		System.out.println();
		System.out.println("--- --- --- ---");


		// doesn't work, exception with Missing IN or OUT parameter at index:: 1
//		System.out.println("Test 1.2: Data of all customers");
//		List<Customer> custList = cDao.getAllCustomers();
//		Iterator<Customer> iter = custList.iterator();
//
//		while (iter.hasNext()) {
//			Customer c = iter.next();
//
//			System.out.println("Customer first name: " + c.getCustomer_first_name());
//			System.out.println("Customer last name: " + c.getCustomer_last_name());
//		}
//		System.out.println("--- --- --- ---");



		// here everything is good
//		System.out.println("Test 2.1: Get booking data");
//
//		Booking b1 = bDao.getBooking(100);
//		System.out.println("Booking details: " + b1.getBooking_id());
//		System.out.println("Booking code: " + b1.getBookingcode());
//		System.out.println("Check in date: " + b1.getCheck_in_date());
//		System.out.println("Check out date: " + b1.getCheck_out_date());
//		System.out.println("Customer id: " + b1.getCustomer_id());
//		System.out.println();
//		System.out.println("--- --- --- ---");


		// something wrong here
		// Missing IN or OUT parameter at index:: 1 in OraBookingDao at line 52
		// with ResultSet rs = pstmt.executeQuery();

//		System.out.println("Test 2.2: Data of all bookings");
//		List<Booking> bookingsList = bDao.getAllBookings();
//		Iterator<Booking> iter = bookingsList.iterator();
//
//		while (iter.hasNext()) {
//			Booking b = iter.next();
//
//			System.out.println("Booking id: " + b.getBooking_id());
//			System.out.println("Check in date: " + b.getCheck_in_date());
//			System.out.println("Check out date: " + b.getCheck_out_date());
//			System.out.println("Customer id: " + b.getCustomer_id());
//			System.out.println("Booking code: " + b.getBookingcode());
//		}
//		System.out.println("--- --- --- ---");



		// everything is good here
//		System.out.println("Test 3.2: Add new booking");
//
//		Booking b2 = new Booking();
//		b2.setBooking_id(104);
//		b2.setCheck_in_date("10.05.2016");
//		b2.setCheck_out_date("14.06.2016");
//		b2.setCustomer_id(2);
//		b2.setBookingcode("se2b44");
//
//		if (bDao.addBooking(b2) == true)
//			System.out.println("New booking added");
//		else
//			System.out.println("New booking could not be saved");
//		System.out.println("--- --- --- ---");
	}
}