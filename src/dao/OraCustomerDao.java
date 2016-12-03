package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OraCustomerDao implements CustomerDao {

	@Override
	public Customer getCustomer(int customer_id) {

		//String sql = "select customer_id, customer_first_name, customer_last_name, account_number, birthdate from customer where customer_id=?";
		
		String sql = "select customer_id, customer_first_name, customer_last_name"
				+ " from customer where customer_id=?";
		Customer c = new Customer();
		try {
			PreparedStatement pstmt = OracleDaoFactory.getConnection().prepareStatement(sql);

			pstmt.setInt(1, customer_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				c.setCustomer_id(rs.getInt("customer_id"));
				c.setCustomer_first_name(rs.getString("customer_first_name"));
				c.setCustomer_last_name(rs.getString("customer_last_name"));
				
				// problem with these two
				//java.sql.SQLException: Invalid column name
				c.setAccount_number(rs.getInt("account_number"));
				//c.setBirthdate(rs.getString(rs.getString("birthdate")));
			}

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public List<Customer> getAllCustomers() {
		String sql = "select customer_id, customer_first_name, customer_last_name, account_number, birthdate from customer where customer_id=?";
		List<Customer> cList = new ArrayList<Customer>();

		PreparedStatement pstmt;
		try {
			pstmt = OracleDaoFactory.getConnection().prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Customer c = new Customer();

				c.setCustomer_id(rs.getInt("customer_id"));
				c.setCustomer_first_name(rs.getString("customer_first_name"));
				c.setCustomer_last_name(rs.getString("customer_last_name"));
				c.setAccount_number(rs.getInt("account_number"));
				c.setBirthdate(rs.getString(rs.getString("birthdate")));
				cList.add(c);
			}

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cList;
	}

	@Override
	public boolean addCustomer(Customer c) {
		String sql = "insert into customer (customer_id, customer_first_name, "
				+ "customer_last_name, account_number, birthdate) values ( ?,?,?,?,?)";

		PreparedStatement pstmt;
		try {
			pstmt = OracleDaoFactory.getConnection().prepareStatement(sql);
			pstmt.setInt(1, c.getCustomer_id());
			pstmt.setString(2, c.getCustomer_first_name());
			pstmt.setString(3, c.getCustomer_last_name());
			pstmt.setInt(4, c.getAccount_number());
			pstmt.setString(5, c.getBirthdate());

			int r = pstmt.executeUpdate();
			pstmt.close();

			if (r == 1)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return false;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		String sql = "update customer set customer_id=? , customer_first_name=?"
				+ "customer_last_name=?, account_number=?, birthdate=? where customer_id=?";

		//String sql = "update customer set p_nr=? , name=? where p_nr=?";

		PreparedStatement pstmt;
		try {
			pstmt = OracleDaoFactory.getConnection().prepareStatement(sql);
			pstmt.setInt(1, c.getCustomer_id());
			pstmt.setString(2, c.getCustomer_first_name());
			pstmt.setString(3, c.getCustomer_last_name());
			pstmt.setInt(4, c.getAccount_number());
			pstmt.setString(5, c.getBirthdate());
			pstmt.setInt(6, c.getCustomer_id());

			int r = pstmt.executeUpdate();
			pstmt.close();

			if (r == 1)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}