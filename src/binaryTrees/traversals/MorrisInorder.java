package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.List;

import binaryTrees.TreeNode;

/*
 * Approach:
Begin by initializing the current node to the root of the binary tree.
While the current node is not null:
	If the current node lacks a left child, print its value and move to the right child by setting the current node to its right child.
	If the current node has a left child:
		Identify the in-order predecessor of the current node, which is the rightmost node in the left subtree.
		If the right child of the in-order predecessor is null, create a thread by setting its right child to the current node. 
		Then, move to the left child by updating the current node to its left child.
	If the right child of the in-order predecessor is not null, this indicates a previously established thread. 
	Revert this change by setting the right child of the in-order predecessor back to null. 
	Print the current node's value and then move to the right child by setting the current node to its right child.
Repeat the above steps until the traversal reaches the end of the tree.
 */

public class MorrisInorder {

	public List<Integer> getInorder(TreeNode root) {
		// List to store inorder traversal
		List<Integer> inorder = new ArrayList<>();
		// Pointer to the current node
		TreeNode cur = root;

		while (cur != null) {
			if (cur.left == null) {
				// Add current node's value and move to right child
				inorder.add(cur.data);
				cur = cur.right;
			} else {
				// Find the predecessor
				TreeNode prev = cur.left;
				while (prev.right != null && prev.right != cur) {
					prev = prev.right;
				}

				/*
				 * Establish a temporary link and move to the left child
				 */
				if (prev.right == null) {
					prev.right = cur;
					cur = cur.left;
				} else {
					/*
					 * Remove the temporary link, add current node's value and move to the right
					 * child
					 */
					prev.right = null;
					inorder.add(cur.data);
					cur = cur.right;
				}
			}
		}
		// Return inorder traversal
		return inorder;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(6);

		MorrisInorder sol = new MorrisInorder();
		List<Integer> inorder = sol.getInorder(root);

		System.out.print("Binary Tree Morris Inorder Traversal: ");
		for (int val : inorder) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
}
