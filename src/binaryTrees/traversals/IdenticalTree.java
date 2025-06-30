package binaryTrees.traversals;

import binaryTrees.TreeNode;

/*
 * Approach
1. Start at the root node of both trees (p and q). First, check if both nodes are null. If both are null, the current branches are identical up to this point, so return true. If only one of them is null or if their values differ, return false, as this means the trees are not identical.
2. Recursively compare the left subtree of p with the left subtree of q and the right subtree of p with the right subtree of q. At each step, ensure that both the structure (presence of children) and the node values match.
3. If all recursive checks for the left and right subtrees return true, then the trees are identical; otherwise, if any check fails, the trees are not identical. The final result will depend on the outcome of these recursive checks.
 */

public class IdenticalTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		// If both nodes are null, the trees are the same
		if (p == null && q == null) {
			return true;
		}

		// If one of the nodes is null, the trees are not the same
		if (p == null || q == null) {
			return false;
		}

		// If the values of the nodes are different, the trees are not the same
		if (p.data != q.data) {
			return false;
		}

		// Recursively check the left and right subtrees
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static void main(String[] args) {
		// Example usage
		IdenticalTree IdenticalTree = new IdenticalTree();

		// Creating two sample trees
		TreeNode tree1 = new TreeNode(1);
		tree1.left = new TreeNode(2);
		tree1.right = new TreeNode(3);

		TreeNode tree2 = new TreeNode(1);
		tree2.left = new TreeNode(2);
		tree2.right = new TreeNode(3);

		// Checking if the trees are identical
		boolean result = IdenticalTree.isSameTree(tree1, tree2);
		System.out.println("Are the trees identical? " + result); // Output: true
	}
}
