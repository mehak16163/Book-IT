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

public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5593581805536753765L;
	private String name;
	private String nature;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public String getNature() {
		return nature;
	}

	public String getAcro() {
		return acro;
	}

	public String getCode() {
		return code;
	}

	public Timetable getTime() {
		return time;
	}

	public String getFac() {
		return fac;
	}

	public HashMap<String, Student> getStudents() {
		return students;
	}

	public HashMap<Integer, String> getPrereqs() {
		return prereqs;
	}

	public static int getPrereq_count() {
		return prereq_count;
	}

	public static int getPost_count() {
		return post_count;
	}

	public HashMap<String, Integer> getPost() {
		return post;
	}
	private String acro;
	private String code;
	private Timetable time;
	private String fac;
	private HashMap<String, Student> students = new HashMap<>();
	private HashMap<Integer,String > prereqs = new HashMap<>();
	private static int prereq_count=0;
	private static int post_count =0;
	private HashMap<String , Integer> post = new HashMap<>();
	
	public Course(String na,String n , String a,String c ,Timetable t , String f ) {
		code =c;
		fac =f;
		acro =a;
		name = na;
		time = t;
		nature =n;
	}
	
	public void serialise() throws FileNotFoundException, IOException {
		ObjectOutputStream out=null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("./src/Database/courses/"+this.name+".txt"));
			out.writeObject(this);
		}
		finally {
			out.close();
		}
	}
	
	public static Course deserialise(String x) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in =null;
		Course s1;
		try {
			in = new ObjectInputStream(new FileInputStream(x));
		    s1 = (Course)in.readObject();
			
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
		FileReader fr1 = new FileReader("./src/course_info.csv");
		FileReader fr2 = new FileReader("./src/TimeTable.csv");
		BufferedReader br1 = new BufferedReader(fr1);
		BufferedReader br2 = new BufferedReader(fr2);
		String head1 = br1.readLine();
		String head2 = br2.readLine();
		for (int i=1 ; i<=16 ; i++) {
			String[] line1 = br1.readLine().split(",");
			String[] line2 = br2.readLine().split(",");
			String name  = line2[1].toLowerCase();
			String code = line2[2].toUpperCase();
			String acr = line2[5].toUpperCase();
			String fac = line2[3].toLowerCase();
			String nature = line2[0];
			boolean[][] table = new boolean[6][20];
			for (int j = 6 ; j<=20 ; j++) {
				int d;
				if (j==6 || j==11 || j==16){
					d = 0;
				}
				else if (j==7 || j==12 || j== 17) {
					d=1;
				}
				else if (j==8 | j==13 || j==18) {
					d=2;
				}
				else if (j==9 || j==14 || j==19) {
					d=3;
				}
				else
					d=4;
				if (line2[j].equals("-")) {
					continue;
				}
				else {
					String[] slots = line2[j].split("#");
					for (int k=0; k<slots.length;k++) {
						String currslot = slots[k];
						String[] period = currslot.split("\\$");
						String[] time = period[0].split("\\-");
						String start = time[0];
						String end = time[1];
						int st = book.get(start);
						int en = book.get(end) -1;
						for (int h=st ; h<=en ; h++) {
							table[d][h] = true;
						}
					}
				}
			}
			
			Timetable t = new Timetable(table);
			Course c = new Course(name , nature , acr , code , t , fac);
			c.prereqs.put(1, line1[6]);
			c.prereq_count = 1;
			String[] post = line1[7].split(" ");
			for (int g=0;g<post.length;g++) {
				c.post.put(post[g] , g+1);
				c.post_count++;
			}
			c.serialise();
		}
		*/
	}

}
