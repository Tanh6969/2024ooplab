package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.screen.manager.AddDigitalVideoDiscToStoreScreen;
import hust.soict.hedspi.aims.screen.manager.AddCompactDiscToStoreScreen;
import hust.soict.hedspi.aims.screen.manager.AddBookToStoreScreen;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.cart.*;
import hust.soict.hedspi.aims.media.*;

public class StoreScreen extends JFrame {
	private static Store store;
	private static Cart cart;
	private StoreScreen storeFrame;
	
	public StoreScreen() {
		this.storeFrame = this;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	
	public StoreScreen(Store newStore) {
		cart = new Cart();
		store = newStore;
		this.storeFrame = this;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		JMenuItem addBookMenuItem = new JMenuItem("Add Book");
		addBookMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				storeFrame.setVisible(false);
		    	new AddBookToStoreScreen();
			}
		});
		smUpdateStore.add(addBookMenuItem);
		
		JMenuItem addCdMenuItem = new JMenuItem("Add CD");
		addCdMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				storeFrame.setVisible(false);
		    	new AddCompactDiscToStoreScreen();
			}
		});
		smUpdateStore.add(addCdMenuItem);
		
		JMenuItem addDvdMenuItem = new JMenuItem("Add DVD");
		addDvdMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				storeFrame.setVisible(false);
		    	new AddDigitalVideoDiscToStoreScreen();
			}
		});
		smUpdateStore.add(addDvdMenuItem);
		
		menu.add(smUpdateStore);
		
		menu.add(new JMenuItem("View store"));
		JMenuItem cartButton = new JMenuItem("View cart");
		cartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				storeFrame.setVisible(false);
				new CartScreen(cart);			
			}
		});
		menu.add(cartButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cartButton = new JButton("View cart");
		cartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				storeFrame.setVisible(false);
				new CartScreen(cart);
			}
		});
		cartButton.setPreferredSize(new Dimension(100, 50));
		cartButton.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cartButton);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		List<Media> mediaInStore = this.store.getItemsInStore();
		for (int i = 0; i < 9; ++i) {
			if (i >= mediaInStore.size())
				break;
			MediaStore cell = new MediaStore(storeFrame, mediaInStore.get(i), cart);
			center.add(cell);
		}
		
		return center;
	}

	public static Store getStore() {
		return store;
	}

	public static Cart getCart() {
		return cart;
	}
	
}