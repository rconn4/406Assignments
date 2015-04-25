package assignment5;

public class RBNode {

	RBNode left;
	RBNode right;
	int element;
	int color;

	
	public RBNode(int theElement)
	{
		this(theElement, null, null);
	} 
	
	public RBNode(int theElement, RBNode left, RBNode right)
	{
		this.left = left;
		this.right = right;
		this.element = theElement;
		color = 0; // 1 Black ; 0 Red
	}
}
