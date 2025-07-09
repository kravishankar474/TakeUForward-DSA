package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binaryTrees.TreeNode;

/*
 * Approach
1. Initialize an empty queue for storing nodes during traversal and a 2D array (or vector of vectors) for the level order traversal.
2. If the tree is empty, return the empty 2D array and enqueue the root node into the queue.
3. While the queue is not empty:
		1. Determine the current size of the queue, representing the number of nodes at the current level.
		2. Create a vector to store the nodes at the current level.
		3. For each node at the current level, dequeue the front node from the queue. Add the node’s value to the level vector. 
			Enqueue the left and right children of the current node, if they exist.
		4. After processing all nodes at the current level, add the level vector to the 2D array.
4. To obtain the left view, extract the first element from each level's vector and store it in a separate array. 
	This array represents the left view of the binary tree.
5. To obtain the right view, extract the last element from each level's vector and store it in a separate array. 
	This array represents the right view of the binary tree.
 */
public class RightLeftView {

	// Function to return the Right view of the binary tree
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		// Get the level order traversal of the tree
		List<List<Integer>> levelTraversal = levelOrder(root);

		// Iterate through each level and add the last element to the result
		for (List<Integer> level : levelTraversal) {
			res.add(level.get(level.size() - 1));
		}

		return res;
	}

	// Function to return the Left view of the binary tree
	public List<Integer> leftSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		// Get the level order traversal of the tree
		List<List<Integer>> levelTraversal = levelOrder(root);

		// Iterate through each level and add the first element to the result
		for (List<Integer> level : levelTraversal) {
			res.add(level.get(0));
		}

		return res;
	}

	// Function that returns the level order traversal of a Binary tree
	private List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();

		// Return an empty list if the tree is empty
		if (root == null) {
			return ans;
		}

		// Use a queue to perform level order traversal
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> level = new ArrayList<>();

			// Process each node in the current level
			for (int i = 0; i < size; i++) {
				TreeNode top = q.poll();
				level.add(top.data);

				// Enqueue the left child if it exists
				if (top.left != null) {
					q.add(top.left);
				}

				// Enqueue the right child if it exists
				if (top.right != null) {
					q.add(top.right);
				}
			}

			// Add the current level to the result
			ans.add(level);
		}

		return ans;
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

		RightLeftView RightLeftView = new RightLeftView();

		// Get the Right View traversal
		List<Integer> rightView = RightLeftView.rightSideView(root);

		// Print the result for Right View
		System.out.print("Right View Traversal: ");
		for (int node : rightView) {
			System.out.print(node + " ");
		}
		System.out.println();

		// Get the Left View traversal
		List<Integer> leftView = RightLeftView.leftSideView(root);

		// Print the result for Left View
		System.out.print("Left View Traversal: ");
		for (int node : leftView) {
			System.out.print(node + " ");
		}
		System.out.println();
	}
}
