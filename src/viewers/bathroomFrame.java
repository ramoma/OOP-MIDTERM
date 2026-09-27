package viewers;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bathroomFrame extends JPanel{

	private static int bathPosX = 300;
	private static int bathPosY = 300;
	
	private static Image sprite = new ImageIcon(bathroomFrame.class.getResource("/sprites/idle.gif")).getImage();
	private static Image spriteHappy = new ImageIcon(bathroomFrame.class.getResource("/sprites/happy.png")).getImage();
	private static Image bathroom = new ImageIcon(bathroomFrame.class.getResource("/backgrounds/bathroom.gif")).getImage();
	
	bathroomFrame(){
		
		setLayout(null);
		
	}
	
	public void takeBath() {
		
		
		
	}
	
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics g2D = (Graphics2D) g;
		
		g2D.drawImage(bathroom, 0,0, this);
		g2D.drawImage(sprite, 55, 370, this);
		
	}

}
