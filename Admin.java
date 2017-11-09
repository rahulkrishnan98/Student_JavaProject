import java.util.*;
import java.lang.*;
import java.io.*;

class Admin{
	
	
	public void goMenu(){
		   System.out.println("Welcome to ADMIN view");
		do{
			System.out.println();
			System.out.println("(1) Add Students");
			System.out.println("(2) Add Faculty");
			System.out.println("(3) Add Subject");
			System.out.println("(4) Show All Students");
			System.out.println("(5) Show All Faculty");
			System.out.println("(6) Show All Subjects");
			System.out.println("(7) Go Back");
			System.out.println();
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			switch(n){
				case 1:
						System.out.println("========================== Add Students =======================");
						System.out.println();
						System.out.println("Enter the Name : ");
						String name = s.next();
						System.out.println("Enter the RollNo :");
						String rol= s.next();
						System.out.println("Enter the Branch :");
						String bra = s.next();
						System.out.println("Enter the Parent Name :");
						String par = s.next();
						new Student(name,rol,bra,par);
						System.out.println();
						break;
				case 2:
						System.out.println("==========================Add Faculty =========================");
						System.out.println();
						System.out.println("Enter the Name : ");
						String  facname= s.next();
						System.out.println("Enter the Id");
						String id = s.next();
						new Faculty(facname,id);
						System.out.println();
						break;
				case 3:
						System.out.println("==========================Add Subject =========================");
						System.out.println();
						System.out.println("Enter the Subject Name");
						String subname =s.next();
						System.out.println("Enter the Course Code of the Subject");
						String course = s.next();
						new Subject(subname,course);
						System.out.println();
						break;
				case 4:
						System.out.println("======================================= Total Students List ===========================================");
						System.out.println();
						for(Student stud : Student.totalStudentsList){	
            				System.out.println(stud.getName()+"\t"+stud.getRoll()+"\t"+stud.getBranch()+"\t"+stud.parent.getName());
        					}
        					System.out.println();
        				break;
        		case 5:
        				System.out.println("==========================Total Faculty List ==============================");
        				System.out.println();
        				for(Faculty fac : Faculty.totalFacultyList){
        					System.out.println(fac.getName()+"  " + fac.getId());

        				}	
        				System.out.println();
        				break;	
        		case 6:
        				System.out.println("==========================Total Subjects List =============================");
        				System.out.println();
        				for(Subject sub : Subject.totalSubjectslist){
        					System.out.println(sub.getsubName());
        				}
        				break;	
				case 7:
						return;
				default :
						System.out.println("Enter Valid number");				
			}
		}
		while(true);



		}

}