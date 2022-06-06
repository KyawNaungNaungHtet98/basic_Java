package application;



import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SampleController {
	@FXML
	private TextField txt_name;
	@FXML
	private PasswordField txt_password;
	@FXML
	private Label lbl_result;
	@FXML
	public void btn_login_click() {
		String name = txt_name.getText();
		String pass = txt_password.getText();
		System.out.println("Name : " + name);
		System.out.println("Password : " + pass);
		if(name.isEmpty()) {
			lbl_result.setText("Please enter username");
			return;
		}
		if(pass.isEmpty()) {
			lbl_result.setText("Please enter passowrd");
			return;
		}
		if(name.equals(("mmit")) && pass.equals("123")) {
			lbl_result.setText("Login Success");
		} else {
			lbl_result.setText("Login fail");
		}
	}
	
	@FXML
	public void btn_clear_click() {
		txt_name.setText("");
		txt_password.setText(null);
	}
	
	@FXML
	public void lbl_click() throws IOException {
		Main.changeScene("Register.fxml");
	}
}
