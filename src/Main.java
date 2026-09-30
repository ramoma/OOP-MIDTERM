

import Controls.statusHandler;
import viewers.gameOver;
import viewers.nameSprite;
import Controls.dbController;

import javax.swing.JOptionPane;



public class Main {
	
	private static dbController db = new dbController();
	private static statusHandler statusH = new statusHandler();
	
	public static void main(String[] args) {
		
//		nameSprite name = new nameSprite();
//		gameOver frame = new gameOver();
//		frame.setVisible(true);
		statusH.initSprite();
		dbController.checkSpriteAlive();
		
		
		
	}
	

	
}
