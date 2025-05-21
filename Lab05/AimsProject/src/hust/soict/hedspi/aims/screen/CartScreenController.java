package hust.soict.hedspi.aims.screen;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JFrame;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	
	private Cart cart;
	private CartScreen cartFrame;
	private FilteredList<Media> filteredByIdList;
	private FilteredList<Media> filteredByTitleList;
	
	@FXML
	private Label lbTotalCost;
	
	@FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
	public CartScreenController(CartScreen cartFrame, Cart cart) {
		this.cartFrame = cartFrame;
		this.cart = cart;
		filteredByIdList = new FilteredList<>(cart.getItemsOrdered(), temp -> true);
		filteredByTitleList = new FilteredList<>(cart.getItemsOrdered(), temp -> true);
	}
	
	public void initialize() {
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("title"));
		
		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("category"));
		
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float>("cost"));
		
		tblMedia.setItems(this.cart.getItemsOrdered());

		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener( 
				new ChangeListener<Media>() { 
					@Override 
					public void changed(ObservableValue<? extends Media> observable, 
							Media oldValue, 
							Media newValue) { 
						if (newValue != null) { 
							updateButtonBar(newValue); 
						} 
					} 
				});
		
		tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, 
						String oldValue, 
						String newValue) {
				showFilteredMedia(newValue);
				filteredByIdList.setPredicate(media -> {
					return media.isFilteredById(newValue);
				});
				filteredByTitleList.setPredicate(media -> {
					return media.isFilteredByTitle(newValue);
				});
			}
		});

		updateLbTotalCost();
	}
	
	void updateLbTotalCost() {
		lbTotalCost.setText(Double.toString(this.cart.getTotalCost()));
	}

	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable)
			btnPlay.setVisible(true);
		else
			btnPlay.setVisible(false);
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		updateLbTotalCost();
	}
	
	void showFilteredMedia(String newValue) {
		if (radioBtnFilterId.isSelected())
			tblMedia.setItems(filteredByIdList);
		else
			tblMedia.setItems(filteredByTitleList);
	}
	
	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
		new PlaceOrderDialog(cartFrame, cart);
		cart.clear();
	}
	
	@FXML
	void btnPlayPressed(ActionEvent event) {
		new PlayDialog(cartFrame, tblMedia.getSelectionModel().getSelectedItem());
	}
	
	@FXML
	void btnViewStorePressed(ActionEvent event) {
		this.cartFrame.setVisible(false);
		new StoreScreen();
	}
	
	@FXML
    void miAddBook(ActionEvent event) {
		this.cartFrame.setVisible(false);
    	new AddBookToStoreScreen();
    }

	@FXML
    void miAddCd(ActionEvent event) {
    	this.cartFrame.setVisible(false);
    	new AddCompactDiscToStoreScreen();
    }

    @FXML
    void miAddDvd(ActionEvent event) {
    	this.cartFrame.setVisible(false);
    	new AddDigitalVideoDiscToStoreScreen();
    }
	
}