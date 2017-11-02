package Backend;

import java.io.Serializable;

public class Timetable implements Serializable {
	Boolean[][] table = new Boolean[6][20];
	
	public Timetable(Boolean[][] ta) {
		table = ta;
	}
	
	public void viewTable() {
		
	}
}
