package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import javax.naming.LimitExceededException;

public class ItemController {

    private Media media;
    private Cart cart;
    @FXML
    private Button btnAddToCart;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    private Button btnPlay;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    void btnAddtoCartClicked(ActionEvent event) throws LimitExceededException {
        cart.addMedia(media);
        // Implementation
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
        if (media instanceof DigitalVideoDisc dvd) {
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
        } else if (media instanceof CompactDisc cd) {
            try {
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
            } catch (PlayerException e) {
                // Hiển thị popup lỗi
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Media Player Error");
                    alert.setHeaderText("Cannot play this media");
                    alert.setContentText(e.getMessage()); // Hiển thị "ERROR: CD length is non-positive"
                    alert.showAndWait();
                });
            }
        }
    }

    public void setData(Media media){
        this.media = media;

        // Safely set text on labels
        if (lblTitle != null) {
            lblTitle.setText(media.getTitle());
        }

        if (lblCost != null) {
            lblCost.setText(media.getCost() + " $");
        }

        // Safely handle play button visibility
        if (btnPlay != null) {
            btnPlay.setVisible(media instanceof Playable);

            // Set margin if needed
            if (!(media instanceof Playable) && btnAddToCart != null) {
                HBox.setMargin(btnAddToCart, new Insets(0,0,0,100));
            }
        }
    }
}