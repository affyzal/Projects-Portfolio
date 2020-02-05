
import java.util.*;

public class DeleteAppointmentException extends Exception{
  private Employee employee[];
  private Appointment appointment;

	/**
	* Default empty DeleteAppointmentException constructor
	*/
	public DeleteAppointmentException() {
		super();
	}

	/**
	* Default DeleteAppointmentException constructor
	*/
	public DeleteAppointmentException(Employee employee, Appointment appointment) {
		super();
    Employee[] temp = {employee};
    this.employee = temp;
		this.appointment = appointment;
	}

  /**
  * Default DeleteAppointmentException constructor
  */
  public DeleteAppointmentException(Employee employee[], Appointment appointment) {
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
	* Create string representation of DeleteAppointmentException for printing
	* @return String
	*/
	@Override
	public String toString() {
		return "DeleteAppointmentException [employee=" + employee + ", appointment=" + appointment + "]";
	}
}
