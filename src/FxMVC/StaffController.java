package FxMVC;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StaffController {

	public void bookingInfoBtnClicked(ActionEvent event) {

		try {
			Parent home_page_parent = FXMLLoader.load(getClass().getResource("BookingInfoView.fxml"));
			Scene home_page_scene = new Scene(home_page_parent);
			Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(home_page_scene);
			app_stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteSWCategoryBtnClicked(ActionEvent event) {

		try {
			Parent home_page_parent = FXMLLoader.load(getClass().getResource("DeleteSpecialWishesCategory.fxml"));
			Scene home_page_scene = new Scene(home_page_parent);
			Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(home_page_scene);
			app_stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void backBtnClicked(ActionEvent event) {
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
