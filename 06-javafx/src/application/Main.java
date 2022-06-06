package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	static Stage originStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root);
			originStage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void changeScene(String input_fxml) throws IOException {
		Parent root = FXMLLoader.load(Main.class.getResource(input_fxml));
		Scene scene = new Scene(root);
		originStage.hide();
		originStage.setScene(scene);
		originStage.setResizable(false);
		originStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
