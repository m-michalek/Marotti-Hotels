package dao;

public abstract class DaoFactory {

	public static final int ORACLE = 1;
	public static final int POSTGRE = 2;

	abstract public CustomerDao createCustomerDao();

	abstract public BookingDao createBookingDao();

	public static DaoFactory getFactory(int whichFactory) {

		switch (whichFactory) {

		case ORACLE:
			return new OracleDaoFactory();

		case POSTGRE:
			return null;

		default:
			return null;
		}
	}
}