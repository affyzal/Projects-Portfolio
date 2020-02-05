import java.util.*;

public class UndoOperation{
    private int operation;
    private Appointment deletedApt, addedApt;
    private LinkedList<Employee> employees;

	/**
	* Returns value of operation
	* @return
	*/
	public int getOperation() {
		return operation;
	}

	/**
	* Sets new value of operation
	* @param int operation
	*/
	public void setOperation(int operation) {
		this.operation = operation;
	}

	/**
	* Returns value of deletedApt
	* @return deletedApt
	*/
	public Appointment getDeletedApt() {
		return deletedApt;
	}

	/**
	* Sets new value of deletedApt
	* @param Appointment deletedApt
	*/
	public void setDeletedApt(Appointment deletedApt) {
		this.deletedApt = deletedApt;
	}

	/**
	* Returns value of addedApt
	* @return addedApt
	*/
	public Appointment getAddedApt() {
		return addedApt;
	}

	/**
	* Sets new value of addedApt
	* @param Appointment addedApt
	*/
	public void setAddedApt(Appointment addedApt) {
		this.addedApt = addedApt;
	}

	/**
	* Returns value of employees
	* @return employees
	*/
	public LinkedList<Employee> getEmployees() {
		return employees;
	}

	/**
	* Sets new value of employees
	* @param LinkedList<Employee> employees
	*/
	public void setEmployees(LinkedList<Employee> employees) {
		this.employees = employees;
	}

	/**
	* Default empty UndoOperation constructor
	*/
	public UndoOperation() {
		super();
	}

	/**
	* Default UndoOperation constructor
	*/
	public UndoOperation(int operation, Appointment deletedApt, Appointment addedApt, LinkedList<Employee> employees) {
		super();
		this.operation = operation;
		this.deletedApt = deletedApt;
		this.addedApt = addedApt;
		this.employees = employees;
	}
}
