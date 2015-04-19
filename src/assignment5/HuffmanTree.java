package assignment5;


public class HuffmanTree implements Comparable<HuffmanTree>{

	HuffmanNode root;

	public HuffmanTree(HuffmanTree t1, HuffmanTree t2) {
		root = new HuffmanNode();
		root.right = t1.root;
		root.left = t2.root;
		root.freq = t1.root.freq + t2.root.freq;
	}

	/** Create a tree containing a leaf node */
	public HuffmanTree(char element, int frequency) {
		root = new HuffmanNode(element, frequency);
	}
	
	public int compareTo(HuffmanTree t) {
	      if (root.freq < t.root.freq) // Purposely reverse the order
	        return 1;
	      else if (root.freq == t.root.freq)
	        return 0;
	      else
	        return -1;
	    }
}
