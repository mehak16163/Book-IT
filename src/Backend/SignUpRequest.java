package Backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SignUpRequest implements Serializable {
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
	public static SignUpRequest deserialise(String x) throws FileNotFoundException, IOException, ClassNotFoundException {
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
