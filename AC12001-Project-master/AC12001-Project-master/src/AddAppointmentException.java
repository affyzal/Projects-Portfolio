
public class AddAppointmentException extends Exception{
  private Employee employee;
  private Appointment appointment;

	/**
	* Default empty AddAppointmentException constructor
	*/
	public AddAppointmentException() {
		super();
	}

	/**
	* Default AddAppointmentException constructor
	*/
	public AddAppointmentException(Employee employee, Appointment appointment) {
		super();
    	this.employee = employee;
		this.appointment = appointment;
	}

	/**
	* Returns value of employee
	* @return employee
	*/
	public Employee getEmployee() {
		return employee;
	}

	/**
	* Sets new value of employee
	* @param Employee employee
	*/
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	* Returns value of appointment
	* @return appointment
	*/
	public Appointment getAppointment() {
		return appointment;
	}

	/**
	* Sets new value of appointment
	* @param Appointment appointment
	*/
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	/**
	* Create string representation of AddAppointmentException for printing
	* @return
	*/
	@Override
	public String toString() {
		return "AddAppointmentException [employee=" + employee + ", appointment=" + appointment + "]";
	}
}
