package Controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ButtonsHandler implements KeyListener{
	
	public boolean keyleft, keyright;
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		int action = e.getKeyCode();

		
		if(action == KeyEvent.VK_D) {
			keyright = true;
		} else if (action == KeyEvent.VK_A){
			keyleft = true;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int action = e.getKeyCode();

		
		if(action == KeyEvent.VK_D) {
			keyright = false;
		} else if (action == KeyEvent.VK_A){
			keyleft = false;
		}
		
	}

}
