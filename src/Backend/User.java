package Backend;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;




     /**
	 * 
     * <h1> User Class </h1>
     * <p> User class that implements Serialisable and creates serialisable objects. </p>
     * @author Mehak Gupta
     * @author Pankhuri Kasliwal
     * @version 1.0
     * @since November 12, 2017
	 *
	 */
public class User implements Serializable {
	private String name;
	private String email;
	protected String password;
	public String getName() {
		return name;
	}

	/**
	*
	* @return email id 
	*
	*/
	public String getEmail() {
		return email;
	}

	/**
	*
	*
	* <p> Constructor </p>
	* @param n String
	* @param em String
	* @param p String 
	*/
	public User(String n , String em , String p) {
		name = n;
		email = em;
		password = p;
	}
	
	
}
