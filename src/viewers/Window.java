package viewers;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame{
	
	private static JButton action1;
	private static JPanel mainContent = new JPanel();
	private static outdoorFrame outdoor = new outdoorFrame();
	private static indoorFrame indoor = new indoorFrame();

	public Window(){
		
		setTitle("My Little Ghibli");
		setSize(512,917);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		
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
		mainContent.add(outdoor, BorderLayout.CENTER);
		
		
		getContentPane().add(mainContent, BorderLayout.CENTER);
		getContentPane().add(topBar, BorderLayout.NORTH);
		
	}
	
	private void createActionsMenu() {
		
		JPanel mainBody = new JPanel();
		
		action1 = new JButton("Change Screen");
		action1.setPreferredSize(new Dimension(144,53));
		action1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				repaintMainContent(indoor);
			}
		});
		
		
		mainBody.setPreferredSize(new Dimension(412, 251));
		mainBody.setBackground(Color.ORANGE);
		mainBody.setLayout(new FlowLayout());
		
		mainBody.add(action1);
		
		getContentPane().add(mainBody, BorderLayout.SOUTH);
		
	}
	
	private void repaintMainContent(JPanel panel) {
		
		mainContent.removeAll();
		mainContent.repaint();
		mainContent.revalidate();
		
		mainContent.add(panel);
		
	}
	
}
