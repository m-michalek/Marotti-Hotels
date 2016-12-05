package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OraBookingDao implements BookingDao {

	@Override
	public Booking getBooking(int booking_id) {

		String sql = "SELECT booking_id, customer_id, check_in_date,check_out_date, bookingcode "
				+ "FROM booking "
				+ "WHERE booking_id=?";
		Booking b = new Booking();
		try {
			PreparedStatement pstmt = OracleDaoFactory.getConnection().prepareStatement(sql);

			pstmt.setInt(1, booking_id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				b.setBooking_id(rs.getInt("booking_id"));
				b.setCustomer_id(rs.getInt("customer_id"));
				b.setCheck_in_date(rs.getString("check_in_date"));
				b.setCheck_out_date(rs.getString("check_out_date"));
				b.setBookingcode(rs.getString("bookingcode"));
			}

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	@Override
	public List<Booking> getAllBookings() {

		// java.sql.SQLException: Missing IN or OUT parameter at index:: 1
		// at dao.OraBookingDao.getAllBookings(OraBookingDao.java:57)
		
		String sql = "SELECT booking_id, customer_id, check_in_date, check_out_date, bookingcode "
				+ "FROM booking";

		List<Booking> bList = new ArrayList<Booking>();

		PreparedStatement pstmt;
		try {
			pstmt = OracleDaoFactory.getConnection().prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Booking b = new Booking();

				b.setBooking_id(rs.getInt("booking_id"));
				b.setCustomer_id(rs.getInt("customer_id"));
				b.setCheck_in_date(rs.getString("check_in_date"));
				b.setCheck_out_date(rs.getString("check_out_date"));
				b.setBookingcode(rs.getString("bookingcode"));

				bList.add(b);
			}

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bList;
	}

	@Override
	public boolean addBooking(Booking b) {
		String sql = "INSERT INTO booking ( booking_id, customer_id, check_in_date,"
					+ "check_out_date, bookingcode) VALUES ( ?,?,?,?,?)";

		PreparedStatement pstmt;
		try {
			pstmt = OracleDaoFactory.getConnection().prepareStatement(sql);
			pstmt.setInt(1, b.getBooking_id());
			pstmt.setInt(2, b.getCustomer_id());
			pstmt.setString(3, b.getCheck_in_date());
			pstmt.setString(4, b.getCheck_out_date());
			pstmt.setString(5, b.getBookingcode());

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
	public boolean updateBooking(Booking b) {
		String sql = "UPDATE booking "
				+ "SET booking_id=? , customer_id=?,check_in_date=?, check_out_date=?, bookingcode=? "
				+ "WHERE booking_id=?";

		PreparedStatement pstmt;
		try {
			pstmt = OracleDaoFactory.getConnection().prepareStatement(sql);

			pstmt.setInt(1, b.getBooking_id());
			pstmt.setInt(2, b.getCustomer_id());
			pstmt.setString(3, b.getCheck_in_date());
			pstmt.setString(4, b.getCheck_out_date());
			pstmt.setString(5, b.getBookingcode());
			pstmt.setInt(1, b.getBooking_id());

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