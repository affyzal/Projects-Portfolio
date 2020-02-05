import java.util.*;
import java.time.*;

public class Employee implements Comparable<Employee> {
    private String id;
    private String name;
    private AppointmentTree appointments;
    //private Stack<UndoOperation> undoStack;

    @Override
    public int compareTo(Employee e) {
        return this.id.compareTo(e.getId());
    }

    /**
    * Default empty Employee constructor
    */
    public Employee() {
        super();
        this.appointments = new AppointmentTree();
        //undoStack = new Stack<UndoOperation>();
    }

    /**
    * Default Employee constructor
    * @param String id , String name
    * @return none
    */
    public Employee(String id, String name) {
        super();
        this.id = id;
        this.name = name;
        this.appointments = new AppointmentTree();
        //undoStack = new Stack<UndoOperation>();
    }

    /**
    * Default Employee constructor
    * @param String id , String name, AppointmentTree appointments
    */
    public Employee(String id, String name, AppointmentTree appointments) {
        super();
        this.id = id;
        this.name = name;
        this.appointments = appointments;
        //undoStack = new Stack<UndoOperation>();
    }

    /**
    * Returns value of id
    * @return id
    */
    public String getId() {
        return id;
    }

    /**
    * Sets new value of id
    * @param String id
    */
    public void setId(String id) {
        this.id = id;
    }

    /**
    * Returns value of name
    * @return name
    */
    public String getName() {
        return name;
    }

    /**
    * Sets new value of name
    * @param String name
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * Returns value of appointments
    * @return appointments
    */
    public AppointmentTree getAppointments() {
        return appointments;
    }

    /**
    * Sets new value of appointments
    * @param AppointmentTree appointments
    */
    public void setAppointments(AppointmentTree appointments) {
        this.appointments = appointments;
    }
     
    /**
     * add appointment to tree
     * @param Appointment appointment
     */
    public void addAppointment(Appointment appointment) throws AddAppointmentException{
        try{
            appointments.add(appointment);
            //undoStack.push(new UndoOperation(1,appointment));
        }
        catch(AddAppointmentException e){
            e.setEmployee(this);
            throw e;
        }
    }

    /**
     * remove appointment from tree
     * @param Appointment appointment
     */
    public void removeAppointment(Appointment appointment) throws AppointmentNotFoundException{
        try{
            appointments.delete(appointment);
            //undoStack.push(new UndoOperation(0,appointment));
        }
        catch(AppointmentNotFoundException e){
            e.setEmployee(this);
            throw e;
        }
    }
     
    /**
     * return appointments on a certain day
     * @param LocalDate day
     * @return appointment
     */
    public LinkedList<Appointment> appointmentsOnDay(LocalDate day) throws AppointmentNotFoundException{
        try{
            return appointments.find(day);
        }
        catch(AppointmentNotFoundException e){
          e.setEmployee(this);
            throw e;
        }
    }

    /**
     * returns appointments at a certain time
     * @param LocalDateTime dateTime
     * @return apt
     */
    public Appointment appointmentAtTime(LocalDateTime dateTime) throws AppointmentNotFoundException{
      Appointment apt = null;
        try{
            apt = appointments.find(dateTime);
        }
        catch(AppointmentNotFoundException e){
          e.setEmployee(this);
            throw e;
        }
        return apt;
    }



	/**
	* Create string representation of Employee for printing
	* @return
	*/
	@Override
	public String toString() {
		return "\t" + id + "\t" + name;
	}
}
