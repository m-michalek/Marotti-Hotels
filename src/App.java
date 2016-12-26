import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import BookingDaoPackage.Booking;
import BookingDaoPackage.BookingDao;
import CustomerDaoPackage.Customer;
import CustomerDaoPackage.CustomerDao;
import dao.DaoFactory;

public class App {

	public static void main(String[] args) {

		DaoFactory daoFactory = DaoFactory.getFactory(DaoFactory.ORACLE);
		CustomerDao cDao = daoFactory.createCustomerDao();
		BookingDao bDao = daoFactory.createBookingDao();

		// customer tests
		//testGetCustomerData(cDao);

		testGetDataOfAllCustomers(cDao);

		//testAddCustomer(cDao);
		
		//testGetBookingData(bDao);

		//testGetDataOfAllBookings(bDao);

		//testAddNewBooking(bDao);
	}

	private static void testAddCustomer(CustomerDao cDao) {
		System.out.println("Test: add new customer");
		Customer c2 = new Customer();
		c2.setCustomer_id(5);
		c2.setCustomer_first_name("Frank");
		c2.setCustomer_last_name("Mueller");
		c2.setAccount_number(2345566);
		c2.setBirthdate("3.02.1998");
		
		if (cDao.addCustomer(c2) == true)
			System.out.println("New customer added");
		else 
			System.out.println("New customer cannot be added");
		System.out.println("--- --- --- ---");
	}

	private static void testAddNewBooking(BookingDao bDao) {

		System.out.println("Test 3.2: Add new booking");

		Booking b2 = new Booking();
		b2.setBooking_id(105);
		b2.setCheck_in_date("10.04.2016");
		b2.setCheck_out_date("14.04.2016");
		b2.setCustomer_id(2);
		b2.setBookingcode("se222b44");

		if (bDao.addBooking(b2) == true)
			System.out.println("New booking added");
		else
			System.out.println("New booking could not be saved");
		System.out.println("--- --- --- ---");
	}

	private static void testGetDataOfAllBookings(BookingDao bDao) {
		System.out.println("Test 2.2: Data of all bookings");
		List<Booking> bookingsList = bDao.getAllBookings();
		Iterator<Booking> iter1 = bookingsList.iterator();

		while (iter1.hasNext()) {
			Booking b = iter1.next();

			System.out.println("Booking id: " + b.getBooking_id());
			System.out.println("Check in date: " + b.getCheck_in_date());
			System.out.println("Check out date: " + b.getCheck_out_date());
			System.out.println("Customer id: " + b.getCustomer_id());
			System.out.println("Booking code: " + b.getBookingcode());
		}
		System.out.println("--- --- --- ---");
	}

	private static void testGetBookingData(BookingDao bDao) {
		System.out.println("Test 2.1: Get booking data");

		Booking b1 = bDao.getBooking(100);
		System.out.println("Booking details: " + b1.getBooking_id());
		System.out.println("Booking code: " + b1.getBookingcode());
		System.out.println("Check in date: " + b1.getCheck_in_date());
		System.out.println("Check out date: " + b1.getCheck_out_date());
		System.out.println("Customer id: " + b1.getCustomer_id());
		System.out.println();
		System.out.println("--- --- --- ---");
	}

	private static void testGetDataOfAllCustomers(CustomerDao cDao) {
		System.out.println("Test 1.2: Data of all customers");
		List<Customer> custList = cDao.getAllCustomers();
		Iterator<Customer> iter = custList.iterator();

		while (iter.hasNext()) {
			Customer c = iter.next();

			System.out.println("Customer first name: " + c.getCustomer_first_name());
			System.out.println("Customer last name: " + c.getCustomer_last_name());
			System.out.println("Account number: " + c.getAccount_number());
			System.out.println("Birthdate: " + c.getBirthdate());
			System.out.println("--- --- --- ---");
		}
		System.out.println("--- --- --- ---");
	}

	private static void testGetCustomerData(CustomerDao cDao) {
		System.out.println("Test 1.1: Customer data");
		Customer c1 = cDao.getCustomer(2);

		System.out.println("Customer first name: " + c1.getCustomer_first_name());
		System.out.println("Customer last name: " + c1.getCustomer_last_name());

		System.out.println("Account number: " + c1.getAccount_number());
		System.out.println(c1.getBirthdate());
		System.out.println();
		System.out.println("--- --- --- ---");
	}
}