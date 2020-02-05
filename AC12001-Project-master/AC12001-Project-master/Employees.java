import java.util.LinkedList;
/**
 * Contains methods needed to hold employee data
 * 
 * @author (Andrew Hart group 22) 
 * @version (1.0)
 */
public class Employees
{
   public int id ;
   public String name;
   public diary planner;
   public LinkedList employeeList;
    
  

    /**
     * Constructor for objects of class Employee
     */
    public Employees()
    {
        
        employeeList = new LinkedList();
        
        
        
    }
    
   public void generateEmployees()
   {
       employeeList.add(1234 , "Andrew Hart");
       employeeList.add(1235 , "Ryan Anderson");
       employeeList.add(1236 , "Isaac Lowry");
       employeeList.add(1237 , "Afzal Miah");
       
    }
    

   }
