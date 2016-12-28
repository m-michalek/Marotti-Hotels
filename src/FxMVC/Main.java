package FxMVC;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			primaryStage.setTitle("Welcome to Marotti Hotels");
			primaryStage.setScene(new Scene (root, 600, 400));
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}