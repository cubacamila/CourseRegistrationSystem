import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Student extends User implements StudentClass, java.io.Serializable{
	// makes sure data won't be serialized
	
	private  ArrayList<Course> currentCourses;
	public Student() {
		super();
	}
	public Student(String username, String password, String firstname, String lastname) {
		super(username, password, firstname, lastname);
		this.currentCourses = new ArrayList<Course>();
	}
	
	public ArrayList<Course> viewAllCourses() throws FileNotFoundException {
		ArrayList<Course> courses= Lists.readCourseData();
		for(Course c: courses)
		   System.out.println(c);
		return courses;
	}
	
	public ArrayList<Course> viewEmptyCourses() throws FileNotFoundException {
		ArrayList<Course> courses= Lists.readCourseData();
		ArrayList<Course>empty=Lists.readCourseData();
		for(int i =0;i<courses.size();i++) {
			if(courses.get(i).getCurrentnumstudents()==0)
				empty.add(courses.get(i));
		}
		return empty;
	}
	public static ArrayList<Student> loadStudents(){
		 ArrayList<Student> students = new ArrayList<Student>();
		 try{
			  //FileInputSystem recieves bytes from a file
		      FileInputStream fis = new FileInputStream("Students.ser");
		      
		      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
		      ObjectInputStream ois = new ObjectInputStream(fis);
		      
		      //Cast as Employee. readObject will take the object from ObjectInputStream
		      
		      //if(ois.available()!=0) {
		    	  students = (ArrayList<Student>)ois.readObject();
		    	  System.out.println(students.size());
		    	  System.out.println(students.get(0).getFirstname());
		    	  System.out.println("Students loaded");

		      //}
		      ois.close();
		      fis.close();
		      
		 }
		    catch(IOException ioe) {
		    	ioe.printStackTrace();
		    	return students;
		    }
		 catch(ClassNotFoundException cnfe) {
		       cnfe.printStackTrace();
		     }
		 return students;
	}
	public static void saveStudents(ArrayList<Student> s) {
		System.out.println(s.get(0).getFirstname());
		
		try {
			//FileOutput Stream writes data to a file
			FileOutputStream fos = new FileOutputStream("Students.ser");
			
			//ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//Writes the specific object to the OOS
			oos.writeObject(s);
			
			//Close both streams
			oos.close();
			fos.close();
			System.out.println("Serialization complete");
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return this.firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return this.lastname;      
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public ArrayList<Course> getCurrentCourses() {
		return this.currentCourses;
	}
	public void register(Course a) {
		this.currentCourses.add(a);
	}
	
	
	public void withdraw(Course w) {
		this.currentCourses.remove(w);
	}
	
@Override
	public void register() {
		// TODO Auto-generated method stub
		
	}

@Override
public String currentCourses() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void withdraw() {
	// TODO Auto-generated method stub
	
}

@Override
public void exit() {
	// TODO Auto-generated method stub
	
}

}
