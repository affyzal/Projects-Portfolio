
import java.util.*;
import java.time.*;
import java.time.temporal.*;
import java.io.*;

public class Manager {
  private TreeMap<String, Employee> employees;
  private AppointmentTree appointments;
  private Stack<UndoOperation> undoStack;

  public Manager() {
    employees = new TreeMap<String, Employee>();
    appointments = new AppointmentTree();
    undoStack = new Stack<UndoOperation>();
  }

  /**
   * Adds employee to list
   * @param String id , String name
   * @return true
   */
  public boolean addEmployee(String id, String name) {
    Employee temp = employees.put(id, new Employee(id, name));
    if (temp == null) {
      return true;
    } else {
      employees.put(id, temp);
      return false;
    }
  }

  /**
   * Adds employee to list
   * @param String name
   * @return true
   */
  public boolean addEmployee(String name) {
    Employee temp = employees.put(Integer.toString(employees.size()), new Employee(Integer.toString(employees.size()), name));
    if (temp == null) {
      return true;
    } else {
      employees.put(Integer.toString(employees.size()), temp);
      return false;
    }
  }

  /**
   * Gets the employee reference by id
   * @param String id
   * @return Employee(id)
   */
  public Employee employeeById(String id) {
    return employees.get(id);
  }

  /**
   * initialises set of employees
   * @param none
   * @return toReturn
   */
  public Employee[] allEmployees() {
    NavigableSet keySet = this.employees.navigableKeySet();
    Employee[] toReturn = new Employee[this.employees.size()];
    Iterator<String> iter = keySet.iterator();
    int i = 0;
    while (iter.hasNext()) {
      toReturn[i] = employees.get(iter.next());
      i++;
    }
    return toReturn;
  }

  /**
   * returns appointments by day
   * @param LocalDate day
   * @return toReturn
   *
   */
  public LinkedList<Appointment> appointmentsOnDay(LocalDate day) throws AppointmentNotFoundException {
    LinkedList<Appointment> toReturn = null;
    try {
      toReturn = appointments.find(day);
    } catch (AppointmentNotFoundException e) {
      throw e;
    }
    return toReturn;
  }

  /**
   * returns appointments by time
   * @param LocalDateTime dateTime
   * @return toReturn
   */
  public Appointment appointmentAtTime(LocalDateTime dateTime) throws AppointmentNotFoundException {
    Appointment toReturn = null;
    try {
      toReturn = appointments.find(dateTime);
    } catch (AppointmentNotFoundException e) {
      throw e;
    }
    return toReturn;
  }

  /**
   * adds new appointment
   * @param Employee employee , Appointment apt
   * @return none
   */
  public void addAppointment(Employee employee, Appointment apt) throws AddAppointmentException {
    try {
      appointments.add(apt);
      employee.addAppointment(apt);
      LinkedList<Employee> employees = new LinkedList<Employee>();
      employees.add(employee);
      UndoOperation undo = new UndoOperation(1, null, apt, employees);
      undoStack.push(undo);
    } catch (AddAppointmentException e) {
      throw e;
    }
  }

  /**
   * Adds appointment but with multiple appointment exception
   * @param Employee employee[] , Appointment apt
   * @return none
   */
  public void addAppointment(Employee employee[], Appointment apt) throws AddMultipleAppointmentException {
    LinkedList<Employee> employeeErrors = new LinkedList<Employee>();
    LinkedList<Employee> addedEmployees = new LinkedList<Employee>();
    try {
      appointments.add(apt);
    } catch (AddAppointmentException e) {
    }
    for (int i = 0; i < employee.length; i++) {
      try {
        employee[i].addAppointment(apt);
        addedEmployees.add(employee[i]);
      } catch (AddAppointmentException e) {
        employeeErrors.add(e.getEmployee());
      }
    }
    UndoOperation undo = new UndoOperation(1, null, apt, addedEmployees);
    undoStack.push(undo);
    if (employeeErrors.size() != 0) {
      throw new AddMultipleAppointmentException((Employee[]) (employeeErrors.toArray()), apt);
    }
  }

  /**
   * finds available time for appointment
   * @param Employee[] employees , LocalDate day , long lengthOfTime
   * @return availableTimes
   */
  public LinkedList<Appointment> findAvailableTime(Employee[] employees, LocalDate day, long lengthOfTime) {
    LinkedList<Appointment> appointments = new LinkedList<Appointment>();
    TreeMap<LocalDateTime, Integer> meetingTimes = new TreeMap<LocalDateTime, Integer>();

    for (int i = 0; i < employees.length; i++) {
      try {
        appointments.addAll(employees[i].appointmentsOnDay(day));
      } catch (Exception e) {
        //TODO handle this exception
      }
    }
    Iterator<Appointment> aptIter = appointments.iterator();
    while (aptIter.hasNext()) {
      Appointment apt = aptIter.next();
      Integer aptStart = meetingTimes.put(apt.getStart(), 1);
      if (aptStart != null) {
        meetingTimes.put(apt.getStart(), aptStart + 1);
      }
      Integer aptEnd = meetingTimes.put(apt.getEnd(), -1);
      if (aptEnd != null) {
        meetingTimes.put(apt.getEnd(), aptEnd - 1);
      }
    }
    LinkedList<Appointment> availableTimes = new LinkedList<Appointment>();

    NavigableSet<LocalDateTime> keys = meetingTimes.navigableKeySet();
    Iterator<LocalDateTime> keyIter = keys.iterator();
    int count = 0;
    Appointment freeSlot = new Appointment(LocalDateTime.of(day, LocalTime.MIN), null, "Available Slot", "");
    boolean free = true;
    while (keyIter.hasNext()) {
      LocalDateTime time = keyIter.next();
      Integer val = meetingTimes.get(time);

      count += val;
      if (count > 0 && free) {
        if (freeSlot.getStart().until(time, ChronoUnit.MINUTES) > lengthOfTime) {
          freeSlot.setEnd(time.minusMinutes(lengthOfTime));
          availableTimes.addLast(freeSlot);
        }
        free = false;
      }
      if (count == 0) {
        freeSlot = new Appointment(time, null, "Available Slot", "");
        free = true;
      }
    }
    if (freeSlot.getStart().until(LocalDateTime.of(day, LocalTime.MAX), ChronoUnit.MINUTES) > lengthOfTime) {
      freeSlot.setEnd(LocalDateTime.of(day, LocalTime.MAX).minusMinutes(lengthOfTime));
      availableTimes.addLast(freeSlot);
    }
    return availableTimes;
  }

  /**
   * returns employees with appointments
   * @param Appointment apt
   * @return toReturn
   */
  public LinkedList<Employee> employeesWithAppointment(Appointment apt) {
    LinkedList<Employee> toReturn = new LinkedList<Employee>();
    NavigableSet<String> keySet = employees.navigableKeySet();
    Iterator<String> iter = keySet.iterator();
    while (iter.hasNext()) {
      Employee current = employees.get(iter.next());
      try {
        current.appointmentAtTime(apt.getStart());
        toReturn.add(current);
      } catch (AppointmentNotFoundException e) {
      }
    }
    return toReturn;
  }

  /**
   * removes appointment from user's diary
   * @param Appointment apt
   * @return none
   */
  public void removeAppointment(Appointment apt) throws AppointmentNotFoundException {
    LinkedList<Employee> employeesWithApt = employeesWithAppointment(apt);
    Iterator<Employee> iter = employeesWithApt.iterator();
    while (iter.hasNext()) {
      try {
        iter.next().removeAppointment(apt);
      } catch (AppointmentNotFoundException e) {
        throw e;
      }
    }
    this.appointments.delete(apt);
  }

  /**
   * saves diary to file
   * @param none
   * @return none
   */
  public void save() throws IOException {
    String toOutput = "";
    NavigableSet<String> keySet = employees.navigableKeySet();
    Iterator<String> empKeyIter = keySet.iterator();
    while (empKeyIter.hasNext()) {
      Employee current = employees.get(empKeyIter.next());
      toOutput += current.getId() + "," + current.getName() + ",;";
    }
    toOutput += "\n";
    LinkedList<Appointment> allAppointments = appointments.allAppointments();
    Iterator<Appointment> aptIter = allAppointments.iterator();
    while (aptIter.hasNext()) {
      Appointment current = aptIter.next();
      toOutput += current.getStart() + "," + current.getEnd() + "," + current.getType() + "," + current.getLocation()
          + ",";
      LinkedList<Employee> employeesAtAppointment = employeesWithAppointment(current);
      Iterator<Employee> empIter = employeesAtAppointment.iterator();
      while (empIter.hasNext()) {
        Employee currentEmp = empIter.next();
        toOutput += currentEmp.getId() + ":";
      }
      toOutput += ",;";
    }
    PrintWriter writer = null;
    FileOutputStream stream = null;
    try {
      stream = new FileOutputStream("save.txt");
      writer = new PrintWriter(stream);
      writer.println(toOutput);
    } catch (IOException e) {
      throw e;
    } finally {
      try {
        writer.close();
        stream.close();
      } catch (IOException e) {
        throw e;
      }
    }
  }

  /**
   * loads diary from file
   * @param none
   * @return none
   */
  public void load() throws IOException {
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    try {
      fileReader = new FileReader("save.txt");
      bufferedReader = new BufferedReader(fileReader);
      String line;
      line = bufferedReader.readLine();
      ArrayList<String> employee = new ArrayList<String>(Arrays.asList(line.split(";")));
      for (String e : employee) {
        System.out.println(e);
        ArrayList<String> employeeFields = new ArrayList<String>(Arrays.asList(e.split(",")));
        this.employees.put(employeeFields.get(0), new Employee(employeeFields.get(0), employeeFields.get(1)));
      }
      line = bufferedReader.readLine();
      ArrayList<String> appointment = new ArrayList<String>(Arrays.asList(line.split(";")));
      for (String a : appointment) {
        ArrayList<String> aptFields = new ArrayList<String>(Arrays.asList(a.split(",")));
        Appointment apt = new Appointment(LocalDateTime.parse(aptFields.get(0)), LocalDateTime.parse(aptFields.get(1)),
            aptFields.get(2), aptFields.get(3));
        ArrayList<String> aptEmployees = new ArrayList<String>(Arrays.asList(aptFields.get(4).split(":")));
        LinkedList<Employee> aptEmployeesList = new LinkedList<Employee>();
        for (String e : aptEmployees) {
          aptEmployeesList.add(this.employeeById(e));
        }
        System.out.println(aptFields.get(4));
        System.out.println(aptEmployees);
        try {
          addAppointment(aptEmployeesList.toArray(new Employee[0]), apt);
        } catch (AddMultipleAppointmentException e) {
        }
      }
    } catch (IOException e) {
      throw e;
    } finally {

      try {
        if (bufferedReader != null) {
          bufferedReader.close();
        }
      } catch (IOException e) {
        throw e;
      }
    }
  }

  /**
   * undos previous action
   * @param none
   * @return undoOpp;
   */
  public UndoOperation undo() {
    UndoOperation undoOpp = null;
    if (!undoStack.empty()) {
      undoOpp = undoStack.pop();
      LinkedList<Employee> employees = undoOpp.getEmployees();
      switch (undoOpp.getOperation()) {
      case (1): {
        try {
          removeAppointment(undoOpp.getAddedApt());
        } catch (AppointmentNotFoundException e) {
        }
        break;
      }
      case (2): {
        try {
          addAppointment(employees.toArray(new Employee[0]), undoOpp.getDeletedApt());
        } catch (AddMultipleAppointmentException e) {
        }
      }
      }
    }
    return undoOpp;
  }

  public UndoOperation editApt(LocalDateTime start) throws AppointmentNotFoundException {
    Appointment toEdit = null;
    try {
      toEdit = this.appointmentAtTime(start);
    } catch (AppointmentNotFoundException e) {
      throw e;
    }
    LinkedList<Employee> employees = employeesWithAppointment(toEdit);
    Iterator<Employee> iter = employees.iterator();
    while (iter.hasNext()) {
      try {
        iter.next().removeAppointment(toEdit);
      } catch (AppointmentNotFoundException e) {
        throw e;
      }
    }
    this.appointments.delete(toEdit);
    return new UndoOperation(3, toEdit,
        new Appointment(toEdit.getStart(), toEdit.getEnd(), toEdit.getType(), toEdit.getLocation()), employees);
  }

  public void editDay(UndoOperation edit, LocalDate newDay, LocalTime newTime) {
    long meetingLength = edit.getAddedApt().getStart().until(edit.getAddedApt().getEnd(), ChronoUnit.MINUTES);
    edit.getAddedApt().setStart(LocalDateTime.of(newDay, newTime));
    edit.getAddedApt().setEnd(edit.getAddedApt().getStart().plusMinutes(meetingLength));
  }

  public void editTime(UndoOperation edit, LocalTime newTime) {
    long meetingLength = edit.getAddedApt().getStart().until(edit.getAddedApt().getEnd(), ChronoUnit.MINUTES);
    edit.getAddedApt().setStart(LocalDateTime.of(edit.getAddedApt().getStart().toLocalDate(), newTime));
    edit.getAddedApt().setEnd(edit.getAddedApt().getStart().plusMinutes(meetingLength));
  }

  public void editLength(UndoOperation edit, long meetingLength) {
    edit.getAddedApt().setEnd(edit.getAddedApt().getStart().plusMinutes(meetingLength));
  }

  public void editType(UndoOperation edit, String type) {
    edit.getAddedApt().setType(type);
  }

  public void editLocation(UndoOperation edit, String location) {
    edit.getAddedApt().setLocation(location);
  }

  public void finishEdit(UndoOperation edit) {
    LinkedList<Employee> employeesWithApt = edit.getEmployees();
    try {
      addAppointment(employeesWithApt.toArray(new Employee[0]), edit.getAddedApt());
    } catch (AddMultipleAppointmentException e) {
    }
  }

}
