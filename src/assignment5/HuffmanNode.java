package assignment5;

public class HuffmanNode {
	
	char element;
	int freq;
	HuffmanNode left;
	HuffmanNode right;
	
	
	public HuffmanNode(){
		
	}
	
	public HuffmanNode(char element, int freq){
		this.element = element;
		this.freq = freq;
		
	}
}
