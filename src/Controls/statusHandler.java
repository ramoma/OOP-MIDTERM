package Controls;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import viewers.Window;
import viewers.indoorFrame;

import java.util.Random;


public class statusHandler{
	
	private static boolean isAlive = true;
	private static boolean isSleeping = false;
	private static boolean isEating = false;
	private static boolean isBathing = false;
	private static boolean statusValid;
	
	private static int hunger;
	private static int happiness;
	private static int energy;
	private static int clean;
	
	private static Timer timer;
	private static Timer batheTimer;
	private static Timer sleepTimer;
	private static Timer eatTimer;
	
	private static dbController db = new dbController();
	private static indoorFrame indoor = new indoorFrame();
	
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
	
	public boolean checkCurrentStatus(int action) {
		
		
		switch(action) {
		
			case 1:
				if(isSleeping || isBathing) {
					
					System.out.println("cannot eat");
					
				} else {
					
					System.out.println("is eating");
					isEating = true;
					statusValid =  isEating;
				}
				break;
			case 2:
				if(isBathing || isEating) {
					
					System.out.print("cannot sleep");
					
				} else {
				
					System.out.print("is sleeping");
					isSleeping = true;
					statusValid = isSleeping;
					
				}
				break;
				
			case 3:
				if(isEating || isSleeping) {
					
					System.out.print("cannot bathe");
					
				} else {
					isBathing = true;
					statusValid = isBathing;
					System.out.print("bathing");
					
				}
		
		}
		
		return statusValid;
		
	}
	
	private static void unsetValid() {statusValid = false;}
	
	public void setStatus() {
		
		int[] stats = db.getStats();
		
		hunger = stats[0];
		happiness = stats[1];
		energy = stats[2];
		clean = stats[3];
		
		return;
		
	}
	
	public void updateSleep(){
		
		isSleeping = true;
		
		if(indoor.checkIsSleeping()) {
			
			isSleeping = false;
			sleepTimer.stop();
			System.out.print("sleep interrupted");
			unsetValid();
			
		} else {
			
			sleepTimer = new Timer(3000, e-> {
				energy = 100;
				isSleeping = false;
			});
			
			sleepTimer.start();		
			unsetValid();
			
		}
	}
	
	public void updateClean(){
		
		batheTimer = new Timer(3000, e ->{
			
			clean = 100;
			isBathing = false;
			
		});
		batheTimer.setRepeats(false);
		batheTimer.start();
		
		
	
	}
	
	public static void updatehunger(){ 

		eatTimer = new Timer(3000, e ->{

			isEating = false;
			
		});
		eatTimer.start();
		hunger = 100;
		eatTimer.stop();
		
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
