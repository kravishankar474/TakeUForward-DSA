package binaryTrees.traversals;

import binaryTrees.TreeNode;

/*
 * Approach
Base Case: If the current node is null, return 0, indicating there are no nodes to count at this point.
Recursive Calls: Compute the heights of the left and right subtrees by making recursive calls.
Check Heights: If the left height is equal to the right height, it indicates that the last level of the tree is completely filled. 
	In this case, you can calculate the total number of nodes using the formula: (1 << lh) - 1, where << denotes the left shift operator.
Handle Incomplete Last Level: If the left height does not match the right height, it suggests that the last level is not fully populated. 
	Here, you should recursively compute the number of nodes in both the left and right subtrees, and return the total count as 1 + countNodes(root->left) + countNodes(root->right).
Calculate Tree Heights: To determine the height of a subtree, initialize a height variable to 0. 
	Traverse down the left or right side of the tree using a while loop, incrementing the height variable until reaching a leaf node. 
		Return the final computed height.
 */
public class CountNodesBinaryTree {

	public int countNodes(TreeNode root) {
		// Base case: If the root
		// is NULL, there are no nodes
		if (root == null) {
			return 0;
		}

		// Find the left height and
		// right height of the tree
		int lh = findHeightLeft(root);
		int rh = findHeightRight(root);

		// Check if the last level
		// is completely filled
		if (lh == rh) {
			// If so, use the formula for
			// total nodes in a perfect
			// binary tree i.e. 2^h - 1
			return (1 << lh) - 1;
		}

		// If the last level is not completely
		// filled, recursively count nodes in
		// left and right subtrees
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	// Function to find the left height of a tree
	private int findHeightLeft(TreeNode node) {
		int height = 0;
		// Traverse left child until
		// reaching the leftmost leaf
		while (node != null) {
			height++;
			node = node.left;
		}
		return height;
	}

	// Function to find the right height of a tree
	private int findHeightRight(TreeNode node) {
		int height = 0;
		// Traverse right child until
		// reaching the rightmost leaf
		while (node != null) {
			height++;
			node = node.right;
		}
		return height;
	}


	public static void main(String[] args) {
		// Create the binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);

		CountNodesBinaryTree sol = new CountNodesBinaryTree();

		// Call the countNodes function
		int totalNodes = sol.countNodes(root);

		// Print the result
		System.out.println("Total number of nodes in the Complete Binary Tree: " + totalNodes);
	}
}
