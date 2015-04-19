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
 * 
 * This Class all Assignment 2 Code
 */

import java.util.*;

public class TopologicalSort {
	
	public static int[] sortedArray(Graph graph, int [] inDegreeArray){
		Stack<Integer> S = new Stack<Integer>();
		int [] output = new int [inDegreeArray.length];
		for(int i = 1; i < inDegreeArray.length; i++){
			if(inDegreeArray[i] == 0){
				S.push(i);
			}
		}
		int count = 1;
		int u;
		while(!S.isEmpty()){
			u = S.pop();
			output[count] = u;
			count++;
			Node[] adjacentVerticesArray = graph.adjacentVertices(u);
			for(int j = 0; j < adjacentVerticesArray.length; j++){
				int theNode = adjacentVerticesArray[j].name;
				inDegreeArray[theNode] = inDegreeArray[theNode] - 1;
				if(inDegreeArray[theNode] == 0){
					S.push(theNode);
				}
			}
		}
		if(count > graph.numNodes){
			return output;
		}
		System.out.println("G is cyclic");
		return output;
	}
	
}
