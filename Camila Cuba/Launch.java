import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Launch {
	public static void main(String[]args) throws IOException {
		//DESERIALLIZE
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		ArrayList<Course> courses= Lists.readCourseData();
		
		ArrayList<Student>students=Lists.studentList();
		ArrayList<Course> fullcourses= new ArrayList<>();
		//for(Course c: courses)
		  // System.out.println(c);
		 
		boolean b=true; //=answer.equals("admin")||answer.equals("student")||answer.equals("Admin")||answer.equals("Student");
		
		//Course.saveCourses(courses);
		//Student.saveStudents(students);
		
//		ArrayList<Course> coursesMaster=Course.loadCourses();
		ArrayList<Course> courses =Course.loadCourses();
		students=Student.loadStudents();
		if (courses == null) {
			Lists.readCourseData();
		}
		while(b) {
			System.out.println("Admin or Student or Exit?");
			String answer = in.readLine();
			if(answer.contentEquals("Exit")||answer.contentEquals("exit"))
				b=false;
			else if(answer.equals("Student")||answer.equals("student")){ 																																		                                                                                                                                                                         
			  System.out.print("Username: ");
		        String user =in.readLine();
		        System.out.println(user);
		        for(int i =0;i<students.size();i++) {
		        	System.out.println(students.get(i).getUsername());
		        	if(students.get(i).getUsername().equals(user)) {
		        		Student login= students.get(i);
		        		System.out.print("Password: ");
				        String pass = in.readLine();
				        while(login.getPassword().equals(pass)) {
				        	System.out.println("Welcome "+login);
				        	System.out.println("What would you like to do?\n"
				        			+ "1. View all courses\n"
				        			+ "2.View all courses that are not full\n"
				        			+ "3. Register in a course\n"
				        			+ "4. Withdraw from a course\n"
				        			+ "5. View all courses currently registered in\n"
				        			+ "6. Exit");
				        	int schoice= Integer.parseInt(in.readLine());
				        	if(schoice==1) {
				        		for(Course c: courses)
				        			  System.out.println(c);
				        	}
				        	else if(schoice==2) {
				        		ArrayList<Course>empty= new ArrayList<Course>();
				        		for(int k =0;k<courses.size();k++) {
				        			if(courses.get(k).getCurrentnumstudents()==0)
				        				empty.add(courses.get(k));
				        		}
				        		for(Course cc: empty)
				        			System.out.println(cc);
				        	}
				        	else if(schoice==3) {
				        		System.out.println("What course would u like to register in? Input Course name" );
				        		String rn= in.readLine();
				        		System.out.println("Input course ID");
				        		String ri= in.readLine();
				        		for(int m=0;m<courses.size();m++) {
				        			if(courses.get(m).getCourseid().equals(ri)&&courses.get(m).getCoursename().equals(rn)) {
				        				int cn = courses.get(m).getCurrentnumstudents();
				        				int mn = courses.get(m).getMaxnumstudents();
				        				if(cn>=mn) {
				        					System.out.println("Sorry this course is full"); 
				        				}
				        				else {
				        					//ArrayList<Student>studentsincourse= new ArrayList<Student>();
				        					//ArrayList<Course>studentscourses=new ArrayList<Course>();
				        					System.out.println("Input Student first name");
				        					String na= in.readLine();
				        					System.out.println("Input Student last name");
				        					String nal = in.readLine();
				        					for(int a=0;a<students.size();a++) {
				        						if(students.get(a).getFirstname().equals(na)&&students.get(a).getLastname().equals(nal)) {    //**********MAKE SURE STUDENT ISN'T ALREADY REGISTERED
				        							Student news=students.get(a);
				        							courses.get(m).addStudentToCourse(news);
				        							//System.out.println(courses.get(m).getCurrentnumstudents());
				        							news.register(courses.get(m));
				        							//System.out.println(students.get(a).getCurrentCourses());
				        						}
				        					}
				        				}
				        			}
				        		}	
				        	}
				        	else if(schoice==4) { //WITHDRAW
				        		System.out.println("Enter First name");
				        		String fn= in.readLine();
				        		System.out.println("Enter Last name");
				        		String ln= in.readLine();
				        		System.out.println("Enter course name");
				        		String cn = in.readLine();
				        		for(int w = 0;w<courses.size();w++) { //looking for course
				        			Course aa= courses.get(w);
				        			if(aa.getCoursename().equals(cn)) { //FIND COURSE
				        				for(int ss= 0;ss<aa.getCoursestudents().size();ss++) {  // looping through list of STUDENTS in THAT Course
				        					if(aa.getCoursestudents().get(ss).getLastname().equals(ln)==false||aa.getCoursestudents().get(ss).getFirstname().equals(fn)==false){ // looking for name of student in that course
				        						System.out.println("Student with name " +fn+" "+ln+" does not exist in that course.");
				        					}
				        					else {
				        						Student news =aa.getCoursestudents().get(ss);
				        						news.withdraw(aa);
				        						aa.removeStudentFromCourse(aa.getCoursestudents().get(ss));
				        						 ///////// not working
				        					}
				        				}
				        			}
				        		}
				        	}
				        	else if(schoice==5) {
				        		System.out.println(login.getCurrentCourses());				        	
				        		}
				        	else if(schoice==6) {
				        		break;
				        	}
				        }	
		        	}	
		        }
		}
		else if(answer.equals("admin")||answer.equals("Admin")) {
			/*System.out.println("Input Username");
			String auser=in.readLine();
			System.out.println("input Password");
			String apass= in.readLine();
			if(auser.equals("Admin")&&apass.equals("Admin001")) {*/
			
			
			
			System.out.println("Choose one: \n"
					+"1. Course Management\n"
					+"2. Reports");
			int achoice = Integer.parseInt(in.readLine());
			if(achoice==1) {
						System.out.println("Choose one:\n"
								+ "1.Create a new course\n" + 
								"2.Delete a course\n" + 
								"3.Edit a course \n" + 
								"4.Display information for a given course (by course ID)\n" + 
								"5.Register a student \n" + 
								"6.Exit");
						int choice=Integer.parseInt(in.readLine());
			//ArrayList<Course> courses= Lists.readCourseData();
				if( choice==1) {
				System.out.println("Enter coursename");
				String coursename= in.readLine();
				System.out.println("Enter Course ID");
				String courseID= in.readLine();
				System.out.println("Enter maximum # of students allowed in this course");
				int maxNum=Integer.parseInt(in.readLine());
				int currentNumStudents=0;
				System.out.println("Enter Instructor name");
				String instructor= in.readLine();
				System.out.println("Enter section number");
				int section=Integer.parseInt(in.readLine());
				System.out.println("Enter course location");
				String location= in.readLine();
				Course c = new Course(coursename, courseID,maxNum,currentNumStudents,
						instructor,section,location);
				courses.add(c);
				System.out.println("Course added");
				for(Course s: courses)
					   System.out.println(s);
			}
			else if(choice==2) {
				System.out.println("What is the name of the course you want to delete?");
				String de= in.readLine();
				Course courseToRemove = null;
				for (Course d : courses) {
					boolean a= d.getCoursename().equals(de);
					if(a==true)
						courseToRemove=d;
				}
				if(courseToRemove!=null)
					courses.remove(courseToRemove);
				for(Course t: courses)
					   System.out.println(t);
				System.out.println("Course Deleted");
			}
			else if(choice==3){
				System.out.println("What course would you like to edit?");
				for(Course t: courses)
					   System.out.println(t);
				String coursedit= in.readLine();
				System.out.println(coursedit);
				for(int i =0;i<courses.size();i++) {
					boolean c= courses.get(i).getCoursename().equals(coursedit);
					Course ce= courses.get(i);
					if(c==true) {
						System.out.println("What would you like to edit from this course?\n"
								+ "1. Maximum number of students\n"
						+ "2. Current number of students\n"
						+ "3. Instructor \n"
						+ "4. section \n"
						+ "5. location \n");
				int edit=Integer.parseInt(in.readLine());
				while(edit==1||edit==2||edit==3||edit==4) {
					if(edit==1) {
						System.out.println("What would u like the new max to be?");
						int newmax=Integer.parseInt(in.readLine());
						ce.setMaxnumstudents(newmax);
						System.out.println("New max is set");
					}
					else if(edit==2) {
						System.out.println("What is the new current num of students?");
						int newcurr=Integer.parseInt(in.readLine());
						ce.setCurrentnumstudents(newcurr);
						System.out.println("New current number is set");
					}
					else if(edit==3) {
						System.out.println("Who is the new instructor?");
						String ins = in.readLine();
						ce.setInstructor(ins);
					}
					else if(edit==4) {
						System.out.println("What is the new section number?");
						int sec= Integer.parseInt(in.readLine());
						ce.setSection(sec);
					}
					else if(edit==5) {
						System.out.println("What is the new location for the course?");
						String loc= in.readLine();
						ce.setLocation(loc);
					}	
				}	
			}
		}
	}
			else if(choice==4) {
				System.out.println("Enter course ID");
				String courseid= in.readLine();
				for(int j=0;j<courses.size();j++) {
					if(courses.get(j).getCourseid().equals(courseid))
						System.out.println(courses.get(j));
				}
			}
			else if(choice==5) {
				System.out.println("Student's first name");
				String fn= in.readLine();
				System.out.println("Student's last name");
				String ln= in.readLine();
				System.out.println("Student User Name");
				String un= in.readLine();
				System.out.println("Student Password");
				String pw = in.readLine();
				Student s1= new Student(un,pw,fn,ln);
						students.add(s1);
						System.out.println("Student added");
						for(Student s: students)
							   System.out.println(s.username);
					}		
			else if(choice==6) {
			}
		}
			if(achoice==2) {
				System.out.println("Which report would you like to see?\n"
						+"1. View ALL courses\n"
						+"2. View all courses that are FULL \n"
						+"3. Write to a file a list of courses that are full\n"
						+"4. View names of student registered in a specific course\n"
						+"5. View list of courses that student is registered in\n"
						+"6. SORT courses based on current number of students registered \n"
						+"7. Exit");
				int rchoice= Integer.parseInt(in.readLine());
				if(rchoice==1) {      ////////////////////view all courses and students in each course
					for(Course c: courses)
	        			  System.out.println(c.getCoursename());
				}
				else if(rchoice==2) { ////full courses
					for(int i =0;i<courses.size();i++) {
						int cn = courses.get(i).getCurrentnumstudents();
						int max= courses.get(i).getMaxnumstudents();
						if(cn==max) {
							fullcourses.add(courses.get(i));
						}
					}
					System.out.println(fullcourses);
						}
				else if(rchoice==3) { //file
					try {
					    FileOutputStream fos = new FileOutputStream("file");
					    ObjectOutputStream oos = new ObjectOutputStream(fos);   
					    oos.writeObject(fullcourses); // write MenuArray to ObjectOutputStream
					    oos.close(); 
						}
					catch(Exception e) {
					    e.printStackTrace();
						}
					}
				else if(rchoice==4) { //names of students in specific course
					System.out.println("Input the course ID of the specific course you'd like to see the list of students for.");
					String cid= in.readLine();
					for(int cc=00;cc<courses.size();cc++) {
						String scid=courses.get(cc).getCourseid();
						boolean id= cid.equals(scid);
						if(id) {
							System.out.println(courses.get(cc).getCoursestudents());
						}
					}
				}
				else if(rchoice==5) {
					System.out.println("You have chosen to view the list of courses that a given student is registered in.\n "
							+" Input the student's first name");
					String fn= in.readLine();
					System.out.println("Input the student's last name");
					String ln = in.readLine();
					for(int g= 0;g<students.size();g++) {
						String first = students.get(g).getFirstname();
						String last= students.get(g).getLastname();
						if(first.equals(fn)==false||last.equals(ln)==false) {
							System.out.println(students.get(g).getCurrentCourses());
						}
						else {
							System.out.println("SORRY THAT STUDENT DOESN'T EXIST");
						}
					}
				}
				else if(rchoice==6) {
					Collections.sort(courses);
					System.out.println("Course list sorted by current number of students registered");
					}
				else if(rchoice==7) {
					//break;
					}
				}
			}
		}
		//courses=Course.loadCourses();
		//students=Student.loadStudents();
		Course.saveCourses(courses);
		Student.saveStudents(students);
			
	//	Launch.readData();
	}
}

