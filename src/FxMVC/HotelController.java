package FxMVC;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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

	@FXML
	private TextField hotelTextField;
	@FXML
	private Label hotelNameLabel;
	@FXML
	private Label hotelDescriptionLabel;
	@FXML
	private ListView<String> hotelListView;
	@FXML
	private DatePicker checkInDate;
	@FXML
	private DatePicker checkOutDate;
	@FXML
	private ImageView hotelImage;
	@FXML
	private Button button;
	@FXML
	private ImageView secondImageView;
	@FXML
	private Label label;
	@FXML
	private ComboBox<String> roomCategory;
	@FXML
	private ComboBox<String> hotelComboBox;
	@FXML
	private Label roomsAvailableLbl;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// try to get room categories from the database

		roomCategory.getItems().removeAll(roomCategory.getItems());
		roomCategory.getItems().addAll("Single room", "Double room", "Suite");

		hotelComboBox.getItems().removeAll(hotelComboBox.getItems());
		hotelComboBox.getItems().addAll("Marotti Berlin", "Marotti München");

	}

	public void checkAvailability(ActionEvent event) {

		int rcategoryID = 0;

		System.out.println("checking out availability of hotel with the dates");
		LocalDate checkInAsDate = checkInDate.getValue();
		String checkInString = checkInAsDate.format(DateTimeFormatter.ofPattern("dd.MM.yy"));

		LocalDate checkOutAsDate = checkOutDate.getValue();
		String checkOutString = checkOutAsDate.format(DateTimeFormatter.ofPattern("dd.MM.yy"));

		String roomCategoryString = roomCategory.getValue();

		switch (roomCategoryString) {
			case "Single room":
				rcategoryID = 1;
				break;
			case "Double room":
				rcategoryID = 2;
				break;
		}

		String hotel = hotelComboBox.getValue();

		System.out.println("Check between the dates from " + checkInString + " to " + checkOutString);
		System.out.println("for the room type: " + roomCategory.getValue());
		System.out.println("room category id:" + rcategoryID);
		System.out.println("in a hotel: " +  hotel);

		model.checkAvailability(hotel, checkInString, checkOutString, rcategoryID);

		roomsAvailableLbl.setText("Rooms in a hotel: " + model.getRoomsAvailableModel());

	}

	public void displayAllHotels(ActionEvent event) {

		hotelListView.getItems().clear();
		System.out.println("controller: display all hotels ");

		List<String> hotelNames = new ArrayList<String>();
		List<HotelDto> listOfHotels = model.dislayAllHotels();

		for (HotelDto item : listOfHotels) {
			String name = item.getHotel_name();

			System.out.println(name);
			hotelNames.add(name);
		}

		hotelListView.getItems().addAll(hotelNames);

		hotelListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println("Selected item: " + newValue);

				String hotelName = newValue;
				model.displayHotelInfo(hotelName);

				hotelNameLabel.setText(model.getHotelNameModel());
				hotelDescriptionLabel.setText(model.getHotelDescrModel());
				hotelID = model.getHotelIdModel();
				System.out.println("hotel id: " + hotelID);
			}
		});
	}

	public void backBtnClicked(ActionEvent event) {
		System.out.println("back button clicked");
		try {
			Parent home_page_parent = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			Scene home_page_scene = new Scene(home_page_parent);
			Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(home_page_scene);
			app_stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}