package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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

public class BookEditController  implements Initializable{
	
    @FXML
    private ComboBox<String> cbo_author;

    @FXML
    private ComboBox<String> cbo_category;

    @FXML
    private DatePicker cbo_publish;

    @FXML
    private TextField txt_code;

    @FXML
    private TextField txt_price;

    @FXML
    private TextField txt_title;

    private List<Author> authorList;
    
    private List<Category> categoryList;
    
    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Start.change_scene("view/Books.fxml");
    }

    @FXML
    void btn_search_click(ActionEvent event) {
    	String code = txt_code.getText();
    	if(code.isEmpty()) {
    		showAlert(AlertType.WARNING,"Please enter code");
    		return;
    	}
    	Book book = DatabaseService.findBookByCode(code);
    	if(book != null) {
    		txt_title.setText(book.getTitle());
    		txt_price.setText(String.valueOf(book.getPrice()));
    		cbo_publish.setValue(book.getPublish_date());
    		
    		cbo_author.getSelectionModel().select(book.getAuthorName());
    		cbo_category.getSelectionModel().select(book.getCategoryName());
    	} else {
    		showAlert(AlertType.ERROR,"No book with this code");
    	}
    }

    private void showAlert(AlertType type, String string) {
		Alert alert = new Alert(type);
		alert.setContentText(string);
		alert.setTitle("Message");
		alert.setHeaderText(null);
		alert.showAndWait();
		
	}

	@FXML
    void btn_update_click(ActionEvent event) {
		Book book = new Book();
		book.setCode(Integer.parseInt(txt_code.getText()));
		book.setTitle(txt_title.getText());
		book.setPrice(Integer.parseInt(txt_price.getText()));
		book.setPublish_date(cbo_publish.getValue());
		
		var author_index = cbo_author.getSelectionModel().getSelectedIndex();
		var category_index = cbo_category.getSelectionModel().getSelectedIndex();
		
		book.setAuthor(authorList.get(author_index));
		book.setCategory(categoryList.get(category_index));
		
		if(DatabaseService.updateBook(book)) {
			showAlert(AlertType.INFORMATION,"Update success");
		} else {
			showAlert(AlertType.ERROR,"Something is wrong");
		}
    }
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		authorList = DatabaseService.findAllAuthors();
		categoryList = DatabaseService.findAllCategory();
		var author_names = authorList.stream().map(a-> a.getName()).toList();
		var cate_names = categoryList.stream().map(c-> c.getName()).toList();
		cbo_author.setItems(FXCollections.observableArrayList(author_names));
		cbo_category.setItems(FXCollections.observableArrayList(cate_names));
		
	}
}
