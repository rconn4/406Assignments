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

public class Kruskal {

	//static Set<Integer>[] theSet;
	//static Set<Edge> tree;
	
	static UnionFind unionf;
	
	public static ArrayList<Edge> minimumSpanningtree(Queue<Edge> edgeQueue, int numNodes){
		
		unionf = new UnionFind(numNodes + 1);
		ArrayList<Edge> list = new ArrayList<Edge>();
		Edge e = null;
		
		while(list.size() < numNodes - 1){
			e = edgeQueue.poll();
			int v1 = e.vertex1;
			int v2 = e.vertex2;
			if(unionf.find(v1) != unionf.find(v2)){
				list.add(e);
				unionf.union(v1, v2);
			}
		}
		return list;
		
		
		
	}
		
		/*theSet = new HashSet[numNodes + 1];
		for(int i = 1; i < numNodes + 1; i++){
			theSet[i] = new HashSet<Integer>();
			theSet[i].add(i);
		}
		tree = new HashSet<Edge>();
		Edge e = null;
		int numEdge = edgeQueue.size() - 1;
		while(tree.size() < numEdge){
			e = edgeQueue.poll();
			if(find(e.vertex1) != find(e.vertex2)){
				tree.add(e);
				union(e.vertex1, e.vertex2);
			}
		}
		return tree;

	}

	private static int find(int k){
		for(int i = 1; i < theSet.length; i++){
			Iterator<Integer> ite = theSet[i].iterator();
			while(ite.hasNext()){
				if(ite.next() == k){
					return i;
				}
			}

		}
		return 0;
	}

	private static void union(int i, int j){
		theSet[j] = theSet[i];
	}
*/

}
