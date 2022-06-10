package application.controller;

import java.io.IOException;

import application.Main;
import application.model.entity.DatabaseService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {
    @FXML
    private TextField txt_email;

    @FXML
    private PasswordField txt_password;

    @FXML
    private TextField txt_username;

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Main.change_scene("view/Login.fxml");
    }

    @FXML
    void btn_register_click(ActionEvent event) throws IOException {
    	String username = txt_username.getText();
    	String email = txt_email.getText();
    	String pass = txt_password.getText();
    	if(username==null) {
    		showAlert(AlertType.WARNING,"Please enter username");
    	}
    	if(email==null) {
    		showAlert(AlertType.WARNING,"Please enter email");
    	}
    	if(pass==null) {
    		showAlert(AlertType.WARNING,"Please enter password");
    	}
    	boolean result = DatabaseService.registerLibrian(username,email,pass);
    	if(result == true) {
    		Main.change_scene("view/Main.fxml");
    	} else {
    		showAlert(AlertType.ERROR,"Please retry");
    		txt_username.setText(null);
    		txt_email.setText(null);
    		txt_password.setText(null);
    	}
    }

	private void showAlert(AlertType type, String content) {
		Alert alert = new Alert(type);
		alert.setContentText(content);
		alert.setHeaderText(null);
		alert.setTitle("message");
		alert.showAndWait();
		
	}
}
