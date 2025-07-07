package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import binaryTrees.TreeNode;

/*
 * Approach
1. Begin by initializing an empty map to store nodes according to their 'x' (vertical column) and 'y' (level) coordinates. 
	Utilize a multiset within this map to maintain the correct order of nodes that fall under the same vertical column and level.
2. Set up a queue for performing a breadth-first search (BFS) traversal of the tree, starting with the root node positioned at coordinates (0, 0), 
	where '0' represents the root's vertical column and level.
3. While the queue is not empty, perform the following steps: dequeue a node, and record its value in the map at its corresponding 'x' and 'y' 
	coordinates. Then, enqueue the left and right children of the node with updated coordinates: 
	the left child is enqueued with 'x' decremented by 1 and 'y' incremented by 1, while the right child is enqueued with 'x' incremented by 1 and 'y' incremented by 1.
4. After completing the BFS traversal, process the map to create a list of node values for each vertical column. 
	This involves iterating through the map, collecting values from the multiset for each vertical column, 
	and assembling these values into column vectors.
5. Finally, compile these column vectors into a 2D vector that represents the vertical order traversal of the binary tree, 
	ensuring that nodes are ordered by their vertical column positions.
 */

/*
 * Complexity Analysis
Time Complexity:O(N * log2N * log2N * log2N) : This complexity arises from performing postorder traversal using BFS, where each node's insertion and retrieval operations in nested maps take logarithmic time. Overall, 
	it reflects the combined cost of processing each node and managing the node mappings.

Space Complexity: O(N + N/2) : The space usage is dominated by the map storing nodes by their vertical and level information, occupying O(N) space. 
	Additionally, the queue for BFS can occupy up to O(N/2) space in a balanced tree's worst-case scenario, contributing to the total space complexity.
 */
public class VerticalOrderTraversal {

	// Nested static class Tuple
	static class Tuple {
		TreeNode node;
		int x; // Vertical distance
		int y; // Level

		Tuple(TreeNode node, int x, int y) {
			this.node = node;
			this.x = x;
			this.y = y;
		}
	}

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		// TreeMap to store the nodes at each vertical distance
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodesMap = new TreeMap<>();

		// Queue for BFS traversal (stores node along with its x and y coordinates)
		Queue<Tuple> queue = new LinkedList<>();
		queue.offer(new Tuple(root, 0, 0)); // (node, x, y)

		// Perform BFS
		while (!queue.isEmpty()) {
			Tuple tuple = queue.poll();
			TreeNode node = tuple.node;
			int x = tuple.x;
			int y = tuple.y;

			// Add the node's value to the map at the correct x and y
			nodesMap.putIfAbsent(x, new TreeMap<>());
			nodesMap.get(x).putIfAbsent(y, new PriorityQueue<>());
			nodesMap.get(x).get(y).offer(node.data);

			// Add the left child with updated coordinates to the queue
			if (node.left != null) {
				queue.offer(new Tuple(node.left, x - 1, y + 1));
			}

			// Add the right child with updated coordinates to the queue
			if (node.right != null) {
				queue.offer(new Tuple(node.right, x + 1, y + 1));
			}
		}

		// Prepare the result by sorting keys and compiling nodes
		for (TreeMap<Integer, PriorityQueue<Integer>> yMap : nodesMap.values()) {
			List<Integer> column = new ArrayList<>();
			for (PriorityQueue<Integer> nodes : yMap.values()) {
				while (!nodes.isEmpty()) {
					column.add(nodes.poll());
				}
			}
			result.add(column);
		}

		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		VerticalOrderTraversal VerticalOrderTraversal = new VerticalOrderTraversal();
		List<List<Integer>> result = VerticalOrderTraversal.verticalTraversal(root);

		System.out.println("Vertical Traversal:");
		for (List column : result) {
			System.out.println(column);
		}
	}
}
