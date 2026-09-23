package viewers;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;


public class Window extends JFrame{

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
	
	void createPlayBar() {
		
		JPanel mainContent = new JPanel();
		JPanel topBar = new JPanel();
		
		topBar.setPreferredSize(new Dimension(412, 46));
		
		mainContent.setPreferredSize(new Dimension(412, 553));
		mainContent.setBackground(Color.RED);
		
		
		getContentPane().add(mainContent, BorderLayout.CENTER);
		getContentPane().add(topBar, BorderLayout.NORTH);
		
	}
	
	void createActionsMenu() {
		
		JPanel mainBody = new JPanel();
		
		mainBody.setPreferredSize(new Dimension(412, 251));
		mainBody.setBackground(Color.ORANGE);
		
		getContentPane().add(mainBody, BorderLayout.SOUTH);
		
	}
	
}
