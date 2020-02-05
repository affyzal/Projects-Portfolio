/**
 * 
 * Binary tree class
 * @author affyz
 *
 */
public class Tree {

	public Tree() {
		// TODO Auto-generated constructor stub
	}
	
	public TreeNode root;
	
    
    /**
     * Constructor for objects of class List
     * Create a head
     */
    public Tree(int data)
    {
        root = new TreeNode(data);
    }
    
    /**
     * Function to manually add nodes to binary tree
     * @param parent - parent of node to be added
     * @param child - node to be added
     * @param side = which side of tree to be in
     */
    public void addToList(TreeNode parent, TreeNode child, String side) {
    	if(side.equals("left")) {
    		parent.setLeft(child);
    	}
    	if(side.equals("right")) {
    		parent.setRight(child);
    	}
    }
    /**
     * Function to add recursively new nodes
     * @param root - root ot binary tree of which node is to be added
     * @param ID - value to be given to new node
     */
    public void add(TreeNode root, int ID) {
    	if(ID < root.ID) {
    		if(root.left != null) {
    			add(root.left,ID);
    		}
    		else {
    			root.left = new TreeNode(ID);
    		}
    	}
    	else if(ID > root.ID) {
    		if(root.right != null) {
    			add(root.right, ID);
    		}
    		else {
    			root.right = new TreeNode(ID);
    		}
    	}
    }
    	
    /**
     * getter function to get root
     * @return
     */
    public TreeNode getRoot() {
    	return root;
    }
    /**
     * setter function to set root
     * @param troot - node to be set to root
     */
    public void setRoot(TreeNode troot) {
    	root = troot;
    }
    /**
     * Search function to query items in binary tree
     * @param root - root of binary tree to be searched
     * @param ID - ID to be referenced and searched
     * @return
     */
    public TreeNode findInTree(TreeNode root, int ID) {
    	TreeNode found = null;
    	if(root == null) {
    		return null;
    	}
    	if(root.ID == ID) {
    		return root;
    	}
    	if(root.right != null) {
    		found = findInTree(root.right, ID);
    	}
    	if(found == null) {
    		found = findInTree(root.left, ID);
    	}
    	return found;
    }
    /**
     * function to carry out deletion
     * @param ID - item to be deleted
     */
    public void deleteID(int ID) {
    	root = delete(root,ID);
    }
    /**
     * Function to delete function and rearrange tree if needed.
     * @param root - root of binary tree to be used
     * @param ID - reference to be deleted
     * @return
     */
    public TreeNode delete(TreeNode root, int ID) {
    	if (root==null) {
    		return root;
    	}
    	
    	if(ID < root.ID) { 
    		root.left = delete(root.left, ID);
    	}
    	
    	else if(ID > root.ID) { 
    		root.right = delete(root.right, ID);  			
    	}
    	
    	else {
    		if(root.left==null) {
    			return root.right;
    		}
    		else {
    			if(root.right==null) {
    				return root.left;
    			}
    		}
    		root.ID = setr(root.right);
    		root.right = delete(root.right, root.ID);
    	}
		return root;
    
    }
    /**
     * function to calculate and re-arrange tree if needed after deletion
     * @param root - root of binary tree to be used.
     * @return new value which root is to be set to
     */
    public int setr(TreeNode root)
    {
        int setv = root.ID;
        while (root.left != null)
        {
            setv = root.left.ID;
            root = root.left;
        }
        return setv;
    }
    /**
     * function to print inorder
     * @param node
     */
    public void printinorder(TreeNode node) {
    	if(node == null) {
    		return;
    	}
    	printinorder(node.left);
    	System.out.println(node.ID + "\t");
    	printinorder(node.right);
    }
    /**
    *function to print postorder
    *@param node
    */
    public void printPostorder(TreeNode node) {
    	if(node == null) {
    		return;
    	}
    	printPostorder(node.left);
    	printPostorder(node.right);
    	System.out.println(node.ID + "\t");
    }
    /**
     * function to print preorder
     * @param node
     */
    public void printPre(TreeNode node) {
    	if(node==null) {
    		return;
    	}
    	System.out.println(node.ID + "\t");
    	printPre(node.left);
    	printPre(node.right);
    	
    }
    
    
    
    public static void main(String args[])	//tester in TREE
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
        
        //TreeNode find = tree.findInTree(n3, 2);
        //System.out.print(find.ID);
        System.out.println("EEEEEEEEEEEE");
        
    }

}
