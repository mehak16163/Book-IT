package Backend;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;





/**
	 * 
     * <h1> Room </h1>
     * <p> Class that implements Serialisable and creates serialisable objects for different rooms. </p>
     * @author Mehak Gupta
     * @author Pankhuri Kasliwal
     * @version 1.0
     * @since November 12, 2017
	 *
	 */
public class Room implements Serializable{
	
	private static final long serialVersionUID = 5335174260195498233L;
	private String name;
	private Timetable bookings;
	private int capacity;
	public int getCapacity() {
		return capacity;
	}
	public String getName() {
		return name;
	}
	public Timetable getTimeTable() {
		return bookings;
	}
	public Room(String m ,Timetable t , int c) {
		name = m;
		bookings = t;
		capacity =c;
	}
	

	/**
	*
	* <p> Method that is used to create serialisable objects. </p>
	* @throws FileNotFoundException
	* @throws IOException If an input or output exception occured
	*
	*
	*/
	public void serialise() throws FileNotFoundException, IOException {
		ObjectOutputStream out=null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("./src/Database/rooms/"+this.name+".txt"));
			out.writeObject(this);
		}
		finally {
			out.close();
		}
	}


	/**
	*
	* <p> Method used to deserialise the object. </p>
	* @throws FileNotFoundException
	* @throws IOException If an input or output exception occured
	* @throws ClassNotFoundException
	*
	*/
	public static Object deserialise(String x) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in =null;
		Room s1;
		try {
			in = new ObjectInputStream(new FileInputStream(x));
		    s1 = (Room)in.readObject();
			
		}
		finally
		{	
			in.close();
			}
		return s1;
	}
	public static void main(String[] args) throws IOException {/*
		HashMap<String , Integer> book = new HashMap<>();
		book.put("8.00", 0);
		book.put("8.30", 1);
		book.put("9.00", 2);
		book.put("9.30", 3);
		book.put("10.00", 4);
		book.put("10.30", 5);
		book.put("11.00", 6);
		book.put("11.30", 7);
		book.put("12.00", 8);
		book.put("12.30", 9);
		book.put("1.00", 10);
		book.put("1.30", 11);
		book.put("2.00", 12);
		book.put("2.30", 13);
		book.put("3.00", 14);
		book.put("3.30", 15);
		book.put("4.00", 16);
		book.put("4.30", 17);
		book.put("5.00", 18);
		book.put("5.30", 19);
		book.put("6.00", 20);
		FileReader fr = new FileReader("./src/ROOMS.csv");
		BufferedReader reader = new BufferedReader(fr);
		String head = reader.readLine();
		for (int i =1 ;  i<19 ; i++) {
			String line = reader.readLine();
			String[] clm = line.split(",");
			String name  = clm[0].toLowerCase();
			int capacity = Integer.parseInt(clm[1]);
			boolean[][] table = new boolean[6][20];
			for(int j=2;j<=6;j++) {
				if (clm[j].equals("*")){
					continue;
				}
				String[] booking = clm[j].split("\\$");
				for(int k=0;k<booking.length;k++) {
					String[] lecture = booking[k].split("#");
					String[] time = lecture[1].split("\\*");
					int start = book.get(time[0]);
					int end = book.get(time[1])-1;
					for (int m = start ; m <= end ; m++) {
						table[j-2][m] = true;
					}
				}
			}
			Timetable tb = new Timetable(table);
			Room r = new Room(name , tb , capacity);
			r.serialise();
		}*/
	}
	
}
