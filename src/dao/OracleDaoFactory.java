package dao;

import java.sql.Connection;
import java.sql.SQLException;


import oracle.jdbc.pool.OracleDataSource;

public class OracleDaoFactory extends DaoFactory {
	private static OracleDataSource ds = null;

	public static Connection getConnection() {
		Connection conn = null;
		try {
			if (ds == null) {

				ds = new OracleDataSource();

				ds.setDataSourceName("HWROracleDataSource");
				ds.setURL("jdbc:oracle:thin:@//wi-dbora.hwr-berlin.de:1521/dbk.hwr-berlin.de");

				ds.setUser("marottihotels");
				ds.setPassword("xamarin");

			}

			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public CustomerDao createCustomerDao() {
		return new OraCustomerDao();
	}

	public BookingDao createBookingDao() {
		return new OraBookingDao();
	}
}