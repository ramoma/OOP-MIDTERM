package viewers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import Controls.*;


public class outdoorFrame extends JPanel implements Runnable{
	private static Thread gameThread;
	private static Image background = new ImageIcon(outdoorFrame.class.getResource("/backgrounds/outdoors.gif")).getImage();
	private static Image sprite = new ImageIcon(outdoorFrame.class.getResource("/sprites/idle.gif")).getImage();

	private static boolean isRunning = false;
	
	private static int speed = 3;
	private static int spriteX = 0;
	private static int spriteY = 400;
	private static int spriteBasketX = 0;
	private static int spritebaseketY = 300;
	private static ButtonsHandler handler = new ButtonsHandler();
	
	outdoorFrame(){
		
		addHierarchyListener(e -> {
		    if (isShowing()) {
		        requestFocusInWindow();
		    }
		});
		
		setPreferredSize(new Dimension(412, 553));
		setLayout(null);
		setFocusable(true);
		
		addKeyListener(handler);
	}
	
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.drawImage(background, 0,0,this);	
		
		g2D.drawImage(sprite, spriteX, spriteY, this);
	}

	public void updatePos() {
		
		if(handler.keyleft == true && spriteX > 0) {
			
			spriteX -= speed;
			
		} else if (handler.keyright == true && spriteX < 412) {
			spriteX += speed;
		}
		
	}
	
	public void startThread() {
		gameThread = new Thread(this);
		isRunning = true;
		gameThread.start();
	}
	
	public void endThread() {
		isRunning = false;
		
//		try {
			
			gameThread.interrupt();
			
//		} catch (InterruptedException e) {
//			e.getStackTrace();
//		}
		
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000/60;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(isRunning != false) {
			
			updatePos();
			
			repaint();
			
			try {
				
				double remainingTime = nextDrawTime - System.nanoTime();
				
				remainingTime /= 1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}


}
