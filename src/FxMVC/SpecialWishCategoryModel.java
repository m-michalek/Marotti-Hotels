package FxMVC;

public class SpecialWishCategoryModel {
	
	private String special_wish_description;
	private int special_wish_id;
	private int special_wish_price;

	
	public void deleteSWCategory(int special_wish_cat_id){
		
		SpecialWishDao.deleteSWCategory(special_wish_cat_id);
		
	}
	
	
	public String getSpecial_wish_description() {
		return special_wish_description;
	}
	public void setSpecial_wish_description(String special_wish_description) {
		this.special_wish_description = special_wish_description;
	}
	public int getSpecial_wish_id() {
		return special_wish_id;
	}
	public void setSpecial_wish_id(int special_wish_id) {
		this.special_wish_id = special_wish_id;
	}
	public int getSpecial_wish_price() {
		return special_wish_price;
	}
	public void setSpecial_wish_price(int special_wish_price) {
		this.special_wish_price = special_wish_price;
	}
}
