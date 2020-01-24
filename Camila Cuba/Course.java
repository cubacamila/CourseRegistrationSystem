import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Course implements java.io.Serializable, Comparable {
	private String coursename, courseid, instructor, location;
	private int maxnumstudents, currentnumstudents, section;
	private ArrayList <Student> coursestudents;
	//private ArrayList<Course> fullcourses= new ArrayList<>();
	
	
	public ArrayList<Student> getCoursestudents() {
		return this.coursestudents;
	}
	
	public static ArrayList<Course> loadCourses() throws FileNotFoundException{
		 ArrayList<Course> courses = null;
		 try{
		      FileInputStream fis = new FileInputStream("Courses.ser");
		      
		      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
		      ObjectInputStream ois = new ObjectInputStream(fis);
		      
		      //Cast as Employee. readObject will take the object from ObjectInputStream

		    courses = (ArrayList<Course>)ois.readObject();
		    	  if(courses==null)
		    		  courses= new ArrayList<Course>();
		      
		      ois.close();
		      fis.close();
		      return courses;
		    }
		    catch(IOException ioe) {
		       courses=Lists.readCourseData();
		    }
		 catch(ClassNotFoundException cnfe) {
		       cnfe.printStackTrace();
		     }
		return null;
	}
	public static void saveCourses(ArrayList<Course> c) {
		
		try {
			//FileOutput Stream writes data to a file
			FileOutputStream fos = new FileOutputStream("Courses.ser");
			
			//ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//Writes the specific object to the OOS
			oos.writeObject(c);
			
			//Close both streams
			oos.close();
			fos.close();
			System.out.println("Serialization complete");
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	public void addStudentToCourse(Student s) {
		coursestudents.add(s);
		currentnumstudents++;
	}
	public void removeStudentFromCourse(Student student) {
			coursestudents.remove(student);
			currentnumstudents--;
		
	}
	public Course() {
		super();
	}
	public Course (String coursename, String courseid, 
			int maxnumstudents, int currentnumstudents, 
			String instructor, int section, String location) {
		this.coursename= coursename;
		this.courseid=courseid;
		this.instructor=instructor;
		this.location=location;
		this.maxnumstudents=maxnumstudents;
		this.currentnumstudents=currentnumstudents;
		this.section=section;
		this.coursestudents= new ArrayList<Student>();
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getMaxnumstudents() {
		
		return maxnumstudents;
	}
	public void setMaxnumstudents(int maxnumstudents) {
		this.maxnumstudents = maxnumstudents;
	}
	public int getCurrentnumstudents() {
		return currentnumstudents;
	}
	public void setCurrentnumstudents(int currentnumstudents) {
		this.currentnumstudents = currentnumstudents;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public String toString() {
		return "Course name:"+coursename+" Course ID: "+courseid+
				" Instructor: "+instructor+" Location: "+location+
				" Maximum number of students registered: "+maxnumstudents+
				" Current number of students registered: "+currentnumstudents+
				" Section: "+section;
	}

	
	public int compareTo(Course c) {
		int comparecurrentnumstudents=(c.getCurrentnumstudents());
		return comparecurrentnumstudents-this.currentnumstudents;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	// check ;// thing and whther it goes to the source
	
}