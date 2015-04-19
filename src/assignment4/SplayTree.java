package assignment4;

/*
 * 
 * Ryan Connors
 * Assignment 4
 * CSC406
 * Spring 2015
 * Assigned: March 25th
 * Due: April 15
 * 
 */


public class SplayTree {
	private SplayNode root;
	
	public SplayTree(){
		root = null;
	}
	
	//Insert
	public void insert(int num){
        SplayNode z = root;
        SplayNode p = null;

        while (z != null){
            p = z;
            if (num > p.number)
                z = z.right;
            else
                z = z.left;
        }
        z = new SplayNode();
        z.number = num;
        z.parent = p;

        if (p == null)
            root = z;
        else if (num > p.number)
            p.right = z;
        else
            p.left = z;

        Splay(z);
	}
	//Splay Helper
    public void makeLeftChildParent(SplayNode c, SplayNode p){

        if ((c == null) || (p == null) || (p.left != c) || (c.parent != p))
            System.out.println("WRONG");

        if (p.parent != null){
            if (p == p.parent.left)
                p.parent.left = c;
            else 
                p.parent.right = c;
        }

        if (c.right != null)
            c.right.parent = p;

        c.parent = p.parent;
        p.parent = c;
        p.left = c.right;
        c.right = p;
    }
    
    //Splay helper
    public void makeRightChildParent(SplayNode c, SplayNode p){

        if ((c == null) || (p == null) || (p.right != c) || (c.parent != p))
            System.out.println("WRONG");

        if (p.parent != null){
            if (p == p.parent.left)
                p.parent.left = c;
            else
                p.parent.right = c;
        }

        if (c.left != null)
            c.left.parent = p;

        c.parent = p.parent;
        p.parent = c;
        p.right = c.left;
        c.left = p;

    }
    //Splaying
    private void Splay(SplayNode x){
    	
    	System.out.println("Before Splaying: ");
    	preorder();
    	int nx1 = size(x);
    	int rx1 = rank(x);
    	System.out.println();
    	
        while (x.parent != null){
        	
            SplayNode Parent = x.parent;
            SplayNode GrandParent = Parent.parent;
            
            //Zig
            if (GrandParent == null){
                if (x == Parent.left)
                    makeLeftChildParent(x, Parent);
                else
                    makeRightChildParent(x, Parent);                 
            } 
            else{
                if (x == Parent.left){//ZIG ZIG
                    if (Parent == GrandParent.left){
                        makeLeftChildParent(Parent, GrandParent);
                        makeLeftChildParent(x, Parent);
                    }
                    else {//ZIG ZAG
                        makeLeftChildParent(x, x.parent);
                        makeRightChildParent(x, x.parent);
                    }
                }
                else {//ZIG ZAG
                    if (Parent == GrandParent.left){
                        makeRightChildParent(x, x.parent);
                        makeLeftChildParent(x, x.parent);
                    } 
                    else {//ZIG ZIG
                        makeRightChildParent(Parent, GrandParent);
                        makeRightChildParent(x, Parent);
                    }
                }
            }
        }
      
        root = x;
        System.out.println("After Splay: ");
        preorder();
        int nx2 = size(x);
        int rx2 = rank(x);
        System.out.println();
        System.out.println("n(x) = " + nx1 + " r(x) = " + rx1 + " n'(x) = " + nx2 + " r'(x) = " + rx2);
    }
    
    //delete
    public void delete(int num){
        SplayNode node = findNode(num);
        remove(node);
    }
    //delete
    private void remove(SplayNode node){
    	
        if (node == null)
        	return;
        
        Splay(node);

        if( (node.left != null) && (node.right !=null)){
        	
            SplayNode min = node.left;

            while(min.right!=null){
                min = min.right;
            }

            min.right = node.right;
            node.right.parent = min;
            node.left.parent = null;
            root = node.left;
        }

        else if (node.right != null){
            node.right.parent = null;
            root = node.right;
        } 

        else if( node.left !=null){
            node.left.parent = null;
            root = node.left;
        }
        else{
            root = null;
        }
        
        node.parent = null;
        node.left = null;
        node.right = null;
        node = null;
        System.out.println("After deletion: ");
        preorder();
        System.out.println();
    }
    //search
    public boolean search(int value) {

        return findNode(value) != null;
    }
    //Search
    protected SplayNode findNode(int num){
    	
        SplayNode z = root;
        
        while (z != null){
            if (num > z.number)
                z = z.right;
            else if (num < z.number)
                z = z.left;
            else{
            	Splay(z);
            	return z;
            }
                
        }
        return null;

    }
    
    // r(x) and r'(x) calculation
    public int rank(SplayNode node)
    {
        if (node == null) {
            return 0;
        }
        else{
            return (1 + Math.max(rank(node.left), rank(node.right)));
        }
    }
    
    //n(x) and n'(x) calculation
    public int size(SplayNode node) {

        if(node == null)
            return 0;
        else 
            if(node.left == null && node.right == null)
                return 1;
            else
                return (1 + size(node.left) + size(node.right));    

    }
    //Printing
    public void inorder(){
    	inorder(root);
    }
    
    private void inorder(SplayNode n) {

        if (n != null) {
            inorder(n.left);
            System.out.print(n.number +" ");
            inorder(n.right);
        }
    }
    
    public void preorder(){
    	preorder(root);
    }

    private void preorder(SplayNode n){

        if (n != null){
            System.out.print(n.number +" ");
            preorder(n.left);             
            preorder(n.right);
        }

    }
}
