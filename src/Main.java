import viewers.Window;
import viewers.gameOver;

import Controls.dbController;

import javax.swing.JOptionPane;


public class Main {
	
	public static void main(String[] args) {
		
		dbController db = new dbController();
//		gameOver window2 = new gameOver();
		if(db.checkChar()) {
			
			Window window = new Window();
			
		} else {
			String spriteName = JOptionPane.showInputDialog(null, "enter your sprites name");
		
			while(spriteName.isEmpty()) {
				
				spriteName = JOptionPane.showInputDialog(null, "Name must not be empty");
			}
		
			
			db.initSprite(spriteName);
			
			Window window = new Window();
		}
	}
	
}
