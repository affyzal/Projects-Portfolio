
import java.util.*;
import java.time.*;
import java.time.format.*;

public class Appointment implements Comparable<Appointment> {
    private LocalDateTime start;
    private LocalDateTime end;
    private String type;
    private String location;

	@Override
    public int compareTo(Appointment a) {
        if(this.start.isBefore(a.getStart())){
            return -1;
        }
        else if(this.start.isAfter(a.getStart())){
            return 1;
        }
        else{
            return 0;
        }
    }

    /**
    * Returns value of start
    * @return start
    */
    public LocalDateTime getStart() {
        return start;
    }

    /**
    * Sets new value of start
    * @param LocalDateTime start
    */
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    /**
    * Returns value of end
    * @return end
    */
    public LocalDateTime getEnd() {
        return end;
    }

    /**
    * Sets new value of end
    * @param LocalDateTime end
    */
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    /**
    * Returns value of type
    * @return type
    */
    public String getType() {
        return type;
    }

    /**
    * Sets new value of type
    * @param String type
    */
    public void setType(String type) {
        this.type = type;
    }

    /**
    * Returns value of location
    * @return location
    */
    public String getLocation() {
        return location;
    }

    /**
    * Sets new value of location
    * @param String location
    */
    public void setLocation(String location) {
        this.location = location;
    }

	/**
	* Default empty Appointment constructor
	*/
	public Appointment() {
		super();
	}

	/**
	* Default Appointment constructor
	*/
	public Appointment(LocalDateTime start, LocalDateTime end, String type, String location) {
		super();
		this.start = start;
		this.end = end;
		this.type = type;
		this.location = location;
	}

     /**
     * toString method
     * returns fields
     */
    /*public String toString() {
	return "Start Time:" + this.startTime + ",, "
		+ "End Time:" + this.endTime + ",, " + "Date:"
		+ this.date + ",, " + "Appointment Type:" + this.type;
  }*/

	/**
	* Create string representation of Appointment for printing
	* @return
	*/
	@Override
	public String toString() {
		return "\t"+type+"\t"+start.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))+"-"+end.format(DateTimeFormatter.ofPattern("HH:mm:ss"))+"\t@"+location;
	}
}
