package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.entity.Book;
import com.mmit.model.service.DatabaseService;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookSearchController  implements Initializable{
    @FXML
    private TableColumn<Book, String> col_author;

    @FXML
    private TableColumn<Book, String> col_category;

    @FXML
    private TableColumn<Book, String> col_created_by;

    @FXML
    private TableColumn<Book, Integer> col_id;

    @FXML
    private TableColumn<Book, Integer> col_price;

    @FXML
    private TableColumn<Book, LocalDate> col_publish;

    @FXML
    private TableColumn<Book, String> col_title;

    @FXML
    private TableView<Book> tbl_book;

    @FXML
    private TextField txt_author;

    @FXML
    private TextField txt_category;

    @FXML
    private DatePicker txt_publish;

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Start.change_scene("view/Books.fxml");
    }

    @FXML
    void btn_search_click(ActionEvent event) {
    	String author =txt_author.getText();
    	String category = txt_category.getText();
    	LocalDate pub_date = txt_publish.getValue();
    	
    	var bookList = DatabaseService.searchBook(author,category,pub_date);
    	if(bookList.size() > 0) {
    		tbl_book.setItems(FXCollections.observableArrayList(bookList));
    	} else {
    		tbl_book.setItems(null);
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		col_id.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		col_publish.setCellValueFactory(new PropertyValueFactory<>("publish_date"));
		col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
		col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		col_created_by.setCellValueFactory(new PropertyValueFactory<>("userName"));
		
		
	}
}
