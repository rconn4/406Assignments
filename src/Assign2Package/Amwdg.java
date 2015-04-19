package Assign2Package;

/*
 * 
 * Ryan Connors
 * Assignment 3
 * CSC406
 * Spring 2015
 * Assigned: March 4th
 * Due: March 25th
 * 
 */

import java.io.*;
import java.util.*;

public class Amwdg extends Graph {
	int [][] matrix;

	public Amwdg(int numNodes , int numEdges, String edges ) throws FileNotFoundException{
		super(numNodes, numEdges, edges);
		matrix = new int[numNodes + 1][numNodes + 1];

		for(int i = 0; i < edgeDetermineArray.length; i = i + 3){
			matrix[edgeDetermineArray[i]][edgeDetermineArray[i + 1]] = edgeDetermineArray[i + 2];
		}
		assignment2Data();
	}


	
	protected boolean existEdge(Edge e) {
		return existEdge(e.vertex1, e.vertex2);
	}

	protected boolean existEdge(int i, int j) {
		if(matrix[i][j] != 0){
			return true;
		}
		else{
			return false;
		}
	}

	protected void putEdge(Edge e) {
		putEdge(e.vertex1, e.vertex2, e.weight);
	}
	protected void putEdge(int i, int j){
		System.out.println("please enter a weight as well");
	}
	protected void putEdge(int i, int j, int w) {
		matrix[i][j] = w;
	}

	protected void removeEdge(Edge e) {
		removeEdge(e.vertex1, e.vertex2);
	}


	protected void removeEdge(int i, int j) {
		matrix[i][j] = 0;
	}

	protected int inDegree(int i) {
		int count = 0;
		for(int k = 0; k < matrix.length ; k++){
			if(matrix[k][i] != 0){
				count++;
			}
		}
		return count;
	}

	protected int outDegree(int i) {
		int count = 0;
		for(int k = 0; k < matrix.length; k++){
			if(matrix[i][k] != 0){
				count++;
			}
		}
		return count;
	}

	protected Node[] adjacentVertices(int i) {
		Node [] adjacentVertices = new Node[0];
		for(int k = 0; k < matrix.length; k++){
			if(areAdjacent(i,k)){
				adjacentVertices = addElement(adjacentVertices, new Node(k));
			}
		}
		return adjacentVertices;
	}


	protected boolean areAdjacent(int i, int j) {
		if(existEdge(i,j)){
			return true;
		}
		else{
		return false;
		}
	}
	// Assignment 2 Code
	protected int[] calculateInDegreeArray(){
		int [] inDegreeArray = new int[numNodes + 1];
		for(int i = 0; i < numNodes + 1; i++){
			inDegreeArray[i] = inDegree(i);
		}
		return inDegreeArray;
	}
	
	protected Queue<Edge> getPriorityQueue(){
		PriorityQueue<Edge> priorityQue = new PriorityQueue<Edge>(numEdges, Edge.weightComparator);
		for(int i = 0; i < edgeDetermineArray.length; i = i + 3){
			priorityQue.offer(new Edge(edgeDetermineArray[i], edgeDetermineArray[i + 1], edgeDetermineArray[i + 2]));
		}
		
		return priorityQue;
	}
	
	// End assignment 2 Code
	
	public void printTestData(){
		System.out.println("The matrix is: ");
		printMatrix();
		System.out.println("The number of nodes is: " + numNodes());
		System.out.println("The number of edges is: " + numEdges());
		System.out.println("Value if the edge 1,2 exists using edge object: " + existEdge(new Edge(1,2,1)));
		System.out.println("Value if the edge 2,1 exists using edge object: " + existEdge(new Edge (2,1,2)));
		System.out.println("Value if the edge 1,2 exists usind indices: " + existEdge(1,2));
		System.out.println("Value if the edge 2,1 exists usind indices: " + existEdge(2,1));
		System.out.println("Put the edge 5,4,3 into the graph given edge ");
		putEdge(new Edge(5,4,3));
		System.out.println("Value of existence of putEdge: " + existEdge(new Edge(5,4,3)));
		System.out.println("Put the edge 4,3,3 into the graph given indencies ");
		putEdge(4,3,3);
		System.out.println("Value of existence of putEdge: " + existEdge(new Edge(4,3,3)));
		System.out.println("Remove the edge 5,4,3 from the graph given edge ");
		removeEdge(new Edge(5,4,3));
		System.out.println("Value of existence of removeEdge: " + existEdge(new Edge(5,4,3)));
		System.out.println("Remove the edge 4,3,3 from the graph given indencies ");
		removeEdge(4,3);
		System.out.println("Value of existence of removeEdge: " + existEdge(new Edge(4,3,3)));
		System.out.println("Value of degree of node 2: " + degree(new Node(2)));
		System.out.println("Value of degree of 2: " + degree(2));
		System.out.println("Value of indegree of node 2: " + inDegree(new Node(2)));
		System.out.println("Value of indegree of 2: " + inDegree(2));
		System.out.println("Value of outdegree of node 2: " + outDegree(new Node(2)));
		System.out.println("Value of outdegree of 2: " + outDegree(2));
		System.out.println("The Adjacent vertices to node 2: ");
		for(int i = 0; i < adjacentVertices(new Node(2)).length; i++){
			System.out.print(adjacentVertices(new Node(2))[i].name + " , " );
		}
		System.out.println();
		System.out.println("The Adjacent vertices to 2: ");
		for(int i = 0; i < adjacentVertices(new Node(2)).length; i++){
			System.out.print(adjacentVertices(new Node(2))[i].name + " , " );
		}
		System.out.println();
		System.out.println("Boolean Value if nodes 2 and 1 are Adjacent: " + areAdjacent(new Node(1), new Node(2)));
		System.out.println("Boolean Value if nodes 1 and 3 are Adjacent: " + areAdjacent(new Node(1), new Node(3)));
		System.out.println("Boolean Value if 1 and 2 are adjacent: " + areAdjacent(1,2));
		System.out.println("Boolean Value if 1 and 3 are adjacent: " + areAdjacent(1,3));
	}
	//Assignment 2 test data
	protected void assignment2Data(){
		System.out.println("The Matrix is: ");
		printMatrix();
		int [] inDegreeArray = calculateInDegreeArray();
		int [] sortedArray = TopologicalSort.sortedArray(this, inDegreeArray);
		System.out.println("The sorted Array for Topo sort is: ");
		for(int i = 0; i < sortedArray.length; i++){
			System.out.print(sortedArray[i] + " ");
		}
		System.out.println();
		System.out.println("Kruskals Algorithm (Each line is a sperate edge in the MST) : ");
		ArrayList<Edge> solution = Kruskal.minimumSpanningtree(getPriorityQueue(), numNodes);
		Iterator<Edge> ite = solution.iterator();
		while(ite.hasNext()){
			Edge e = ite.next();
			System.out.println(e.vertex1 + " " + e.vertex2 + " " + e.weight + " ");
		}
		System.out.println();
	}
	// End assingment 2 test data
	//Start Assingment 3 test data
	protected void assingment3TestData(){
		System.out.println("The Matrix is: ");
		printMatrix();
		System.out.println("The transitive closure using Floyds's algorithm is: ");
		int [][] floyd = Floyd.transitiveClosure(matrix);
		for(int i = 0; i < floyd.length; i++){
			for(int j = 0; j < floyd.length; j++){
				if(floyd[i][j] == Integer.MAX_VALUE){
					System.out.print("-1" + " ");
				}
				else
					System.out.print(floyd[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("the shortest path for floyds is: ");
		Floyd.printPath(1, 4);
	}
	// End assignment 3 test data



	protected void printMatrix(){

		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
