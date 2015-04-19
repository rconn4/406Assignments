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

import java.io.*;
import java.util.*;

public class Alwdg extends Graph{

	LinkedList<Edge>[] adjacencyList;

	public Alwdg(int fileType, int numNodes, int numEdges, String edges) throws FileNotFoundException{
		super(numNodes, numEdges, edges);

		adjacencyList = new LinkedList[numNodes + 1];

		for(int i = 0; i < numNodes + 1; i++){
			adjacencyList[i] = new LinkedList<Edge>();	
		}
		for(int i = 0; i < edgeDetermineArray.length; i = i + 3){ 
			adjacencyList[edgeDetermineArray[i]].add(new Edge(edgeDetermineArray[i], edgeDetermineArray[i + 1], edgeDetermineArray[i + 2]));
		}
		assignment2TestData();

	}
	

	protected boolean existEdge(Edge e) {
		return existEdge(e.vertex1, e.vertex2);
	}
	
	
	protected boolean existEdge(int i, int j) {
		for(Edge e : adjacencyList[i]){
			if(e.vertex2 == j){
				return true;
			}
		}
		return false;
	}

	protected void putEdge(Edge e) {
		putEdge(e.vertex1, e.vertex2, e.weight);
	}

	protected void putEdge(int i, int j) {
		System.out.println("please enter a weight as well");
	}
	
	protected void putEdge(int i, int j, int w){
		adjacencyList[i].add(new Edge(i,j,w));
	}

	protected void removeEdge(Edge e) {
		removeEdge(e.vertex1, e.vertex2);
	}


	protected void removeEdge(int i, int j) {
		int count = 0;
		for(Edge e : adjacencyList[i]){
			if(e.vertex2 == j){
				adjacencyList[i].remove(count);
			}
			count++;
		}
	}


	protected int outDegree(int i) {
		return adjacencyList[i].size();
	}
	
	protected int inDegree(int i) {
		int count = 0;
		for(int k = 0; k < adjacencyList.length; k++){
			Iterator<Edge> ite = adjacencyList[k].iterator();
			while(ite.hasNext()){
				if(ite.next().vertex2  == i){
					count++;
				}
			}
		}
		return count;
	}


	protected Node[] adjacentVertices(int i) {
		Node [] adjacentVertices = new Node[0];
		for(Edge e : adjacencyList[i]){
			adjacentVertices = addElement(adjacentVertices, new Node(e.vertex2));
		}
		return adjacentVertices;
	}

	protected boolean areAdjacent(int i, int j) {
		if(existEdge(i,j))
			return true;
		return false;
	}
	//Assignment 2 Start
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
	//Assingment 2 End
	
	
	public void printTestData(){
		System.out.println("the AdjacenyList is: ");
		printAdjacencyList();
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
	//Assignment 2 Test Data Start
	protected void assignment2TestData(){
		System.out.println("The Adjacency List is: ");
		printAdjacencyList();
		int [] inDegreeArray = calculateInDegreeArray();
		int [] sortedArray = TopologicalSort.sortedArray(this, inDegreeArray);
		System.out.println("The sorted Array is: ");
		for(int i = 0; i < sortedArray.length; i++){
			System.out.print(sortedArray[i] + " ");
		}
		System.out.println();
		System.out.println("Kruskals Algorithm: ");
		ArrayList<Edge> solution = Kruskal.minimumSpanningtree(getPriorityQueue(), numNodes);
		Iterator<Edge> ite = solution.iterator();
		while(ite.hasNext()){
			Edge e = ite.next();
			System.out.println(e.vertex1 + " " + e.vertex2 + " " + e.weight + " ");
		}
		System.out.println();

	}
	//Assignment 2 Data End

	protected void printAdjacencyList(){
		for(int i = 0; i < adjacencyList.length; i++){
			Iterator<Edge> ite = adjacencyList[i].iterator();
			while(ite.hasNext()){
				Edge e = ite.next();
				System.out.println(i + " --> " + e.vertex2 + "," + e.weight);
			}
		}
	}
}
