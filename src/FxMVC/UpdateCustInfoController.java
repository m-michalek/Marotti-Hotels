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

public class UpdateCustInfoController {

	@FXML
	private TextField lastNameText;
	@FXML
	private Button updateBtn;
	@FXML
	private Button backBtn;
	@FXML
	private TextField newAddressText;

	CustomerModel model = new CustomerModel();

	String last_name, newAdress;

	public void updateBtnClicked(ActionEvent event) {
		System.out.println("Update info");

		last_name = lastNameText.getText();
		newAdress = newAddressText.getText();
		
		model.changeCustAddress(last_name, newAdress);

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
