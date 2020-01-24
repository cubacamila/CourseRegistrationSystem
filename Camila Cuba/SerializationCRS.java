import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationCRS {
	public static void main(String args[]) {
				Student a = new Student("cc6105", "pass", "Camila"," Cuba");
				Student b  = null;
				try {
					//FileOutput Stream writes data to a file
					FileOutputStream crs = new FileOutputStream("src/MyUniversityCourses.csv");
					
					//ObjectOutputStream writes objects to a stream (A sequence of data)
					ObjectOutputStream stream = new ObjectOutputStream(crs);
					
					//Writes the specific object to the OOS
					stream.writeObject(a);
					
					//Close both streams
					crs.close();
					stream.close();
					System.out.println("Serialization successful");
				} 
				catch (IOException ioe) {
					ioe.printStackTrace();
				}
				
				//Now we will deserialize the same object
				
				 try{
					  //FileInputSystem recieves bytes from a file
				      FileInputStream bytes = new FileInputStream("src/MyUniversityCourses.csv");
				      
				      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
				      ObjectInputStream reconstruct = new ObjectInputStream(bytes);
				      
				      //Cast as Employee. readObject will take the object from ObjectInputStream
				      b = (Student)reconstruct.readObject();
				      reconstruct.close();
				      bytes.close();
				    }
				    catch(IOException ioe) {
				       ioe.printStackTrace();
				       return;
				    }
				 catch(ClassNotFoundException cnfe) {
				       cnfe.printStackTrace();
				       return;
				     }
				    System.out.println("Student Name: "+b.getFirstname() + " "+b.getLastname());
				    System.out.println("Student username: "+b.getUsername());
				    System.out.println("Student password:"+b.getPassword());
				    
				    //Notice the SSN difference. It's because SSN is Transient ;
				    //System.out.println("Employee SSN:"+de.getSSN());

				 
			}
			



}
