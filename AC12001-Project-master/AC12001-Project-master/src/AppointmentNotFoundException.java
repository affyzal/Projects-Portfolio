public class AppointmentNotFoundException extends Exception{
  private Appointment appointment;
  private Employee employee;

	/**
	* Default empty AppointmentNotFoundException constructor
	*/
	public AppointmentNotFoundException() {
		super();
	}

	/**
	* Default AppointmentNotFoundException constructor
	*/
	public AppointmentNotFoundException(Appointment appointment) {
		super();
		this.appointment = appointment;
	}

	/**
	* Default AppointmentNotFoundException constructor
	*/
	public AppointmentNotFoundException(Appointment appointment, Employee employee) {
		super();
		this.appointment = appointment;
		this.employee = employee;
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
	* Create string representation of AppointmentNotFoundException for printing
	* @return
	*/
	@Override
	public String toString() {
		return "AppointmentNotFoundException [appointment=" + appointment + "]";
	}
}
