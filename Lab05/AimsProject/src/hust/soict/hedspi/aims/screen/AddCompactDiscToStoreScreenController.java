package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class AddCompactDiscToStoreScreenController {

	private Store store;
	private AddCompactDiscToStoreScreen addCdFrame;
	
	@FXML
    private Label lbAddStatus;

    @FXML
    private TextField tfArtist;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfTitle;
	
	public AddCompactDiscToStoreScreenController(AddCompactDiscToStoreScreen addCdFrame) {
		this.store = StoreScreen.getStore();
		this.addCdFrame = addCdFrame;
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
		if (tfArtist.getText() == "") {
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
		
		store.addMedia(new CompactDisc(tfTitle.getText(), tfArtist.getText(), tfCategory.getText(), tfCost.getText()));
		lbAddStatus.setTextFill(Color.GREEN);
		lbAddStatus.setText("CD \"" + tfTitle.getText().strip() + "\" has been added to the store.");
		tfTitle.setText(""); tfArtist.setText(""); tfCategory.setText(""); tfCost.setText("");
    }

    @FXML
    void btnViewCartPressed(ActionEvent event) {
    	this.addCdFrame.setVisible(false);
		new CartScreen(StoreScreen.getCart());
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	this.addCdFrame.setVisible(false);
		new StoreScreen();
    }

    @FXML
    void miAddBook(ActionEvent event) {
    	this.addCdFrame.setVisible(false);
    	new AddBookToStoreScreen();
    }

    @FXML
    void miAddDvd(ActionEvent event) {
    	this.addCdFrame.setVisible(false);
    	new AddDigitalVideoDiscToStoreScreen();
    }
	
}