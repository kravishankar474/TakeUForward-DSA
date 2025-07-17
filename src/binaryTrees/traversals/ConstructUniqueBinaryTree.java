package binaryTrees.traversals;

/*
 * Approach
1. To determine if a unique binary tree can be constructed from two given traversals identify combinations that fail 
	to provide sufficient information for unique reconstruction. 
	Return false if the two traversals are the same, as they do not provide additional distinguishing information, 
	or if the traversals are preorder and postorder, which cannot uniquely define a binary tree due to their inability to differentiate 
	between certain tree structures. By checking these conditions, the ConstructUniqueBinaryTree ensures that only valid traversal pairs, 
	which can uniquely define a binary tree, are considered
 */

public class ConstructUniqueBinaryTree {
	
	    public boolean uniqueBinaryTree(int a, int b) {
	        // Return false if both traversals are the same 
	       // or if they are preorder and postorder
	        return !(a == b || (a == 1 && b == 3) || (a == 3 && b == 1));
	    }

	    public static void main(String[] args) {
	        ConstructUniqueBinaryTree ConstructUniqueBinaryTree = new ConstructUniqueBinaryTree();
	        // Example test cases
	        System.out.println(ConstructUniqueBinaryTree.uniqueBinaryTree(1, 2)); 
	        System.out.println(ConstructUniqueBinaryTree.uniqueBinaryTree(1, 3)); 
	    }
	}


