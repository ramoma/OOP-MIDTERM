package viewers;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import Controls.statusHandler;

public class gameOver extends JFrame{
	
	private static boolean isSaving;
	
	private static Image background = new ImageIcon(gameOver.class.getResource("/backgrounds/gameOver.png")).getImage();
	private static ImageIcon yesButton = new ImageIcon(gameOver.class.getResource("/buttons/restart.png"));
	private static ImageIcon noButton = new ImageIcon(gameOver.class.getResource("/buttons/no.png"));
	
	private static statusHandler statusH = new statusHandler();
	
	private static JButton saveButton;
	private static JButton cancelButton;
	
	private static JPanel buttonsPanel;
	
	private static JPanel panel = new JPanel() {
		
		@Override
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			Graphics2D g2D = (Graphics2D) g;
			
			g2D.drawImage(background,0,0,this);

		}
		
	};
	public gameOver(){
		
		setSize(new Dimension(553,553));
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		createButtons();
		setVisible(true);
	
	}
	
	private void createButtons() {
		
		saveButton = new JButton();
		saveButton.setFocusable(false);
		saveButton.setPreferredSize(new Dimension(300,300));
		saveButton.setBackground(new Color(0f,0f,0f,0f));
		saveButton.setIcon(yesButton);
		saveButton.setBorder(null);
		saveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				statusH.initSprite();
				
			}
			
		});
		
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
		buttonsPanel.setBackground(new Color(0f,0f,0f,0f));
		
		buttonsPanel.add(saveButton);
		buttonsPanel.setBounds(130,310,300,300);
		
		panel.setLayout(null);
		panel.add(buttonsPanel);
		
		add(panel);

	}
	
}
