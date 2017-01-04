package FxMVC;

public class RoomCategoryAndPrice {

	private String roomCategory;
	private int roomPrice;
	
	public String getRoomCategory() {
		return roomCategory;
	}
	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	
	public String toString(){
		return "from class: " + this.roomCategory + this.roomPrice;
	}
}
