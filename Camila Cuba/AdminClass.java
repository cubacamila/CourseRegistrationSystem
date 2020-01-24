import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface AdminClass {
	public void createNewCourse() throws FileNotFoundException;
	public void deleteCourse();
	public void editCourse();
	public Course displayCourseInfo();
	public void registerStudent();
	public void exit();
	
	public ArrayList<Course> viewAllCourses() throws FileNotFoundException;
	public void viewFullCourses();
	public void coursesFilledList();
	public void studentsNames();
	public void listOfCurrentCourses();
	public void sortCourses();
	
	

}
