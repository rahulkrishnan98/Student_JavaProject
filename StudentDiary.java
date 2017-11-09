import java.lang.*;
import java.io.*;
import java.util.*;
class StudentDiary {
	public static void main(String[] args) {
		StudentMain stud = new StudentMain();
		FacultyMain facu = new FacultyMain();
		ParentMain par = new ParentMain();
		Admin admin = new Admin();
		StudentDiary.init();
		int a;
		do{
		System.out.println("***************Main Menu****************");
		System.out.println();
		System.out.println("(1)Student\n(2)Faculty\n(3)Admin\n(4)Exit");
		Scanner s = new Scanner(System.in);
		 a = s.nextInt();
		if(a==1){
			
				System.out.println("Enter your Roll no: Ex(u4_______)");
				String roll = s.next();
				Student st = stud.checkRoll(roll);
			
			stud.getProfile(st);
			stud.goMenu(st);
			System.out.println();
			
		}
		else if(a==2){
			System.out.println("Enter your Id");
			String id = s.next();
			Faculty fc = facu.checkId(id);
			facu.getProfile(fc);
			facu.goMenu(fc);
			System.out.println();
		}
		else if(a==3){
			admin.goMenu();
		}
		
		else if(a!=4){
			System.out.println("Enter a valid number");
		}

		}while(a!=4);	
		
		
	}

	public static void init(){
	   	Subject.totalSubjectslist = SubjectMain.getSub();
		Student.totalStudentsList = StudentMain.getStud();
		Faculty.totalFacultyList = FacultyMain.getFac();

		System.out.println(Subject.totalSubjectslist);
		System.out.println(Student.totalStudentsList);
		System.out.println(Faculty.totalFacultyList);
		

	}
}
