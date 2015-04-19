package Assign2Package;

import java.util.Stack;

public class UnionFind {
	
	protected int [] set;
	
	public UnionFind(int n){
		set = new int[n];
		for(int i = 0; i< set.length; i++){
			set[i] = -1;
		}
	}
	
	public int find(int x){
		Stack<Integer> s = new Stack<Integer>(); // not needed?
		while(set[x] >= 0){
			s.push(x);  // not needed?
			x = set[x];
		}
		while(!s.isEmpty()){ // needed???
			set[s.pop()] = x;
		}
		return x;
	}
	
	public void union(int x, int y){
		while(set[x] >= 0){
			x = set[x];
		}
		while(set[y] >= 0){
			y = set[y];
		}
		if(x == y){
			return;
		}
		
		if(set[x] < set[y]){
			set[x] += set[y];
			set[y] = x;
		}
		else{
			set[y] += set[x];
			set[x] = y;
		}
	}
}
