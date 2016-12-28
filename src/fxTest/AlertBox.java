package fxTest;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
	
	public static void display(String title, String message){
		
		Stage window = new Stage();
		
		// alert box that needs to be closed before the user can work with the previous window 
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle(title);
		window.setMinWidth(200);
		
		Label label = new Label(message);
		Button closeButton = new Button("close the window");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
