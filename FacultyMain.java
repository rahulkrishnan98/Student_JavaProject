import java.util.*;
import java.lang.*;
import java.io.*;


class FacultyMain {
	public void getProfile(Faculty fac){
			System.out.println("********* Profile **********");

			System.out.println();
			System.out.println("Name   : "+fac.getName());
			System.out.println("ID : "+fac.getId());
			System.out.println();


		}
		public void goMenu(Faculty sto){
			System.out.println("************ Hello ! "+sto.getName()+" *************");
			System.out.println();
			do{
			

				int n;
				System.out.println("(1)  Show Name");
				System.out.println("(2)  Show Id");
				System.out.println("(3)  Display GradeBook");
				System.out.println("(4)  Add Grades");
				System.out.println("(5)  Show All Students");
				System.out.println("(6)  Register a Subject");
				System.out.println("(7)  Show Registered Subjects");
				System.out.println("(8)  Show All Subjects");
				System.out.println("(9)  Show Profile");
				System.out.println("(10) Add a Remark to Student");
				System.out.println("(11) Give Fine to Students");
				System.out.println("(12) Go Back");
				Scanner s = new Scanner(System.in);
				n = s.nextInt();
				switch(n){
					case 1:
							System.out.println("===================== Name =========================");
							System.out.println("Hello, " +sto.getName());
							System.out.println();
							break;
					case 2:
							System.out.println("===================== Id ===========================");
							System.out.println("Your, Id  "+ sto.getId());
							System.out.println();
							break;
					case 3:
							System.out.println();
							Scanner input = new Scanner(System.in);
							System.out.println("Enter Student Roll: ");
							String roll = input.next();
							Student currentStudent = StudentMain.checkRoll(roll);
							if(currentStudent != null){
								displayGrade(currentStudent);
							}
							break;
					case 4:
							System.out.println();
							System.out.println("Enter Student Roll: ");
							String roll1 = s.next();
							Student currentStudent1 = StudentMain.checkRoll(roll1);
							if(currentStudent1 != null){
								addGrade(currentStudent1);
							}
							break;							
					case 5:
							System.out.println("******** Total Students List**********");
							System.out.println();
							for(Student stud : Student.totalStudentsList){
            				System.out.println(stud.getName()+"\t"+stud.getRoll()+"\t"+stud.getBranch()+"\t"+stud.parent.getName());
	        					}
	        				System.out.println();
	        				break;	
					case 6:
							System.out.println("*************** Register Subject************");

							System.out.println();
							while(true){
								System.out.println("Enter Subject Name:");
								String name = s.next();
								System.out.println("Enter the Course Code");
								String course = s.next();
								Subject su = SubjectMain.returnSub(course);
								if( su != null){
										if(!sto.checkTeachSub(course)){
												sto.addSub(su);
												sto.save();
												// StudentMain.saveStud();
												System.out.println("Saved current session");
												break;
										}
								}
							}
							System.out.println();
							break;
					case 7:
							System.out.println();
							System.out.println("************Registered Subjects***********");
							System.out.println();
							System.out.println(sto.teachSub);
							for(Subject sub : sto.teachSub){
								System.out.println(sub.getsubName()+"  "+sub.getsubCourseCode());
							}
							System.out.println();
							System.out.println("=================================================");
							System.out.println();
							
							break;
					case 8:
							System.out.println();
							System.out.println("================Subjects==============");
							System.out.println();
							for(Subject sub : Subject.totalSubjectslist){
								System.out.println(sub.getsubName()+"  "+sub.getsubCourseCode());
							}
							System.out.println();
							System.out.println("=======================================");
							System.out.println();
							break;
					case 9:
							getProfile(sto);
							break;
					case 10:
							System.out.println();
							System.out.println("=================== Add Remark ===================");
							System.out.println();
							while(true){
							System.out.println("Enter the Students Roll no : ");
							System.out.println();
							Scanner take = new Scanner(System.in);
							String roll2 = take.next();
							Student currentStudent2 = StudentMain.checkRoll(roll2);
								if(currentStudent2 != null){
									System.out.println("Enter the "+currentStudent2.getName()+"'s Remark Description : ");
									String remark = take.next();
									Memo mem = new Memo(sto,remark,currentStudent2);
									currentStudent2.addMemo(mem);
									currentStudent2.save();
									break;
								}
							}	
							System.out.println("=====================================================");
							break;
					case 11:
							System.out.println();
							System.out.println("=================== Add Fine ===================");
							System.out.println();
							while(true){
							System.out.println("Enter the Students Roll no : ");
							System.out.println();
							Scanner take1 = new Scanner(System.in);
							String roll3 = take1.next();
							Student currentStudent3 = StudentMain.checkRoll(roll3);
								if(currentStudent3 != null){
									System.out.println("Enter the "+currentStudent3.getName()+"'s Fine Description : ");
									String remark = take1.next();
									System.out.println("Enter the Fine Amount :");
									int amt = take1.nextInt();
									System.out.println("Enter the Date :");
									int date = take1.nextInt();
									System.out.println("Enter the Month :");
									int month = take1.nextInt();
									System.out.println("Enter the Year :");
									int year = take1.nextInt();
									Fine fin = new Fine(sto,remark,currentStudent3,new Date(date,month,year),amt);
									currentStudent3.addFine(fin);
									currentStudent3.save();
									break;
								}
							}	
							System.out.println("=====================================================");
							break;
					case 12:
							return;
					default :
							System.out.println("Enter Valid number");
							


				}
			}
			while(true);
		}

		public static void saveFac(){

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
		public static ArrayList<Faculty> getFac(){
			FileInputStream fis = null;
	        ObjectInputStream ois = null;
	 
	        ArrayList<Faculty> listOfFaculty = null;
	 
	        try {
	            // reading binary data
	            fis = new FileInputStream("Data/Faculty.ser");
	 
	            // converting binary-data to java-object
	            ois = new ObjectInputStream(fis);
	 
	            // reading object's value and casting ArrayList<Customer>
	            listOfFaculty = (ArrayList<Faculty>) ois.readObject();

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
	        // for(Student stud : listOfStudents){
	        //     System.out.println(stud.getRoll());
	        // }
	        return listOfFaculty;
		}
		public Faculty checkId(String a){
			
			
			Faculty pres = null;
			for(Faculty st :Faculty.totalFacultyList){
				if(st.getId().equals(a)){
					 return st;

				}
			}
			return null;
			
		}

		public void addGrade(Student sto){
			System.out.println("================== "+ sto.getName()+" 's GradeBook ===================");
			System.out.println();
			while(true){
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the subject code: ");
			String code = input.next();
			Subject sub = SubjectMain.returnRegSub(code,sto);
			System.out.println("Enter internals: ");
			float internals = input.nextFloat();
			System.out.println("Enter external: ");
			float external = input.nextFloat();
			System.out.println("Enter Grade: ");
			String grade = input.next();
			if(sub != null){
				if(!hasMarks(code,sto)){
					sto.grade.totalMarksList.add(new Mark(sub,internals,external,grade));
					sto.save();
					break;
				}
				else{
					System.out.println("Marks already exists for the subject..");
				}
			}
			else{
				System.out.println("Student is not registered for the subject..");
			}
			}


		}

		public void displayGrade(Student sto){

			System.out.println("~ GradeBook ~");
			for(Mark g:sto.grade.totalMarksList){
				System.out.println();
				System.out.println("Subject: " + g.subject.getsubName());
				System.out.println("Internals :"+g.getInter());
				System.out.println("Sem       :"+g.getExter());
				System.out.println("Grade     :"+g.getGrade());
				System.out.println();
			}

		}


		public boolean hasMarks(String code,Student st){
			for(Mark g: st.grade.totalMarksList){
				if(g.subject.getsubCourseCode().equals(code)){
					return true;
				}
			}
			return false;
		}

}