package fxTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFX extends Application {

	Stage window;
	Scene sceneMain, sceneHotelInfo, sceneAddNewBooking, sceneCheckIfDateAvailable, loginScene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Marotti Hotels");
		window.setOnCloseRequest(e -> {
			//e.consume();
			//closeProgram();
		});

		initMainScene();
		initHotelInfoScene();
		initAddBookingScene();
		initCheckDatesScene();
		initLoginScene();

//		window.setScene(sceneMain);
		window.setScene(sceneHotelInfo);
		window.show();
	}

	private void initMainScene() {
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

		Label alertlbl = new Label();
		alertlbl.setText("Alert window");

		Button alertbtn = new Button();
		alertbtn.setText("Alert button");
		alertbtn.setOnAction(e -> AlertBox.display("title of window", "message"));

		Label confirmlbl = new Label("And here is the confirm window");
		Button confirmbtn = new Button();
		confirmbtn.setText("Confirm button");
		confirmbtn.setOnAction(e -> {
			boolean result = ConfirmBox.display("Title of confirm window", "Are you sure?");
			System.out.println(result);
		});

		Button closebtn = new Button();
		closebtn.setText("Close the programme");
		closebtn.setOnAction(e -> closeProgram());

		Button loginbtn = new Button("Log in");
		loginbtn.setOnAction(e -> window.setScene(loginScene));

		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label, buttonHotelInfo, buttonAddNewBooking, buttonCheckIfDateAvailable, alertlbl,
				alertbtn, confirmlbl, confirmbtn, closebtn, loginbtn);
		sceneMain = new Scene(layout1, 400, 600);
	}

	private void initHotelInfoScene() {
		// sceneHotelInfo
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		Label label2 = new Label("Here will be displayed info about our different hotels");
		GridPane.setConstraints(label2, 0, 0);
		
		Label labelHotel = new Label("And may be some pictures");
		GridPane.setConstraints(labelHotel, 0, 1);
		
		Button showAllHotels = new Button();
		showAllHotels.setText("Show all Marotti Hotels");
		showAllHotels.setOnAction(e -> System.out.println("select * from hotel"));
		GridPane.setConstraints(showAllHotels, 0, 5);
		
		Button backbtn = new Button();
		backbtn.setText("Back");
		backbtn.setOnAction(e -> window.setScene(sceneMain));
		GridPane.setConstraints(backbtn, 0, 13);

		grid.getChildren().addAll(label2, labelHotel, showAllHotels, backbtn);
		sceneHotelInfo = new Scene(grid, 400, 600);
	}

	private void initAddBookingScene() {
		Label addBookinglbl = new Label("Here you can add a new booking");
		Button addBookingbtnBack = new Button("Back");
		addBookingbtnBack.setOnAction(e -> window.setScene(sceneMain));
		
		VBox layout3 = new VBox(20);
		layout3.getChildren().addAll(addBookinglbl, addBookingbtnBack);
		sceneAddNewBooking = new Scene(layout3, 500, 500);
	}
	
	private void initLoginScene() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		Label nameLabel = new Label("Username");
		GridPane.setConstraints(nameLabel, 0, 0);

		// with default text
		TextField nameInput = new TextField("Default text");
		GridPane.setConstraints(nameInput, 1, 0);

		Label passLabel = new Label("Password");
		GridPane.setConstraints(passLabel, 0, 1);

		// with placeholder
		TextField passInput = new TextField();
		passInput.setPromptText("password");
		GridPane.setConstraints(passInput, 1, 1);

		Button loginbtn = new Button("Log in");
		loginbtn.setOnAction(e -> isInt(nameInput, nameInput.getText()));
		GridPane.setConstraints(loginbtn, 1, 2);
		
		Button backbtn = new Button ("Back");
		backbtn.setOnAction(e -> window.setScene(sceneMain));
		GridPane.setConstraints(backbtn, 1, 3);

		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginbtn, backbtn);
		loginScene = new Scene(grid, 300, 300);
	}
	

	private Boolean isInt(TextField input, String message) {
		try{
			int age = Integer.parseInt(input.getText());
			System.out.println("user is: " + age);
			return true;
		} catch(NumberFormatException e) {
			System.out.println("Error: '" + message + "' is not a number ");
			e.printStackTrace();
			return false;
		}
	}
	

	private void initCheckDatesScene() {
		// sceneCheckIfDateAvailable
		Label checkDatesAvailablelbl = new Label("Here you can check if dates for your visit are available");
		Button checkDatesAvailablebtnBack = new Button("Back");
		checkDatesAvailablebtnBack.setOnAction(e -> window.setScene(sceneMain));

		VBox layout4 = new VBox(20);
		layout4.getChildren().addAll(checkDatesAvailablelbl, checkDatesAvailablebtnBack);
		sceneCheckIfDateAvailable = new Scene(layout4, 400, 600);
	}

	private void closeProgram() {
		Boolean answer = ConfirmBox.display("Some title", "Are you sure you want to exit the app?");
		if (answer) {
			window.close();
		}
	}
}