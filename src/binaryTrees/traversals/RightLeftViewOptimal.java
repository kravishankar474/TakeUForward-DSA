package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.List;

import binaryTrees.TreeNode;

/*
 * Approach
Algorithm for Left View
1. Begin by initializing an empty vector named res to hold the nodes visible from the left view of the binary tree.
2. Implement a recursive depth-first search (DFS) approach to traverse the tree:
		1. Base Case: If the current node is null, terminate the recursion as this indicates the end of a vertical level.
		2. Recursive Function: Define the function to accept the current node, its vertical level, and the result vector res as parameters.
		3. Within the recursive function, check if the size of res is equal to the current level. If true, add the value of the current node to res, 
			as this is the first node encountered at this vertical level.
		4. Proceed by making a recursive call to the function for the left child of the current node, followed by the right child, 
			incrementing the level by 1 for each call. This ensures nodes are processed from top to bottom, left to right.
3. Continue the recursion process until all nodes are traversed and the base case is encountered. Return the vector res, 
	which will now contain the nodes visible from the left view of the tree.
 */
/*
 * for right start with right recursion first.
 */

/*
 * Complexity Analysis
Time Complexity: O(N), where N is the number of nodes in the tree.
As each node is visited once and for each node, we perform a constant amount of work (checking conditions and making at most two recursive calls). 
	Thus, the time complexity is O(N).

Space Complexity: O(H), where H is the height of the binary tree.
Because of the recursive stack space which depends on the height of the tree.

Note:

In a balanced tree, height H is nearly equal to logN. Hence, the best-case space complexity is O(logN).
In a skewed tree, height H is almost equal to N. Hence, the worst-case space complexity turns out to be O(N).
 */
public class RightLeftViewOptimal {

	// Function to return the Right view of the binary tree
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		// Call the recursive function to populate the right-side view
		recursionRight(root, 0, res);

		return res;
	}

	// Function to return the Left view of the binary tree
	public List<Integer> leftSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		// Call the recursive function to populate the left-side view
		recursionLeft(root, 0, res);

		return res;
	}

	// Recursive function to traverse the binary tree and populate the left-side
	// view
	private void recursionLeft(TreeNode root, int level, List<Integer> res) {
		// Check if the current node is NULL
		if (root == null) {
			return;
		}

		// Check if the size of the result list is equal to the current level
		if (res.size() == level) {
			// If equal, add the value of the current node to the result list
			res.add(root.data);
		}

		// Recursively call the function for the left child with an increased level
		recursionLeft(root.left, level + 1, res);

		// Recursively call the function for the right child with an increased level
		recursionLeft(root.right, level + 1, res);
	}

	// Recursive function to traverse the binary tree and populate the right-side
	// view
	private void recursionRight(TreeNode root, int level, List<Integer> res) {
		// Check if the current node is NULL
		if (root == null) {
			return;
		}

		// Check if the size of the result list is equal to the current level
		if (res.size() == level) {
			// If equal, add the value of the current node to the result list
			res.add(root.data);
		}

		// Recursively call the function for the right child with an increased level
		recursionRight(root.right, level + 1, res);

		// Recursively call the function for the left child with an increased level
		recursionRight(root.left, level + 1, res);
	}

	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(10);
		root.left.left.right = new TreeNode(5);
		root.left.left.right.right = new TreeNode(6);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(10);
		root.right.left = new TreeNode(9);

		RightLeftViewOptimal RightLeftViewBrute = new RightLeftViewOptimal();

		// Get the Right View traversal
		List<Integer> rightView = RightLeftViewBrute.rightSideView(root);

		// Print the result for Right View
		System.out.print("Right View Traversal: ");
		for (int node : rightView) {
			System.out.print(node + " ");
		}
		System.out.println();

		// Get the Left View traversal
		List<Integer> leftView = RightLeftViewBrute.leftSideView(root);

		// Print the result for Left View
		System.out.print("Left View Traversal: ");
		for (int node : leftView) {
			System.out.print(node + " ");
		}
		System.out.println();
	}
}
