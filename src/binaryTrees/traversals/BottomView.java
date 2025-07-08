package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import binaryTrees.TreeNode;

/*
 * Approach
1. Initialize a vector named ans to hold the final result of the top view traversal. 
	Also, set up a map to store nodes based on their vertical positions, 
	using the vertical index as the key and the node's value as the associated data.
2. Set up a queue to facilitate breadth-first search (BFS) traversal, starting with the root node, which is assigned a vertical position of 0.
3. Perform the following steps while the queue is not empty:
		1. Dequeue the node at the front of the queue and retrieve its vertical position. put in the map, 
			add the node’s value to the map. This signifies that the node is the first one encountered at this vertical position 
			and should be included in the top view.
		2. If the vertical position is already in the map, skip adding this node, as a node positioned higher in the tree at 
			this vertical coordinate has already been processed and thus represents the top view for that vertical line.
		3. Enqueue the left child of the current node with a vertical position decremented by 1 (current position - 1) and 
			the right child with a vertical position incremented by 1 (current position + 1).
4. After completing the BFS traversal, iterate through the map to gather nodes in ascending order of their vertical positions. 
	Append these nodes to the ans vector. Finally, return the ans vector, which represents the top view traversal of the binary tree.

 */

/*
 * Complexity Analysis
Time Complexity: O(N*logN), where N is the number of nodes in the Binary Tree.
	This complexity arises because the algorithm performs a Breadth-First Search (BFS) traversal of the tree, 
	visiting each node exactly once. And during the traversal, various map operations are performed which take logK complexity where K can be 
	N in the worst case. Thus, the overall time complexity comes out to be O(N*logN).

Space Complexity: O(N) : The space complexity of the algorithm is O(N), where N is the number of nodes in the Binary Tree. 
	This space is primarily consumed by the queue used for BFS traversal, which can hold up to N/2 nodes in the worst case scenario of a balanced tree. Additionally, a map is used to store nodes based on their vertical positions, potentially also using up to N/2 entries in the worst case. Therefore, the overall space usage is proportional to the maximum width of the tree at any level.
 */

public class BottomView {

	// Nested generic Pair class
	static class Pair<K, V> {
		private K key;
		private V value;

		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
	}

	// Function to return the top view of the binary tree
	public List<Integer> BottomView(TreeNode root) {
		// List to store the result
		List<Integer> ans = new ArrayList<>();

		// Check if the tree is empty
		if (root == null) {
			return ans;
		}

		// Map to store the top view nodes based on their vertical positions
		Map<Integer, Integer> mpp = new TreeMap<>();

		// Queue for BFS traversal, each element is a pair containing node and its
		// vertical position
		Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();

		// Push the root node with its vertical position (0) into the queue
		q.add(new Pair<>(root, 0));

		// BFS traversal
		while (!q.isEmpty()) {
			// Retrieve the node and its vertical position from the front of the queue
			Pair<TreeNode, Integer> it = q.poll();
			TreeNode node = it.getKey();
			int line = it.getValue();

			// put the data in the map
				mpp.put(line, node.data);
			

			// Process left child
			if (node.left != null) {
				// Push the left child with a decreased vertical position into the queue
				q.add(new Pair<>(node.left, line - 1));
			}

			// Process right child
			if (node.right != null) {
				// Push the right child with an increased vertical position into the queue
				q.add(new Pair<>(node.right, line + 1));
			}
		}

		// Transfer values from the map to the result list
		for (Integer value : mpp.values()) {
			ans.add(value);
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

        Solution solution = new Solution();

        // Get the Bottom View traversal
        List<Integer> bottomView = solution.bottomView(root);

        // Print the result
        System.out.println("Bottom View Traversal: ");
        for (int node : bottomView) {
            System.out.print(node + " ");
        }
	}
}
