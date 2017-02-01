package FxMVC;

import java.util.List;

public class BookingInfoModel {

	private int booking_idModel;
	private String custNameModel;
	private int roomNumberModel;
	private int room_idModel;
	private int roomCatModel;
	
	
	
	
	// Logik  hier mit DTO und DAO

	public void showBookingInfo(int booking_id) {


	/*	custNameModel= "Bond";
		roomNumberModel= 200;
		room_idModel=2;
		roomCatModel=1;*/
	
		System.out.println("id to search from model: " + booking_id);
		BookingInfoDto bookingvalue = BookingInfoDao.getBookingInfo(booking_id);
		booking_idModel= bookingvalue.getBooking_ID();
		
		custNameModel=bookingvalue.getCustomer_name();
		roomNumberModel=bookingvalue.getRoom_number();
		room_idModel= bookingvalue.getRoom_id();
		roomCatModel= bookingvalue.getRoom_categorey();
		
		System.out.println("bookind id in model: " + booking_idModel);
		
	}

	public int getBooking_idModel() {
		return booking_idModel;
	}

	public void setBooking_idModel(int booking_idModel) {
		this.booking_idModel = booking_idModel;
	}

	public String getCustNameModel() {
		return custNameModel;
	}

	public void setCustNameModel(String custNameModel) {
		this.custNameModel = custNameModel;
	}

	public int getRoomNumberModel() {
		return roomNumberModel;
	}

	public void setRoomNumberModel(int roomNumberModel) {
		this.roomNumberModel = roomNumberModel;
	}

	public int getRoom_idModel() {
		return room_idModel;
	}

	public void setRoom_idModel(int room_idModel) {
		this.room_idModel = room_idModel;
	}

	public int getRoomCatModel() {
		return roomCatModel;
	}

	public void setRoomCatModel(int roomCatModel) {
		this.roomCatModel = roomCatModel;
	}

}
