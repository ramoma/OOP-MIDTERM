package Controls;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;


import java.util.Random;


public class statusHandler{
	
	private static boolean isAlive = true;
	private static boolean isAsleep = false;
	private static int hunger;
	private static int happiness;
	private static int energy;
	private static int clean;
	private static Timer timer;
	private static Timer sleepTimer;
	private static dbController db = new dbController();
	
	private static ImageIcon currentStateHunger;
	private static ImageIcon currentStateHappiness;
	private static ImageIcon currentStateClean;
	private static ImageIcon currentStateEnergy;
	
	private static ImageIcon fullBar = new ImageIcon(statusHandler.class.getResource("/sprites/status/100_.png"));
	private static ImageIcon quarterBar = new ImageIcon(statusHandler.class.getResource("/sprites/status/75_.png"));
	private static ImageIcon halfBar = new ImageIcon(statusHandler.class.getResource("/sprites/status/50_.png"));
	private static ImageIcon lowBar = new ImageIcon(statusHandler.class.getResource("/sprites/status/30_.png"));
	private static ImageIcon depletedBar = new ImageIcon(statusHandler.class.getResource("/sprites/status/Low_.png"));
	
	public void startHandler(){
//180000
		timer = new Timer(3000, e ->depleteStats());
		timer.start();
		
	}
	
	public void setStatus() {
		
		int[] stats = db.getStats();
		
		hunger = stats[0];
		happiness = stats[1];
		energy = stats[2];
		clean = stats[3];
		
		return;
		
	}
	
	public void updateSleep(boolean isAsleep){
		
		System.out.println("penis");
		if(isAsleep) {
			
			sleepTimer = new Timer(180000, e-> {
				energy = 100;
			});
			
			sleepTimer.start();			
		} else {
			
			sleepTimer.stop();
			
		}
		
	}
	
	public boolean die() {
		
		if(timer != null) {
			timer.stop();
		}
		
		return false;
		
	}
	
	public void depleteStats() {
		
		if(hunger != 0 && happiness != 0 && energy != 0 && clean != 0) {
			
			int spec,spec1,spec2,spec3;
			Random rand = new Random();
			
			spec = rand.nextInt(0,8);
			spec1 = rand.nextInt(0,8);
			spec2 = rand.nextInt(0,8);
			spec3 = rand.nextInt(0,8);
			
			hunger -= spec1;
			happiness -= spec;
			energy -= spec3;
			clean -= spec2;
		
			System.out.println(currentStateHappiness);
			System.out.println(hunger);
			System.out.println(happiness);
			System.out.println(energy);
			System.out.println(clean);
			
		} else {
			
			die();
			
		}
	}
	
	
	
	public JLabel getHappiness() {
		
		
		JLabel panel = new JLabel();
		panel.setSize(100,50);
		
		if (happiness == 100) {
			
			currentStateHappiness = fullBar;

		} else if(happiness <=75) {
			
			currentStateHappiness = quarterBar;
			
		}
		panel.setIcon(currentStateHappiness);
		
		return panel;
		
	}
	
	public JLabel getHunger() {
		
		
		JLabel panel = new JLabel();
		panel.setSize(100,50);
		
		if (happiness == 100) {
			
			currentStateHappiness = fullBar;

		}
		panel.setIcon(currentStateHappiness);
		
		System.out.print(currentStateHappiness);
		
		return panel;
		
	}

	public JLabel getEnergy() {
		
		
		JLabel panel = new JLabel();
		panel.setSize(100,50);
		
		if (happiness == 100) {
			
			currentStateHappiness = fullBar;
	
		}
		panel.setIcon(currentStateHappiness);
		
		return panel;
		
	}

	public JLabel getClean() {
		
		
		JLabel panel = new JLabel();
		panel.setSize(100,50);
		
		if (happiness == 100) {
			
			currentStateHappiness = fullBar;
	
		}
		panel.setIcon(currentStateHappiness);
		
		System.out.print(currentStateHappiness);
		
		return panel;
		
	}
	
	
}
