package Backend;

import java.io.Serializable;

public class Timetable implements Serializable {
	public boolean[][] table = new boolean[6][20];
	
	public Timetable(boolean[][] ta) {
		table = ta;
	}
	
	public void viewTable() {
		
	}
}
