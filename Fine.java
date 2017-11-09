import java.util.*;
import java.io.*;

class Fine implements Serializable{
	String msg;
	Faculty from;
	Student to;
	Date date;
	int amount;
	public Fine(Faculty from,String msg,Student to,Date date,int amount){
		this.msg = msg;
		this.from = from;
		this.to = to;
		this.date=date;
		this.amount = amount;
	}
	public String getMsg(){
		return this.msg;

	}


}