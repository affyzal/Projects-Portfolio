/**
 * node class
 * @author affyz
 *
 */
public class TreeNode {

	public TreeNode() {
		// TODO Auto-generated constructor stub
	}
	
	public TreeNode left;
	public TreeNode right;	
	public int ID;
	public int mark;
	/**
	 * initialise class
	 * @param ID - ID to be used to generate new node
	 */
	public TreeNode(int ID)
    {
        // initialise instance variables
        this.ID = ID;
        this.left = null;
        this.right = null;
        this.mark = 0;
    }
	
	/**
	 * setter for ID
	 * @param ID
	 */
	public void setID(int ID) {
		this.ID = ID;
	}
	/**
	 * getter for ID
	 * @return
	 */
	public int getID() {
		return ID;
	}
	/**
	 * setter for left node
	 * @param left
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	/**
	 * setter for right node
	 * @param right
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}
	/**
	 * setter for mark value
	 * @param mark
	 */
	public void setMark(int mark) {
		this.mark = mark;
	}
	/**
	 * getter for mark value
	 * @return
	 */
	public int getMark() {
		return mark;
	}
	/**
	 * getter for right node
	 * @return
	 */
	public TreeNode getRight() {
		return this.right;
	}
	/**
	 * setter for left node
	 * @return
	 */
	public TreeNode getLeft() {
		return this.left;
	}
	
    

	
}
