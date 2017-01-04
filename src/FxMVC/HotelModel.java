package FxMVC;

import java.util.List;

public class HotelModel {

	private String hotelNameModel;
	private String hotelDescrModel;
	private int hotelIdModel;
	private int roomsAvailable;
	private int priceModel;
	private RoomCategoryAndPrice roomCatPrice;

	public List<HotelDto> displayHotelInfoNew(String hotelName) {

		// hotelDescrModel = "Hotel in the center of Berlin";
		// hotelNameModel = "Marotti Berlin";

		// get the information from database
		// HotelDto hotel = HotelDao.getHotelInfo(hotelName);
		// this.hotelDescrModel = hotel.getHotel_description();
		// this.hotelNameModel = hotel.getHotel_name();
		// this.hotelIdModel = hotel.getHotel_id();
		// this.priceModel = hotel.getPrice();
		// this.roomCatPrice = hotel.getRoomCatPrice();

		List<HotelDto> hotel = HotelDao.getHotelInfoNew(hotelName);
		// this.hotelDescrModel = hotel.getHotel_description();
		// this.hotelNameModel = hotel.getHotel_name();
		// this.hotelIdModel = hotel.getHotel_id();
		// this.priceModel = hotel.getPrice();
		// this.roomCatPrice = hotel.getRoomCatPrice();

		return hotel;
	}
	
	public void displayHotelInfo(String hotelName) {

		// hotelDescrModel = "Hotel in the center of Berlin";
		// hotelNameModel = "Marotti Berlin";

		// get the information from database
		 HotelDto hotel = HotelDao.getHotelInfo(hotelName);
		 this.hotelDescrModel = hotel.getHotel_description();
		 this.hotelNameModel = hotel.getHotel_name();
		 this.hotelIdModel = hotel.getHotel_id();
		 this.priceModel = hotel.getPrice();
		 
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

	public int getPriceModel() {
		return priceModel;
	}

	public RoomCategoryAndPrice getRoomCatPrice() {
		return roomCatPrice;
	}
}