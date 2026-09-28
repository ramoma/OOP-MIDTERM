import viewers.Window;
import Controls.dbController;

import javax.swing.JOptionPane;


public class Main {
	
	public static void main(String[] args) {
		
		dbController db = new dbController();
		
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
