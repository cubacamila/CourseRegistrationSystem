import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface StudentClass {
	
	public ArrayList<Course> viewAllCourses() throws FileNotFoundException;
	public ArrayList<Course> viewEmptyCourses() throws FileNotFoundException;

	public void register();
	public void withdraw();
	public String currentCourses();
	public void exit();
	void withdraw(Course w);
}
