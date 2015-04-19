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
import java.util.*;

public class Knapsack {

	protected static int [][] M;
	protected static int [][] sub;
	protected static int []weights;

	public static int[][] theKnapsack(String vString, String wString, int n, int W){

		// make values into array
		String[] vStringArray = vString.split("[ ]+");
		int[] v = new int [vStringArray.length];
		for (int i = 0; i < vStringArray.length; i++) {
			v[i] = Integer.parseInt(vStringArray[i]);
		}
		// make weights into an array
		String[] wStringArray = wString.split("[ ]+");
		int[] w = new int [wStringArray.length];
		for (int i = 0; i < wStringArray.length; i++) {
			w[i] = Integer.parseInt(wStringArray[i]);
		}

		//intialize
		M = new int[n + 1][W + 1];
		sub = new int[n + 1][W + 1];
		weights = w;
		
		//set zeros for first column and row
		for(int j = 0; j < W; j++){
			M[0][j] = 0;
		}
		//algorithm with sub[][] for keeping track
		for(int i = 1; i <= n ; i++){
			for(int j = 1; j <= W ; j++){
				if((j - w[i]) >= 0){
					if(M[i-1][j] > (v[i] + M[i-1][j - w[i]] )){
						M[i][j] = M[i-1][j];
						sub[i][j] = -1;
					}
					else{
						M[i][j] = (v[i] + M[i-1][j - w[i]] );
						sub[i][j] = 1;
					}
				}
				else{
					M[i][j] = M[i-1][j];
				}
			}
		}
		printMatrix(M);
		subset(M,w);
		return M;


	}
	// produce optimal subset
	public static void subset(int [][]solutionMatrix, int []weights){
		int[] subset = new int[weights.length];
		int numItems = 0;
		int i = solutionMatrix.length - 1;
		for (int j = solutionMatrix[0].length - 1; j >= 0 && i > 0;i--) {
			if (solutionMatrix[i][j] != solutionMatrix[i-1][j]) {
				subset[numItems] = i;
				j -= weights[i-1];
				numItems++;
			}
		}
		int [] optimal = Arrays.copyOfRange(subset, 0, numItems);
		System.out.print("the optimal subset is: { ");
		for(int m = 0; m < optimal.length; m++){
			System.out.print(optimal[m] + " , ");
		}
		System.out.println("} ");
	}
	
	//print matrix
	public static void printMatrix(int[][] matrix) {
		System.out.println("The matrix is: ");
		for (int i = 0; i < matrix.length ; i++) {
			for (int j = 0; j <= matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
