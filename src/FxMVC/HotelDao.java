package FxMVC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelDao {

	private static OracleDsSingleton ds = OracleDsSingleton.getInstance();

	public static HotelDto getHotelInfo(String hotelname) {
		HotelDto hotel = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String selectStatement = "select * from hotel where hotel_name=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(selectStatement.toString());
			hotel = new HotelDto();

			pstmt.setString(1, hotelname);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				hotel.setHotel_description(rset.getString("hotel_description"));
				hotel.setHotel_name(rset.getString("hotel_name"));
			}

			System.out.println("Done!");

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
		return hotel;
	}
}
