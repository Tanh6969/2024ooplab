package hust.soict.hedspi.aims.screen;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import hust.soict.hedspi.aims.media.*;

public class PlayDialog extends JDialog{
	
	private Object playableObject;
	
	PlayDialog(JFrame frame, Object playableObject){
		this.playableObject = playableObject;
		Container cp = getContentPane();
		
		String label = "<html>";
		if (this.playableObject instanceof DigitalVideoDisc) {
			DigitalVideoDisc dvd = (DigitalVideoDisc) this.playableObject;
			label += "Playing DVD: " + dvd.getTitle() + "<br>";
			label += "DVD length: " + dvd.getLength() + "<br>";
		}
		else if (this.playableObject instanceof CompactDisc) {
			CompactDisc cd = (CompactDisc) this.playableObject;
			for (Track track : cd.getTracks()){
				label += "Playing track: " + track.getTitle() + "<br>";
				label += "Track length: " + track.getLength() + "<br>";
				label += "<br>";
			}
		}
		else if (this.playableObject instanceof Track) {
			Track track = (Track) this.playableObject;
			label += "Playing track: " + track.getTitle() + "<br>";
			label += "Track length: " + track.getLength() + "<br>";
		}
		else
			label += "This media cannot be played.";
		label += "</html>";
		
		JLabel jLabel = new JLabel(label);
		jLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		cp.add(jLabel);
		
		setLocationRelativeTo(frame);
		setVisible(true);
		setTitle("Play");
		pack();
	}
	
}