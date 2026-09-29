package psu.se411.lab4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainClass extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root = new StackPane(new Label("Hello, lab4!"));
			primaryStage.setScene(new Scene(root, 400, 300));
			primaryStage.setTitle("lab4");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
