package viewers;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Image;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class popupFrame extends JFrame{
	
	private static boolean isSaving;
	
	private static Image background = new ImageIcon(popupFrame.class.getResource("/backgrounds/gameOver.png")).getImage();
	private static JPanel diePanel = new JPanel();
	
	public popupFrame(){
		
		setSize(553,553);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	
	}
	
	
}
