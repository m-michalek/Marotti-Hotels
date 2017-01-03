package FxMVC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDao {

	private static OracleDsSingleton ds = OracleDsSingleton.getInstance();
	//Holt Server- Logindaten
	
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
				hotel.setHotel_id(rset.getInt("hotel_id"));
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
					System.out.println("Connection closed error");
				}
			}
		}
		return hotel;
	}

	public static int checkRoomsAvailable(String hotel, String checkInString, String checkOutString,
			int rcategoryID) {

		int roomsinHotelInt = 0;
		int roomsBookedInt = 0;

		// first get the number of rooms in a hotel
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String selectStatement = "select count(r.room_id) "
				+ "from room r "
				+ "join hotel h "
				+ "on h.hotel_id=r.hotel_id "
				+ "join rcategory rc "
				+ "on rc.rcategory_id=r.rcategory_id "
				+ "where h.hotel_name=? "
				+ "and rc.rcategory_id=? ";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(selectStatement.toString());

			pstmt.setString(1, hotel);
			pstmt.setInt(2, rcategoryID);
			
			rset = pstmt.executeQuery();

			while (rset.next()) {

				roomsinHotelInt = rset.getInt("count(r.room_id)");
			}

			conn.close();

		} catch (SQLException esql) {
			esql.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Connection closed error");
				}
			}
		}

		// second get the number of rooms already booked
		Connection conn1 = null;
		PreparedStatement pstmt1 = null;
		ResultSet rset1 = null;

		String selectStatement1 = "select count(r.room_id) as roomsBooked from roombooking rb "
				+ "join booking b on rb.booking_id=b.booking_id join room r on r.room_id=rb.room_id "
				+ "join hotel h on h.hotel_id=r.hotel_id join rcategory rc on "
				+ "rc.rcategory_id=r.rcategory_id where h.hotel_name = ? and "
				+ "(b.check_in_date between ? and ?) and rc.rcategory_id=?";

		try {
			conn1 = ds.getConnection();
			pstmt1 = conn1.prepareStatement(selectStatement1.toString());

			pstmt1.setString(1, hotel);
			pstmt1.setString(2, checkInString);
			pstmt1.setString(3, checkOutString);
			pstmt1.setInt(4, rcategoryID);

			rset1 = pstmt1.executeQuery();

			while (rset1.next()) {

				roomsBookedInt = rset1.getInt("roomsBooked");
			}

			System.out.println("In hotel rooms: " + roomsinHotelInt + ", booked: " + roomsBookedInt);

			conn1.close();

		} catch (SQLException esql) {
			esql.printStackTrace();
		} finally {
			if (conn1 != null) {
				try {
					conn1.close();
				} catch (SQLException e) {
					System.out.println("Connection closed error");
				}
			}
		}
		return roomsinHotelInt - roomsBookedInt;
	}

	public static List<HotelDto> displayAllHotels() {

		List<HotelDto> list = new ArrayList<HotelDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String selectStatement = "select * from hotel";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(selectStatement.toString());
			rset = pstmt.executeQuery();

			while (rset.next()) {
				HotelDto hotel = new HotelDto();
				hotel.setHotel_description(rset.getString("hotel_description"));
				hotel.setHotel_name(rset.getString("hotel_name"));
				list.add(hotel);
			}

			conn.close();

		} catch (SQLException esql) {
			esql.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Connection closed error");
				}
			}
		}
		return list;
	}
}
