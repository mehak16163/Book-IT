package Backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



/**
	 * 
     * <h1> SignUp Request </h1>
     * <p> Class that implements Serialisable and creates serialisable objects. </p>
     * @author Mehak Gupta
     * @author Pankhuri Kasliwal
     * @version 1.0
     * @since November 12, 2017
	 *
	 */
public class SignUpRequest implements Serializable {
	private static final long serialVersionUID = -8312553311027397734L;


	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return pass;
	}
	public String getType() {
		return type;
	}
	private String name;
	private String email;
	private String pass;
	private String type;
	
	public SignUpRequest(String n , String e, String p , String t) {
		name = n;
		email = e;
		pass = p;
		type =t;
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
			out = new ObjectOutputStream(new FileOutputStream("./src/Database/signup/"+this.name+".txt"));
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
		SignUpRequest s1;
		try {
			in = new ObjectInputStream(new FileInputStream(x));
		    s1 = (SignUpRequest)in.readObject();
			
		}
		finally
		{
			in.close();
			}
		return s1;
	}
	
}
