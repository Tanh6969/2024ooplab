package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.screen.manager.StoreScreen;
import hust.soict.hedspi.aims.screen.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import hust.soict.hedspi.aims.media.*;
import javafx.application.Platform;
import hust.soict.hedspi.aims.cart.*;
import hust.soict.hedspi.aims.screen.manager.AddToCartDialog;
import hust.soict.hedspi.aims.screen.customer.PlayDialog;
import hust.soict.hedspi.aims.screen.customer.StoreScreen;

public class MediaStore extends JPanel{
	private Media media;
	private Cart cart;
	
	public MediaStore(StoreScreen storeFrame, Media media, Cart cart) {
		this.media = media;
		this.cart = cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + "$");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		container.add(setAddToCart(storeFrame));
		if (media instanceof Playable) 
			container.add(setPlayButton(storeFrame));
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private JButton setPlayButton(StoreScreen storeFrame) {
		JButton playButton = new JButton("Play");
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PlayDialog(storeFrame, media);
			}
		});
		return playButton;
	}
	
	private JButton setAddToCart(StoreScreen storeFrame) {
		JButton addToCartButton = new JButton("Add to cart");
		addToCartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AddToCartDialog(storeFrame, media);
					cart.addMedia(media);
				} catch (Exception err) {};
			}
		});
		return addToCartButton;
	}
}