package binaryTrees.traversals;

import binaryTrees.TreeNode;

/*
 * 
 * Approach
1. If the current node is null (meaning there is no node), return 0. This is the base case of our recursion.
2. Recursively find the maximum depth of the left sub-tree and the maximum depth of the right sub-tree.
3. The depth of the current node is 1 (for the current node itself) plus the maximum of the depths of the left and right sub-trees.
 */

public class MaxDepthInBT {

	public int maxDepth(TreeNode root) {
		// Base case: if the node is null, return 0
		if (root == null) {
			return 0;
		}
		// Recursively find the depth of the left and right subtrees
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		// The depth of the tree is 1 current node + the maximum depth of the subtrees
		return 1 + Math.max(left, right);
	}

	// Main method to test the function
	public static void main(String[] args) {
		MaxDepthInBT MaxDepthInBT = new MaxDepthInBT();
		// Example usage:
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println("Maximum Depth: " + MaxDepthInBT.maxDepth(root));
	}
}
