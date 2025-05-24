/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hust.soict.hedspi.test.screen.customer.store;
import hust.soict.hedspi.aims.*;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.screen.customer.*;
import hust.soict.hedspi.aims.store.Store;
/**
 *
 * @author Admin
 */
public class TestViewStoreScreen extends Application{
    private static Store store;
    public void start(Stage primaryStage) throws Exception
    {
        final String STORE_FXML_FILE_PATH = "hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();
        
        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
    public static void main(String[] args)
    {
      Track track1 = new Track("Turkish March", 2);
		Track track2 = new Track("Liebestraum", 3);
		Track track3 = new Track("Swan Lake", 5);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(
				"Tarzan", "Animation", "Jafar", 2, 18.25f);
		
		CompactDisc cd1 = new CompactDisc(
				"Classical Melody", "Various Artist", "Classical", 6.5f);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		cd1.addTrack(track3);
		
		Book book1 = new Book("DSA", "Textbook", 15.75f);
		book1.addAuthor("Nguyen Van A");
		Book book2 = new Book("Calculus III", "Textbook", 15.0f);
		book2.addAuthor("Bui Xuan Dieu");
		book2.addAuthor("Dao Tuan Anh");
		
		Store store = new Store();
		store.addMedia(dvd1);
		store.addMedia(cd1);
		store.addMedia(book1);
		store.addMedia(book2);
		
		
    }
}
