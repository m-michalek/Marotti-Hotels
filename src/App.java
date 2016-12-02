import dao.BookingDao;
import dao.Customer;
import dao.CustomerDao;
import dao.DaoFactory;



public class App {

	public static void main(String[] args) {

		DaoFactory daoFactory = DaoFactory.getFactory(DaoFactory.ORACLE);
		CustomerDao cDao = daoFactory.createCustomerDao();
		BookingDao bDao = daoFactory.createBookingDao();


		System.out.println("Test 1: Data of the  Customer");

		Customer c1 = cDao.getCustomer(2);

		System.out.println("Customer first name " + c1.getCustomer_first_name());
		System.out.println("Customer last name " + c1.getCustomer_last_name());
		System.out.println("");
		System.out.println("--- --- --- ---");

	}
}