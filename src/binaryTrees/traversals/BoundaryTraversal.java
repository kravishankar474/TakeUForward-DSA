package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.List;

import binaryTrees.TreeNode;

/*
 * Approach
 * 1. Begin by initializing an empty array to collect the nodes encountered during the boundary traversal. 
 * 		Additionally, create a helper function designed to determine whether a node is a leaf, 
 * 		which helps to prevent the inclusion of duplicate nodes in the traversal.
 * 2. Define a recursive function called addLeftBoundary and use a vector to keep track of nodes on the left boundary. 
 * 		Start this function at the root of the tree and proceed down the leftmost path until you reach a leaf node. 
 * 		For every non-leaf node encountered, append its value to the result list. 
 * 		Continue by traversing to the left child, and if the left child is not available, call the function on the right child.
 * 3. Next, create a recursive function named addLeafNodes and use a vector to store the nodes found at the bottom of the tree. 
 * 		When this function encounters a leaf node, add its value to the result list. 
 * 		Recursively visit the left and right subtrees of the current node following a preorder traversal pattern.
 * 4. Define another recursive function, addRightBoundary, and use a vector to capture nodes on the right boundary. 
 * 		Begin at the root and traverse the rightmost path of the tree until reaching a leaf node. 
 * 		For each non-leaf node, first attempt to traverse to its right child; if that child is unavailable, move to the left child. 
 * 		As the recursion returns, add the current node's value to the result list
 * 
 * Complexity Analysis
Time Complexity: O(N) where N is the number of nodes in the Binary Tree. 
	This is due to traversing the left boundary, bottom nodes, and right boundary sequentially, each operation being at most O(N).

Space Complexity: O(N) for storing boundary nodes and auxiliary recursion stack space in the worst-case scenario of a skewed tree.

 */
public class BoundaryTraversal {

	// Function to check if a node is a leaf
	public boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}

	// Function to add the left boundary of the tree
	public void addLeftBoundary(TreeNode root, List<Integer> res) {
		TreeNode curr = root.left;
		while (curr != null) {
			if (!isLeaf(curr)) {
				res.add(curr.data);
			}
			if (curr.left != null) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
	}

	// Function to add the right boundary of the tree
	public void addRightBoundary(TreeNode root, List<Integer> res) {
		TreeNode curr = root.right;
		List<Integer> temp = new ArrayList<>();
		while (curr != null) {
			if (!isLeaf(curr)) {
				temp.add(curr.data);
			}
			if (curr.right != null) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		for (int i = temp.size() - 1; i >= 0; --i) {
			res.add(temp.get(i));
		}
	}

	// Function to add the leaves of the tree
	public void addLeaves(TreeNode root, List<Integer> res) {
		if (isLeaf(root)) {
			res.add(root.data);
			return;
		}
		if (root.left != null) {
			addLeaves(root.left, res);
		}
		if (root.right != null) {
			addLeaves(root.right, res);
		}
	}

	// Main function to perform the boundary traversal of the binary tree
	public List<Integer> boundary(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		if (!isLeaf(root)) {
			res.add(root.data);
		}

		addLeftBoundary(root, res);
		addLeaves(root, res);
		addRightBoundary(root, res);

		return res;
	}

	// Helper function to print the result
	public static void printResult(List<Integer> result) {
		for (int val : result) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		BoundaryTraversal BoundaryTraversal = new BoundaryTraversal();

		// Get the boundary traversal
		List<Integer> result = BoundaryTraversal.boundary(root);

		// Print the result
		System.out.print("Boundary Traversal: ");
		printResult(result);
	}
}
