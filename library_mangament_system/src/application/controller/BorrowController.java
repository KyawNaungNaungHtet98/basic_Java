package application.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.model.entity.DatabaseService;
import application.model.service.Transcation;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BorrowController implements Initializable{
	   @FXML
	    private TableColumn<Transcation, LocalDate> col_borrow_date;

	    @FXML
	    private TableColumn<Transcation, LocalDate> col_due_date;

	    @FXML
	    private TableColumn<Transcation, Integer> col_id;

	    @FXML
	    private TableColumn<Transcation, String> col_librian;

	    @FXML
	    private TableColumn<Transcation, String> col_member;

	    @FXML
	    private TableColumn<Transcation, String> col_title;

	    @FXML
	    private TableView<Transcation> tbl_borrow;

	    @FXML
	    private TextField txt_book_code;

	    @FXML
	    private TextField txt_member_id;

	    private List<Transcation> borrowBookList;
	    @FXML
	    void btn_back_click(ActionEvent event) throws IOException {
	    	Main.change_scene("view/Main.fxml");
	    }

	    @FXML
	    void btn_borrow(ActionEvent event) throws SQLException {
	    	String code = txt_book_code.getText();
	    	String member_id = txt_member_id.getText();
	    	boolean result =DatabaseService.borrowBook(code , member_id);
	    	if(result == true) {
	    		showAlert(AlertType.INFORMATION, "Success for borrow");
	    		loadBorrowBook();
	    	} else {
	    		showAlert(AlertType.INFORMATION, "Please return book or book is already borrowed");
	    	}
	    	 
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
			col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
			col_member.setCellValueFactory(new PropertyValueFactory<>("member_name"));
			col_title.setCellValueFactory(new PropertyValueFactory<>("book_title"));
			col_borrow_date.setCellValueFactory(new PropertyValueFactory<>("borrow_date"));
			col_due_date.setCellValueFactory(new PropertyValueFactory<>("due_date"));
			col_librian.setCellValueFactory(new PropertyValueFactory<>("librian_name"));
			loadBorrowBook();
		}

		private void loadBorrowBook() {
			borrowBookList = DatabaseService.findAllborrowBook();
			tbl_borrow.setItems(FXCollections.observableArrayList(borrowBookList));
			
		}
		
}
