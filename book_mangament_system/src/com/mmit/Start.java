package com.mmit;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Start extends Application {
	static Stage originStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/Main.fxml"));
			Scene scene = new Scene(root);
			originStage = primaryStage;
			
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void change_scene(String input_file) throws IOException {
		Parent root = FXMLLoader.load(Start.class.getResource(input_file));
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
