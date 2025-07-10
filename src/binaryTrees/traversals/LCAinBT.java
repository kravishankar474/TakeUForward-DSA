package binaryTrees.traversals;

import binaryTrees.TreeNode;

/*
 * Approach
1. Start by checking if the current root node is null or matches one of the target nodes (x or y). 
	If the root is null or matches either target node, then return the root, as it could potentially be the LCA or 
	simply indicate the end of the search path.
2. Perform a recursive search in the left subtree to find the nodes x and y. 
	This involves calling the LCA function on the left child of the current root.
3. Similarly, perform a recursive search in the right subtree. 
	This entails calling the LCA function on the right child of the current root.
4. After completing the recursive searches, analyze the results of both subtree searches. 
	If both recursive calls return non-null values, it implies that one target node was found in each subtree. 
	Consequently, the current root node must be the LCA, as it is the common ancestor of both nodes.
5. If only one of the subtree searches returns a non-null result, it indicates that both target nodes are located within the same subtree. 
	In this case, return the non-null result, which represents the LCA found in that subtree.
 */

/*
 * Complexity Analysis
Time complexity: O(N) where n is the number of nodes.

Space complexity: O(N), auxiliary space.
 */

public class LCAinBT {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// Base case
		if (root == null || root == p || root == q) {
			return root;
		}

		// Search in left and right subtrees
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// Result
		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else { // Both left and right are not null, we found our result
			return root;
		}
	}

	public static void main(String[] args) {
		// Construct a simple binary tree
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);

		LCAinBT LCAinBT = new LCAinBT();
		TreeNode p = root.left; // Node with value 5
		TreeNode q = root.right; // Node with value 1

		TreeNode lca = LCAinBT.lowestCommonAncestor(root, p, q);
		System.out.println("Lowest Common Ancestor: " + lca.data);
	}
}
