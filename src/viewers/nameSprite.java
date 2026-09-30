package viewers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Controls.dbController;
import Controls.statusHandler;

public class nameSprite extends JFrame{
	
	private static Image background = new ImageIcon(gameOver.class.getResource("/backgrounds/name.png")).getImage();
	private static ImageIcon yesButton = new ImageIcon(gameOver.class.getResource("/buttons/yes.png"));
	private static ImageIcon noButton = new ImageIcon(gameOver.class.getResource("/buttons/no.png"));
	
	private static JButton saveButton;
	private static JButton cancelButton;
	
	private static String spriteName;
	
	private boolean isNamed = false;
	
	private static statusHandler statusH = new statusHandler(); 
	private static dbController db = new dbController();
	
	private static JPanel buttonsPanel;
	
	private static JPanel panel = new JPanel() {
		
		@Override
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			Graphics2D g2D = (Graphics2D) g;
			
			g2D.drawImage(background,0,0,this);

		}
		
	};
	
	
	public nameSprite(){
		
		setSize(533,533);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		drawButtons();
		setVisible(true);
		
		
	}
		
	private void drawButtons() {
		
		JTextArea name = new JTextArea();
		name.setBounds(100,200,300,80);
		name.setFont(new Font("MV Boli", Font.BOLD, 50));

		saveButton = new JButton();
		saveButton.setFocusable(false);
		saveButton.setPreferredSize(new Dimension(100,100));
		saveButton.setOpaque(false);
		saveButton.setBackground(new Color(0f,0f,0f,0f));
		saveButton.setBorder(null);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				spriteName = name.getText();
				if(spriteName.isEmpty()) {
					
					System.out.print("nrowmn");
					System.out.print(spriteName);

					
				} else {
					
					isNamed = true;
					System.out.print(spriteName);
					db.initSprite(spriteName);
					
					
					dispose();
					
				}
					
				
			}
		});
		saveButton.setIcon(yesButton);
		
		cancelButton = new JButton();
		cancelButton.setFocusable(false);
		cancelButton.setPreferredSize(new Dimension(100,100));
		cancelButton.setOpaque(false);
		cancelButton.setBackground(new Color(0f,0f,0f,0f));
		cancelButton.setBorder(null);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				name.setText(null);
			}
		});
		cancelButton.setIcon(noButton);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setPreferredSize(new Dimension(240,100));
		buttonsPanel.setLayout(new FlowLayout());
		buttonsPanel.setBackground(new Color(0f,0f,0f,0f));
		buttonsPanel.setOpaque(false);
		
		buttonsPanel.add(saveButton);
		buttonsPanel.add(cancelButton);
		
		panel.setLayout(null);
		buttonsPanel.setBounds(150,390, 230,100);
		
		panel.add(name);
		panel.add(buttonsPanel);
		
		add(panel);
		
	}
	
	public boolean returnSprite() {return isNamed;}
	
	
}
