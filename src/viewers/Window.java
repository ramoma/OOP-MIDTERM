package viewers;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;

public class Window extends JFrame{
	
	Container c = getContentPane();

	public Window(){
		
		setTitle("My Little Ghibli");
		setSize(512,917);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		
	}
	
	void createPlayBar() {
		//passthis
	}
	
}
