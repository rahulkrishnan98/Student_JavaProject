# Student_JavaProject
Casing includes Java class files and code for a student Diary.(Semester : 3)
Each commit has associated description. Main class and subjugates are committed like-wise. Storage class and directory containing appropriate files are stored seperately.
Project Status :Pending(Refer issue)


*Project Breakdown/ Description* 

1] StudentDiary.java : (Link)
1] Student view
 1.1] Student re-directs to studentMain with Menu options particular to the student and displays Profile in the beginning.<authentication is based on unique ID -roll Number using  checkRoll() method.
2] Faculty view
 2.1] Similar to student view, faculty also is authenticated based on the userID provided at run-time which is cross-checked with dataBase using checkId() method from facultyMain.
3] Admin view
 3.1] Admin view has the furthest access in comparison to all views. Here it is re-directed to admin class where there is an entire list of options, which encompasses the following :
 (1) Add Students
(2) Add Faculty
(3) Add Subject
(4) Show All Students
(5) Show All Faculty
(6) Show All Subjects
4] For all other invalid options, the user is directed to start screen again.

2] Admin.java : (Link)  

1] Creating new Student: We use the student class constructor. (input parameters : String name,String roll,String branch,String parName)
2] Same process for the faculty addition( Note: admin priority over faculty.)
3] Same process with subject initialization.
4] To show all instances of the student, faculty or subject , they have been stored using save() method, prior to function call in their respective classes. We iterate through arrayList and show values accordingly.
3]FacultyMain.java:(Link) 
1] Menu/Options for the Faculty are :
(1)  Show Name
(2)  Show Id
(3)  Display GradeBook (Authenticates with roll again)
(4)  Add Grades
(5)  Show All Students
(6)  Register a Subject (Registers a new Subject with given two parameters and saves to file. ReturnSub method returns the subject, verifying the successful addition of the new subject.
(7)  Show Registered Subjects
(8)  Show All Subjects
(9)  Show Profile
(10) Add a Remark to Student //All comments are stored by faculty to student in the Memo class(As indicated by variables).
(11) Give Fine to Students //Is given for late due or misconduct by faculty and is returned by string.
(12) Go Back
PS: faculty also has it's save method() defined here.
4]Memo and Fine classes : (Link)
Both of the aforementioned classes are called from the Faculty view only. The faculty has the ability to fine or give a memo.

5] Achievement.java : (Link)
This class holds the Achievement and message of the same. 
Future roadmap: Creating an extended part of the class and method definition to categorize different events based on scope and duration with perks, bonuses or scholarship adding to additional grade points.
6] Misc Files and other Exception classes: (Link)

1] Faculty Methods
2] Marks methods
3] Student methods
7]Users.java:(Link)
We use the functionality of ArrayList to store objects into the File and access from it. (Concept implemented: Serializing and deserializing objects)

8] Grade.java: (Link)

1] Adding grade and modifying the grade.

Project Links 
1] Github repository 

Referred Websites 
1] ICT social  : referred to diary project the OOP way

-- 
