package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.*;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import java.util.*;

public class Aims {
	
	private static Store store = new Store();
	private static Cart cart = new Cart();
	private static Scanner scanner = new Scanner(System.in);
	
	private static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	private static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	private static void mediaDetailsPlayableMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	private static void mediaDetailsOtherMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1");
	}
	
	private static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove medias from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	private static void sortMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	private static void filterMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	private static void updateMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media");
		System.out.println("2. Remove a media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	private static void addMediaMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add DVD");
		System.out.println("2. Add CD");
		System.out.println("3. Add book");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	private static void addDVDMenu() {
		System.out.println("Add DVD options: ");
		System.out.println("--------------------------------");
		System.out.println("1. By title");
		System.out.println("2. By title, category, cost");
		System.out.println("3. By title, category, director, cost");
		System.out.println("4. By title, category, director, length, cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	private static void addCDMenu() {
		System.out.println("Add CD options: ");
		System.out.println("--------------------------------");
		System.out.println("1. By title, artist");
		System.out.println("2. By title, artist, category, cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	private static void addBookMenu() {
		System.out.println("Add book options: ");
		System.out.println("--------------------------------");
		System.out.println("1. By title");
		System.out.println("2. By title, category, cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	private static int getOption(int upper) {
		int option = scanner.nextInt();
		String s = "Please choose a number: ";
		for (int i = 0; i < upper; ++i)
			s += i + "-";
		s += upper;
		
		while (option < 0 || option > upper) {
			System.out.println(s);
			option = scanner.nextInt();
		}
		
		return option;
	}
	
	private static Media getMediaInStore() {
		System.out.println("Enter media name: ");
		String mediaName = scanner.nextLine();
		
		Media curMedia = null;
		for (Media media : store.getItemsInStore())
			if (media.getTitle().equals(mediaName)) {
				curMedia = media;
				break;
			}
		
		if (curMedia == null) 
			System.out.println("Media \"" + mediaName + "\" not found");
		
		return curMedia;
	}

	private static Media getMediaInCart() {
		System.out.println("Enter media name: ");
		scanner.nextLine();
		String mediaName = scanner.nextLine();
		
		Media curMedia = null;
		for (Media media : cart.getItemsOrdered())
			if (media.getTitle().equals(mediaName)) {
				curMedia = media;
				break;
			}
		
		if (curMedia == null) 
			System.out.println("Media \"" + mediaName + "\" not found");
		
		return curMedia;
	}
	
	private static void viewStore() {
		int option = -1;
		while (option != 0) {
			storeMenu();
			store.print();
			option = getOption(4);
			scanner.nextLine();
			
			if (option == 1)
				seeMediaDetail(getMediaInStore()); //Done
			else if (option == 2)
				addMediaToCart(getMediaInStore()); //Done
			else if (option == 3)
				playMedia(getMediaInStore()); //Done
			else if (option == 4)
				seeCurrentCart(); //Done
		}
	}
	
	private static void updateStore() {
		int option = -1;
		while (option != 0) {
			updateMenu();
			option = getOption(2);
			scanner.nextLine();
			
			if (option == 1)
				addMediaToStore();
			else if (option == 2)
				removeMediaFromStore(getMediaInStore());
		}
	}
	
	private static void seeCurrentCart() {
		int option = -1;
		while (option != 0) {
			cartMenu();
			cart.print();
			option = getOption(5);
			scanner.nextLine();
			
			if (option == 1)
				filterMediaInCart(); //Done
			else if (option == 2)
				sortMediaInCart(); //Done
			else if (option == 3)
				removeMediaFromCart(getMediaInStore()); //Done
			else if (option == 4)
				playMedia(getMediaInCart()); //Done
			else if (option == 5)
				placeOrder(); //Done
		}
	}
	
	private static void seeMediaDetail(Media curMedia) {
		if (curMedia == null) 
			return;
		
		int option = -1;
		while (option != 0) {
			if (curMedia instanceof Playable) {
				mediaDetailsPlayableMenu();
				option = getOption(2);
			}
			else {
				mediaDetailsOtherMenu();
				option = getOption(1);
			}
			scanner.nextLine();
			
			if (option == 1)
				cart.addMedia(curMedia);
			else if (option == 2)
				playMedia(curMedia);
		}
	}
	
	private static void filterMediaInCart() {
		int option = -1;
		while (option != 0) {
			filterMenu();
			option = getOption(2);
			scanner.nextLine();
			
			if (option == 1) {
				System.out.println("ID: ");
				cart.search(scanner.nextInt());
				scanner.nextLine();
			}
			else if (option == 2) {
				System.out.println("Title: ");
				cart.search(scanner.nextLine());
			}
				
		}
	}
	
	private static void sortMediaInCart() {
		int option = -1;
		sortMenu();
		option = getOption(2);
		scanner.nextLine();
		
		if (option == 1) {
			cart.sortByTitle();
			System.out.println("Cart sorted by title");
		}
			
		else if (option == 2) {
			cart.sortByCost();
			System.out.println("Cart sorted by cost");
		}
	}
	
	private static void removeMediaFromStore(Media curMedia) {
		if (curMedia == null)
			return;
		store.removeMedia(curMedia);
	}
	
	private static void addDVDToStore(){
		String title = "";
		String category = "";
		String director = "";
		int length = 0;
		float cost = 0;
		
		int option = -1;	
		while (option != 0) {
			addDVDMenu();
			option = getOption(4);
			scanner.nextLine();
			
			if (option > 0) {
				System.out.println("Title: "); 
				title = scanner.nextLine();
			}
			if (option > 1) {
				System.out.println("Category: "); 
				category = scanner.nextLine();
				System.out.println("Cost: "); 	
				cost = scanner.nextFloat();
				scanner.nextLine();
			}
			if (option > 2) {
				System.out.println("Director: "); 
				director = scanner.nextLine();
			}
			if (option > 3) {
				System.out.println("Length: "); 	
				length = scanner.nextInt();
				scanner.nextLine();
			}
			
			if (option == 1)
				store.addMedia(new DigitalVideoDisc(title));
			else if (option == 2)
				store.addMedia(new DigitalVideoDisc(title, category, cost));
			else if (option == 3)
				store.addMedia(new DigitalVideoDisc(title, category, director, cost));
			else if (option == 4)
				store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
		}
	}
	
	private static void addCDToStore(){
		String title = "";
		String artist = "";
		String category = "";
		float cost = 0;
		
		int option = -1;	
		while (option != 0) {
			addCDMenu();
			option = getOption(2);
			scanner.nextLine();
			
			if (option > 0) {
				System.out.println("Title: "); 		
				title = scanner.nextLine();
				System.out.println("Artist: "); 		
				artist = scanner.nextLine();
			}
			if (option > 1) {
				System.out.println("Category: "); 
				category = scanner.nextLine();
				System.out.println("Cost: "); 	
				cost = scanner.nextFloat();
				scanner.nextLine();
			}
			
			if (option == 1)
				store.addMedia(new CompactDisc(title, artist));
			else if (option == 2)
				store.addMedia(new CompactDisc(title, artist, category, cost));
		}
	}
	
	private static void addBookToStore(){
		String title = "";
		String category = "";
		float cost = 0;
		
		int option = -1;	
		while (option != 0) {
			addBookMenu();
			option = getOption(2);
			scanner.nextLine();
			
			if (option > 0) {
				System.out.println("Title: ");
				title = scanner.nextLine();
			}			
			if (option > 1) {
				System.out.println("Category: "); category = scanner.nextLine();
				System.out.println("Cost: "); 	cost = scanner.nextFloat();
				scanner.nextLine();
			}
			
			if (option == 1)
				store.addMedia(new Book(title));
			else if (option == 2)
				store.addMedia(new Book(title, category, cost));
		}
	}
	
	private static void addMediaToStore() {
		int option = -1;		
		while (option != 0) {
			addMediaMenu();
			option = getOption(3);
			scanner.nextLine();
			
			if (option == 1)
				addDVDToStore(); //Done
			else if (option == 2)
				addCDToStore(); //Done
			else if (option == 3)
				addBookToStore(); //Done
		}
	}
	
	private static void removeMediaFromCart(Media curMedia) {
		if (curMedia == null)
			return;
		cart.removeMedia(curMedia);
	}
	
	private static void addMediaToCart(Media curMedia) {
		if (curMedia == null)
			return;
		cart.addMedia(curMedia);
	}
	
	private static void playMedia(Media curMedia) {
		if (curMedia == null)
			return;
		if (curMedia instanceof DigitalVideoDisc)
			((DigitalVideoDisc) curMedia).play();
		else if (curMedia instanceof CompactDisc)
			((CompactDisc) curMedia).play();
		else
			System.out.println("Cannot play \"" + curMedia.getTitle() + "\"");
	}
	
	private static void placeOrder() {
		List<Media> itemsOrdered = cart.getItemsOrdered();
		
		if (itemsOrdered.size() == 0) {
			System.out.println("There is no mediae in the cart.");
			return;
		}
		
		for (int i = itemsOrdered.size() - 1; i >= 0; --i)
			cart.removeMedia(itemsOrdered.get(i));
		
		System.out.println("An order is created");
	}

	public static void setStore(Store store) {
		Aims.store = store;
	}

	public static void main(String[] args) {
		int option = -1;
		while (option != 0) {
			showMenu();
			option = getOption(3);
			scanner.nextLine();
			
			if (option == 1)
				viewStore(); //Done
			else if (option == 2)
				updateStore(); //Done
			else if (option == 3) //Done
				seeCurrentCart();
		}
	}
}