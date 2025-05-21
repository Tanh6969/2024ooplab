package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;

import java.io.IOException;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddCompactDiscToStoreScreen extends JFrame{
	private AddCompactDiscToStoreScreen addCdFrame;
	
	public AddCompactDiscToStoreScreen() {
		super();
		
		this.addCdFrame = this;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Add Cd");
		this.setVisible(true);
		setSize(1024, 768);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader (getClass().getResource("addcd.fxml"));				
					AddCompactDiscToStoreScreenController controller = new AddCompactDiscToStoreScreenController(addCdFrame);
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