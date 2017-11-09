import java.util.*;
import java.io.*;
class Mark implements Serializable {
	Subject subject;
	float internal;
	float external;
	String grade;
	public Mark(Subject subject,float internal, float external, String grade){
		this.subject = subject;
		this.internal = internal;
		this.external = external;
		this.grade = grade;
	}
	public float getInter(){
		return this.internal;
	}
	public float getExter(){
		return this.external;
	}
	public String getGrade(){
		return this.grade;
	}



}