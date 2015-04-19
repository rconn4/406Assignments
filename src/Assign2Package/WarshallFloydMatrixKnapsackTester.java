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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class WarshallFloydMatrixKnapsackTester extends JPanel{
	
	int numNodes;
	int numEdges;
	String edgesList;
	int numMatrices;
	String dataArray;
	String values;
	String weights;
	int numValues;
	int knapsackWeight;
	
	
	private static final long serialVersionUID = 1L;
	AlgorithmType algorithmType;
	String algorithmStringType;
	
	//File properties
	private File selectedFile;
	private Scanner fileStream;
	private JFileChooser chooseFile;
	
	public WarshallFloydMatrixKnapsackTester() throws FileNotFoundException {
		chooseFile = new JFileChooser();
		if(chooseFile.showOpenDialog(WarshallFloydMatrixKnapsackTester.this) == JFileChooser.APPROVE_OPTION){
			selectedFile = chooseFile.getSelectedFile();
			fileStream = new Scanner(selectedFile);
			algorithmStringType = fileStream.nextLine();
			for (AlgorithmType algorithm: AlgorithmType.values()){
				if (algorithmStringType.equals(algorithm.algorithmType())){
					algorithmType = algorithm;
					break;
				}
			}
			
			switch (algorithmType) {
			case Warshall:
				numNodes = Integer.parseInt(fileStream.nextLine());
				numEdges = Integer.parseInt(fileStream.nextLine());
				edgesList = fileStream.nextLine();
				new Amdg(numNodes, numEdges, edgesList);
				break;
			case Floyd:
				numNodes = Integer.parseInt(fileStream.nextLine());
				numEdges = Integer.parseInt(fileStream.nextLine());
				edgesList = fileStream.nextLine();
				new Amwdg(numNodes, numEdges, edgesList);
				break;
			case MatrixMultiplication:
				numMatrices = Integer.parseInt(fileStream.nextLine());
				dataArray = fileStream.nextLine();
				System.out.println("MATRIX CHAIN MULTIPLICATION: ");
				printMatrix(MatrixMultiplication.matrixMultiplicationProblem(numMatrices, dataArray));
				System.out.println("The optimal parerentheis is: ");
				String s = MatrixMultiplication.printOptimalParens(0, numMatrices - 1);
				System.out.println(s);
				break;
			case Knapsack:
				values = fileStream.nextLine();
				weights = fileStream.nextLine();
				numValues = Integer.parseInt(fileStream.nextLine());
				knapsackWeight = Integer.parseInt(fileStream.nextLine());
				System.out.println(" 0 - 1 KNAPSACK PROBLEM:  ");
				Knapsack.theKnapsack(values, weights , numValues, knapsackWeight);
				break;
			default:
				break;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		try{
			new WarshallFloydMatrixKnapsackTester();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
			throw ex;
		}
	}
	
	public static void printMatrix(int[][] matrix) {
		System.out.println("The matrix is: ");
		for (int i = 0; i < matrix.length ; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
