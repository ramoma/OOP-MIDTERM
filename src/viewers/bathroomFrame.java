package viewers;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import Controls.statusHandler;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bathroomFrame extends JPanel{

	private static boolean isBathing = false;
	
	private static Image sprite = new ImageIcon(bathroomFrame.class.getResource("/sprites/idle.gif")).getImage();
	private static Image spriteHappy = new ImageIcon(bathroomFrame.class.getResource("/sprites/happy.png")).getImage();
	private static Image bathroom = new ImageIcon(bathroomFrame.class.getResource("/backgrounds/bathroom.gif")).getImage();
	private static statusHandler statusH = new statusHandler();
	
	private static Timer bathTimer;
	
	bathroomFrame(){
		
		setLayout(null);
		
	}
	
	public boolean checkIsBathing() {return isBathing;}
	
	public boolean takeBath() {
		
		isBathing = true;
		bathTimer = new Timer(5000, e -> {
			
			isBathing = false;
			statusH.updateClean();
			
		});
		bathTimer.setRepeats(false);
		bathTimer.start();
		
		return true;
		
	}
	
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics g2D = (Graphics2D) g;
		
		g2D.drawImage(bathroom, 0,0, this);
		
		if(isBathing) {
			
			g2D.drawImage(spriteHappy, 260, 190, this);
			
		} else {
			
			g2D.drawImage(sprite, 55, 370, this);
			
		}
		
		
	}

}
