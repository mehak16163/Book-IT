package Backend;

public class Student extends User implements Comparable {
	
	
	public Student(String n , String e , String p) {
		super(n,e,p);
	}
	
	public int compareTo(Object t) {
		Student s = (Student)t;
		if(this.getName().equals(s.getName()) && (this.getEmail().equals(s.getEmail())) && this.password.equals(s.password)) {
			return 1;
		}
		else return 0;
	}
}
