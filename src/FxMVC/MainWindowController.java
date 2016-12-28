package FxMVC;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindowController {

	public void displayInfoAboutHotelsClicked(ActionEvent event) {
		System.out.println("displayInfoAboutHotels button clicked");

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

	public void bookAHotelClicked(ActionEvent event) {
		System.out.println("bookAHotel button clicked");
	}

	public void printAReceiptClicked(ActionEvent event) {
		System.out.println("printAReceipt button clicked");
	}

}
