package FxMVC;

public class BookingModel {

	private String hotel;
	private String roomCategory;
	private String checkIn;
	private String checkOut;

	public BookingModel(){
		
	}
	
	public BookingModel(String hotel1, String roomCategory1, String checkIn1, String checkOut1){
		hotel = hotel1;
		roomCategory = roomCategory1;
		checkIn = checkIn1;
		checkOut = checkOut1;
	}
	
	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		System.out.println("here comes to string" + hotel);
		return super.toString();
	}

}
