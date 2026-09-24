package viewers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class indoorFrame extends JPanel{

	private static Image background = new ImageIcon(outdoorFrame.class.getResource("/backgrounds/peenar.gif")).getImage();
	indoorFrame(){
		
		JPanel mainContent = new JPanel();
		
		setPreferredSize(new Dimension(46, 46));
		setBackground(Color.GREEN);
		
		
	}
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.drawImage(background, 0,0,this);	
		
	}
	
}
