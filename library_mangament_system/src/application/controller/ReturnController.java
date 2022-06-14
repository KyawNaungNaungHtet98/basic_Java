package application.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import application.model.entity.DatabaseService;
import application.model.service.Transcation;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReturnController implements Initializable{
	@FXML
    private TableColumn<Transcation, String> col_Librian;

    @FXML
    private TableColumn<Transcation, LocalDate> col_borrow;

    @FXML
    private TableColumn<Transcation, LocalDate> col_due;

    @FXML
    private TableColumn<Transcation, Integer> col_fees;

    @FXML
    private TableColumn<Transcation, Integer> col_id;

    @FXML
    private TableColumn<Transcation, String> col_member;

    @FXML
    private TableColumn<Transcation, LocalDate> col_return;

    @FXML
    private TableColumn<Transcation, String> col_title;

    @FXML
    private TableView<Transcation> tbl_return;

    @FXML
    private TextField txt_code;

    @FXML
    private TextField txt_member_id;

    private List<Transcation> returnBookList;
    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Main.change_scene("view/Main.fxml");
    }

    @FXML
    void btn_return_click(ActionEvent event) throws SQLException {
    	var return_book = tbl_return.getSelectionModel().getSelectedItem();
    	if (return_book != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Are u sure to sumbit for return");
			alert.setHeaderText(null);
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				if (DatabaseService.findReturnBook(return_book)) {
					showAlert(AlertType.INFORMATION, "Deleted");
					loadReturn();
				} else {
					showAlert(AlertType.ERROR, "Something is wrong");
					loadReturn();
				}
			}
		}
	}
    	
    	
    private void showAlert(AlertType type, String content) {
    	Alert alert = new Alert(type);
		alert.setContentText(content);
		alert.setHeaderText(null);
		alert.setTitle("message");
		alert.showAndWait();
		
	}


	

    @FXML
    void btn_search_click(ActionEvent event) {
    	String code = txt_code.getText();
    	String id = txt_member_id.getText();
    	var bookList = DatabaseService.searchReturnBook(code, id);
		if (bookList.size() > 0) {
			tbl_return.setItems(FXCollections.observableArrayList(bookList));
			clear();
		} else {
			tbl_return.setItems(null);
			clear();
		}
		
    }

	private void clear() {
		txt_code.setText(null);
		txt_member_id.setText(null);		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_member.setCellValueFactory(new PropertyValueFactory<>("member_name"));
		col_title.setCellValueFactory(new PropertyValueFactory<>("book_title"));
		col_borrow.setCellValueFactory(new PropertyValueFactory<>("borrow_date"));
		col_due.setCellValueFactory(new PropertyValueFactory<>("due_date"));
		col_Librian.setCellValueFactory(new PropertyValueFactory<>("librian_name"));
		col_return.setCellValueFactory(new PropertyValueFactory<>("return_date"));
		col_fees.setCellValueFactory(new PropertyValueFactory<>("fees"));
		loadReturn();
		tbl_return.getSelectionModel().selectedItemProperty().addListener((obs, old_select, new_select) -> {
			if (new_select != null) {
				var return_book = tbl_return.getSelectionModel().getSelectedItem();
			}
		});
		
	}

	private void loadReturn() {
		returnBookList = DatabaseService.findReturnBook();
		tbl_return.setItems(FXCollections.observableArrayList(returnBookList));
		
	}

}
