package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.screen.AddBookToStoreScreenController;
import hust.soict.hedspi.aims.store.Store;

import java.io.IOException;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddBookToStoreScreen extends JFrame{
	private AddBookToStoreScreen addBookFrame;
	
	public AddBookToStoreScreen() {
		super();
		
		this.addBookFrame = this;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Add Book");
		this.setVisible(true);
		setSize(1024, 768);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader (getClass().getResource("addbook.fxml"));				
					AddBookToStoreScreenController controller = new AddBookToStoreScreenController(addBookFrame);
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