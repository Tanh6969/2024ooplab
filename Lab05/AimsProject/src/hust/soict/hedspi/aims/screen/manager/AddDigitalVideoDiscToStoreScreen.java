package hust.soict.hedspi.aims.screen.manager;

import java.io.IOException;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddDigitalVideoDiscToStoreScreen extends JFrame{
	private AddDigitalVideoDiscToStoreScreen addDvdFrame;
	
	public AddDigitalVideoDiscToStoreScreen() {
		super();
		
		this.addDvdFrame = this;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Add Dvd");
		this.setVisible(true);
		setSize(1024, 768);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader (getClass().getResource("adddvd.fxml"));				
					AddDigitalVideoDiscToStoreScreenController controller = new AddDigitalVideoDiscToStoreScreenController(addDvdFrame);
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