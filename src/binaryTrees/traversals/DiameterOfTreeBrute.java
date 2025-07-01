package binaryTrees.traversals;

import binaryTrees.TreeNode;

/*
 * Approach
1. Start by initializing a global variable diameter to keep track of the maximum diameter encountered during the traversal. 
	This variable will be updated at each node as the tree is traversed.
2. Create a recursive function called calculateHeight that calculates the height of each node. 
	For each node, compute the height of its left and right subtrees, and use these values to determine the current diameter by summing the heights. 
	Continuously update the diameter variable with the maximum value encountered during this process.
3. Begin traversing the tree from the root node, utilizing the calculateHeight function to compute and update the maximum diameter at each node. 
	Once the traversal is complete, return the value stored in diameter as the final result.
 */

public class DiameterOfTreeBrute {

	// Function to compute the height of a subtree
	private int height(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}

	// Function to find the diameter of a binary tree (Brute Force)
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		// Get the height of left and right subtrees
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		// Calculate diameter through the current node
		int currentDiameter = leftHeight + rightHeight;

		// Recursively calculate the diameter of left and right subtrees
		int leftDiameter = diameterOfBinaryTree(root.left);
		int rightDiameter = diameterOfBinaryTree(root.right);

		// Return the maximum of the three values
		return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
	}

	public static void main(String[] args) {
		// Creating a test tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		DiameterOfTreeBrute sol = new DiameterOfTreeBrute();
		System.out.println("Diameter of the binary tree is: " + sol.diameterOfBinaryTree(root));
	}
}
