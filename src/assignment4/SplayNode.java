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

public class SplayNode {
	SplayNode left;
	SplayNode right;
	SplayNode parent;
	int number;
	
	public SplayNode(){
		this(0,null,null,null);
	}
	
	public SplayNode(int num){
		this(num,null,null,null);
	}
	
	public SplayNode(int number, SplayNode left, SplayNode right, SplayNode parent){
		this.number = number;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
}
