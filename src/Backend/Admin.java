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

public class Admin extends User implements Comparable {
	private static HashMap<Integer , Request> requests = new HashMap<>();
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
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		ObjectOutputStream out=null ;
		String name = rd.readLine();
		String email = rd.readLine();
		String pass = rd.readLine();
		//File f = new File("./src/Database/"+name+".txt");
		Admin s = new Admin(name , email , pass);
		out  = new ObjectOutputStream(new FileOutputStream("./src/Database/admins/"+name+".txt"));
		out.writeObject(s);
		out.close();
	}
}
