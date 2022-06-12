package application.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import application.model.entity.DatabaseService;
import application.model.service.Members;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class OldMemberController implements Initializable{
	  @FXML
	    private ComboBox<String> cbo_year;

	    @FXML
	    private TableColumn<Members, String> col_academic;

	    @FXML
	    private TableColumn<Members, LocalDate> col_expired;

	    @FXML
	    private TableColumn<Members, Integer> col_id;

	    @FXML
	    private TableColumn<Members, String> col_name;

	    @FXML
	    private TableColumn<Members, LocalDate> col_register;

	    @FXML
	    private TableColumn<Members, Integer> col_roll_no;

	    @FXML
	    private TableColumn<Members, String> col_year;

	    @FXML
	    private DatePicker dob_register;

	    @FXML
	    private TableView<Members> tbl_member;

	    @FXML
	    private TextField txt_academic;

	    @FXML
	    private TextField txt_id;

	    @FXML
	    private TextField txt_member;

	    @FXML
	    private TextField txt_name;

	    @FXML
	    private TextField txt_roll_no;
	    
	    private List<Members> memberList;

	    @FXML
	    void btn_back_click(ActionEvent event) throws IOException {
	    	Main.change_scene("view/Member.fxml");
	    }

	    @FXML
	    void btn_search_click(ActionEvent event) {
	    	String id = txt_id.getText();
	    	String member_name = txt_member.getText();
	    	var memberList = DatabaseService.searchMember(id,member_name);
	    	if(memberList.size() > 0) {
	    		tbl_member.setItems(FXCollections.observableArrayList(memberList));
	    	} else {
	    		tbl_member.setItems(null);
	    	}
	    	
	    }

	    @FXML
	    void btn_update_click(ActionEvent event) {
	    	Members members = new Members();
	    	String name = txt_name.getText();
	    	String roll = txt_roll_no.getText();
	    	String year = cbo_year.getSelectionModel().getSelectedItem();
	    	String academic = txt_academic.getText();
	    	LocalDate register = dob_register.getValue();
	    	
	    	members.setName(name);
	    	members.setRoll(Integer.parseInt(roll));
	    	members.setYear(year);
	    	members.setAcademic(academic);
	    	members.setRegister_date(register);
	    	
	    	boolean result = DatabaseService.updateMember(members);
	    	if(result == true) {
	    		showAlert(AlertType.INFORMATION,"Update Success");
	    	} else {
	    		showAlert(AlertType.INFORMATION,"Something is wrong");
	    	}
	    	loadMembers();
	    }

	    private String changeString(int roll) {
			String s = String.valueOf(roll);
			return s;
		}

		private void showAlert(AlertType type, String content) {
	    	Alert alert = new Alert(type);
			alert.setContentText(content);
			alert.setHeaderText(null);
			alert.setTitle("message");
			alert.showAndWait();
			
		}

		@FXML
	    void tbn_delete_click(ActionEvent event) {
			Members member = tbl_member.getSelectionModel().getSelectedItem();
			if(member != null) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Are u sure to delete");
				alert.setHeaderText(null);
				Optional<ButtonType>  result = alert.showAndWait();
				if(result.get() == ButtonType.OK) {
					
					boolean rs = DatabaseService.deleteMember(member);
					if(rs == true) {
			    		showAlert(AlertType.INFORMATION,"Delete Success");
			    		txt_name.setText(null);
			    		txt_academic.setText(null);
			    		txt_roll_no.setText(null);
			    		cbo_year.setValue(null);
			    		dob_register.setValue(null);
			    	} else {
			    		showAlert(AlertType.INFORMATION,"Something is wrong");
			    		txt_name.setText(null);
			    		txt_academic.setText(null);
			    		txt_roll_no.setText(null);
			    		cbo_year.setValue(null);
			    		dob_register.setValue(null);
			    	}
			    	loadMembers();
				}
			}
			
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
			col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
			col_roll_no.setCellValueFactory(new PropertyValueFactory<>("roll"));
			col_academic.setCellValueFactory(new PropertyValueFactory<>("academic"));
			col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
			col_expired.setCellValueFactory(new PropertyValueFactory<>("expired_date"));
			col_register.setCellValueFactory(new PropertyValueFactory<>("register_date"));
			loadMembers();
			tbl_member.getSelectionModel().selectedItemProperty().addListener(
					(obs,old_select,new_select) -> {
						if(new_select != null) {
							var member = tbl_member.getSelectionModel().getSelectedItem();
							txt_name.setText(member.getName());
				    		txt_roll_no.setText(changeString(member.getRoll()));
				    		cbo_year.setValue(member.getYear());
				    		txt_academic.setText(member.getAcademic());
				    		dob_register.setValue(member.getRegister_date());
						}
					}
					);
			List<String> year = List.of("First Year","Second Year","Third year","Fourth Year");
			cbo_year.setItems(FXCollections.observableArrayList(year));
			
			
		}

		private void loadMembers() {
			memberList = DatabaseService.viewAllMembers();
			tbl_member.setItems(FXCollections.observableArrayList(memberList));
			
		}
}
