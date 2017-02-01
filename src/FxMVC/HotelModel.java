package FxMVC;

import java.util.List;

public class HotelModel {

	private String hotelNameModel;
	private String hotelDescrModel;
	private int hotelIdModel;
	private int roomsAvailable;

	public void displayHotelInfo(String hotelName) {

		// hotelDescrModel = "Hotel in the center of Berlin";
		// hotelNameModel = "Marotti Berlin";

		HotelDto hotel = HotelDao.getHotelInfo(hotelName);

		hotelDescrModel = hotel.getHotel_description();
		hotelNameModel = hotel.getHotel_name();

	}

	public void checkAvailability(String hotel, String checkInString, String checkOutString,
			String roomCategoryString) {

		int roomsAvailableInHotel = HotelDao.checkRoomsAvailable(hotel, checkInString, checkOutString,
				roomCategoryString);
		this.roomsAvailable = roomsAvailableInHotel;

	}

	public List<HotelDto> dislayAllHotels() {

		List<HotelDto> hotelList = HotelDao.displayAllHotels();
		return hotelList;

	}

	public String getHotelNameModel() {
		return hotelNameModel;
	}

	public String getHotelDescrModel() {
		return hotelDescrModel;
	}

	public int getHotelIdModel() {
		return hotelIdModel;
	}

	public int getRoomsAvailableModel() {
		return roomsAvailable;
	}

}