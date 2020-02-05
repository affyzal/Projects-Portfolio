
public class Stack 
{
    public ListNode head;
    
    public List stack;
    
    public int popnum;
    
    /**
     * Constructor for objects of class List
     * Create a head
     */
    public Stack()
    {
        head = null;
    }

     /**
     * Add a new node at the start of a list
     * 
     * @param  data to add
     * @return nothing    
     */
    public void push(int num)
    {
        //stack.addToList(num);
    	
    	ListNode  newOne;
        
        newOne = new ListNode(num);        
        newOne.setNext(head);
        
        head = newOne;
    }
    /**
     * pop{take off} the first item in the stack of the linked list
     * @param stack
     * @return
     */
    public int pop(List stack) {
    	
    	//stack.deleteFromStart(stack);
    	
    	ListNode temp = head;
    	int popnum = temp.getNum();
    	System.out.print("\n");
    	System.out.print(popnum);
    	
    	if (head == null) {
    		System.out.println("There is no data available for deleting");
    		return popnum;
    	}
    	
    	head = temp.next;
    	this.popnum = popnum;
 
    	return popnum;
}
    
    /**
     * Function to format and print items in list, also checks if list is empty
     */
    public void printStack()
    {
       ListNode marker;

       if (head == null)
       {
       	System.out.println("The list is empty.");  
       }
       else
       {
	        System.out.println("The list contains:");    
	        for (marker = head; marker != null; marker=marker.getNext())
	        {
	              System.out.println(marker.PrintNum());  
	        }
       }
   }


}
