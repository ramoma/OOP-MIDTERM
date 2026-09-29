package Controls;

import java.net.URL;
import java.sql.*;

public class dbController {
	
//	URL loc = dbController.class.getResource("/valuesStorage/values");
	
	private static boolean hasSave;
	private static int hunger;
	private static int happiness;
	private static int energy;
	private static int clean;
	
	private static int[] stats = new int[4];

	private static String dbUrl = "jdbc:sqlite:valuesStorage/values";
	
	public boolean checkChar() {
		
		
		
		try {
			
			Connection db = DriverManager.getConnection(dbUrl);
			
			PreparedStatement stmt = db.prepareStatement("SELECT COUNT(*) AS count FROM spriteValues");
			
			ResultSet res = stmt.executeQuery();
			
			if(res.getInt("count") > 0) {
				
				hasSave = true;
				
			}
			else {
				
				hasSave = false;
				
			}
			
			
			
			db.close();
			
		} catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
		return hasSave;
		
	}
	
	public int[] getStats() {
		try {
			
			Connection db = DriverManager.getConnection(dbUrl);	
			PreparedStatement stmt = db.prepareStatement("SELECT * FROM spriteValues");
			
			ResultSet res = stmt.executeQuery();
			
			
			while(res.next()) {
				
				hunger = res.getInt("hunger");
				happiness = res.getInt("happiness");
				energy = res.getInt("energy");
				clean = res.getInt("clean");
				
			}
				
			stats[0] = hunger;
			stats[1] = happiness;
			stats[2] = energy;
			stats[3] = clean;
			
			db.close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();			
		}
		
		return stats;
		
	}
	
	public void initSprite(String name){
		
		try {
			
			Connection db = DriverManager.getConnection(dbUrl);
			
			PreparedStatement stmt = db.prepareStatement("insert into spriteValues(name, hunger, happiness, energy, clean) values(?,100,100,100,100)");
			
			stmt.setString(1, name);
			stmt.executeUpdate();
			
			db.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public static void updateSprite(int hunger, int happiness, int energy, int clean) {
		
try {
			
			Connection db = DriverManager.getConnection(dbUrl);
			
			PreparedStatement stmt = db.prepareStatement("update spriteValues set hunger = ?, happiness = ?, energy = ?, clean = ?");
			
			stmt.setInt(1, hunger);
			stmt.setInt(2, happiness);
			stmt.setInt(3, energy);
			stmt.setInt(4, clean);
			
			stmt.executeUpdate();
			
			db.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
