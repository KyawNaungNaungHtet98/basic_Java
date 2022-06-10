package application.controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class MemberController {
	  @FXML
	    void btn_back_click(ActionEvent event) throws IOException {
		  Main.change_scene("view/Main.fxml");
	    }

	    @FXML
	    void btn_new_member(MouseEvent event) throws IOException {
	    	Main.change_scene("view/NewMember.fxml");
	    }

	    @FXML
	    void btn_old_member(MouseEvent event) throws IOException {
	    	Main.change_scene("view/OldMember.fxml");
	    }
}
