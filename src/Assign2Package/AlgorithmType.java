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

public enum AlgorithmType {
	Warshall("Warshall"), Floyd("Floyd"), MatrixMultiplication("MatrixMultiplication"), Knapsack("Knapsack");
	private String value;
	private AlgorithmType(String value) {
		this.value = value;
	}
	
	public String algorithmType(){
		return this.value;
	}
}
