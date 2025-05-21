package hust.soict.hedspi.aims.screen;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class AddDigitalVideoDiscToStoreScreenController {
	private Store store;
	private AddDigitalVideoDiscToStoreScreen addDvdFrame;
	
	@FXML
    private Label lbAddStatus;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfDirector;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfTitle;
	
	public AddDigitalVideoDiscToStoreScreenController(AddDigitalVideoDiscToStoreScreen addDvdFrame) {
		this.store = StoreScreen.getStore();
		this.addDvdFrame = addDvdFrame;
	}
	
	private boolean isDouble(String s) {
		try {Float.parseFloat(tfCost.getText()); return true;} catch (Exception e) {return false;}
	}
	
	private boolean isInt(String s) {
		try {Integer.parseInt(tfCost.getText()); return true;} catch (Exception e) {return false;}
	}
	
	@FXML
    void btnAddPressed(ActionEvent event) {
		boolean isValid = true;
		if (tfTitle.getText() == "") {
			isValid = false;
			
		}
		if (tfCategory.getText() == "") {
			isValid = false;
			
		}
		if (tfDirector.getText() == "") {
			isValid = false;
			
		}
		if (tfLength.getText() == "") {
			isValid = false;
			
		}
		if (!isInt(tfLength.getText().strip())) {
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
		
		store.addMedia(new DigitalVideoDisc(
				tfTitle.getText(), tfCategory.getText(), tfDirector.getText(), tfLength.getText(), tfCost.getText()));
		lbAddStatus.setTextFill(Color.GREEN);
		lbAddStatus.setText("DVD \"" + tfTitle.getText().strip() + "\" has been added to the store.");
		tfTitle.setText(""); tfCategory.setText(""); tfDirector.setText(""); tfLength.setText(""); tfCost.setText("");
    }

    @FXML
    void btnViewCartPressed(ActionEvent event) {
    	this.addDvdFrame.setVisible(false);
		new CartScreen(StoreScreen.getCart());
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	this.addDvdFrame.setVisible(false);
		new StoreScreen();
    }

    @FXML
    void miAddBook(ActionEvent event) {
    	this.addDvdFrame.setVisible(false);
    	new AddBookToStoreScreen();
    }

    @FXML
    void miAddCd(ActionEvent event) {
    	this.addDvdFrame.setVisible(false);
    	new AddCompactDiscToStoreScreen();
    }

}