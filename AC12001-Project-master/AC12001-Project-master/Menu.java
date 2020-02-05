
import java.time.*;
import java.util.Scanner;
/**
 * Menu from which the user chooses which action to perform
 * 
 * @author (Andrew Hart Group 22) 
 * @version (1.0)
 */
public class Menu
{
    
    private Manager manager = new Manager();
   public String user_id = "";
   public String meetingTime = "";
   public String meetingTime2 = "";
    
    
    public static void main(String args[])
    {
        
       Menu menu = new Menu();
       menu.createEmployees();
       menu.runMenu1();
        
    }
    
    
     /**
      * Initialises the list of employees
      * 
      */
    public void createEmployees(){
      System.out.println("add employees");
      System.out.println(manager.addEmployee("123","qwe"));
      System.out.println(manager.addEmployee("345","dfg"));
      System.out.println(manager.addEmployee("135","sdg"));
      System.out.println(manager.addEmployee("213","ghj"));
      System.out.println(manager.addEmployee("678","asd"));
    }
    
    /**
     * Runs the initial startup menu
     * 
     */
    private void runMenu1()
    {
        String userChoice;
        boolean exit = false;
        
        do
        {
           
            System.out.println(" Meeting Manager");
            System.out.println("         1 - Edit Planner");
            System.out.println("         2 - Display Planner");
            System.out.println("         3 - Search Planner");
            System.out.println("         4 - Quit Manager");
            
            System.out.println("Please select an option and press enter");
            
            userChoice = getString(">>>>  ");
            
            switch (userChoice)
            {
                
                case "1":
                      
                    //  planner.edApp(starttime , endtime , date , type);
                      runMenu2();
                
                      break;
                
                case "2":
                
                System.out.println("Which user's diary do you wish to display?");
                chooseEmployee(user_id);
                
                break;
                
                case "3":
                
                   System.out.println("What user's are being searched?");
                   user_id = getString(">>> ");
                   System.out.println("What is this searches' start date?");
                   meetingTime = getString(">>> ");
                   System.out.println("what is this searches' end date?");
                   meetingTime2 = getString(">>> ");
                
                
                break ;
                
                case "4":
                
                       exit = true;
                
                        break;
                        
                default: System.out.println("That is not a valid option, please choose again");
                         break;
 
                 }
                } while (!exit);
       }

       
    /**
     * runs the secondary "edit planner" menu
     * and it's subsequent menus
     */   
    private void runMenu2( )
    {
        String userChoice;
        boolean exit = false;
        
        do
        {
           
            System.out.println(" Edit Planner");
            System.out.println("         1 - Add Entry");
            System.out.println("         2 - Delete Entry");
            System.out.println("         3 - Edit Entry");
            System.out.println("         4 - Undo previous Edit");
            System.out.println("         5 - Return to Previous Menu");
            System.out.println("         6 - Quit Program");
            
            System.out.println("Please select an option and press enter");
            
            userChoice = getString(">>>>  ");
            
            switch (userChoice)
            {
                
              case "1":
              
              
                 // System.out.println("How many Employees are attending this meeting?");
                 //  userChoice = getString(">>>>  ");
               
               
                   System.out.println(" When does the meeting begin?  (YYYY-MM-DDT13:Hrs:Mins)");
                   meetingTime = getString(">>>> ");
               
                   System.out.println(" When does the meeting end?  (YYYY-MM-DDT13:Hrs:Mins)"); 
                   meetingTime2 = getString(">>>> ");
                 
                   System.out.println("What is the meeting's description?");
                   String meetingDescription = getString(">>>> ");
                   
                    Appointment apt = new Appointment(LocalDateTime.parse(meetingTime) ,LocalDateTime.parse(meetingTime2),meetingDescription,"");
       
                    System.out.println(" Enter the user id of the employee");
                    user_id = getString(">>>> ");
                    Employee emp = manager.employeeById(user_id);

                     System.out.println(" Enter the user id of the second employee");
                    user_id = getString(">>>> ");
                    Employee emp2 = manager.employeeById(user_id);
                   
                    Employee[] empArr = {emp, emp2};
                  
                      try{
                            manager.addAppointment(empArr,apt);
                          //  manager.addAppointment(emp2,apt);
                          }
                               catch(Exception e){
                                   System.out.println(e);
                               }
                
                     break;
                
                case "2":
                
                    System.out.println("Which meeting do you want to delete? (YYYY-MM-DDT13-hrs-mins)");
                    meetingTime = getString(">>> ");
                   
                try{
                     LocalDateTime start = LocalDateTime.parse(meetingTime);
                     System.out.println(start);
                     Appointment removedApt = manager.appointmentAtTime(start);
                     System.out.println(removedApt);
                      manager.removeAppointment(removedApt);
                    }
                    catch(Exception e){
                            System.out.println(e);
                      }
                    
                   
                
                      break;
                
                case "3":
                
                    System.out.println("Which Meeting do you wish to edit?");
                    meetingTime = getString(">>>");
                    
                      do{
                          
                            System.out.println("1. Edit Day");
                            System.out.println("2. Edit Time");
                            System.out.println("3. Edit Length");
                            System.out.println("4. Edit Description");
                            System.out.println("5. Edit Location");
                            System.out.println("6 Return to previous menu");
                            
                          
                          
                            userChoice = getString(">>>>  ");
            
                            switch (userChoice)
                             {
                
                                case "1":
                            
                                 break;
                                 
                                 case "2":
                                 
                                 break;
                                 
                                 case "3":
                                 
                                 break;
                                 
                                 case "4":
                                 
                                 break;
                                 
                                 case "5":
                                 
                                 break;
                                 
                                 case "6":
                                 
                                 
                                 
                                 exit = true;
                                 break;
                               }    
                            } while(!exit);
                    
                
                break ;
                
                case "4":
                
                  //   undoOperation.undo();
                
                break;
                
                case "5":
                
                     runMenu1();
                
                       break;
                
                case "6":
                
                       exit = true;
                
                        break;
                        
                default: System.out.println("That is not a valid option, please choose again");
                         break;
 
             }
                } while (!exit);
       }
    
        /**
    * selects the employee id for use in methods
    * @param String user_id
    * @return user_id
    * 
    */
   
   public String chooseEmployee(String user_id)
   {
     
       user_id = getString(">>>");
       
    
     return user_id;
       
       
    }
    
    /**
     * Gets the time a meeting begins
     * @param String meetingTime
     * @return meetingTime
     */
    public String getMeeting(String meetingTime)
    {
        meetingTime = getString(">>>>  ");
        
        return meetingTime;
        
    }
    
    
    /**
     * Gets the time a meeting ends
     * @param String meetingTime2
     * @return meetingTime
     */
    public String getMeeting2(String meetingTime2)
    {
        meetingTime2 = getString(">>>>  ");
        
        return meetingTime2;
        
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
		
		return s.next();
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
