import java.util.*;
import java.time.*;

public class Menu {
  private Manager manager;

  public static void main(String args[]) {
    Menu menu = new Menu();
    menu.run();
  }

  /**
  * Default empty Menu constructor
  */
  public Menu() {
    super();
    this.manager = new Manager();
  }

  public void run() {
    String userChoice;
    boolean exit = false;

    System.out.println("\n\n Meeting Manager");
    System.out.println("         1  - Add Employee");
    System.out.println("         2  - Display All Employees");
    System.out.println("         3  - Display Appointments For Day");
    System.out.println("         4  - Add Appointment");
    System.out.println("         5  - Delete Appointment");
    System.out.println("         6  - Edit Appointment");
    System.out.println("         7  - Display Employees Attending Appointment");
    System.out.println("         8  - Display Employees Appointments");
    System.out.println("         9  - Save All Diaries");
    System.out.println("         10 - Load All Diaries");
    System.out.println("         11 - Exit");

    do {

      System.out.println("Please select an option and press enter (type 0 for options)");

      userChoice = getString(">>>>  ");

      switch (userChoice) {
        case("0"):{
          System.out.println("\n\n Meeting Manager");
          System.out.println("         1  - Add Employee");
          System.out.println("         2  - Display All Employees");
          System.out.println("         3  - Display Appointments For Day");
          System.out.println("         4  - Add Appointment");
          System.out.println("         5  - Delete Appointment");
          System.out.println("         6  - Edit Appointment");
          System.out.println("         7  - Display Employees Attending Appointment");
          System.out.println("         8  - Display Employees Appointments");
          System.out.println("         9  - Save All Diaries");
          System.out.println("         10 - Load All Diaries");
          System.out.println("         11 - Exit");
          break;
        }
        case("1"):{
          String name = getString("Enter new employees name\n>>>>  ");
          manager.addEmployee(name);
          break;
        }
        case("2"):{
          Employee[] employees = manager.allEmployees();
          System.out.println("All Employees\n\tID\tName");
          for(Employee e:employees){
            System.out.println(e);
          }
          break;
        }
        case("3"):{
          try{
            String day = getString("Enter the day to search(format:YYYY-MM-DD)\n>>>>  ");
            LocalDate date = LocalDate.parse(day);
            LinkedList<Appointment> apts = manager.appointmentsOnDay(date);
            System.out.println("\tDescription\tTime\tLocation");
            for(Appointment a:apts){
              System.out.println(a);
            }
          }
          catch(Exception e){
            System.out.println("invalid Input");
          }
          break;
        }
        case("4"):{
          try{
            LocalDate date = LocalDate.parse(getString("Enter day to have meeting(format:YYYY-MM-DD)\n>>>>  "));
            String in = "";
            LinkedList<Employee> employees = new LinkedList<Employee>();
            in = getString("Enter employee ids to attend meeting (enter -1 to stop entering employees)\n>>>>  ");
            do{
              employees.add(manager.employeeById(in));
              in = getString("Enter employee ids to attend meeting (enter -1 to stop entering employees)\n>>>>  ");
            }while(!in.equals("-1"));
            long length = (long)(getInt("Enter the length of the meeting in minutes\n>>>>  "));
            LinkedList<Appointment> apts = manager.findAvailableTime(employees.toArray(new Employee[0]),date,length);
            System.out.println("\tDescription\tTime");
            for(Appointment a:apts){
              System.out.println(a);
            }
            LocalTime time = LocalTime.parse(getString("Enter time to have meeting between available slots above(format:HH:MM:SS)\n>>>>  "));
            boolean valid = false;
            for(Appointment a:apts){
              if(time.isAfter(a.getStart().toLocalTime()) && time.isBefore(a.getEnd().toLocalTime())){
                valid = true;
              }
              else {
                throw new Exception();
              }
            }
            String type = getString("Enter description of appointment\n>>>>  ");
            String location = getString("enter location of t he appointment\n>>>>  ");
            Appointment apt = new Appointment(LocalDateTime.of(date,time),LocalDateTime.of(date,time).plusMinutes(length),type,location);
            manager.addAppointment(employees.toArray(new Employee[0]),apt);
          }
          catch(Exception e){
            System.out.println("Invalid Input");
          }
          break;
        }
        case("5"):{
          try{
            LocalDate date = LocalDate.parse(getString("Enter day to delete meeting(format:YYYY-MM-DD)\n>>>>  "));
            LinkedList<Appointment> apts = manager.appointmentsOnDay(date);
            System.out.println("\tDescription\tTime\tLocation");
            for(Appointment a:apts){
              System.out.println(a);
            }
            LocalTime time = LocalTime.parse(getString("Enter start time of meeting to delete from above(format:HH:MM:SS)\n>>>>  "));
            Appointment apt = manager.appointmentAtTime(LocalDateTime.of(date,time));
            manager.removeAppointment(apt);
          }
          catch(Exception e){
            System.out.println("InvalidInput");
          }
          break;
        }

      }
    } while (!exit);
  }

  /**
   * Uses Scanner to get a new String from the user
   */
  public String getString(String userPrompt)
  {
      Scanner s = new Scanner(System.in);
    System.out.print(userPrompt);
    while (!s.hasNext())
    {
      s.next();
      System.out.print(userPrompt);
    }
    String temp = s.next();
    return temp;
  }

  public int getInt(String userPrompt)
{
  Scanner s = new Scanner(System.in);

  System.out.print(userPrompt);
  while (!s.hasNextInt())
  {
    s.next();
    System.out.print(userPrompt);
  }

  int num = s.nextInt();
  return num;
}
}
