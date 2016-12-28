package FxMVC;

import java.util.List;

public class HotelModel {

	private String hotelNameModel;
	private String hotelDescrModel;

	public void displayHotelInfo(String hotelName) {

		System.out.println("here will be the searching performed");
		// hotelDescrModel = "Hotel in the center of Berlin";
		// hotelNameModel = "Marotti Berlin";

		// get the information from database
		HotelDto hotel = HotelDao.getHotelInfo(hotelName);
		this.hotelDescrModel = hotel.getHotel_description();
		this.hotelNameModel = hotel.getHotel_name();

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
}