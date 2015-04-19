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


public class MatrixMultiplication {

	protected static String str = "";
	protected static int [][] N;
	//keep track of optimal parenthesis
	protected static int [][] s;

	public static int[][] matrixMultiplicationProblem(int n, String diString){
		N = new int[n][n];
		s = new int[n][n];
		int [] di;
		
		//Make di array 
		String[] diStringArray = diString.split("[ ]+");
		di = new int [diStringArray.length];
		for (int i = 0; i < diStringArray.length; i++) {
			di[i] = Integer.parseInt(diStringArray[i]);
		}
		//set diagonal to zero's
		for(int i = 0; i < (n - 1); i++){
			N[i][i] = 0;
		}
		for(int b = 1; b <= (n-1); b++){
			for(int i = 0; i <= (n-b-1); i++){
				int j = i + b;
				N[i][j] = Integer.MAX_VALUE;
				for(int k = i; k <= (j-1); k++){
					int number = N[i][k] + N[k + 1][j] + (di[i]*di[k + 1] * di[j + 1]);
					if(number <= N[i][j]){
						N[i][j] = number;
						s[i][j] = k;
					}

				}

			}
		}
		return N;
	}


	protected static String printOptimalParens(int i, int j){
		if(i == j){
			str += "A[" + i + "]";	
		}
		else{
			str += " (";
			printOptimalParens(i, s[i][j]);
			printOptimalParens(s[i][j] + 1, j);
			str += ") ";
		}
		return str;

	}

}

