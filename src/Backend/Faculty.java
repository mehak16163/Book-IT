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

public class Faculty extends User implements Comparable{
	private Timetable f_table=new Timetable(new Boolean[6][20]);
	private HashMap<String , Course> courses = new HashMap<>();
	public Faculty(String n ,String e ,String p) {
		super(n,e,p);
	}
	
	public void setTable(Timetable t) {
		f_table = t;
	}
	public int compareTo(Object t) {
		Faculty s = (Faculty)t;
		if(this.getName().equals(s.getName()) && (this.getEmail().equals(s.getEmail())) && this.password.equals(s.password)) {
			return 1;
		}
		else return 0;
	}
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
		Faculty f = new Faculty("Anuradha Sharma" , "anuradha@iiitd.ac.in" , "faculty_3");
		f.serialise();
	}
}
