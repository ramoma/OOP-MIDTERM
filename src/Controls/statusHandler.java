package Controls;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import viewers.Window;
import viewers.indoorFrame;
import viewers.nameSprite;

import java.util.Random;


public class statusHandler{
	
	private static boolean isAlive = true;
	private static boolean isSleeping = true;
	private static boolean isEating = true;
	private static boolean isBathing = true;
	private static boolean isPlaying = true;
	private static boolean action;
	private static boolean reset;
	
	private static int hunger;
	private static int happiness;
	private static int energy;
	private static int clean;
	
	private static Timer timer;
	private static Timer batheTimer;
	private static Timer sleepTimer;
	private static Timer eatTimer;
	
	private static dbController db = new dbController();
	
//	private static nameSprite name;

	
	private static ImageIcon fullBar = new ImageIcon(statusHandler.class.getResource("/sprites/status/100_.png"));
	private static ImageIcon quarterBar = new ImageIcon(statusHandler.class.getResource("/sprites/status/75_.png"));
	private static ImageIcon halfBar = new ImageIcon(statusHandler.class.getResource("/sprites/status/50_.png"));
	private static ImageIcon lowBar = new ImageIcon(statusHandler.class.getResource("/sprites/status/30_.png"));
	private static ImageIcon depletedBar = new ImageIcon(statusHandler.class.getResource("/sprites/status/Low_.png"));
	
	public void startHandler(){
		
		//180000
		timer = new Timer(5000, e ->depleteStats());
		timer.start();
		
	}
	
	public boolean getValid(int stat) {
		
		switch(stat) {
		
			case 1:
				System.out.print(isSleeping);
				System.out.print(isBathing);
				
				action = isEating;
				break;
			case 2:
				System.out.print(isEating);
				System.out.print(isBathing);
				action = isSleeping;
				break;
			case 3:
				System.out.print(isSleeping);
				System.out.print(isEating);
				action = isBathing;
				break;
				
			case 4:
				isBathing = false;
				isEating = false;
				isSleeping = false;
				
				action = isPlaying;
				break;
		
		}
		
		return action;
		
	}
	
	public void setStatus() {
		
		int[] stats = db.getStats();
		
		hunger = stats[0];
		happiness = stats[1];
		energy = stats[2];
		clean = stats[3];
		
		return;
		
	}
	
	public void updateSleep(){
		
		if(isSleeping) {
			
			isBathing = false;
			isEating = false;
			
			sleepTimer = new Timer(3000, e-> {
				
				energy = 100;
				
				isBathing = true;
				isEating = true;
				
			});
			
			sleepTimer.setRepeats(false);
			sleepTimer.start();	
			
		}
				
	}
	
	public void InterruptSleep() {
		
		sleepTimer.stop();
		isBathing = true;
		isEating = true;
		
	}
	
	public void updateClean(){
		
		
		if(isBathing) {
			isEating = false;
			isSleeping = false;
			
			batheTimer = new Timer(3000, e ->{
				
				clean = 100;
				isEating = true;
				isSleeping = true;
				
			});
			batheTimer.setRepeats(false);
			batheTimer.start();
		}
	}
	
	public static void updatehunger(){ 

		if(isEating) {
			
			isBathing = false;
			isSleeping = false;
			
			eatTimer = new Timer(3000, e ->{
				
				hunger = 100;
				isBathing = true;
				isSleeping = true;
				
			});
			
			eatTimer.start();
			eatTimer.setRepeats(false);
//			eatTimer.stop();
			
		}
			
		
	}
	
	public static void updateHappiness(){happiness = 100;}
	
	public static void depleteHunger() {hunger -= 20;}
	
	public static void depletenergy() {energy -= 20;}
	
	public static void depleteClean() {clean -= 20;}
	
	public static boolean checkIsAlive() { return isAlive; }
	
	public void depleteStats() {
		
		if(hunger != 0 && happiness != 0 && energy != 0 && clean != 0) {
			
			int spec,spec1,spec2,spec3;
			Random rand = new Random();
			
			spec = rand.nextInt(0,8);
			spec1 = rand.nextInt(0,8);
			spec2 = rand.nextInt(0,8);
			spec3 = rand.nextInt(0,8);
			
			hunger = Math.max(0, hunger - spec1);
			happiness = Math.max(0, happiness - spec);
			energy = Math.max(0, energy - spec3);
			clean = Math.max(0, clean - spec2);
			
			System.out.println("penits");
			System.out.println(hunger);
			System.out.println(happiness);
			System.out.println(clean);
			System.out.println(energy);
			
		} else {
			
			isAlive = false;
			
		}
	}
	
	public static void initSprite() {
		
		if(db.checkChar()) {
			
			Window window = new Window();
			
		} else {
			nameSprite name = new nameSprite();
			
			while(!name.returnSprite()) {
				if(name.returnSprite()) {
					continue;
				} else {
					System.out.print("empty");
				}
			}
				
			
			Window window = new Window();
		}
		
	}
	
	public void unsetPlaying() {
		isBathing = true;
		isEating = true;
		isSleeping = true;
	}
	
	public void setReset() {reset = true;}
	public boolean getReset() {return reset;}
	public void unsetReset() {reset = false;}
	
	
	public ImageIcon getIconFor(int value) {
	    if (value >= 100)     return fullBar;
	    else if (value >= 75) return quarterBar;
	    else if (value >= 50) return halfBar;
	    else if (value >= 30) return lowBar;
	    else                  return depletedBar;
	}

	public int getHappinessValue() { return happiness; }	
	public int getHungerValue() { return hunger; }
	public int getEnergyValue() { return energy; }
	public int getCleanValue() { return clean; }
	
}
