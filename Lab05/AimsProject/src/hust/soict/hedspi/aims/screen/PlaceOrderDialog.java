package hust.soict.hedspi.aims.screen;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import hust.soict.hedspi.aims.cart.Cart;

public class PlaceOrderDialog extends JDialog{
	
	PlaceOrderDialog(JFrame frame, Cart cart){
		Container cp = getContentPane();
		
		String label = "<html> An order has been placed.<br>Your total cost: " + cart.getTotalCost() + " $</html>";
		if (cart.getItemsOrdered().size() == 0)
			label = "<html>No items in cart.</html>";
		JLabel jLabel = new JLabel(label);
		jLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		cp.add(jLabel);
		
		setLocationRelativeTo(frame);
		setVisible(true);
		setTitle("Place order");
		pack();
	}
	
}