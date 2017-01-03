package FxMVC;

public class HotelDto {
	
	private String hotel_name;
	private String hotel_description;
	private int hotel_id;
	private int numberOfRoomsInHotel;
	private int roomsBooked;
	
	public int getRoomsBooked() {
		return roomsBooked;
	}
	public void setRoomsBooked(int roomsBooked) {
		this.roomsBooked = roomsBooked;
	}
	public int getNumberOfRoomsInHotel() {
		return numberOfRoomsInHotel;
	}
	public void setNumberOfRoomsInHotel(int numberOfRoomsInHotel) {
		this.numberOfRoomsInHotel = numberOfRoomsInHotel;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getHotel_description() {
		return hotel_description;
	}
	public void setHotel_description(String hotel_description) {
		this.hotel_description = hotel_description;
	}

}
