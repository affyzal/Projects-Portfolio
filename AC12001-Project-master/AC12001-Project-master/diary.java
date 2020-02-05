package diary;

import java.util.Scanner;
import java.util.Stack;

public class diary {

	public diary() {
		// TODO Auto-generated constructor stub
	}
	
	int appointments;
	
	Stack<Integer> edits;
	
	public void checkTime(){
		System.out.print("CHECK MEETING TIME MENU");
		System.out.print("Enter the ID of the employee ");
		Scanner s1 = new Scanner(System.in);
		System.out.print(">>>");
		String srchname = s1.nextLine();
		
		double start;
		double end;
		String date;
		String type;
		
		
		
		
		
		
	}
	
	public void undo() {
		
		
	}
	
	public void srchM() {
		
	}
	
	public void addApp() {
		
	}
	
	public void rmApp(starttime, endtime, date, type) {
		
	}
	
	public void edApp() {
		String choice;
		Boolean exit=false;

        do
        {
    		System.out.println("EDIT PLANNER");
    		System.out.println("\t1 - Add entry");
    		System.out.print("\t2 - Delete entry");
    		System.out.println("\t3 - Undo entry");
    		System.out.println("\t4 - Quit");
            
            choice=getString("Please make a choice, and press ENTER: ");
        
            switch (choice)
            {
                case "1":
                	addApp();
                	break;
                case "2":
                	rmApp();
                	break;
                case "3":
                	undo();
                	break;
                case "4": 
                	System.out.println("Goodbye\n");
                      exit=true;
                        break;
                default: System.out.println("That is not a valid choice, please try again");
                        break;         
            }
        }while (!exit);
	}
	
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
	

}
