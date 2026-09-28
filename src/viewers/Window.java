package viewers;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Controls.statusHandler;


public class Window extends JFrame{
	
	private static JButton action1;
	private static JButton action2;
	private static JButton action3;
	private static JButton action4;
	private static JButton action5;
	
	private static JPanel mainContent = new JPanel();
	private static outdoorFrame outdoor = new outdoorFrame();
	private static indoorFrame indoor = new indoorFrame();
	private static bathroomFrame bathroom = new bathroomFrame();
	private static JPanel mainBody = new JPanel();
	
	private static Image icon = new ImageIcon(Window.class.getResource("/sprites/icon.png")).getImage();
	private static ImageIcon outdoorButton = new ImageIcon(Window.class.getResource("/buttons/Basket.png"));
	private static ImageIcon foodButton = new ImageIcon(Window.class.getResource("/buttons/Eat.png"));
	private static ImageIcon bathroomButton = new ImageIcon(Window.class.getResource("/buttons/Bath.png"));
	private static ImageIcon sleepButton = new ImageIcon(Window.class.getResource("/buttons/Bed.png"));
	
	private JLabel happinessLabel;
	private JLabel hungerLabel;
	private JLabel energyLabel;
	private JLabel cleanLabel;
	
	private static statusHandler statusH = new statusHandler();
	private static Timer refreshTimer;
	
	
	

	public Window(){
		
		setTitle("My Little Ghibli");
		setSize(512,917);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		setIconImage(icon);
		setLocationRelativeTo(null);
		
		statusH.setStatus();
		statusH.startHandler();
		startRefreshTimer();
		
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
		
		mainBody = new JPanel();
	
		JPanel basketPanel = new JPanel();
		basketPanel.setPreferredSize(new Dimension(100,200));
		basketPanel.setLayout(new FlowLayout());
		
		JPanel bedPanel = new JPanel();
		bedPanel.setPreferredSize(new Dimension(100,200));
		bedPanel.setLayout(new FlowLayout());
		
		JPanel bathroomPanel = new JPanel();
		bathroomPanel.setPreferredSize(new Dimension(100,200));
		bathroomPanel.setLayout(new FlowLayout());
		
		JPanel foodPanel = new JPanel();
		bathroomPanel.setPreferredSize(new Dimension(100,200));
		bathroomPanel.setLayout(new FlowLayout());
		
		happinessLabel = new JLabel();
		happinessLabel.setPreferredSize(new Dimension(100, 50));
		
		hungerLabel = new JLabel();
		hungerLabel.setPreferredSize(new Dimension(100, 50));
		
		energyLabel = new JLabel();
		energyLabel.setPreferredSize(new Dimension(100, 50));
		
		cleanLabel = new JLabel();
		cleanLabel.setPreferredSize(new Dimension(100, 50));
		
		refreshBars(); 
		
		action1 = new JButton("Go Indoors");
		action1.setPreferredSize(new Dimension(144,53));
		action1.setFocusable(false);
		action1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
//				outdoor.endThread();
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
		
		basketPanel.add(action2);
		basketPanel.add(happinessLabel);
		
		
		action3 = new JButton();
		action3.setIcon(foodButton);
		action3.setPreferredSize(new Dimension(100,100));
		
//		soemething goes here and i am about to fucking kill myself 
		
		action4 = new JButton();
		action4.setIcon(bathroomButton);
		action4.setPreferredSize(new Dimension(100,100));
		action4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				
				repaintMainContent(bathroom);
				
			}
		});
		
		bathroomPanel.add(action4);
		bathroomPanel.add(cleanLabel);
		
		action5 = new JButton();
		action5.setIcon(sleepButton);
		action5.setPreferredSize(new Dimension(100,100));
		action5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				
				if(indoor.checkIsSleeping()) {
					
					indoor.wakeSprite();
					statusH.updateSleep(indoor.checkIsSleeping());
					
				} else {
					
					indoor.sleep();
					statusH.updateSleep(indoor.checkIsSleeping());
					
				}
				
			}
		});
		
		bedPanel.add(action5);
		bedPanel.add(energyLabel);
		
		mainBody.setPreferredSize(new Dimension(412, 251));
		mainBody.setLayout(new FlowLayout());
		
//		mainBody.add(action1);
		mainBody.add(basketPanel);
		mainBody.add(action3);
		mainBody.add(bathroomPanel);
		mainBody.add(bedPanel);
		
		getContentPane().add(mainBody, BorderLayout.SOUTH);
		
	}
	
	private void refreshBars() {
	    happinessLabel.setIcon(statusH.getIconFor(statusH.getHappinessValue()));
	    hungerLabel.setIcon(statusH.getIconFor(statusH.getHappinessValue()));
	    energyLabel.setIcon(statusH.getIconFor(statusH.getHappinessValue()));
	    cleanLabel.setIcon(statusH.getIconFor(statusH.getHappinessValue()));
	    happinessLabel.setIcon(statusH.getIconFor(statusH.getHappinessValue()));
	}

	private void startRefreshTimer() {
	    refreshTimer = new Timer(3000, e -> refreshBars());
	    refreshTimer.start();
	}
	
	private void repaintMainContent(JPanel panel) {
		
		mainContent.removeAll();
		mainContent.repaint();
		mainContent.revalidate();
		
		mainContent.add(panel);
		
	}
	
}
