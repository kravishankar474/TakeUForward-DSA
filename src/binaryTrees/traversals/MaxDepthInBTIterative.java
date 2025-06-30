package binaryTrees.traversals;

import java.util.LinkedList;
import java.util.Queue;

import binaryTrees.TreeNode;

/*
 * Strategy
1. Begin by setting up a queue for level order traversal and a variable called depth to keep track of the tree's depth. If the root is null, return 0, indicating that the tree is empty. Otherwise, add the root node to the queue and initialize depth to 0.
2. Continue processing as long as the queue is not empty: Increment depth by 1 to advance to the next level. For each node at the current level (based on the number of elements in the queue), remove the node from the front of the queue and enqueue its left and right children if they are present.
3. Once the loop completes, return depth, which indicates the maximum depth of the tree
 */

/*
 * Complexity Analysis:
Time Complexity: O(N), the iterative MaxDepthInBTIterative processes each node once, resulting in O(n) time complexity.

Space Complexity: O(w), where w is the maximum width of the tree
 */

public class MaxDepthInBTIterative {

	public int maxDepth(TreeNode root) {
		// If the tree is empty, return 0
		if (root == null) {
			return 0;
		}

		// Create a queue to hold nodes to be processed
		Queue<TreeNode> q = new LinkedList<>();
		// Push the root node into the queue
		q.add(root);
		// Initialize level to 0
		int level = 0;

		// While there are nodes in the queue
		while (!q.isEmpty()) {
			// Get the number of nodes at the current level
			int size = q.size();

			// Process all nodes at the current level
			for (int i = 0; i < size; i++) {
				// Get the front node in the queue
				TreeNode front = q.poll();

				// Enqueue left child if it exists
				if (front.left != null) {
					q.add(front.left);
				}

				// Enqueue right child if it exists
				if (front.right != null) {
					q.add(front.right);
				}
			}
			// Increment level to move to the next level
			level++;
		}

		// Return the maximum depth
		return level;
	}

	// Main method to test the function
	public static void main(String[] args) {
		MaxDepthInBTIterative MaxDepthInBTIterative = new MaxDepthInBTIterative();
		// Example usage:
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println("Maximum Depth: " + MaxDepthInBTIterative.maxDepth(root));
	}
}
