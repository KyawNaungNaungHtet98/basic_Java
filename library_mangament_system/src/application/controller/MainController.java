package application.controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class MainController {
	 @FXML
	    void btn_book_edition(MouseEvent event) throws IOException {
		 Main.change_scene("view/Book.fxml");
	    }

	    @FXML
	    void btn_borrow_book(MouseEvent event) throws IOException {
	    	Main.change_scene("view/Borrow.fxml");
	    }

	    @FXML
	    void btn_exit_click(ActionEvent event) {
	    	System.exit(0);
	    }

	    @FXML
	    void btn_member_system(MouseEvent event) throws IOException {
	    	Main.change_scene("view/Member.fxml");
	    }

	    @FXML
	    void btn_return_book(MouseEvent event) throws IOException {
	    	Main.change_scene("view/Return.fxml");
	    }
}
