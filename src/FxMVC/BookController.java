package FxMVC;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BookController implements Initializable {
	
	BookingModel bookingModel = new BookingModel();
	
	@FXML
	private TextField textField;
	@FXML
	private Label label;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String checkIn = bookingModel.getCheckIn();
		bookingModel.toString();
		System.out.println("two: " + checkIn);
	}
	
	public void backBtnClicked(ActionEvent event) {
		try {
			Parent home_page_parent = FXMLLoader.load(getClass().getResource("HotelView.fxml"));
			Scene home_page_scene = new Scene(home_page_parent);
			Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(home_page_scene);
			app_stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	

}
