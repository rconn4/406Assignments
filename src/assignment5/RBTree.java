package assignment5;

public class RBTree {
	
	public RBTree(){
		
	}
	
	public void InsertBST(){
		
	}
	
}
/*
	public Node InsertRB(Node T, key x) {
	     root = insertBST(T, x);
	     color[x]  = red;
	     while ( x != root && p[x].color == red) {
	           if  (p[x] = p[p[x]].left)  {      //parent is the left child of grandParent
	                y = p[p[x]].right;
	                if (y.color == red) {   
	              //case 1: dual red problem. Recolor.  Rule: whenever the sibling of a red node’s redParent is red.
	                     p[p[x] = red;
	                     p[x] = black;
	                      p[p[x]].right.color = black;
	                } else { if (x ==p[x].right) {
	                   //case 2: we know at this point y.color = black. Restructure. Rule: whenever the red 
	             //child's red parent's sibling is black or null
		       x.color = black; 
	                  p[p[x]].color = red;
	                       do LR rotation; }   
	                } else { 			//case 3
	                             p[p[x].color = red;
	                             p[x]color = black;
	                             do LL rotation; }
	           else { parent is the right child of the grand parent. same code as above but switch left and right.} 
	     } // endWhile
	    root.color = black;
	    return root;
	} 
	*/


