package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.mmit.Start;
import com.mmit.model.entity.Author;
import com.mmit.model.entity.Book;
import com.mmit.model.entity.Category;
import com.mmit.model.service.DatabaseService;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BookAddController implements Initializable{
	 @FXML
	    private ComboBox<String> cbo_author;

	    @FXML
	    private ComboBox<String> cbo_category;

	    @FXML
	    private TextField txt_code;

	    @FXML
	    private TextField txt_price;

	    @FXML
	    private DatePicker txt_publish;

	    @FXML
	    private TextField txt_title;
	    
	    private List<Author> authorList;
	    private List<Category> categoryList;

	    @FXML
	    void btn_back_click(ActionEvent event) throws IOException {
	    	Start.change_scene("view/Books.fxml");
	    }

	    @FXML
	    void btn_reset_click(ActionEvent event) {
//	    	txt_code.setText(null);
//	    	txt_title.setText(null);
//	    	txt_price.setText(null);
//	    	txt_publish.setValue(null);
	    	
	    }

	    @FXML
	    void btn_save_click(ActionEvent event) {
	    	String code = txt_code.getText();
	    	String title = txt_title.getText();
	    	String price = txt_price.getText();
	    	LocalDate publish_date = txt_publish.getValue();
	    	
	    	int author_index = cbo_author.getSelectionModel().getSelectedIndex();
	    	int category_index = cbo_category.getSelectionModel().getSelectedIndex();
	    	
	    	if(code.isEmpty()) {
	    		showAlert(AlertType.WARNING,"Please Enter book code");
	    		return;
	    	}
	    	
	    	if(title.isEmpty()) {
	    		showAlert(AlertType.WARNING,"Please Enter book Title");
	    		return;
	    	}
	    	
	    	if(price.isEmpty()) {
	    		showAlert(AlertType.WARNING,"Please Enter book price");
	    		return;
	    	}
	    	
	    	if(publish_date == null ) {
	    		showAlert(AlertType.WARNING,"Please Enter book publish Date");
	    		return;
	    	}
	    	if(author_index == -1) {
	    		showAlert(AlertType.WARNING,"Please Enter Author");
	    		return;
	    	}
	    	if(category_index == -1) {
	    		showAlert(AlertType.WARNING,"Please Enter book category");
	    		return;
	    	}
	    	
	    	//save
	    	Book book = new Book();
	    	book.setCode(Integer.parseInt(code));
	    	book.setTitle(title);
	    	book.setPrice(Integer.parseInt(price));
	    	book.setPublish_date(publish_date);
	    	book.setAuthor(authorList.get(author_index));
	    	book.setCategory(categoryList.get(category_index));
	    	book.setCreated_by(LoginController.login_user);
	    	if(DatabaseService.saveBook(book)) {
	    		showAlert(AlertType.INFORMATION,"New Book Saved");
	    	} else {
	    		showAlert(AlertType.ERROR,"Something is wrong");
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
			
			loadAuthors();
			loadCategorys();
			
		}

		private void loadCategorys() {
			categoryList = DatabaseService.findAllCategory();
			List<String> names = categoryList.stream().map(c-> c.getName()).toList();
			cbo_category.setItems(FXCollections.observableArrayList(names));
			
			
		}

		private void loadAuthors() {
			authorList = DatabaseService.findAllAuthors();
			List<String> names = authorList.stream().map(a-> a.getName()).collect(Collectors.toList());
			cbo_author.setItems(FXCollections.observableArrayList(names));
		}
}
