package Assign2Package;

/*
 * 
 * Ryan Connors
 * Assignment 1
 * CSC406
 * Spring 2015
 * Assigned: January 26th
 * Due: February 11th
 * 
 * Please put each piece of information on their own line
 * 
 * In the first line of the file Please enter one of the following numbers
 * 1:Amdg
 * 2:Amwdg
 * 3:Alwdg
 * 4:Aldg
 * 5:Amwg
 * 6:Alwg
 * Then enter the number of nodes
 * Then enter the number of edges
 * Then enter the list of edges with a space between every number
 * 
 */

import java.io.*;

import javax.swing.*;

import java.util.*;


public class GraphTester extends JPanel {

	int fileType;
	int numNodes;
	int numEdges;
	String edges;
	File selectedFile;
	Scanner readFile;
	private JFileChooser chooseFile;

	public GraphTester(){
		chooseFile = new JFileChooser();
		try{
			if(chooseFile.showOpenDialog(GraphTester.this) == JFileChooser.APPROVE_OPTION){
				selectedFile = chooseFile.getSelectedFile();
				readFile = new Scanner(selectedFile);
				fileType = Integer.parseInt(readFile.nextLine());
				numNodes = Integer.parseInt(readFile.nextLine());
				numEdges = Integer.parseInt(readFile.nextLine());
				edges = readFile.nextLine();
				
				switch(fileType){
				case 1: new Amdg(numNodes, numEdges , edges); break;
				case 2: new Amwdg(numNodes , numEdges, edges); break;
				case 3: new Alwdg(fileType, numNodes, numEdges, edges); break;
				case 4:	new Aldg(fileType, numNodes, numEdges, edges); break;
				case 5: new Amwg(fileType, numNodes, numEdges, edges); break;
				case 6: new Alwg(fileType, numNodes, numEdges, edges); break;
				}
			}
		}
		catch (FileNotFoundException ex){
			System.out.println("The requested file was not found");
		}
	}
	public static void main(String []args) throws IOException{
		try{
			new GraphTester();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
			try {
				throw ex;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}


