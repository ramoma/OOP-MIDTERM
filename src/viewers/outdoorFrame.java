package viewers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
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
	private static Image bread = new ImageIcon(outdoorFrame.class.getResource("/sprites/food/bread.png")).getImage();
	private static Image apple = new ImageIcon(outdoorFrame.class.getResource("/sprites/food/egg.png")).getImage();
	private static Image water = new ImageIcon(outdoorFrame.class.getResource("/sprites/food/melon.png")).getImage();
	private static Image sushi = new ImageIcon(outdoorFrame.class.getResource("/sprites/food/sushi.png")).getImage();
	
	private static Image[] images = {bread, apple, water, sushi};
 
	private static boolean isRunning = false;
	private static statusHandler statusH = new statusHandler();
	
	private static int speed = 3;
	private static int spriteX = 0;
	private static int spriteY = 400;

	private List<FallingObject> fallingObjects = new ArrayList<>();
	private Random rand = new Random();
	private Random randf = new Random();
	private int spawnCounter = 0;
	private static final int SPAWN_INTERVAL = 60; // frames between spawns, tune to taste
	private static final int FALL_SPEED = 4;
	
	private static int foodS = 2;
	private static int foodX = 275;
	private static int foodY = 0;
	
	
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
	
	public Thread getThread() {return gameThread;}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.drawImage(background, 0,0,this);	
		
		g2D.drawImage(sprite, spriteX, spriteY, this);
		
	    for (FallingObject obj : fallingObjects) {
	        g2D.drawImage(obj.getImage(), obj.getObhX(), obj.getObjY(), this);
	    }
	}

	public void updatePos() {
		
		foodY += foodS;
		
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
		
		fallingObjects.clear();
		isRunning = false;
		statusH.unsetPlaying();
		gameThread.interrupt();
		
	}
	
	public void updateFallingObjects() {
	    
		int i = randf.nextInt(0,3);
	    spawnCounter++;
	    if (spawnCounter >= SPAWN_INTERVAL) {
	        spawnCounter = 0;
	        int x = rand.nextInt(getWidth() - 32); // 32 = object width
	        fallingObjects.add(new FallingObject(x, 0, 32, 32, images[i]));
	    }

	    // move + collide
	    Rectangle spriteBounds = new Rectangle(spriteX, spriteY, sprite.getWidth(null), sprite.getHeight(null));

	    Iterator<FallingObject> it = fallingObjects.iterator();
	    while (it.hasNext()) {
	        FallingObject obj = it.next();
	        obj.setObjY(obj.getObjY() + FALL_SPEED);

	        if (obj.getBounds().intersects(spriteBounds)) {
	            it.remove();        
	            continue;
	        }

	        if (obj.getObjY() > 400) {
	            it.remove();    
	            
	            endThread();
	            statusH.updateHappiness();
    			statusH.depleteHunger();
    			statusH.depleteClean();
    			statusH.depletenergy();
	            isRunning = false;
	            
	        }
	    }
	}

	public boolean gameEnd() {
		
		return isRunning;
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000/60;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(isRunning != false) {
			
			updatePos();
			updateFallingObjects();
			
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
