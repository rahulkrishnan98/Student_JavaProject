import java.io.*;
import java.util.*;
class Student extends Users implements Serializable { 
	String roll;
	String name;
	String branch;
	Users user = new Users();
	ArrayList<Subject> registeredSub;
	Grade grade;
	Parent parent;
	ArrayList<Achievement> achievement;
	ArrayList<Memo> memos;
	ArrayList<Fine> fines;
	// Student(){

	// }
	static ArrayList<Student> totalStudentsList = new ArrayList<Student>();

	public Student(String name,String roll,String branch,String parName){
		this.name=name;
		this.roll=roll;
		this.branch=branch;
		totalStudentsList.add(this);
		this.registeredSub = new ArrayList<Subject>();
		this.achievement = new ArrayList<Achievement>();
		this.parent = new Parent(parName,roll);
		this.grade = new Grade();
		this.memos = new ArrayList<Memo>();
		this.fines = new ArrayList<Fine>();
		// StudentMain.saveStud();
		this.save();
	}
	public String getRoll(){
		return roll;
	}
	public String getName(){
		return name;
	}
	public String getBranch(){
		return branch;
	}
	public void setRoll(String r){
		this.roll=r;
	}
	public void setName(String n){
		this.name=n;

	}
	public void setBranch(String b){
		this.branch=b;
	}
	public void addSub(Subject su){
		this.registeredSub.add(su);
	}
	public void addAch(Achievement ac){
		this.achievement.add(ac);
	}
	public void addFine(Fine fn){
		this.fines.add(fn);
	}
	public void addMemo(Memo me){
		this.memos.add(me);
	}
	public boolean checkRegSub(String a){
		for(Subject st : registeredSub){
			if(st.equals(a)){
				return true;

			}
		}
		return false;
	}


}
class Test{
	public static void main(String[] args) {
		ArrayList<Student> arrst = new ArrayList<Student>();
		Subject s1 = new Subject("math","15mat123");
		Subject s2 = new Subject("phy","15phy123");
		Subject s3 = new Subject("soc","15soc123");
		Student s4 = new Student("Naveen","63","CSE","Nash");
		Faculty s5 = new Faculty("Gopal","55");
		
        FileInputStream fis = null;
        ObjectInputStream ois = null;
 
        ArrayList<Student> listOfStudents = null;
 
        try {
            // reading binary data
            fis = new FileInputStream("Data/Students.ser");
 
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
 
            // reading object's value and casting ArrayList<Customer>
            listOfStudents = (ArrayList<Student>)ois.readObject();
        } 
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        } 
        catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
        for(Student stud : listOfStudents){
            System.out.println(stud.getName());
        }

        ArrayList<Faculty> listOfFaculty = null;
 
        try {
            // reading binary data
            fis = new FileInputStream("Data/Faculty.ser");
 
            // converting binary-data to java-object
            ois = new ObjectInputStream(fis);
 
            // reading object's value and casting ArrayList<Customer>
            listOfFaculty = (ArrayList<Faculty>)ois.readObject();
        } 
        catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        } 
        catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
        for(Faculty stud : listOfFaculty){
            System.out.println(stud.getName());
        }


	}
}