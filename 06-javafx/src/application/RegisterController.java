package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class RegisterController implements Initializable{
    @FXML
    private ComboBox<String> cbo_city;

    @FXML
    private CheckBox chk_java;

    @FXML
    private CheckBox chk_js;

    @FXML
    private CheckBox chk_php;

    @FXML
    private ToggleGroup ratio_group;

    @FXML
    private TextArea txt_area;

    @FXML
    private DatePicker txt_dob;

    @FXML
    private PasswordField txt_password;

    @FXML
    private TextField txt_username;

    @FXML
    void btn_login_click(ActionEvent event) throws IOException {
    	Main.changeScene("Sample.fxml");
    }

    @FXML
    void btn_register_click(ActionEvent event) {
    	String name = txt_username.getText();
    	String pass = txt_password.getText();
    	LocalDate dob = txt_dob.getValue();
    	//selected index
    	int index = cbo_city.getSelectionModel().getSelectedIndex();
    	
    	//selected item
    	String item = cbo_city.getSelectionModel().getSelectedItem();
    	String skillSet = "";
    	if(chk_java.isSelected()) {
    		skillSet += chk_java.getText() + ",";
    	}
    	if(chk_php.isSelected()) {
    		skillSet += chk_php.getText() + ",";
    	}
    	if(chk_js.isSelected()) {
    		skillSet += chk_js.getText() + ",";
    	}
    	
    	RadioButton selectedRadio=(RadioButton) ratio_group.getSelectedToggle();
    	String gender = selectedRadio.getText();
    	String others = txt_area.getText();
    	
    	System.out.println("---Your Profile---");
    	System.out.println("Username : " + name);
    	System.out.println("Password : " + pass);
    	System.out.println("Birthday : " + dob);
    	System.out.println("City : " + index + "(" + item + ")");
    	System.out.println("Skillset : " + skillSet);
    	System.out.println("Gender : " + gender);
    	System.out.println("Other : " + others);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<String> city = List.of("Yangon","Mandalay","Pyin Oo Lwin");
		cbo_city.setItems(FXCollections.observableArrayList(city));
		
	}
}
