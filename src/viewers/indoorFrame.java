package viewers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controls.statusHandler;

public class indoorFrame extends JPanel{
	
	private static Image awakeSprite = new ImageIcon(outdoorFrame.class.getResource("/sprites/idle.gif")).getImage();
	private static Image sleepingSprite = new ImageIcon(outdoorFrame.class.getResource("/sprites/sleeping.png")).getImage();
	private static Image happySprite = new ImageIcon(outdoorFrame.class.getResource("/sprites/happy.png")).getImage();
	
	private static Image background = new ImageIcon(outdoorFrame.class.getResource("/backgrounds/indoors.gif")).getImage();
	private static Image bread = new ImageIcon(outdoorFrame.class.getResource("/sprites/food/bread.png")).getImage();
	private static JPanel lightOff = new JPanel();
	
	private static Timer eatTimer;
	private static Timer sleepTimer;
	
	private static statusHandler statusH = new statusHandler();
	
	private static boolean isSleeping = false;
	private static boolean isEating = false;
	
	public indoorFrame(){
		
		setLayout(null);
		
		setPreferredSize(new Dimension(412, 553));
		
		
	}
	
	public void eat() {
		
		isEating = true;
		
		eatTimer = new Timer(3000, e ->{

			isEating = false;
		});
		eatTimer.setRepeats(false);
		eatTimer.start();
		
	}
	
	public void sleep(){
		
		isSleeping = true;
		lightOff.setSize(new Dimension(533,533));
		lightOff.setBackground(new Color(0f,0f,0f,.5f));
		
		add(lightOff);
		revalidate();
		repaint();
		
	}
	
	public void wakeSprite() {
		
		isSleeping = false;
		reDraw(lightOff);
		
	}
	
	public boolean checkIsSleeping() {return isSleeping;}
	
	public boolean checkIsEating() {return isEating;}
	
	public void reDraw(JPanel panel) {
		
		remove(panel);
		repaint();
		revalidate();
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.drawImage(background, 0,0,this);
		
		if (isSleeping) {
			
			g2D.drawImage(sleepingSprite,50,400, this);
			
		} else if (isEating) {

			g2D.drawImage(happySprite, 50,400,this);
			g2D.drawImage(bread, 160,400,this);
			
		}
		
		else {
			
			g2D.drawImage(awakeSprite, 50,400,this);
			
		}
		
		
	}
	
}
