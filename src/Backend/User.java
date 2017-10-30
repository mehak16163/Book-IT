package Backend;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String email;
	protected String password;
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public User(String n , String em , String p) {
		name = n;
		email = em;
		password = p;
	}
	
	
}
