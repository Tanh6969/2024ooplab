package hust.soict.hedspi.aims.screen.customer.controller;


import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;



public class CartController {
   private final Store store;
    private final Cart cart;
    public CartController(Cart cart, Store store){
        this.cart = cart;
        this.store = store;
    }

    

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;


    @FXML
    private TextField tfFilter;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterGroup;

    @FXML
    private TableView<Media> tblMedia;



    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if ( media instanceof Playable){
            if(media instanceof DigitalVideoDisc dvd){
                dvd.play();


                // Display the dialog pane
                javafx.scene.control.Dialog<Button> dialog = new javafx.scene.control.Dialog<>();
                DialogPane dialogPane = new DialogPane();
                dialogPane.setHeaderText("Playing: " + dvd.getTitle());
                dialogPane.setContentText("Media is now playing...");

                Label details = new Label(
                        "Length: " + dvd.getLength() + " minutes\n" +
                                "Director: " + dvd.getDirector() + "\n" +
                                "Category: " + dvd.getCategory()
                );
                dialogPane.setExpandableContent(details);
                // Thêm nút Close
                ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.OK_DONE);
                dialogPane.getButtonTypes().add(closeButton);
                dialog.setDialogPane(dialogPane);
                dialog.showAndWait();
            }else if(media instanceof CompactDisc cd){
                cd.play();


                // Display the dialog pane
                javafx.scene.control.Dialog<Button> dialog = new javafx.scene.control.Dialog<>();
                DialogPane dialogPane = new DialogPane();
                dialogPane.setHeaderText("Playing: " + cd.getTitle());
                dialogPane.setContentText("Media is now playing...");

                Label details = new Label(
                        "Length: " + cd.getLength() + " minutes\n" +
                                "Director: " + cd.getDirector() + "\n" +
                                "Category: " + cd.getCategory()
                );
                dialogPane.setExpandableContent(details);
                // Thêm nút Close
                ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.OK_DONE);
                dialogPane.getButtonTypes().add(closeButton);
                dialog.setDialogPane(dialogPane);
                dialog.showAndWait();
            }

        }


    }

    void updateCostLabel(){
        float totalCost = 0;
        for (Media media: cart.getItemsOrdered()){
            totalCost += media.getCost();
        }
        costLabel.setText( totalCost + "$");
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        updateCostLabel();

    }

    @FXML
    void viewStorebtnPressed(ActionEvent event) {
        try{
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"));
            ViewStoreController controller = new ViewStoreController(store,cart);
            fxmlloader.setController(controller);

            Parent root = fxmlloader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    @FXML
    public void initialize(){
        colMediaId.setCellValueFactory(
                new PropertyValueFactory<Media, Integer>("id")
        );
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title")
        );
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category")
        );
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost")
        );

        if(cart.getItemsOrdered() != null){
            tblMedia.setItems(cart.getFilteredItemsOrdered());

        }
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);

            }
        });

        radioBtnFilterId.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // If selected
                showFilteredMedia(tfFilter.getText());
            }
        });

        radioBtnFilterTitle.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { // If selected
                showFilteredMedia(tfFilter.getText());
            }
        });

        updateCostLabel();







    }

    @FXML
    

    void updateButtonBar(Media media){
        if (media == null){
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }else{
            btnRemove.setVisible(true);
            if (media instanceof Playable){
                btnPlay.setVisible(true);
            }else{
                btnPlay.setVisible(false);
            }

        }
    }



    void showFilteredMedia(String filter) {
        if (radioBtnFilterId.isSelected()) {
            // Filter by ID
            cart.getFilteredItemsOrdered().setPredicate(media -> String.valueOf(media.getId()).contains(filter));
        } else if (radioBtnFilterTitle.isSelected()) {
            // Filter by Title
            cart.getFilteredItemsOrdered().setPredicate(media -> media.getTitle().toLowerCase().contains(filter.toLowerCase()));
        }
    }


    @FXML
    void placeOrderbtnPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Cart");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty. Please add items before placing an order.");
            alert.showAndWait();
        } else {
            cart.emptyCart();
            updateCostLabel();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Placed");
            alert.setHeaderText(null);
            alert.setContentText("Your order has been successfully placed!");
            alert.showAndWait();
        }
    }





}