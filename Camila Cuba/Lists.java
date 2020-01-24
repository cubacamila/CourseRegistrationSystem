import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lists  implements java.io.Serializable  {
	public static ArrayList<Course> readCourseData() throws FileNotFoundException{
		String file = "src/MyUniversityCourses.csv";
		Scanner courseScanner = new Scanner(new File(file)); 
		courseScanner.nextLine();
		ArrayList<Course> courseList = new ArrayList<Course>();
		while(courseScanner.hasNext()) {
			StringTokenizer courses = new StringTokenizer(courseScanner.nextLine(), ",");
			String courseName =  courses.nextToken();
			String courseID = courses.nextToken();
			int maxStudents = Integer.parseInt(courses.nextToken());
			int currentStudents = Integer.parseInt(courses.nextToken());
			courses.nextToken();
			String courseInstructor=courses.nextToken();
			int courseSection =  Integer.parseInt(courses.nextToken());
			String courseLocation= courses.nextToken();
			Course p = new Course(courseName,courseID,maxStudents,
					currentStudents,courseInstructor, courseSection, courseLocation);
			courseList.add(p);
		}
		return courseList;
	}
	public static ArrayList<Student> studentList() throws FileNotFoundException{
		ArrayList<Student>studentList= new ArrayList<Student>();
		//studentList.add(a);
		return studentList;
		
		}
	
	}


