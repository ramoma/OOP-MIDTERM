import viewers.Window;
import viewers.popupFrame;

import Controls.dbController;

import javax.swing.JOptionPane;



public class Main {
	
	private static dbController db = new dbController();
	
	public static void main(String[] args) {
		
		
//		popupFrame window2 = new popupFrame();
		
		initSprite();
		
	}
	
	private static void initSprite() {
		
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
