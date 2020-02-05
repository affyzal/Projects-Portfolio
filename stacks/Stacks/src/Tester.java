import java.util.InputMismatchException;
import java.util.Scanner;

public class Tester
{
    private List testlist;
    private Stack stack;
    
    /**
     * Please don't write your test code directly in your main method!
     * Create an instance of your test class and then run various test methods.
     * @param args
     */
    public static void main(String args[])
    {
        Tester test = new Tester();

        test.init();
        test.process();
    }

    /**
     * Write any test initialisation code here
     */
    private void init()
    {
       testlist = new List();
       stack = new Stack();
    }

    
    /**
     * Process our tests
     */
    private void process()
    {
    	runTestMenu();
    }
    
    /**
     * Run automatic tests
     */
    private void runAutomatedTests()
    {
    	
    	stack.push(99);
    	stack.pop(stack.stack);
    	
    	stack.push(999);
    	stack.push(9999);
    	stack.push(8888);
    	//stack.printStack();
    	
    	stack.pop(stack.stack);
    	
     }
    

    /**
     * Display a menu, validate the user's input and return the choice they made
     * 
     * @param   none
     * @return  char x, the validated choice made by the user
     */
    private void runTestMenu()
    {
        String choice;
        boolean exit=false;
        
        do
        {
        	System.out.println("\n");
            System.out.println("List test Menu");
            System.out.println("A - add a number");
            System.out.println("P - print the list");
            System.out.println("T - run automated tests");
            System.out.println("Q - quit");        
            
            choice=getString("Please make a choice, and press ENTER: ");
        
            switch (choice)
            {
                case "A":
                case "a":
                	append();
                	break;
                case "P":
                case "p":
                	testlist.printList();
                	break;
                case "T":
                case "t":
                	runAutomatedTests();
                	break;
                case "Q":
                case "q": 
                	System.out.println("Goodbye\n");
                      exit=true;
                        break;
                default: System.out.println("That is not a valid choice, please try again");
                        break;         
            }
        }while (!exit);
    }
          
    /**
     * Add - user has chosen add, take student code & exam mark, and add to list
     * 
     * @param   none
     * @return  none
     */
    private void append()
    {
        int num;
        boolean terminator;
        terminator =false;

        do
        {
           num = getInt("Type in the number");
           terminator = true;
         } while (!terminator);

        testlist.addToList(num);
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
    
    /**
	 * Uses Scanner to obtain an integer input
	 * Uses Scanner's hasNextInt() method to check that a valid int
	 * has been inputed. One issue is that lines of text with spaces will
	 * result in unneeded prompts but the program does not crash with invalid input
	 * @return Returns the number inputed by the user
	 */
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
	
	/**
	 * Uses Scanner to obtain an integer input
	 * Catches the exception thrown if a non-integer is entered
	 * by the user then reads and discards the non-integer text
	 * and tries again until a valid int is entered.
	 * @return Returns the number inputed by the user
	 */
	public int getIntException(String userPrompt)
	{
		int num = 0;
		boolean valid = false;
		Scanner s = new Scanner(System.in);
		
		// Loop until we get a valid int input from the user
		do {
			try {
				System.out.print(userPrompt);
				num = s.nextInt();
				valid = true;
			}
			catch (InputMismatchException e)
			{
				// Read and discard the invalid input
				s.next();
				System.out.println("Please enter a valid integer:");
			}
		} while (!valid);
	
		return num;
	}
}