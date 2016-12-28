package FxMVC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HotelController {

	HotelModel model = new HotelModel();

	@FXML
	private TextField hotelTextField;
	@FXML
	private Label hotelNameLabel;
	@FXML
	private Label hotelDescriptionLabel;
	@FXML
	private ListView hotelListView;

	public void searchForHotel(ActionEvent event) {

		String hotelName = hotelTextField.getText();

		model.displayHotelInfo(hotelName);
		
		hotelNameLabel.setText(model.getHotelNameModel());
		hotelDescriptionLabel.setText(model.getHotelDescrModel());
	}

	
	public void displayAllHotels(ActionEvent event) {
		System.out.println("controller: display all hotels ");
		
		List<String> hotelNames = new ArrayList<String>();
		
		List<HotelDto> listOfHotels = model.dislayAllHotels();
		
		for (HotelDto item : listOfHotels){
			String name = item.getHotel_name();
			System.out.println(name);
			hotelNames.add(name);
		}
		
		hotelListView.getItems().addAll(hotelNames);
		
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