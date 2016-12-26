import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class MainFX extends Application {
	
	Stage window; 
	Scene sceneMain, sceneHotelInfo, sceneAddNewBooking, sceneCheckIfDateAvailable;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		primaryStage.setTitle("Marotti Hotels");

		// sceneMain
		Label label = new Label("Welcome to Marotti Hotels");
		
		Button buttonHotelInfo = new Button();
		buttonHotelInfo.setText("Check information about our hotels");
		buttonHotelInfo.setOnAction(e -> window.setScene(sceneHotelInfo));
		
		Button buttonAddNewBooking = new Button();
		buttonAddNewBooking.setText("Book a hotel");
		buttonAddNewBooking.setOnAction(e -> window.setScene(sceneAddNewBooking));
		
		Button buttonCheckIfDateAvailable = new Button();
		buttonCheckIfDateAvailable.setText("Check if dates are available");
		buttonCheckIfDateAvailable.setOnAction(e -> window.setScene(sceneCheckIfDateAvailable));

		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label, buttonHotelInfo, buttonAddNewBooking, buttonCheckIfDateAvailable);
		sceneMain = new Scene(layout1, 600, 400);
		
		// sceneHotelInfo
		Label label2 = new Label("Here will be displayed info about our different hotels");
		Label labelHotel = new Label("And may be some pictures");
		Button button2 = new Button();
		button2.setText("Back");
		button2.setOnAction(e -> window.setScene(sceneMain));
		
		VBox layout2 = new VBox(20);
		layout2.getChildren().addAll(label2, labelHotel, button2);
		sceneHotelInfo = new Scene(layout2, 400, 600);
		
		// sceneAddNewBooking
		Label addBookinglbl = new Label ("Here you can add a new booking");
		Button addBookingbtnBack = new Button ("Back");
		addBookingbtnBack.setOnAction(e -> window.setScene(sceneMain));
		
		VBox layout3 = new VBox(20);
		layout3.getChildren().addAll(addBookinglbl, addBookingbtnBack);
		sceneAddNewBooking = new Scene(layout3, 500, 500);
		
		// sceneCheckIfDateAvailable
		Label checkDatesAvailablelbl = new Label("Here you can check if dates for your visit are available");
		Button checkDatesAvailablebtnBack = new Button("Back");
		checkDatesAvailablebtnBack.setOnAction(e -> window.setScene(sceneMain));
		
		VBox layout4 = new VBox(20);
		layout4.getChildren().addAll(checkDatesAvailablelbl, checkDatesAvailablebtnBack);
		sceneCheckIfDateAvailable = new Scene(layout4, 400, 600);
				
		window.setScene(sceneMain);
		window.show();
	}
}
