public class AddMultipleAppointmentException extends Exception{
  private Employee employee[];
  private Appointment appointment;

	/**
	* Default empty AddMultipleAppointmentException constructor
	*/
	public AddMultipleAppointmentException() {
		super();
	}

	/**
	* Default AddMultipleAppointmentException constructor
	*/
	public AddMultipleAppointmentException(Employee employee, Appointment appointment) {
		super();
    Employee[] temp = {employee};
    this.employee = temp;
		this.appointment = appointment;
	}

  /**
  * Default AddMultipleAppointmentException constructor
  */
  public AddMultipleAppointmentException(Employee employee[], Appointment appointment) {
    super();
    this.employee = employee;
    this.appointment = appointment;
  }

	/**
	* Returns value of employee
	* @return employee
	*/
	public Employee[] getEmployee() {
		return employee;
	}

	/**
	* Sets new value of employee
	* @param Employee employee
	*/
	public void setEmployee(Employee employee) {
		this.employee = new Employee[1];
		this.employee[0] = employee;
	}

	/**
	* Sets new value of employee
	* @param Employee employee[]
	*/
	public void setEmployee(Employee employee[]) {
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
	* @return String
	*/
	@Override
	public String toString() {
		return "AddMultipleAppointmentException [employee=" + employee + ", appointment=" + appointment + "]";
	}
}

