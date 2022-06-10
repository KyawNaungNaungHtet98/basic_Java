package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.model.entity.DatabaseService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class NewMemberController implements Initializable{
	  @FXML
	    private ComboBox<String> cbo_year;

	    @FXML
	    private TextField txt_academic;

	    @FXML
	    private TextField txt_name;

	    @FXML
	    private TextField txt_roll;

	    @FXML
	    void btn_back_click(ActionEvent event) throws IOException {
	    	Main.change_scene("view/Main.fxml");
	    }

	    @FXML
	    void btn_register_click(ActionEvent event) throws IOException {
	    	String name = txt_name.getText();
	    	String roll = txt_roll.getText();
	    	String year = cbo_year.getSelectionModel().getSelectedItem();
	    	String academic = txt_academic.getText();
	    	if(name == null) {
	    		showAlert(AlertType.WARNING,"Please Enter Name");
	    		return;
	    	}
	    	if(roll == null) {
	    		showAlert(AlertType.WARNING,"Please Enter Roll_no");
	    		return;
	    	}
	    	if(academic == null) {
	    		showAlert(AlertType.WARNING,"Please Enter Academic Year");
	    		return;
	    	}
	    	if(year == null) {
	    		showAlert(AlertType.WARNING,"Please Choose Year");
	    		return;
	    	}
	    	DatabaseService.registerMember(name,roll,year,academic);
	    	Main.change_scene("view/Main.fxml");
	    	
	    	
	    }

		private void showAlert(AlertType type, String content) {
			Alert alert = new Alert(type);
			alert.setContentText(content);
			alert.setHeaderText(null);
			alert.setTitle("message");
			alert.showAndWait();
			
		}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			List<String> year = List.of("First Year","Second Year","Third year","Fourth Year");
			cbo_year.setItems(FXCollections.observableArrayList(year));
			
		}
}
