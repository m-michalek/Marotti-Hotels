package FxMVC;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteSpecialWishesController {

	@FXML
	private TextField categoryText;
	@FXML
	private Button deleteBtn;
	@FXML
	private Button backBtn;

	SpecialWishCategoryModel model = new SpecialWishCategoryModel();

	public void deleteSWCategoryBtnClicked(ActionEvent event) {

		System.out.println("Delete swcat clicked");

		String categoryString = categoryText.getText();

		int catInt;

		try {
			catInt = Integer.parseInt(categoryString);

			model.deleteSWCategory(catInt);

		} catch (NumberFormatException ex) {
			AlertBox.display("Error!", "Please check you entered a number!");
		}

	}

	public void backBtnClicked(ActionEvent event) {
		try {
			Parent home_page_parent = FXMLLoader.load(getClass().getResource("StaffView.fxml"));
			Scene home_page_scene = new Scene(home_page_parent);
			Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			app_stage.setScene(home_page_scene);
			app_stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
