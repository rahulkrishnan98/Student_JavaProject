import java.util.*;
import java.lang.*;
import java.io.*;
class Faculty extends Users implements Serializable {
	Users user = new Users();
	static ArrayList<Faculty> totalFacultyList = new ArrayList<Faculty>();

	String id;
	String name;
	ArrayList<Subject> teachSub;
	public Faculty(String name,String id){
		this.name = name;
		this.id = id;
		this.teachSub = new ArrayList<Subject>();
		totalFacultyList.add(this);
		this.save();
	}
	public String getName(){
		return this.name;
	}
	public String getId(){
		return this.id;
	}
	public void setName(String name){
		this.name=name;

	}
	public void setId(String id){
		this.id =id;
	}

	public void addSub(Subject su){
		this.teachSub.add(su);
	}
	public boolean checkTeachSub(String a){
		for(Subject st : teachSub){
			if(st.getsubCourseCode().equals(a)){
				return true;

			}
		}
		return false;
	}



}