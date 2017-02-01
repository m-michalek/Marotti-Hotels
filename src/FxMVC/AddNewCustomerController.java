package FxMVC;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNewCustomerController {

	@FXML
	private TextField firstNameText;
	@FXML
	private Button addNewCustomerBtn;
	@FXML
	private TextField lastNameText;
	@FXML
	private TextField countryText;
	@FXML
	private TextField cityText;
	@FXML
	private TextField indexText;
	@FXML
	private TextField streetText;
	@FXML
	private TextField accountNumberText;
	@FXML
	private Button addNewCustomerBtn1;
	@FXML
	private DatePicker birthdateText;

	CustomerModel model = new CustomerModel();
	
	String first_name, last_name, country, city, street, birthdate, index, accountNumber;
	LocalDate birthdateAsDate;
	int indexInt, accountNumberInt;

	public void addNewCustomerBtnClicked(ActionEvent event) {

		first_name = firstNameText.getText();
		last_name = lastNameText.getText();
		birthdateAsDate = birthdateText.getValue();
		country = countryText.getText();
		city = cityText.getText();
		index = indexText.getText();
		street = streetText.getText();
		accountNumber = accountNumberText.getText();

		if (index.length() == 0) {
			index = "0";
		}

		if (accountNumber.length() == 0) {
			accountNumber = "0";
		}

		try {
			birthdate = birthdateAsDate.format(DateTimeFormatter.ofPattern("dd.MM.yy"));
		} catch (NullPointerException e1) {
			System.out.println("Error with birthdate");
		}

		try {
			indexInt = Integer.parseInt(index);
			accountNumberInt = Integer.parseInt(accountNumber);

		} catch (NumberFormatException e) {
			System.out.println(first_name + ", " + last_name + ", " + birthdate + ", " + country + ", " + city + ", "
					+ index + ", " + street + ", " + accountNumber);
			AlertBox.display("Error!", "Please check that index and account number do not contain letters!");
		}

		if (first_name.length() == 0 || last_name.length() == 0) {
			AlertBox.display("Error!", "Please insert first and last name");
		} else {
			model.addCustomer(first_name, last_name, birthdate, country, city, street, indexInt, accountNumberInt);
		}
	}

	public void backBtnClicked(ActionEvent event) {
		System.out.println("back button clicked");
		try {
			Parent home_page_parent = FXMLLoader.load(getClass().getResource("CustomerView.fxml"));
			Scene home_page_scene = new Scene(home_page_parent);
			Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(home_page_scene);
			app_stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}