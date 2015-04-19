package assignment4;

/*
 * 
 * Ryan Connors
 * Assignment 4
 * CSC406
 * Spring 2015
 * Assigned: March 25th
 * Due: April 15
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JPanel;


public class SplayTreeTester extends JPanel {
	String nodeList;
	String stringArray [];
	int nodeArray [];
	String parameters = "[ ]+";
	
	
	private static final long serialVersionUID = 1L;
	
	//File properties
	private File selectedFile;
	private Scanner fileStream;
	private JFileChooser chooseFile;
	
	public SplayTreeTester() throws FileNotFoundException {
		chooseFile = new JFileChooser();
		SplayTree splay = new SplayTree();
		if(chooseFile.showOpenDialog(SplayTreeTester.this) == JFileChooser.APPROVE_OPTION){
			selectedFile = chooseFile.getSelectedFile();
			fileStream = new Scanner(selectedFile);
			nodeList = fileStream.nextLine();
			stringArray = nodeList.split(parameters);
			nodeArray = new int[stringArray.length];
			for(int i = 0; i < stringArray.length; i++){
				nodeArray[i] = Integer.parseInt(stringArray[i]);
			}
			for(int j = 0; j < nodeArray.length; j++){
				System.out.println("INSERTING " + nodeArray[j] + " INTO SPLAY TREE ");
				splay.insert(nodeArray[j]);
				System.out.println("--------------------------------------------------" );
			}
			System.out.println("INSERTING 6 INTO SPLAY TREE: ");
			splay.insert(6);
			System.out.println("--------------------------------------------------" );
			System.out.println("SEARCHING FOR 4 IN SPLAY TREE: ");
			splay.search(4);
			System.out.println("--------------------------------------------------" );
			System.out.println("DELETING 2 FROM SPLAY TREE: ");
			splay.delete(2);
			System.out.println("--------------------------------------------------" );
			System.out.println("SEARCHING FOR 6 IN SPLAY TREE: ");
			splay.search(6);
			System.out.println("--------------------------------------------------" );
			System.out.println("DELETING 5 FROM SPLAY TREE: ");
			splay.delete(5);
			System.out.println("--------------------------------------------------" );
			System.out.println("INSERTING 2 INTO SPLAY TREE: ");
			splay.insert(2);
			
			
			
		}
	}
	public static void main(String[] args) throws Exception {
		try{
			new SplayTreeTester();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
			throw ex;
		}
	}
}

