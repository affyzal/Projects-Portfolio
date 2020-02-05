
import java.time.*;
import java.io.*;

public class Tester {

  private Manager manager = new Manager();

  public static void main(String args[]) {
    Tester test = new Tester();
    test.makeEmployees();
    test.searchById();
    test.findTimeForEmployees();
    test.addAppointment();
    test.findTimeForEmployees();
    test.undo();
    test.findTimeForEmployees();
    test.undo();
    test.findTimeForEmployees();
  //  test.addAppointmentMultiple();
    //test.findTimeForEmployees();
    //test.removeAppointment();
    //test.load();
    //test.findTimeForEmployees();
    //test.save();
  }

  public void makeEmployees() {
    System.out.println("add employees");
    System.out.println(manager.addEmployee("123", "qwe"));
    System.out.println(manager.addEmployee("345", "dfg"));
    System.out.println(manager.addEmployee("135", "sdg"));
    System.out.println(manager.addEmployee("213", "ghj"));
    System.out.println(manager.addEmployee("678", "asd"));
  }

  public void searchById() {
    System.out.println("search by id");
    System.out.println(manager.employeeById("123"));
    System.out.println(manager.employeeById("345"));
    System.out.println(manager.employeeById("567"));
  }

  public void findTimeForEmployees() {
    System.out.println("find time for 1 employee");
    Employee[] testEmployees = { manager.employeeById("123") };
    System.out.println(manager.findAvailableTime(testEmployees, LocalDate.parse("2018-04-15"), 20));
    System.out.println("find time for 2 employees");
    Employee[] testEmployees2 = { manager.employeeById("123"), manager.employeeById("345") };
    System.out.println(manager.findAvailableTime(testEmployees2, LocalDate.parse("2018-04-15"), 20));
  }

  public void addAppointment() {
    System.out.println("add appointment");
    Appointment apt = new Appointment(LocalDateTime.parse("2018-04-15T12:00:00"),
        LocalDateTime.parse("2018-04-15T13:00:00"), "test", "");
    Employee emp = manager.employeeById("123");
    Appointment apt2 = new Appointment(LocalDateTime.parse("2018-04-15T13:00:00"),
        LocalDateTime.parse("2018-04-15T13:30:00"), "test", "");
    Employee emp2 = manager.employeeById("345");
    try {
      manager.addAppointment(emp, apt);
      manager.addAppointment(emp2, apt2);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void addAppointmentMultiple() {
    System.out.println("add appointment multiple");
    Appointment apt = new Appointment(LocalDateTime.parse("2018-04-15T14:00:00"),
        LocalDateTime.parse("2018-04-15T15:00:00"), "test", "");
    Employee emp = manager.employeeById("123");
    Employee emp2 = manager.employeeById("345");
    Employee[] empArr = { emp, emp2 };
    try {
      manager.addAppointment(empArr, apt);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void removeAppointment() {
    System.out.println("remove appointment");
    try {
      LocalDateTime start = LocalDateTime.parse("2018-04-15T14:00:00");
      System.out.println(start);
      Appointment apt = manager.appointmentAtTime(start);
      System.out.println(apt);
      manager.removeAppointment(apt);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void save() {
    try{
      manager.save();
    }
    catch(IOException e){

    }
  }

  public void load() {
    try{
      manager.load();
    }
    catch(IOException e){

    }
  }

  public void undo(){
    System.out.println("undo");
    manager.undo();
  }

}
