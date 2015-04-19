package Assign2Package;

/*
 * 
 * Ryan Connors
 * Assignment 2
 * CSC406
 * Spring 2015
 * Assigned: February 11th
 * Due: March 4th
 * 
 */

import java.util.*;
import java.io.*;

public abstract class Graph {

	String [] stringArray;
	int [] edgeDetermineArray;
	String edges;
	int fileType;
	int numNodes;
	int numEdges;
	int j = 0;
	String parameters = "[ ]+";

	public Graph(int numNodes, int numEdges, String edges){
		this.edges = edges;
		this.fileType = fileType;
		this.numNodes = numNodes;
		this.numEdges = numEdges;
		stringArray = edges.split(parameters);
		edgeDetermineArray = new int[stringArray.length];
		for(int i = 0; i < stringArray.length; i++){
			edgeDetermineArray[i] = Integer.parseInt(stringArray[i]);
		}
	}

	protected Node [] addElement(Node[] orginal, Node add){
		Node [] newArray = Arrays.copyOf(orginal, orginal.length + 1);
		newArray[orginal.length] = add;
		return newArray;
	}

	protected int numNodes(){
		return this.numNodes;	
	}
	protected int numEdges(){
		return this.numEdges;
	}
	abstract protected boolean existEdge(Edge e);
	
	abstract protected boolean existEdge(int i, int j);
	
	abstract protected void putEdge(Edge e);
	abstract protected void putEdge(int i, int j);
	abstract protected void removeEdge(Edge e);
	abstract protected void removeEdge(int i, int j);
	
	protected  int degree(Node i){
		return degree(i.name);
	}
	protected int degree(int i){
		return inDegree(i) + outDegree(i);
	}
	protected int inDegree(Node i){
		return inDegree(i.name);
	}
	abstract protected int inDegree(int i);
	
	protected int outDegree(Node i){
		return outDegree(i.name);
	}
	abstract protected int outDegree(int i);
	
	protected Node [] adjacentVertices(Node i){
		return adjacentVertices(i.name);
	}
	abstract protected Node [] adjacentVertices(int i);
	
	protected boolean areAdjacent(Node i, Node j){
		return areAdjacent(i.name,j.name);
	}
	abstract protected boolean areAdjacent(int i, int j);
	
	abstract int[] calculateInDegreeArray();
}
