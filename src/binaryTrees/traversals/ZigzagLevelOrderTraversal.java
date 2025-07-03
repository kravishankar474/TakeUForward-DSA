package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binaryTrees.TreeNode;

/*
 * Approach
1. Begin by initializing an empty queue for node storage during traversal and a 2D vector to capture the level order traversal. 
	If the binary tree is empty, return this empty 2D vector immediately. Additionally, create a leftToRight flag to track the traversal direction. When leftToRight is true, nodes are inserted into the level vector from left to right; when false, they are inserted from right to left.
2. Enqueue the root node of the binary tree into the queue to start the traversal.
3. Proceed with the following steps while the queue is not empty:
	1. Determine the current size of the queue, which reflects the number of nodes present at the current level of the tree.
	2. Create a vector named level to store the nodes' values at the current level.
	3. For each node at the current level, remove the front node from the queue, store its value in the level vector 
		(inserting from left to right if leftToRight is true, or from right to left if false), and enqueue its child nodes (if they exist).
4. After processing all nodes at the current level, append the level vector to the ans 2D vector. 
	Toggle the leftToRight flag to reverse the traversal direction for the subsequent level.
5. After all levels have been processed, return the ans 2D vector, which contains the zigzag level-order traversal of the binary tree.
 */

/*
 * Complexity Analysis
Time Complexity: O(N) where N is the number of nodes in the binary tree. Each node of the binary tree is enqueued and dequeued exactly once, 
	hence all nodes need to be processed and visited.

Space Complexity: O(N) where N is the number of nodes in the binary tree. In the worst case, 
	the queue has to hold all the nodes of the last level of the binary tree, t
	he last level could at most hold N/2 nodes hence the space complexity of the queue is proportional to O(N).
 */

public class ZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		// List to store the result of zigzag traversal
		List<List<Integer>> result = new ArrayList<>();

		// Check if the root is NULL, return an empty result
		if (root == null) {
			return result;
		}

		// Queue to perform level order traversal
		Queue<TreeNode> nodesQueue = new LinkedList<>();
		nodesQueue.add(root);

		// Flag to determine the direction of traversal (left to right or right to left)
		boolean leftToRight = true;

		// Continue traversal until the queue is empty
		while (!nodesQueue.isEmpty()) {
			// Get the number of nodes at the current level
			int size = nodesQueue.size();

			// List to store the values of nodes at the current level
			List<Integer> row = new ArrayList<>(Collections.nCopies(size, 0));

			// Traverse nodes at the current level
			for (int i = 0; i < size; i++) {
				// Get the front node from the queue
				TreeNode node = nodesQueue.poll();

				// Determine the index to insert the node's value based on the traversal
				// direction
				int index = leftToRight ? i : (size - 1 - i);

				// Insert the node's value at the determined index
				row.set(index, node.data);

				// Enqueue the left and right children if they exist
				if (node.left != null) {
					nodesQueue.add(node.left);
				}
				if (node.right != null) {
					nodesQueue.add(node.right);
				}
			}

			// Switch the traversal direction for the next level
			leftToRight = !leftToRight;

			// Add the current level's values to the result list
			result.add(row);
		}

		// Return the final result of zigzag level order traversal
		return result;
	}

	public static void printResult(List<List<Integer>> result) {
		for (List<Integer> row : result) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
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

		ZigzagLevelOrderTraversal ZigzagLevelOrderTraversal = new ZigzagLevelOrderTraversal();

		// Get the zigzag level order traversal
		List<List<Integer>> result = ZigzagLevelOrderTraversal.zigzagLevelOrder(root);

		// Print the result
		printResult(result);
	}
}
