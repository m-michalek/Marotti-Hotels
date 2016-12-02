package dao;

public class Booking {

	private int booking_id;
	private int customer_id;
	private String check_in_date;
	private String check_out_date;
	private String bookingcode;
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCheck_in_date() {
		return check_in_date;
	}
	public void setCheck_in_date(String check_in_date) {
		this.check_in_date = check_in_date;
	}
	public String getCheck_out_date() {
		return check_out_date;
	}
	public void setCheck_out_date(String check_out_date) {
		this.check_out_date = check_out_date;
	}
	public String getBookingcode() {
		return bookingcode;
	}
	public void setBookingcode(String bookingcode) {
		this.bookingcode = bookingcode;
	}


}
