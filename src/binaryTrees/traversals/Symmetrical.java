package binaryTrees.traversals;

import binaryTrees.TreeNode;

/*
 * Algorithm Steps
1. First, check if the tree is empty by verifying if the root node is null. 
	If the tree is empty, return true because an empty tree is symmetric by default.
2. If the tree is not empty, invoke a utility function, passing the left and right subtrees of the root node. 
	This function will handle the recursive checks necessary to determine symmetry.
3. The base case in the recursive function occurs when both the left and right subtrees are null, in which case the function should return true. 
	However, if only one subtree is null while the other is not, return false, as this indicates asymmetry.
4. For each node, compare the values of the current nodes from the left and right subtrees. 
	Recursively check whether the left subtree of the left node mirrors the right subtree of the right node and vice versa. 
	Continue these recursive comparisons until all corresponding nodes have been evaluated. 
	If every comparison holds true, the tree is symmetric, and the function should return true. 
	If any comparison fails, the function will return false, indicating that the tree is not symmetric.
 */

/*
 * Complexity Analysis
Time complexity: O(N) This is because there are N number of nodes in the binary tree each node is traversed once to check for symmetry.

Space complexity : O(h) This is because the maximum depth of the recursion stack is equal to the height of the tree.
 */
public class Symmetrical {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true; // An empty tree is symmetric
		}
		return symmetry(root.left, root.right);
	}

	private boolean symmetry(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true; // Both nodes are null, so symmetric
		}

		if (left == null || right == null) {
			return false; // One of the nodes is null, so not symmetric
		}

		if (left.data != right.data) {
			return false; // The values of the nodes do not match, so not symmetric
		}

		// Recursively check the children of the nodes
		return symmetry(left.left, right.right) && symmetry(left.right, right.left);
	}

	public static void main(String[] args) {
		Symmetrical Symmetrical = new Symmetrical();

		// Create a sample tree: 1, 2, 2, 3, 4, 4, 3
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);

		// Test the symmetric tree
		System.out.println(Symmetrical.isSymmetric(root)); // Output: true
	}
}
