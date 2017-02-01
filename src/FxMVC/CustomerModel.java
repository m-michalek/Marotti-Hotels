package FxMVC;

public class CustomerModel {

	private String customer_first_name;
	private String customer_last_name;
	private String country;
	private String city;
	private String street;
	private int index;
	private String birthdate;
	private int accountNumber;

	public void addCustomer(String customer_first_name, String customer_last_name, String birthdate, String country,
			String city, String street, int index, int accountNumber) {
		
		CustomerDao.addCustomer(customer_first_name, customer_last_name, birthdate, country,
			 city, street, index, accountNumber);
	}
	
	public void changeCustAddress(String customer_last_name, String street ){
		System.out.println(customer_last_name + street);
		
		CustomerDao.updateCustAddress(customer_last_name, street);
		
	}

	public String getCustomer_first_name() {
		return customer_first_name;
	}

	public void setCustomer_first_name(String customer_first_name) {
		this.customer_first_name = customer_first_name;
	}

	public String getCustomer_last_name() {
		return customer_last_name;
	}

	public void setCustomer_last_name(String customer_last_name) {
		this.customer_last_name = customer_last_name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
}