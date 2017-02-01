package FxMVC;

public class BookingInfoDto {

	
	
	// ledilgilch nur f�r STruktur f�r Dao Klasse die dann bef�llt/aufgerufen wird
	
	
	private int booking_ID;
	private String customer_name;
	private int room_number;
	private int room_id;
	private int room_categorey;
	public int getBooking_ID() {
		return booking_ID;
	}
	public void setBooking_ID(int booking_ID) {
		this.booking_ID = booking_ID;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getRoom_number() {
		return room_number;
	}
	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public int getRoom_categorey() {
		return room_categorey;
	}
	public void setRoom_categorey(int room_categorey) {
		this.room_categorey = room_categorey;
	}

}
