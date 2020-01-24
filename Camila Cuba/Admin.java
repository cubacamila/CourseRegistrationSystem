import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Admin extends User implements AdminClass, java.io.Serializable {
	boolean change;
	
	public Admin(String username, String password, String firstname, String lastname) {
		super(username, password, firstname, lastname);
	}
	
	public Admin() {
		super();
	}

	public ArrayList<Course> viewAllCourses() throws FileNotFoundException {
		return Lists.readCourseData();
	}
	
	public void createNewCourse() throws FileNotFoundException {
		
	}
	

	public void deleteCourse(Course a) {
		 if (a == null)
	            return;
	         int position = Lists.readCourseData().indexOf(a);
	         if (position == -1)
	            return;
	         Lists.readCourseData().add(position, Lists.readCourseData().size()-1);
	         change = true;
	}

	@Override
	public void editCourse() {
		// TODO Auto-generated method stub
		
	}

	

	public void registerStudent(String first, String last, String user, String pass) {
             
      }
      
		// TODO Auto-generated method stub
		

	

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	

	
	public void viewFullCourses() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void coursesFilledList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void studentsNames() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listOfCurrentCourses() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortCourses() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCourse() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void registerStudent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course displayCourseInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

}
