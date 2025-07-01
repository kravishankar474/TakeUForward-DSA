package binaryTrees.traversals;

import binaryTrees.TreeNode;

/*
 * Algorithm Steps
1. Perform a postorder traversal of the Binary Tree using recursion: 
	First visit the left subtree, then the right subtree, and finally the root node. 
	During this traversal, compute the heights of the left and right subtrees for each node. 
	Utilize these computed heights to verify the balance condition at the current node.
2. If, at any node, the absolute difference between the heights of the left and right subtrees exceeds 1, or 
	if any subtree is determined to be unbalanced (returns -1), return -1 immediately, signaling that the tree is unbalanced.
3. For a balanced tree, return the height of the current node by taking the greater height of its left or right subtree 
	and adding 1 to account for the current node itself.
4. Continue the traversal process until all nodes have been visited. 
	The final result will either be the height of the entire tree if it is balanced, or -1 if the tree is found to be unbalanced at any point.
 */

public class BalancedTreeOptimal {

	public boolean isBalanced(TreeNode root) {
		// Call the recursive helper method to check balance status.
		// If the heightDifference() returns -1, the tree is unbalanced.
		return dfsHeight(root) != -1;
	}

	/**
	 * Recursive method to calculate the height of the tree. Returns -1 if the tree
	 * is unbalanced, otherwise returns the height of the tree.
	 * 
	 * @param root The current node of the tree.
	 * @return The height of the tree if balanced, -1 if unbalanced.
	 */
	private int dfsHeight(TreeNode root) {
		// Base case: If the current node is null, the height of an empty tree is 0.
		if (root == null)
			return 0;

		// Recursively calculate the height of the left subtree.
		int leftHeight = dfsHeight(root.left);
		// If the left subtree is unbalanced, propagate the unbalance status.
		if (leftHeight == -1)
			return -1;

		// Recursively calculate the height of the right subtree.
		int rightHeight = dfsHeight(root.right);
		// If the right subtree is unbalanced, propagate the unbalance status.
		if (rightHeight == -1)
			return -1;

		// Check if the difference in height between the left and right subtrees is
		// greater than 1.
		// If the difference is greater, the tree is unbalanced.
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;

		// Return the height of the tree rooted at the current node.
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(6);
		root.left.right.right.right = new TreeNode(7);

		// Creating an instance of the BalancedTreeOptimal class
		BalancedTreeOptimal BalancedTreeOptimal = new BalancedTreeOptimal();

		// Checking if the tree is balanced
		if (BalancedTreeOptimal.isBalanced(root)) {
			System.out.println("The tree is balanced.");
		} else {
			System.out.println("The tree is not balanced.");
		}
	}
}
