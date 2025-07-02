package binaryTrees.traversals;
/*
 * Approach
1. Start by initializing a variable diameter to keep track of the maximum diameter of the tree. 
	Then, create a helper function named height that accepts a node and a reference to the diameter variable.
2. For the base case, if the node is null, return 0. In the recursive function, compute the heights of the left and right subtrees for each node. 
	Determine the current diameter by adding these subtree heights together and then adding 1 to account for the node itself. 
	Update the global diameter variable with the maximum value encountered so far.
3. Once the entire tree has been traversed, return the maximum diameter recorded during the traversal as the final result.
 */

import binaryTrees.TreeNode;

/*
 * Complexity Analysis
Time Complexity: O(N) In the optimized approach, each node is visited once, and its height is calculated during the postorder traversal.

Space Complexity: O(H) The space complexity is determined by the maximum depth of the recursion stack, which corresponds to the height of the tree, H.
 */

public class DiameterOfTreeOptimal {

	// Function to find the diameter of a binary tree
	public int diameterOfBinaryTree(TreeNode root) {
		// Initialize the variable to store the diameter of the tree
		int[] diameter = new int[1];
		diameter[0] = 0;

		// Call the height function to traverse the tree and calculate diameter
		height(root, diameter);

		// Return the calculated diameter
		return diameter[0];
	}

	// Function to calculate the height of the tree and update the diameter
	private int height(TreeNode node, int[] diameter) {
		// Base case: If the node is null, return 0 indicating an empty tree height
		if (node == null) {
			return 0;
		}

		// Recursively calculate the height of left and right subtrees
		int[] lh = new int[1];
		int[] rh = new int[1];
		lh[0] = height(node.left, diameter);
		rh[0] = height(node.right, diameter);

		// Update the diameter with the maximum of current diameter
		diameter[0] = Math.max(diameter[0], lh[0] + rh[0]);

		// Return the height of the current node's subtree
		return 1 + Math.max(lh[0], rh[0]);
	}

	// Main method to test the function
	public static void main(String[] args) {
		// Example usage: Create a tree and find its diameter
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		DiameterOfTreeOptimal DiameterOfTreeOptimal = new DiameterOfTreeOptimal();
		int result = DiameterOfTreeOptimal.diameterOfBinaryTree(root);
		System.out.println("Diameter of the binary tree is: " + result);
	}
}
