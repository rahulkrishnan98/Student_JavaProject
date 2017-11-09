import java.util.*;
import java.io.*;

class Memo implements Serializable{
	String msg;
	Faculty from;
	Student to;
	public Memo(Faculty from,String msg,Student to){
		this.msg = msg;
		this.from = from;
		this.to = to;
	}
	public String getMsg(){
		return this.msg;

	}


}