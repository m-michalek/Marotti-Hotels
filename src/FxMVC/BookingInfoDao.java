package FxMVC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingInfoDao {

	private static OracleDsSingleton ds = OracleDsSingleton.getInstance();

	public static BookingInfoDto getBookingInfo(int booking_id) {

		BookingInfoDto bookinginfo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String selectStatement = "select c.customer_id, c.customer_first_name, c.customer_last_name as lastname,  "
				+ "b.booking_id as bookingid, b.check_in_date, b.check_out_date, rc.room_category_id as"
				+ " rcategory, r.room_number as roomnumber "
				+ "from customer c join booking b on c.customer_id=b.customer_id join roombooking rb "
				+ "on rb.booking_id=b.booking_id join room r on rb.room_id=r.room_id join hotel h "
				+ "on h.hotel_id=r.hotel_id join room_category rc on rc.room_category_id=r.room_category_id "
				+ "where b.booking_id=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(selectStatement.toString());
			bookinginfo = new BookingInfoDto();

			pstmt.setInt(1, booking_id);
			rset = pstmt.executeQuery();

			while (rset.next()) {

				try {
					bookinginfo.setRoom_id(rset.getInt("bookingid"));
					bookinginfo.setCustomer_name(rset.getString("lastname"));
					System.out.println("last name: ");
					System.out.println(rset.getString("lastname"));
					bookinginfo.setRoom_categorey(rset.getInt("rcategory"));
					bookinginfo.setRoom_number(rset.getInt("roomnumber"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			conn.close();

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
		return bookinginfo;
	}

}
