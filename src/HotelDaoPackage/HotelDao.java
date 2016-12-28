package HotelDaoPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Singleton.OracleDsSingleton;

public class HotelDao {

	private static OracleDsSingleton ds = OracleDsSingleton.getInstance();

	public static HotelDto getAllHotels() {

		HotelDto hotel = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		StringBuffer selectHotel = new StringBuffer();

		selectHotel.append("select * from hotel");

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(selectHotel.toString());
			hotel = new HotelDto();

			rset = pstmt.executeQuery();

			while (rset.next()) {
				hotel.setHotelName(rset.getString("hotel_name"));
				hotel.setHotelDescription(rset.getString("hotel_description"));
			}
			conn.close();

		} catch (SQLException esql) {
			esql.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return hotel;
	}
}