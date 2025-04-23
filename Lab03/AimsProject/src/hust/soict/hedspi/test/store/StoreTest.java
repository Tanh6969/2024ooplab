/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hust.soict.hedspi.test.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
/**
 *
 * @author Admin
 */
public class StoreTest {
      public static void main(String[] args) {
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = 
				new DigitalVideoDisc(
						"The Lion King", 
						"Animation", 
						"Roger Allers", 
						87,
						19.95f);
		store.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = 
				new DigitalVideoDisc(
						"Star Wars", 
						"Science Fiction", 
						"George Lucas", 
						87,
						24.95f);
		store.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = 
				new DigitalVideoDisc(
						"Aladin", 
						"Animation", 
						18.99f);
		store.addDigitalVideoDisc(dvd3);
		
		store.removeDigitalVideoDisc(dvd3);

	}
}
