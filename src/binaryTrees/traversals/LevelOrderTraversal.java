package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binaryTrees.TreeNode;

/*
 * 
 * Step 1: Initialise an empty queue and a 2D vector to store the level-order traversal result. If the binary tree is empty, return this empty 2D vector.
Step 2: Add the root node to the queue. This starts the traversal process from the top of the tree.
Step 3: While the queue is not empty, perform the following:
			Get the size of the queue, which indicates the number of nodes at the current level.
			Create a temporary vector to store the nodes' values for the current level.
			Iterate through the number of nodes at the current level:
			Dequeue the front node from the queue.
			Add the node’s value to the temporary vector.
			Enqueue the left and right children of this node (if they exist) into the queue.
			After processing all nodes at the current level, add the temporary vector to the 2D vector.
Step 4: Once the traversal is complete, return the 2D vector which now contains the level-order traversal of the binary tree.
 */

public class LevelOrderTraversal {

	// Function to perform level-order traversal of a binary tree
	public List<List<Integer>> levelOrder(TreeNode root) {
		// Create a list to store the levels
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			// If the tree is empty, return an empty list
			return ans;
		}

		// Create a queue to store nodes for level-order traversal
		Queue<TreeNode> q = new LinkedList<>();
		// Add the root node to the queue
		q.add(root);

		while (!q.isEmpty()) {
			// Get the size of the current level
			int size = q.size();
			// Create a list to store nodes at the current level
			List<Integer> level = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				// Get the front node from the queue
				TreeNode node = q.poll();
				// Add the node value to the current level list
				level.add(node.data);

				// Enqueue the child nodes if they exist
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
			// Add the current level to the answer list
			ans.add(level);
		}
		// Return the level-order traversal of the tree
		return ans;
	}

	// Main method to test the level-order traversal
	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		// Create an instance of the LevelOrderTraversal class
		LevelOrderTraversal LevelOrderTraversal = new LevelOrderTraversal();
		// Perform level-order traversal
		List<List<Integer>> result = LevelOrderTraversal.levelOrder(root);

		// Printing the level-order traversal result
		System.out.println("Level Order Traversal of Tree:");
		for (List<Integer> level : result) {
			System.out.println(level);
		}
	}
}
