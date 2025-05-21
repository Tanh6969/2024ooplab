package hust.soict.hedspi.aims.screen;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class AddBookToStoreScreenController {
	private Store store;
	private AddBookToStoreScreen addBookFrame;
	
	@FXML
    private Label lbAddStatus;

    @FXML
    private TextField tfAuthors;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfTitle;
	
	public AddBookToStoreScreenController(AddBookToStoreScreen addBookFrame) {
		this.store = StoreScreen.getStore();
		this.addBookFrame = addBookFrame;
	}
	
	private boolean isDouble(String s) {
		try {Float.parseFloat(tfCost.getText()); return true;} catch (Exception e) {return false;}
	}
	
	@FXML
    void btnAddPressed(ActionEvent event) {
		boolean isValid = true;
		if (tfTitle.getText() == "") {
			isValid = false;
			
		}
		if (tfAuthors.getText() == "") {
			isValid = false;
			
		}
		if (tfCategory.getText() == "") {
			isValid = false;
			
		}
		if (tfCost.getText() == "") {
			isValid = false;
			
		}
		if (!isDouble(tfCost.getText().strip())) {
			isValid = false;
			
		}
		
		if (!isValid)
			return;
		
		store.addMedia(new Book(tfTitle.getText(), tfAuthors.getText(), tfCategory.getText(), tfCost.getText()));
		lbAddStatus.setTextFill(Color.GREEN);
		lbAddStatus.setText("Book \"" + tfTitle.getText().strip() + "\" has been added to the store.");
		tfTitle.setText(""); tfAuthors.setText(""); tfCategory.setText(""); tfCost.setText("");
    }

    @FXML
    void btnViewCartPressed(ActionEvent event) {
    	this.addBookFrame.setVisible(false);
		new CartScreen(StoreScreen.getCart());
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	this.addBookFrame.setVisible(false);
		new StoreScreen();
    }

    @FXML
    void miAddCd(ActionEvent event) {
    	this.addBookFrame.setVisible(false);
    	new AddCompactDiscToStoreScreen();
    }

    @FXML
    void miAddDvd(ActionEvent event) {
    	this.addBookFrame.setVisible(false);
    	new AddDigitalVideoDiscToStoreScreen();
    }

}