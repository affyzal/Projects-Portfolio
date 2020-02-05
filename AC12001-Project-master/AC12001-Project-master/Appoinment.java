import java.util.*;

public class Appoinment implements Comparable<Appoinment>{

	public Appoinment(int id, String startTime, String endTime, String date, String type) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
		this.type = type;
	}
	
	int id;
	String startTime;
	String endTime;
	String date;
	String type;
	
	public int compareTo(Appoinment a) {
		// TODO Auto-generated method stub
		if(id > a.id) {
			return 1;
		}else if(id<a.id) {
			return -1;
		}else {
			return 0;
		}

	}

}
