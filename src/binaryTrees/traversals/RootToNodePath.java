package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.List;

import binaryTrees.TreeNode;

/*
 * Approach
1. Begin by initializing an empty vector to hold the current path from the root to the target node.
2. Define a recursive function to perform a Depth-First Search (DFS). 
	Start the traversal from the root node and explore the tree following an in-order sequence.
3. In the recursive function, return false if the current node is null, indicating that the end of the current path has been reached. 
	Return true if the current node’s data matches the target value, signaling that the path has been successfully found.
4. During each recursive call, append the current node's value to the path vector. Check if the node’s value equals the target value. 
	Recursively call the function for both the left and right children of the current node.
5. If the target node is not found along the current path, remove the last node from the vector to backtrack and explore other potential paths.
6. Finally, return the vector that contains the path from the root node to the target node once the target is found.
 */

/*
 * Complexity Analysis
Time Complexity : O(N) where N is the number of nodes in the binary tree. Each node of the binary tree is visited exactly once during the traversal.

Space Complexity : O(N) where N is the number of nodes in the binary tree. This is because the stack can potentially hold all nodes in the tree when dealing with a skewed tree (all nodes have only one child), 
	consuming space proportional to the number of nodes.
 */
public class RootToNodePath {

	public List<List<Integer>> allRootToLeaf(TreeNode root) {
		// List to store all root-to-leaf paths
		List<List<Integer>> allPaths = new ArrayList<>();
		// List to store the current path
		List<Integer> currentPath = new ArrayList<>();

		// Helper function to perform DFS
		dfs(root, currentPath, allPaths);

		return allPaths;
	}

	private void dfs(TreeNode node, List<Integer> path, List<List<Integer>> allPaths) {
		if (node == null) {
			return; // Base case: return if the current node is null
		}

		path.add(node.data); // Add the current node's data to the path

		if (node.left == null && node.right == null) {
			// Add the path to allPaths if it's a leaf node
			allPaths.add(new ArrayList<>(path));
		} else {
			// Recursively call the function on the left child
			dfs(node.left, path, allPaths);
			// Recursively call the function on the right child
			dfs(node.right, path, allPaths);
		}
		// Backtrack by removing the last node from the path
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		RootToNodePath RootToNodePath = new RootToNodePath();
		System.out.println(RootToNodePath.allRootToLeaf(root));
	}
}
