package binaryTrees.traversals;

import binaryTrees.TreeNode;

/*
 * Approach
1. First, check if the root node is null. If it is, return true because an empty tree is inherently balanced.
2. For non-empty trees, recursively calculate the height of both the left and right subtrees using a helper function, often called getHeight. Store these heights and compare them. If the absolute difference between the heights is greater than 1, return false, as this indicates the tree is unbalanced at the current node.
3. If the height difference is 1 or less, proceed by recursively invoking the isBalanced function on the left and right child nodes. If both subtrees are found to be balanced, return true. If either subtree is unbalanced, return false, indicating that the tree overall is not balanced.
 */

/*
 * Time Complexity: O(N^2) where N is the number of nodes in the Binary Tree. For each node in the Binary Tree, all other nodes are traversed to calculate its height, resulting in a nested traversal structure, leading to O(N) operations for each of the N nodes, hence O(N * N) = O(N^2).

Space Complexity: O(N), because of the recursive stack space.
 */

public class BalancedTree {

	public boolean isBalanced(TreeNode root) {
		// If the tree is empty, it's balanced
		if (root == null) {
			return true;
		}

		// Calculate the height of left and right subtrees
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);

		// Check if the absolute difference in heights
		// of left and right subtrees is <= 1
		if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
			return true;
		}

		// If any condition fails, the tree is unbalanced
		return false;
	}

	// Function to calculate the height of a subtree
	public int getHeight(TreeNode root) {
		// Base case: if the current node is NULL,
		// return 0 (height of an empty tree)
		if (root == null) {
			return 0;
		}

		// Recursively calculate the height
		// of left and right subtrees
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);

		// Return the maximum height of left and right subtrees
		// plus 1 (to account for the current node)
		return Math.max(leftHeight, rightHeight) + 1;
	}

	// Main function

	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(6);
		root.left.right.right.right = new TreeNode(7);

		// Creating an instance of the BalancedTree class
		BalancedTree BalancedTree = new BalancedTree();

		// Checking if the tree is balanced
		if (BalancedTree.isBalanced(root)) {
			System.out.println("The tree is balanced.");
		} else {
			System.out.println("The tree is not balanced.");
		}
	}
}
