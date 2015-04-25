package assignment5;

public class RBTree {
	private RBNode current;
	private RBNode parent;
	private RBNode grand;
	private RBNode great;
	private RBNode header;
	private static RBNode nullNode;
	/* static initializer for nullNode */
	static{
		nullNode = new RBNode(0);
		nullNode.left = nullNode;
		nullNode.right = nullNode;
	}
	// Black - 1  RED - 0 
	static final int BLACK = 1;    
	static final int RED   = 0;

	public RBTree(int negInf){
		header = new RBNode(negInf);
		header.left = nullNode;
		header.right = nullNode;
	}

	public boolean isEmpty(){
		return header.right == nullNode;
	}

	public void makeEmpty(){
		header.right = nullNode;
	}

	public void insert(int item )
	{
		current = parent = grand = header;
		nullNode.element = item;

		while (current.element != item){            
			great = grand; 
			grand = parent; 
			parent = current;
			current = item < current.element ? current.left : current.right;
			// Check if two red children and fix if so            
			if (current.left.color == RED && current.right.color == RED){
				handleReorient( item );
			}
		}
		// Insertion fails if already present
		if (current != nullNode){
			return;
		}
		current = new RBNode(item, nullNode, nullNode);

		if (item < parent.element){
			parent.left = current;
		}
		else{
			parent.right = current;   
		}
		handleReorient( item );
	}

	private void handleReorient(int item){
		// Do the color flip
		current.color = RED;
		current.left.color = BLACK;
		current.right.color = BLACK;

		if (parent.color == RED){
			
			grand.color = RED;
			if (item < grand.element != item < parent.element)
				parent = rotate( item, grand );  // Start dbl rotate
			current = rotate(item, great );
			current.color = BLACK;
		}
		// Make root black
		header.right.color = BLACK; 
	}  

	private RBNode rotate(int item, RBNode parent){
		
		if(item < parent.element)
			return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;  
			else
				return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);  
	}
	/* Rotate binary tree node with left child */
	private RBNode rotateWithLeftChild(RBNode k2){
		
		RBNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		return k1;
	}
	/* Rotate binary tree node with right child */
	private RBNode rotateWithRightChild(RBNode k1){
		
		RBNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		return k2;
	}
	
	public void preorder()
    {
        preorder(header.right);
    }
    private void preorder(RBNode r)
    {
        if (r != nullNode)
        {
            char c = 'B';
            if (r.color == 0)
                c = 'R';
            System.out.print(r.element +""+c+" ");
            preorder(r.left);             
            preorder(r.right);
        }
    }
    
    //http://www.sanfoundry.com/java-program-implement-red-black-tree/
}




