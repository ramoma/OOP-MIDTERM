package viewers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class outdoorFrame extends JPanel{
	
	private static Image background = new ImageIcon("../assets/outoorBackGround.png").getImage();
	
	outdoorFrame(){
		
		setPreferredSize(new Dimension(412, 553));
		setBackground(Color.BLUE);
		
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.drawImage(background, 0,0,null);	
		g2D.drawLine(0,0,500,500);
		
	}

}
