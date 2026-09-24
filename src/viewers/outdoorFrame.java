package viewers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class outdoorFrame extends JPanel{
	
	
	private static Image background = new ImageIcon(outdoorFrame.class.getResource("/backgrounds/outdoors.gif")).getImage();
//	private static Image something = new ImageIcon(outdoorFrame.class.getResource("/backgrounds/peenar.gif")).getImage();
	
	outdoorFrame(){
		setPreferredSize(new Dimension(412, 553));
	}
	
	
	
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.drawImage(background, 0,0,this);	
		
	}

}
