package application.controller;



import java.io.IOException;



import application.Main;
import application.model.entity.DatabaseService;
import application.model.service.Librian;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginController {
	@FXML
    private TextField txt_email;

    @FXML
    private PasswordField txt_password;
    
    public static Librian login_user;
    

    @FXML
    void btn_exit_click(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void btn_login_click(ActionEvent event) throws IOException {
    	String email = txt_email.getText();
    	String password = txt_password.getText();
    	var login = DatabaseService.logIn(email,password);
    	if(login!= null) {
    		login_user = login;
    		Main.change_scene("view/Main.fxml");
    	} else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("You are not authenticated");
    		alert.setHeaderText(null);
    		alert.setTitle("Message");
    		alert.showAndWait();
    	}
    }

    @FXML
    void btn_register_click(ActionEvent event) throws IOException {
    	Main.change_scene("view/Reigster.fxml");
    }
}
