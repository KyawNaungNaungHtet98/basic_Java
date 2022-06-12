package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import application.Main;
import application.model.entity.DatabaseService;
import application.model.service.Author;
import application.model.service.Book;
import application.model.service.Category;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditBookController implements Initializable {
	@FXML
	private ComboBox<String> cbo_author;

	@FXML
	private ComboBox<String> cbo_category;

	@FXML
	private TableColumn<Book, String> col_author;

	@FXML
	private TableColumn<Book, Integer> col_avaliable;

	@FXML
	private TableColumn<Book, String> col_category;

	@FXML
	private TableColumn<Book, String> col_created_by;

	@FXML
	private TableColumn<Book, Integer> col_id;

	@FXML
	private TableColumn<Book, String> col_title;

	@FXML
	private TableView<Book> tbl_book;

	@FXML
	private TextField txt_author;

	@FXML
	private TextField txt_book_title;

	@FXML
	private TextField txt_category;

	@FXML
	private TextField txt_title;

	private List<Book> bookList;
	private List<Author> authorList;
	private List<Category> categoryList;

	@FXML
	void btn_add_click(ActionEvent event) {
		String title = txt_book_title.getText();
		int author_index = cbo_author.getSelectionModel().getSelectedIndex();
		int category_index = cbo_category.getSelectionModel().getSelectedIndex();
		if (title.isEmpty()) {
			showAlert(AlertType.INFORMATION, "Please Enter Book title ");
			return;
		}
		if (author_index == -1) {
			showAlert(AlertType.INFORMATION, "Please Choose Author");
			return;
		}
		if (category_index == -1) {
			showAlert(AlertType.INFORMATION, "Please Choose Index");
			return;
		}

		Book b = new Book();
		b.setTitle(title);
		b.setAuthor(authorList.get(author_index));
		b.setCategory(categoryList.get(category_index));
		b.setUser(LoginController.login_user);
		boolean rs = DatabaseService.addBook(b);
		if (rs == true) {
			showAlert(AlertType.INFORMATION, "Successful for Add book");
			loadBook();
			clearAddtext();
		} else {
			showAlert(AlertType.INFORMATION, "Fail to add book");
			loadBook();
			clearAddtext();
		}
	}

	private void clearAddtext() {
		txt_book_title.setText(null);
		cbo_author.setValue(null);
		cbo_category.setValue(null);

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
	void btn_delete_click(ActionEvent event) {
		Book b = tbl_book.getSelectionModel().getSelectedItem();
		if (b != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Are u sure to delete");
			alert.setHeaderText(null);
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				if (DatabaseService.deleteBook(b)) {
					showAlert(AlertType.INFORMATION, "Deleted");
					clearAddtext();
					loadBook();
				} else {
					showAlert(AlertType.ERROR, "Something is wrong");
					loadBook();
					clearAddtext();
				}
			}
		}
	}

	@FXML
	void btn_search_click(ActionEvent event) {
		String name = txt_author.getText();
		String title = txt_title.getText();
		String category = txt_category.getText();
		var bookList = DatabaseService.searchBook(name, title, category);
		if (bookList.size() > 0) {
			tbl_book.setItems(FXCollections.observableArrayList(bookList));
			clear();
		} else {
			tbl_book.setItems(null);
			clear();
		}
	}

	private void clear() {
		txt_author.setText(null);
		txt_title.setText(null);
		txt_category.setText(null);

	}

	@FXML
	void btn_update_click(ActionEvent event) {
		Book b = new Book();
		b.setTitle(txt_book_title.getText());
		b.setAuthor(authorList.get(cbo_author.getSelectionModel().getSelectedIndex()));
		b.setCategory(categoryList.get(cbo_category.getSelectionModel().getSelectedIndex()));

		if (DatabaseService.updateBook(b)) {
			showAlert(AlertType.INFORMATION, "Update success");
			clearAddtext();
			loadBook();
		} else {
			showAlert(AlertType.ERROR, "Something is wrong");
			loadBook();
			clearAddtext();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_id.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
		col_avaliable.setCellValueFactory(new PropertyValueFactory<>("available"));
		col_created_by.setCellValueFactory(new PropertyValueFactory<>("userName"));
		loadBook();
		loadCategorys();
		loadAuthors();
		tbl_book.getSelectionModel().selectedItemProperty().addListener((obs, old_select, new_select) -> {
			if (new_select != null) {
				var book = tbl_book.getSelectionModel().getSelectedItem();
				txt_book_title.setText(book.getTitle());
				cbo_author.setValue(book.getAuthorName());
				cbo_category.setValue(book.getCategoryName());
			}
		});
	}

	private void loadBook() {
		bookList = DatabaseService.vierAllBook();
		tbl_book.setItems(FXCollections.observableArrayList(bookList));

	}

	private void loadCategorys() {
		categoryList = DatabaseService.viewAllCategory();
		List<String> names = categoryList.stream().map(c -> c.getName()).toList();
		cbo_category.setItems(FXCollections.observableArrayList(names));

	}

	private void loadAuthors() {
		authorList = DatabaseService.findAllAuthors();
		List<String> names = authorList.stream().map(a -> a.getName()).collect(Collectors.toList());
		cbo_author.setItems(FXCollections.observableArrayList(names));
	}
}
