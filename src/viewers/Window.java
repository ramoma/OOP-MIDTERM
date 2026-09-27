package viewers;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controls.ButtonsHandler;


public class Window extends JFrame{
	
	private static JButton action1;
	private static JButton action2;
	private static JButton action3;
	private static JButton action4;
	private static JPanel mainContent = new JPanel();
	private static outdoorFrame outdoor = new outdoorFrame();
	private static indoorFrame indoor = new indoorFrame();
	
	private static ImageIcon outdoorButton = new ImageIcon(Window.class.getResource("/buttons/Basket.png"));
	private static ImageIcon foodButton = new ImageIcon(Window.class.getResource("/buttons/Eat.png"));

	public Window(){
		
		setTitle("My Little Ghibli");
		setSize(512,917);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		
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
				repaintMainContent(indoor, outdoor);
			}
		});
		
		action2 = new JButton();
		action2.setIcon(outdoorButton);
		action2.setPreferredSize(new Dimension(100,100));
		action2.setFocusable(false);
		action2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				outdoor.startThread();
				repaintMainContent(outdoor, indoor);
				
			}
		});
		
		action3 = new JButton();
		action3.setIcon(foodButton);
		action3.setPreferredSize(new Dimension(100,100));
		
		action4 = new JButton();
		action4.setIcon(outdoorButton);
		action4.setPreferredSize(new Dimension(100,100));
		
		mainBody.setPreferredSize(new Dimension(412, 251));
		mainBody.setLayout(new FlowLayout());
		
		mainBody.add(action1);
		mainBody.add(action2);
		mainBody.add(action3);
		
		getContentPane().add(mainBody, BorderLayout.SOUTH);
		
	}
	
	private void repaintMainContent(JPanel panel, JPanel panel2) {
		
		mainContent.remove(panel2);
		mainContent.repaint();
		mainContent.revalidate();
		
		mainContent.add(panel);
		
	}
	
}
