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

public class Edge{
	
	int vertex1;
	int vertex2;
	int weight;
	
	public Edge(int vertex1, int vertex2 , int weight){
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}
	public Edge(int vertex1, int vertex2){
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}
	
	public boolean equal(Object edge){
		if(edge == this){
			return true;
		}
		if(edge == null || edge.getClass() != this.getClass()){
			return false;
		}
		Edge e = (Edge) edge;
		return (this.vertex1 == e.vertex1 && this.vertex2 == e.vertex2)
				|| (this.vertex1 == e.vertex1 && this.vertex2 == e.vertex2 && this.weight == e.weight);
	}
	
	public static Comparator<Edge> weightComparator = new Comparator<Edge>(){
		
		public int compare(Edge e1, Edge e2){
			int edge1 = e1.weight;
			int edge2 = e2.weight;
			return edge1 - edge2;
		}
	};

}
