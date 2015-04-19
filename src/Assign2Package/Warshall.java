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

public class Warshall {

	public static int[][] transitiveClosure(int [][] theMatrix) {
		int [][] matrix = theMatrix;
		for(int k = 1; k < matrix.length; k++){
			for(int i = 1; i < matrix.length; i++){
				for(int j = 1; j < matrix.length; j++ ){
					if((matrix [i][k] == 1) && (matrix[k][j] == 1)){
						matrix[i][j] = 1;
					}
				}
			}
		}
		return matrix;
	}
}
