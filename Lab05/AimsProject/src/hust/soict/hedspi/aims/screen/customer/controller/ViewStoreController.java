package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewStoreController {

    public Store store;
    public Cart cart;
    @FXML
    private GridPane gridPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml"));
            fxmlLoader.setController(new CartController(cart,store));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

public ViewStoreController(){

}

public ViewStoreController(Store store){
    this.store = store;
    this.cart = new Cart();
}
public ViewStoreController(Store store,Cart cart){
    this.store = store;
    this.cart = cart;
}

@FXML
public void initialize(){
    if (store == null) {
        System.err.println("Error: Store is null. Make sure to set the store before initializing the view.");
        return;
    }

    final String ITEM_FXML_FILE_PATH="/hust/soict/hedspi/aims/screen/customer/view/item.fxml";
    int column = 0;
    int row = 1;
    for (int i=0;i < store.getItemsInStore().size();i++){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
            ItemController itemController = new ItemController(cart);
            fxmlLoader.setController(itemController);
            AnchorPane anchorPane  = new AnchorPane();
            anchorPane = fxmlLoader.load();
            itemController.setData(store.getItemsInStore().get(i));



            if(column == 3){
                column = 0;
                row++;
            }
            gridPane.add(anchorPane,column++,row);

            GridPane.setMargin(anchorPane, new Insets(20,10,10,10));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}




}