package Backend;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;



     /**
	 * 
     * <h1> Booking Requests </h1>
     * <p> This class Faculty extends User class and implements Comparable interface methods and creates objects for Faculty. </p>
     * @author Mehak Gupta
     * @author Pankhuri Kasliwal
     * @version 1.0
     * @since November 11, 2017
	 *
	 *
	 *
	 *
	 *
	 */

    public class Faculty extends User implements Comparable{
	private Timetable f_table=new Timetable(new boolean[6][20]);
	private HashMap<String , Course> courses = new HashMap<>();
	private HashMap<Integer , Request> requests = new HashMap<>();
	public Faculty(String n ,String e ,String p) {
		super(n,e,p);
	}
	
	public void setTable(Timetable t) {
		f_table = t;
	}
	public  HashMap<Integer , Request> getRequest(){
		return requests;
	}
	public int compareTo(Object t) {
		Faculty s = (Faculty)t;
		if(this.getName().equals(s.getName()) && (this.getEmail().equals(s.getEmail())) && this.password.equals(s.password)) {
			return 1;
		}
		else return 0;
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
			out = new ObjectOutputStream(new FileOutputStream("./src/Database/faculty/"+this.getName()+".txt"));
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
	public static Faculty deserialise(String x) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in =null;
		Faculty s1;
		try {
			in = new ObjectInputStream(new FileInputStream(x));
		    s1 = (Faculty)in.readObject();
			
		}
		finally
		{
			in.close();
			}
		return s1;
	}

	public static void main(String[] args) throws IOException {
		
	}
}
