package viewers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class indoorFrame extends JPanel{
	
	private static Image awakeSprite = new ImageIcon(outdoorFrame.class.getResource("/sprites/idle.gif")).getImage();
	private static Image background = new ImageIcon(outdoorFrame.class.getResource("/backgrounds/indoors.gif")).getImage();
	indoorFrame(){
		
		JPanel mainContent = new JPanel();
		
		setPreferredSize(new Dimension(412, 553));
		
		
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.drawImage(background, 0,0,this);	
		g2D.drawImage(awakeSprite, 50,400,this);
		
	}
	
}
