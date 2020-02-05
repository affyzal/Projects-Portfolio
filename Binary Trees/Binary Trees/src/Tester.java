import java.util.InputMismatchException;
import java.util.Scanner;

public class Tester {

	public Tester() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Tree test;
	//public static TreeNode root;

	
    
    /**
     * Please don't write your test code directly in your main method!
     * Create an instance of your test class and then run various test methods.
     * @param args
     */
    public static void main(String args[])
    {
        Tester test = new Tester();

        test.init(1);
        test.process();
        
    }

    /**
     * Write any test initialisation code here
     */
    public void init(int data)
    {
       test = new Tree(1);
       test.root = new TreeNode(data);

    }

    
    /**
     * Process our tests
     */
    public void process()
    {
    	runTestMenu();
    }
    
    /**
     * Run automatic tests
     */
    public void runAutomatedTests()
    {
        TreeNode n1 = new TreeNode(1);
        
        
        
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(5);

        Tree tree = new Tree(3); // 
        tree.add(tree.root, 44);
        tree.printinorder(tree.root);
        TreeNode found = tree.findInTree(tree.root,4);
        if(found!=null) {
        	System.out.println("FFFFFFFFFFFFFFFFF");
        }
        if(found==null) {
        	System.out.print("NNNNNFFFFFFFF");
        }
        
        tree.deleteID(44);
        tree.printinorder(tree.root);
        
        tree.addToList(tree.root, n1, "left"); //         1/ \
        tree.addToList(tree.root, n2, "right"); //            4
        tree.addToList(n2, n3, "left"); //             2/ \
        tree.addToList(n2, n4, "right"); //                5
        System.out.println("WWWWWWWWWW");
        tree.printinorder(tree.root);
        System.out.println("WWWWWWWWWW");
        tree.printPostorder(tree.root);
        System.out.print("WWWWWWWWWW");
        tree.printPre(tree.root);
        System.out.println("TTTT");
        tree.deleteID(3);
        tree.printinorder(tree.root);
        System.out.println("EEEEEEEEEEEE");

    	
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
        String prchoice;
        boolean exit=false;
        do
        {
        	System.out.println("\n");
            System.out.println("BINARY TREES Menu");
            System.out.println("A - add a node");
            System.out.println("D - Delete a node");
            System.out.println("S - Search for a node in the tree");
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
                case "D":
                case "d":
                	System.out.println("DELETE menu");
                	int delID;
                	delID = getInt("Type in the ID to delete: ");
                	test.deleteID(delID);
                	System.out.println("WWWWWWWWWWWWWWWWW");
                	break;
                case "s":
                case "S":
                	System.out.println("SEARCH menu");
                	int srchitem;
                	srchitem = getInt("Type in the ID to search for: ");
                	TreeNode found = test.findInTree(test.root, srchitem);
                    if(found!=null) {
                    	System.out.println("The search item was found in the binary tree");
                    }
                    if(found==null) {
                    	System.out.println("The search item was not found in the binary tree");
                    }
                    break;
                case "P":
                case "p":
                	System.out.println("\n");
                	System.out.println("PRINT Menu");
                	System.out.println("1 - Print Inorder");
                	System.out.println("2 - Print Postorder");
                	System.out.println("3 - Print Preorder");
                    System.out.println("Q - quit");        
                	prchoice = getString("Please make a choice, and press ENTER: ");
                	
                	if(prchoice.equals("1")){
                		test.printinorder(test.root);
                		break;
                	}
                	if(prchoice.equals("2")) {
                		test.printPostorder(test.root);
                		break;
                	}
                	if(prchoice.equals("3")) {
                			test.printPre(test.root);
                			break;
                	}
                	if(prchoice.equals("Q")) {
                			System.out.println("Exiting Print Menu!");
                			break;
                	}

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
           num = getInt("Type in the number: ");
           terminator = true;
         } while (!terminator);

        test.add(test.root, num);
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
