package assignment5;

import java.util.*;

public class Huffman {

	String text;
	int [] frequency;
	PriorityQueue<HuffmanTree> Q;

	public Huffman(String s){
		text = s;
		frequency = getCharacterFrequency(text);
		HuffmanTree hf = huffmanTree();
		printTreeInOrder(hf.root);
	}


	public HuffmanTree huffmanTree(){
		Q = new PriorityQueue<HuffmanTree>();
		for (int i = 0; i < frequency.length; i++) {
			if (frequency[i] > 0){
				HuffmanTree tree = new HuffmanTree((char)i, frequency[i]);
				Q.offer(tree);
			}
		}
		while(Q.size() > 1){
			HuffmanTree f1 = Q.poll();
			HuffmanTree f2 = Q.poll();
			HuffmanTree tree2 = new HuffmanTree(f1, f2);
			Q.offer(tree2);
		}
		return Q.poll();
	}

	public int[] getCharacterFrequency(String text) {
		int[] counts = new int[256]; // 256 ASCII characters

		for (int i = 0; i < text.length(); i++){
			counts[(int)text.charAt(i)]++; // Count the character in text
		}
		return counts;
	}
	
	public void printTreePreOrder(HuffmanNode n){
		  if (n != null){
	            System.out.println("element: " + n.element + " frequency: " + n.freq );
	            printTreePreOrder(n.left);             
	            printTreePreOrder(n.right);
	        }
	}
	
	public void printTreeInOrder(HuffmanNode n){
		  if (n != null){
			  printTreePreOrder(n.left); 
	            System.out.println("element: " + n.element + " frequency: " + n.freq );            
	            printTreePreOrder(n.right);
	        }
	}
}
