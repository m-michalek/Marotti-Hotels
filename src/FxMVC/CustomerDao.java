package FxMVC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao {

	private static OracleDsSingleton ds = OracleDsSingleton.getInstance();

	public static void addCustomer(String customer_first_name, String customer_last_name, String birthdate,
			String country, String city, String street, int index, int accountNumber) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String selectStatement = "insert into customer (customer_first_name, customer_last_name, account_number, "
				+ "customer_birthdate, customer_country, customer_city, customer_post_index, customer_street) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(selectStatement);
			pstmt.setString(1, customer_first_name);
			pstmt.setString(2, customer_last_name);
			pstmt.setInt(3, accountNumber);
			pstmt.setString(4, birthdate);
			pstmt.setString(5, country);
			pstmt.setString(6, city);
			pstmt.setInt(7, index);
			pstmt.setString(8, street);

			rset = pstmt.executeQuery();

			conn.close();

			System.out.println("new customer added!");

		} catch (SQLException esql) {
			esql.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Connection close error");
				}
			}
		}
	}

	public static void updateCustAddress(String customer_last_name, String street) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String selectStatement = "update customer set customer_street=? where customer_last_name=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(selectStatement);
			pstmt.setString(1, street);
			pstmt.setString(2, customer_last_name);

			rset = pstmt.executeQuery();

			conn.close();

			System.out.println("customer address updated!");

		} catch (SQLException esql) {
			esql.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Connection close error");
				}
			}
		}
	}

}
