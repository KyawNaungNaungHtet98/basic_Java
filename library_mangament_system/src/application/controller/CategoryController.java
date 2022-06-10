package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import application.model.entity.DatabaseService;
import application.model.service.Category;
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

public class CategoryController implements Initializable{

    @FXML
    private TableColumn<Category, String> col_category;

    @FXML
    private TableColumn<Category, Integer> col_id;

    @FXML
    private TableView<Category> tbl_category;

    @FXML
    private TextField txt_category;
    
    private List<Category> categoryList;

    @FXML
    void btn_add_category(ActionEvent event) {
    	String category = txt_category.getText();
    	if(category == null) {
    		showAlert(AlertType.WARNING,"Please enter category");
    	} else {
    		DatabaseService.saveCategory(category);
    		txt_category.setText(null);
    		loadCategories();
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
    void btn_back_click(ActionEvent event) throws IOException {
    	Main.change_scene("view/Book.fxml");
    }

    @FXML
    void btn_delete_category(ActionEvent event) {
		Category category = tbl_category.getSelectionModel().getSelectedItem();
		if(category!= null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Are u sure to delete");
			alert.setHeaderText(null);
			Optional<ButtonType>  result = alert.showAndWait();
			if(result.get() == ButtonType.OK) {
				
				DatabaseService.deleteCategory(category.getId());
				txt_category.setText(null);
				loadCategories();
			}
		}
    }

    @FXML
    void btn_edit_category(ActionEvent event) {
    	String name = txt_category.getText();
		Category category = tbl_category.getSelectionModel().getSelectedItem();
		category.setName(name);
		DatabaseService.updateCategory(category);
		txt_category.setText(null);
		loadCategories();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_id.setCellValueFactory(new PropertyValueFactory<>("id")); // getId();
		col_category.setCellValueFactory(new PropertyValueFactory<>("name")); // getName();
		loadCategories();
		tbl_category.getSelectionModel().selectedItemProperty().addListener(
				(obs,old_select,new_select) -> {
					if(new_select != null) {
						var category = tbl_category.getSelectionModel().getSelectedItem();
						txt_category.setText(category.getName());
					}
				}
				);
		
	}

	private void loadCategories() {
		categoryList = DatabaseService.viewAllCategory();
		tbl_category.setItems(FXCollections.observableArrayList(categoryList));
		
	}
}
