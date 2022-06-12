package application.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import application.model.entity.DatabaseService;
import application.model.service.Author;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class AuthorController implements Initializable {
	@FXML
	private ComboBox<String> cbo_city;

	@FXML
	private TableColumn<Author, String> col_author;

	@FXML
	private TableColumn<Author, LocalDate> col_birthday;

	@FXML
	private TableColumn<Author, String> col_city;

	@FXML
	private TableColumn<Author, String> col_id;

	@FXML
	private DatePicker dob_birthday;

	@FXML
	private TableView<Author> tbl_author;

	@FXML
	private TextField txt_author_name;

	@FXML
	private TextField txt_name;

	@FXML
	void btn_add_click(ActionEvent event) {
		String name = txt_name.getText();
		String city = cbo_city.getSelectionModel().getSelectedItem();
		LocalDate birthday = dob_birthday.getValue();
		Author author = new Author();
		author.setName(name);
		author.setCity(city);
		author.setBirthday(birthday);
		boolean rs = DatabaseService.addAuthor(author);
		if (rs == true) {
			showAlert(AlertType.INFORMATION, "Add author Success");
			loadAuthors();
			clear();
		} else {
			showAlert(AlertType.INFORMATION, "Fail to add author");
			clear();

		}

	}

	private void clear() {
		txt_name.setText(null);
		cbo_city.setValue(null);
		dob_birthday.setValue(null);

	}

	private void showAlert(AlertType type, String body) {
		Alert alert = new Alert(type);
		alert.setContentText(body);
		alert.setTitle("Message");
		alert.setHeaderText(null);
		alert.showAndWait();

	}

	@FXML
	void btn_back_click(ActionEvent event) throws IOException {
		Main.change_scene("view/Main.fxml");
	}

	@FXML
	void btn_delete_click(ActionEvent event) {
		var author = tbl_author.getSelectionModel().getSelectedItem();
		if (author != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Are u sure to delete");
			alert.setHeaderText(null);
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				DatabaseService.deleteAuthor(author.getId());
				clear();
				loadAuthors();
			}
		}
	}

	@FXML
	void btn_search_click(ActionEvent event) {
		String name = txt_author_name.getText();
		List<Author> author = DatabaseService.searchAuthor(name);
		tbl_author.setItems(FXCollections.observableArrayList(author));
	}

	@FXML
	void btn_update_click(ActionEvent event) {
		var selected_author = tbl_author.getSelectionModel().getSelectedItem();
		if (txt_name == null) {
			showAlert(AlertType.INFORMATION, "Please enter author name");
			clear();
			return;
		}
		if (cbo_city == null) {
			showAlert(AlertType.INFORMATION, "Please Choose City");
			clear();
			return;
		}
		if (dob_birthday == null) {
			showAlert(AlertType.INFORMATION, "Please Choose Birthday");
			clear();
			return;
		}
		selected_author.setBirthday(dob_birthday.getValue());
		selected_author.setName(txt_name.getText());
		selected_author.setCity(cbo_city.getValue());

		DatabaseService.updateAuthor(selected_author);
		clear();
		loadAuthors();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_author.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		col_city.setCellValueFactory(new PropertyValueFactory<>("city"));
		loadAuthors();
		List<String> year = List.of("Yangon", "Mandalay", "Pathein", "Pyin Oo Lwin");
		cbo_city.setItems(FXCollections.observableArrayList(year));
		tbl_author.getSelectionModel().selectedItemProperty().addListener((obs, old_select, new_select) -> {
			if (new_select != null) {
				var author = tbl_author.getSelectionModel().getSelectedItem();
				dob_birthday.setValue(author.getBirthday());
				cbo_city.setValue(author.getCity());
				txt_name.setText(author.getName());
			}
		});
	}

	private void loadAuthors() {

		List<Author> authors = DatabaseService.findAllAuthors();
		tbl_author.setItems(FXCollections.observableArrayList(authors));

	}
}
