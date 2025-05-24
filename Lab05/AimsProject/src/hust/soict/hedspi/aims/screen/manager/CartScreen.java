package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.screen.*;
import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.screen.customer.CartScreenController;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame{
	
	private Cart cart;
	private CartScreen cartFrame;
	
	public CartScreen(Cart cart) {
		super();
		
		this.cart = cart;
		this.cartFrame = this;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		setSize(1024, 768);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader (getClass()
							.getResource("cart.fxml"));				
					CartScreenController controller = 
							new CartScreenController(cartFrame, cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}