package assignment5;
/*
 * type 1 for huffman and 2 for RB tree in first line
 * Second line: data to be inputed
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class HuffmanRBTreeTester extends JPanel{

	int algorithm;
	String RBData;
	String stringArray [];
	int [] RBNodeArray;
	String huffmanData;
	String parameters = "[ ]+";


	private static final long serialVersionUID = 1L;

	//File properties
	private File selectedFile;
	private Scanner fileStream;
	private JFileChooser chooseFile;

	public HuffmanRBTreeTester() throws FileNotFoundException {
		chooseFile = new JFileChooser();
		if(chooseFile.showOpenDialog(HuffmanRBTreeTester.this) == JFileChooser.APPROVE_OPTION){
			selectedFile = chooseFile.getSelectedFile();
			fileStream = new Scanner(selectedFile);
			algorithm = Integer.parseInt(fileStream.nextLine());
			
			if(algorithm == 1){
				huffmanData = fileStream.nextLine();
				Huffman h = new Huffman(huffmanData);
			}
			else if (algorithm == 2){
				RBData = fileStream.nextLine();
				stringArray = RBData.split(parameters);
				RBNodeArray = new int[stringArray.length];
				for(int i = 0; i < stringArray.length; i++){
					RBNodeArray[i] = Integer.parseInt(stringArray[i]);
				}
				RBTree rbt = new RBTree(Integer.MIN_VALUE); 
				for(int j = 0; j < RBNodeArray.length; j++){
					System.out.println("INSERTING " + RBNodeArray[j] + " INTO SPLAY TREE ");
					rbt.insert(RBNodeArray[j]);
					rbt.preorder();
					System.out.println("--------------------------------------------------" );
				}
			}

		}
	}
	public static void main(String[] args) throws Exception {
		try{
			new HuffmanRBTreeTester();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
			throw ex;
		}
	}
}





