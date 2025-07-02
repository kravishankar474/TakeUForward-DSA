package binaryTrees.traversals;

import binaryTrees.TreeNode;

/*
 * Approach
1. Begin by defining a recursive function designed to calculate the maximum path sum for each subtree rooted at a given node. 
	If the current node is null, return 0, as there is no valid path through a null node.
2. Proceed by calculating the maximum path sum for both the left and right subtrees. 
	If the path sum for either subtree is negative, it should be disregarded, as including it would decrease the overall sum. 
	This can be achieved by taking the maximum of 0 and the calculated path sum for each subtree.
3. For each node, compute the potential maximum path sum that passes through the node and its children. 
	This sum includes the node itself and the maximum path sums from both subtrees. 
	If this value exceeds the current global maximum sum, update the global maximum to reflect this new higher value.
4. Finally, return the maximum path sum for the current node, considering only one of its subtrees. This step ensures that when the function backtracks up the tree, only the highest path sum from either the left or right subtree is propagated upward, maintaining the integrity of the overall maximum path sum calculation.
 */

public class MaximumPathSum {

	/*
	 * Recursive function to find the maximum path sum for a given subtree rooted at
	 * 'root' The variable 'maxi' is a reference parameter updated to store the
	 * maximum path sum encountered
	 */
	int findMaxPathSum(TreeNode root, int[] maxi) {
		// Base case: If the current node is null, return 0
		if (root == null) {
			return 0;
		}

		// Calculate the maximum path sum
		// for the left and right subtrees
		int leftMaxPath = Math.max(0, findMaxPathSum(root.left, maxi));
		int rightMaxPath = Math.max(0, findMaxPathSum(root.right, maxi));

		// Update the overall maximum
		// path sum including the current node
		maxi[0] = Math.max(maxi[0], leftMaxPath + rightMaxPath + root.data);

		/*
		 * Return the maximum sum considering only one branch (either left or right)
		 * along with the current node
		 */
		return Math.max(leftMaxPath, rightMaxPath) + root.data;
	}

	// Function to find the maximum
	// path sum for the entire binary tree
	public int maxPathSum(TreeNode root) {
		// Initialize maxi to the
		// minimum possible integer value
		int[] maxi = { Integer.MIN_VALUE };

		// Call the recursive function to
		// find the maximum path sum
		findMaxPathSum(root, maxi);

		// Return the final maximum path sum
		return maxi[0];
	}

	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(6);
		root.left.right.right.right = new TreeNode(7);

		// Creating an instance of the MaximumPathSum class
		MaximumPathSum MaximumPathSum = new MaximumPathSum();

		// Finding and printing the maximum path sum
		int maxPathSum = MaximumPathSum.maxPathSum(root);
		System.out.println("Maximum Path Sum: " + maxPathSum);
	}
}
