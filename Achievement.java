import java.io.*;
import java.util.*;

class Achievement implements Serializable {
	String name;
	String msg;
	Achievement(String name, String msg){
		this.name= name;
		this.msg = msg;
	}

	public String getName(){
		return this.name;
	}
	public String getMsg(){
		return this.msg;
	}
}