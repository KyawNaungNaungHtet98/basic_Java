package application.controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class BookController {

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Main.change_scene("view/Main.fxml");
    }

    @FXML
    void click_add_author(MouseEvent event) throws IOException {
    	Main.change_scene("view/Addauthor.fxml");
    }

    @FXML
    void click_add_category(MouseEvent event) throws IOException {
    	Main.change_scene("view/Category.fxml");
    }

    @FXML
    void click_edit_book(MouseEvent event) throws IOException {
    	Main.change_scene("view/EditBook.fxml");
    }
}
