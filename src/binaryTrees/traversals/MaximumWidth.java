package binaryTrees.traversals;

import java.util.LinkedList;
import java.util.Queue;

import binaryTrees.TreeNode;
import binaryTrees.traversals.BottomView.Pair;

/*
 * Approach
1. Begin by initializing a variable ans to keep track of the MaximumWidth encountered. 
	If the root node is null, return 0 as the width of an empty tree is zero.
2. Set up a queue for level-order traversal, where each queue element is a pair consisting of a node and its index within the level. 
	Start by enqueuing the root node along with its initial index of 0.
3. While the queue contains elements, process each level as follows:
		1. Determine the number of nodes at the current level by measuring the size of the queue. 
			Capture the index of the first node in the level to establish the leftmost position at that level.
		2. Initialize variables first and last to record the indices of the first and last nodes at the current level.
		3. For each node in the current level, compute its relative position based on the level's minimum index. 
			Update the first and last variables to reflect the indices of the first and last nodes in this level. 
			Enqueue the left and right children of the current node, assigning them indices of 2 x current index and 2 x current index + 1, respectively.
4. After processing all nodes in the level, update the MaximumWidth ans by calculating the difference between last and first, and adding 1.
5. Continue the level-order traversal until all levels are examined. The final value of ans represents the MaximumWidth of the binary tree, 
	which is then returned.
 */

public class MaximumWidth {

	public int widthOfBinaryTree(TreeNode root) {
		// If the root is null,
		// the width is zero
		if (root == null) {
			return 0;
		}

		// Initialize a variable 'ans'
		// to store the MaximumWidth
		int ans = 0;

		// Create a queue to perform level-order
		// traversal, where each element is a pair
		// of TreeNode* and its position in the level
		Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
		// Push the root node and its
		// position (0) into the queue
		q.offer(new Pair<>(root, 0));

		// Perform level-order traversal
		while (!q.isEmpty()) {
			// Get the number of
			// nodes at the current level
			int size = q.size();
			// Get the position of the front
			// node in the current level
			int mmin = q.peek().getValue();

			// Store the first and last positions
			// of nodes in the current level
			int first = 0, last = 0;

			// Process each node
			// in the current level
			for (int i = 0; i < size; i++) {
				// Calculate current position relative
				// to the minimum position in the level
				int cur_id = q.peek().getValue() - mmin;
				// Get the current node
				TreeNode node = q.peek().getKey();
				// Pop the front node from the queue
				q.poll();

				// If this is the first node in the level,
				// update the 'first' variable
				if (i == 0) {
					first = cur_id;
				}

				// If this is the last node in the level,
				// update the 'last' variable
				if (i == size - 1) {
					last = cur_id;
				}

				// Enqueue the left child of the
				// current node with its position
				if (node.left != null) {
					q.offer(new Pair<>(node.left, cur_id * 2 + 1));
				}

				// Enqueue the right child of the
				// current node with its position
				if (node.right != null) {
					q.offer(new Pair<>(node.right, cur_id * 2 + 2));
				}
			}

			// Update the MaximumWidth by calculating
			// the difference between the first and last
			// positions, and adding 1
			ans = Math.max(ans, last - first + 1);
		}

		// Return the maximum
		// width of the binary tree
		return ans;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		MaximumWidth sol = new MaximumWidth();
		int maxWidth = sol.widthOfBinaryTree(root);

		System.out.println("MaximumWidth of the binary tree is: " + maxWidth);
	}
}
