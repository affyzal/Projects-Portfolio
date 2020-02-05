
/**
 * 
 * @author Afzal Miah
 */
public class ListNode    
{
    // instance variables
    private int num;
    public ListNode next;

    /**
     * Constructor for objects of class List
     */
    public ListNode(int num)
    {
        // initialise instance variables
        this.num = num;
        this.next = null;
    }
    
     /**
     * Get the next node
     * 
     * @param  none
     * @return the next node
     */
    public ListNode getNext()
    {
        return next;
    }
    
     /**
     * get the number stored in the node
     * 
     * @param  none
     * @return number at this node
     */
    public int getNum()
    {
        return num;
    }
    

     /**
     * Set the next node from the current node
     * 
     * @param  the node to be added at this node's next
     * @return nothing
     */
    public void setNext(ListNode next)
    {
        this.next = next;
    }
    
    
    public int PrintNum() {
    	int num;
    	num = this.num;
    	return num;
    			
    }
    

   

}