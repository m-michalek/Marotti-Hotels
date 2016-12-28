package fxTest;
import com.sun.org.apache.regexp.internal.recompile;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
	
	static boolean answer;
	
	public static boolean display(String title, String message){
		
		Stage window = new Stage();
		// alert box that needs to be closed before the user can work with the previous window 
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(200);
		Label label = new Label(message);
		
		Button yesbtn = new Button("yes");
		Button nobtn = new Button("no");
		
		yesbtn.setOnAction(e -> {
			answer = true;
			window.close();
		});

		nobtn.setOnAction(e -> {
			answer = false;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesbtn, nobtn);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}
}