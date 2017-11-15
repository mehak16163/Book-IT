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
     * <h1> Validation </h1>
     * <p> This class Admin extends User class and implements Comparable interface methods and creates objects for Admin. </p>
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
public class Admin extends User implements Comparable {
	private static HashMap<Integer , Request> requests = new HashMap<>();
	private static HashMap<Integer , SignUpRequest> signupreq = new HashMap<>();
	public Admin(String n  ,String e, String p) {
		super(n,e,p);
	}
	
	public int compareTo(Object t) {
		Admin s = (Admin)t;
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
			out = new ObjectOutputStream(new FileOutputStream("./src/Database/admins/"+this.getName()+".txt"));
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
	public static Admin deserialise(String x) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in =null;
		Admin s1;
		try {
			in = new ObjectInputStream(new FileInputStream(x));
		    s1 = (Admin)in.readObject();
			
		}
		finally
		{
			in.close();
			}
		return s1;
	}
	
	public static void main(String[] args) throws IOException {
		Admin mehak = new Admin("Mehak", "mehak16163@iiitd.ac.in","admin1");
		mehak.serialise();
	}
}
