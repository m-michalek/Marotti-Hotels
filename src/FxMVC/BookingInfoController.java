package FxMVC;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BookingInfoController {

	BookingInfoModel model = new BookingInfoModel();

	@FXML
	private Button infoButton;
	@FXML
	private TextField bookingIDField;
	@FXML
	private Label custName;
	@FXML
	private Label roomNumber;
	@FXML
	private Label roomID;
	@FXML
	private Label roomCat;

	public void infoButtonClicked(ActionEvent event) {

		bookingIDField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					bookingIDField.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		// custName.setText("");
		String bookinginput = bookingIDField.getText();
		System.out.println("booking id: " + bookinginput);
		int bookingID = 0;
		try{
			bookingID = Integer.parseInt(bookinginput);
		} catch (NumberFormatException ex) {
			AlertBox.display("Error!", "Please enter a BookingID");
		}
		
		model.showBookingInfo(bookingID);
		
		
		custName.setText(model.getCustNameModel());
		roomNumber.setText("" + model.getRoomNumberModel());
		roomID.setText("" + model.getRoom_idModel());
		roomCat.setText("" + model.getRoomCatModel());

		// System.out.println(bookinginput);

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
