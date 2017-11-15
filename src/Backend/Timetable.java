package Backend;

import java.io.Serializable;


     /**
	 * 
     * <h1> Timetable Class </h1>
     * <p> Timetable class that implements Serialisable and creates serialisable objects. </p>
     * @author Mehak Gupta
     * @author Pankhuri Kasliwal
     * @version 1.0
     * @since November 12, 2017
	 *
	 */
public class Timetable implements Serializable {
	public boolean[][] table = new boolean[6][20];
	
	public Timetable(boolean[][] ta) {
		table = ta;
	}
	
	public void viewTable() {
		
	}
}
