package viewers;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame{
	
	private static JButton action1;
	private static JButton action2;
	private static JButton action3;
	private static JButton action4;
	private static JPanel mainContent = new JPanel();
	private static outdoorFrame outdoor = new outdoorFrame();
	private static indoorFrame indoor = new indoorFrame();
	private static bathroomFrame bathroom = new bathroomFrame();
	
	private static Image icon = new ImageIcon(Window.class.getResource("/sprites/icon.png")).getImage();
	private static ImageIcon outdoorButton = new ImageIcon(Window.class.getResource("/buttons/Basket.png"));
	private static ImageIcon foodButton = new ImageIcon(Window.class.getResource("/buttons/Eat.png"));
	private static ImageIcon bathroomButton = new ImageIcon(Window.class.getResource("/buttons/Bath.png"));

	public Window(){
		
		setTitle("My Little Ghibli");
		setSize(512,917);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		setIconImage(icon);
		setLocationRelativeTo(null);
		
		setFocusable(false);
		
		createPlayBar();
		createActionsMenu();
		
		setVisible(true);
	
	}
	
	private void createPlayBar() {
		
		mainContent = new JPanel();
		JPanel topBar = new JPanel();
		
		topBar.setPreferredSize(new Dimension(412, 46));
		
		mainContent.setPreferredSize(new Dimension(412, 553));
		mainContent.setBackground(Color.RED);
		mainContent.setLayout(new BorderLayout());
		mainContent.add(indoor, BorderLayout.CENTER);
		
		getContentPane().add(mainContent, BorderLayout.CENTER);
		getContentPane().add(topBar, BorderLayout.NORTH);
		
	}
	
	private void createActionsMenu() {
		
		JPanel mainBody = new JPanel();
		
		action1 = new JButton("Go Indoors");
		action1.setPreferredSize(new Dimension(144,53));
		action1.setFocusable(false);
		action1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				outdoor.endThread();
				repaintMainContent(indoor);
			}
		});
		
		action2 = new JButton();
		action2.setIcon(outdoorButton);
		action2.setPreferredSize(new Dimension(100,100));
		action2.setFocusable(false);
		action2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				
				int pane = JOptionPane.showConfirmDialog(null, "Are you sure you want to play?", "exit", JOptionPane.YES_NO_OPTION);
				
				switch(pane) {
				
					case 0:
						outdoor.startThread();
						repaintMainContent(outdoor);
						break;
					case 1:
						return;
				
				}		
			}
		});
		
		action3 = new JButton();
		action3.setIcon(foodButton);
		action3.setPreferredSize(new Dimension(100,100));
		
		action4 = new JButton();
		action4.setIcon(bathroomButton);
		action4.setPreferredSize(new Dimension(100,100));
		action4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				
				repaintMainContent(bathroom);
				
			}
		});
		
		mainBody.setPreferredSize(new Dimension(412, 251));
		mainBody.setLayout(new FlowLayout());
		
		mainBody.add(action1);
		mainBody.add(action2);
		mainBody.add(action3);
		mainBody.add(action4);
		
		getContentPane().add(mainBody, BorderLayout.SOUTH);
		
	}
	
	private void repaintMainContent(JPanel panel) {
		
		mainContent.removeAll();
		mainContent.repaint();
		mainContent.revalidate();
		
		mainContent.add(panel);
		
	}
	
}
