package hust.soict.hedspi.aims.screen.manager;
import hust.soict.hedspi.aims.screen.*;
import hust.soict.hedspi.aims.media.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import hust.soict.hedspi.aims.media.*;

public class AddToCartDialog extends JDialog{
	
	private Media media;
	
	AddToCartDialog(JFrame frame, Media media){
		this.media = media;
		Container cp = getContentPane();
		
		String label = "<html>\"" + this.media.getTitle() + "\" has been added to cart.</html>";		
		JLabel jLabel = new JLabel(label);
		jLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		cp.add(jLabel);
		
		setLocationRelativeTo(frame);
		setVisible(true);
		setTitle("Add to cart");
		pack();
	}
	
}