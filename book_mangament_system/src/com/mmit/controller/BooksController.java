package com.mmit.controller;

import java.io.IOException;

import com.mmit.Start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class BooksController {

	  @FXML
	    void btn_add_click(ActionEvent event) throws IOException {
		  Start.change_scene("view/AddBook.fxml");
	    }

	    @FXML
	    void btn_back_click(ActionEvent event) throws IOException {
	    	Start.change_scene("view/Main.fxml");
	    }

	    @FXML
	    void btn_delete_click(ActionEvent event) throws IOException {
	    	Start.change_scene("view/DeleteBook.fxml");
	    }

	    @FXML
	    void btn_edit_click(ActionEvent event) throws IOException {
	    	Start.change_scene("view/EditBook.fxml");
	    }

	    @FXML
	    void btn_search_click(ActionEvent event) throws IOException {
	    	Start.change_scene("view/SearchBook.fxml");
	    }
}
