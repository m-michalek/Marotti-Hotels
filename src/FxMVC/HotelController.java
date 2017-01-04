package FxMVC;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fxTest.AlertBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HotelController implements Initializable {

	HotelModel model = new HotelModel();
	int hotelID;
	String checkInString = null, checkOutString = null;
	String roomCategoryString, hotel;
	LocalDate checkInAsDate, checkOutAsDate;

	@FXML
	private TextField hotelTextField;
	@FXML
	private Label hotelNameLabel;
	@FXML
	private Label hotelDescriptionLabel;
	@FXML
	private Label priceLbl;
	@FXML
	private ListView<String> hotelListView;
	@FXML
	private ListView<String> priceList;
	@FXML
	private DatePicker checkInDate;
	@FXML
	private DatePicker checkOutDate;
	@FXML
	private ImageView hotelImage;
	@FXML
	private ImageView secondImageView;
	@FXML
	private ComboBox<String> roomCategory;
	@FXML
	private ComboBox<String> hotelComboBox;
	@FXML
	private Label roomsAvailableLbl;
	@FXML
	private Button checkButton;
	@FXML
	private Button bookBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// try to get room categories from the database

		roomCategory.getItems().removeAll(roomCategory.getItems());
		roomCategory.getItems().addAll("Single room", "Double room");

		hotelComboBox.getItems().removeAll(hotelComboBox.getItems());
		hotelComboBox.getItems().addAll("Marotti Berlin", "Marotti München");

	}

	public void checkAvailability(ActionEvent event) {

		int rcategoryID = 0;
		System.out.println("checking out availability of hotel with the dates");
		checkInAsDate = checkInDate.getValue();
		try {
			checkInString = checkInAsDate.format(DateTimeFormatter.ofPattern("dd.MM.yy"));
		} catch (NullPointerException e) {
			System.out.println("Checking availability without check in date");
		}

		checkOutAsDate = checkOutDate.getValue();
		try {
			checkOutString = checkOutAsDate.format(DateTimeFormatter.ofPattern("dd.MM.yy"));
		} catch (NullPointerException e1) {
			System.out.println("Checking availability without check out date");
		}

		roomCategoryString = roomCategory.getValue();
		hotel = hotelComboBox.getValue();

		if (roomCategoryString != null && hotel != null) {
			System.out.println("Check between the dates from " + checkInString + " to " + checkOutString);
			System.out.println("for the room type: " + roomCategoryString);
			System.out.println("in a hotel: " + hotel);

			try {
				model.checkAvailability(hotel, checkInString, checkOutString, roomCategoryString);
			} catch (NullPointerException ex) {
				ex.printStackTrace();
			}

			roomsAvailableLbl.setText("Rooms in a hotel: " + model.getRoomsAvailableModel());

		} else {

			AlertBox.display("Error!", "Please choose room category and hotel");
		}
	}

	public void displayAllHotels(ActionEvent event) {

		hotelListView.getItems().clear();

		List<String> hotelNames = new ArrayList<String>();
		List<HotelDto> listOfHotels = model.dislayAllHotels();

		for (HotelDto item : listOfHotels) {
			String name = item.getHotel_name();
			hotelNames.add(name);
		}

		hotelListView.getItems().addAll(hotelNames);
		displayInfoAboutHotel();
	}

	private void displayInfoAboutHotel() {

		hotelListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("Selected item: " + newValue);

				String hotelName = newValue;
				model.displayHotelInfo(hotelName);

				hotelNameLabel.setText(model.getHotelNameModel());
				hotelDescriptionLabel.setText(model.getHotelDescrModel());

				// List<RoomCategoryAndPrice> roomCategories = new
				// ArrayList<RoomCategoryAndPrice>();
				//
				// for (HotelDto item : listOfHotels) {
				// RoomCategoryAndPrice roomCategory = (RoomCategoryAndPrice)
				// item.getRoomCatPrice();
				// System.out.println("room category: " +
				// roomCategory.toString());
				// // String roomCategory = item.getHotel_name();
				// roomCategories.add(roomCategory);
				// }

				// priceList.getItems().add(roomCategories);

				// priceLbl.setText("" + model.getPriceModel());
			}
		});
	}

	public void backBtnClicked(ActionEvent event) {
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

	public void bookBtnClicked(ActionEvent event) {

		roomCategoryString = roomCategory.getValue();
		hotel = hotelComboBox.getValue();

		checkOutAsDate = checkOutDate.getValue();
		try {
			checkOutString = checkOutAsDate.format(DateTimeFormatter.ofPattern("dd.MM.yy"));
		} catch (NullPointerException e1) {
			System.out.println("no check out date");
		}

		checkInAsDate = checkInDate.getValue();
		try {
			checkInString = checkInAsDate.format(DateTimeFormatter.ofPattern("dd.MM.yy"));
		} catch (NullPointerException e) {
			System.out.println("no check in date");
		}

		if (roomCategoryString != null && hotel != null && checkInString != null && checkOutString != null) {

			try {
				Parent home_page_parent = FXMLLoader.load(getClass().getResource("BookView.fxml"));
				Scene home_page_scene = new Scene(home_page_parent);
				Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				app_stage.setScene(home_page_scene);
				app_stage.show();

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			AlertBox.display("Error!", "Please choose room category, hotel, check in and check out dates");
		}
	}
}