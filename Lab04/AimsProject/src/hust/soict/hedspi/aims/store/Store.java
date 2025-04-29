
package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.*;
import java.util.*;

public class Store {
	public static final int MAX_NUMBERS_IN_STORE = 100000;
	private List<Media> itemsInStore = new ArrayList<Media>();

	public List<Media> getItemsInStore() {
		return itemsInStore;
	}

	public void addMedia(Media media) {
		if (itemsInStore.size() == 20) {
			System.out.println("The cart is almost full");
			return;
		}
		
		if (itemsInStore.contains(media))
			System.out.println("\"" + media.getTitle() + "\" has existed.");
		else {
			itemsInStore.add(media);
			System.out.println("\"" + media.getTitle() + "\" has been added.");
		}
	}
	
	public void addMedia(Media[] mediaList) {
		for (Media media : mediaList) 
			addMedia(media);
	}
	
	public void addMedia(Media media1, Media media2) {
		addMedia(media1);
		addMedia(media2);
	}
	
	public void removeMedia(Media media) {
		for (Media item : itemsInStore)
			if (item.equals(media)) {
				itemsInStore.remove(media);
				System.out.println("\"" + media.getTitle() + "\" has been removed.");
				return;
			}
		System.out.println("\"" + media.getTitle() + "\" is not found");
	}

	public void print() {
		System.out.println("***********************STORE***********************");
		
		int i = 0;
		for (Media media : itemsInStore) {
			i += 1;
			System.out.println(i + ". " + media.toString());
		}
		
		System.out.println("***************************************************");
	}
	
}
