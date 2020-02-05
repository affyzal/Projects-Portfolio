
public class List 
{
    public ListNode head;
    
    /**
     * Constructor for objects of class List
     * Create a head
     */
    public List()
    {
        head = null;
    }

     /**
     * Add a new node at the start of a list
     * 
     * @param  data to add
     * @return nothing    
     */
    public void addToList(int num)
    {
        ListNode  newOne;
        
        newOne = new ListNode(num);        
        newOne.setNext(head);
        
        head = newOne;
    }
    
    public void deleteFromStart(List list) {
    	ListNode temp = head;
    	
    	if (head == null) {
    		System.out.println("There is no data available for deleting");
    		return;
    	}
    	
    	head = temp.next;
    	return;    
}
    public void printList()
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






