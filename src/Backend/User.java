package Backend;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String email;
	private String password;
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
	public boolean comparePassword(String pass) {
		if (pass.equals(password))
			return true;
		else return false;
	}
	
}
