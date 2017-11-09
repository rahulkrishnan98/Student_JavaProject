import java.util.*;
import java.lang.*;
import java.io.*;

class Users implements Serializable{
	public Users(){


	}
	public void save(){
		if(this instanceof Student){
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;

			try{
				fos = new FileOutputStream("Data/Students.ser");
				oos = new ObjectOutputStream(fos);

				oos.writeObject(Student.totalStudentsList);
				oos.flush();
				oos.close();

			}
			catch (FileNotFoundException fnfex) {
            	fnfex.printStackTrace();
        	}
        	catch (IOException ioex) {
            	ioex.printStackTrace();
        	}
		}
		if(this instanceof Faculty){
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;

			try{
				fos = new FileOutputStream("Data/Faculty.ser");
				oos = new ObjectOutputStream(fos);

				oos.writeObject(Faculty.totalFacultyList);
				oos.flush();
				oos.close();

			}
			catch (FileNotFoundException fnfex) {
            	fnfex.printStackTrace();
        	}
        	catch (IOException ioex) {
            	ioex.printStackTrace();
        	}
		}
	}
		

}