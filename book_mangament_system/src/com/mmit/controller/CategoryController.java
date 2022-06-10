package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.entity.Category;
import com.mmit.model.service.DatabaseService;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CategoryController implements Initializable{
	@FXML
	private TableColumn<Category, LocalDateTime> col_created_at;

	@FXML
	private TableColumn<Category, Integer> col_id;

	@FXML
	private TableColumn<Category, String> col_name;

	@FXML
	private TableColumn<Category, LocalDateTime> col_updated_at;

	@FXML
	private TableView<Category> tbl_category;

	@FXML
	private TextField txt_name;

	private List<Category> categoryList;
	@FXML
	void btn_add_click(ActionEvent event) {
		String name = txt_name.getText();
		
		DatabaseService.saveCategory(name);
		txt_name.setText(null);
		loadCategories();
	}

	@FXML
	void btn_back_click(ActionEvent event) throws IOException {
		Start.change_scene("view/Main.fxml");
	}

	@FXML
	void btn_delete_click(ActionEvent event) {
		Category category = tbl_category.getSelectionModel().getSelectedItem();
		if(category!= null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Are u sure to delete");
			alert.setHeaderText(null);
			Optional<ButtonType>  result = alert.showAndWait();
			if(result.get() == ButtonType.OK) {
				
				DatabaseService.deleteCategory(category.getId());
				txt_name.setText(null);
				loadCategories();
			}
		}

	}

	@FXML
	void btn_update_click(ActionEvent event) {
		String name = txt_name.getText();
		Category category = tbl_category.getSelectionModel().getSelectedItem();
		category.setName(name);
		DatabaseService.updateCategory(category);
		txt_name.setText(null);
		loadCategories();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_id.setCellValueFactory(new PropertyValueFactory<>("id")); // getId();
		col_name.setCellValueFactory(new PropertyValueFactory<>("name")); // getName();
		col_created_at.setCellValueFactory(new PropertyValueFactory<>("created_at"));
		col_updated_at.setCellValueFactory(new PropertyValueFactory<>("updated_at"));
		
		loadCategories();
		tbl_category.getSelectionModel().selectedItemProperty().addListener(
				(obs,old_select,new_select) -> {
					if(new_select != null) {
						var category = tbl_category.getSelectionModel().getSelectedItem();
						txt_name.setText(category.getName());
					}
				}
				);
		
	}

	private void loadCategories() {
		categoryList = DatabaseService.findAllCategory();
		tbl_category.setItems(FXCollections.observableArrayList(categoryList));
		
	}
}
