package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import binaryTrees.TreeNode;

/*
 * 
 * Approach
1. Create three vectors to store the results of Preorder, Inorder, and Postorder traversals. Use a stack to keep track of nodes and their traversal states. Start with the root node and a state of 1 (indicating Preorder).While the stack is not empty, pop the top element from the stack.
2. If the state is 1 (Preorder), add the node's data to the Preorder vector, change the state to 2 (Inorder) and push the node back onto the stack. If the node has a left child, push it onto the stack with a state of 1.
3. If the state is 2 (Inorder), add the node's data to the Inorder vector. change the state to 3 (Postorder) and push the node back onto the stack. If the node has a right child, push it onto the stack with a state of 1.
4. If the state is 3 (Postorder), Add the node's data to the Postorder vector. Return the vectors containing the Preorder, Inorder, and Postorder traversals.
 */

//Helper class to store a TreeNode and its traversal state
class NodeState {
	TreeNode node;
	int state;

	NodeState(TreeNode node, int state) {
		this.node = node;
		this.state = state;
	}
}

public class PreInPostAllInOneGo {

	public List<List<Integer>> treeTraversal(TreeNode root) {
		// Lists to store the traversals
		List<Integer> pre = new ArrayList<>();
		List<Integer> in = new ArrayList<>();
		List<Integer> post = new ArrayList<>();

		// If the tree is empty, return empty traversals
		if (root == null)
			return Arrays.asList(pre, in, post);

		// Stack to maintain nodes and their traversal state
		Stack<NodeState> st = new Stack<>();

		// Start with the root node and state 1 (preorder)
		st.push(new NodeState(root, 1));

		while (!st.isEmpty()) {
			// Get the top element from the stack
			NodeState top = st.pop();
			TreeNode node = top.node;
			int state = top.state;

			// Process the node based on its state
			if (state == 1) {
				// Preorder: Add node data
				pre.add(node.data);
				// Change state to 2 (inorder) for this node
				st.push(new NodeState(node, 2));

				// Push left child onto the stack for processing
				if (node.left != null) {
					st.push(new NodeState(node.left, 1));
				}
			} else if (state == 2) {
				// Inorder: Add node data
				in.add(node.data);
				// Change state to 3 (postorder) for this node
				st.push(new NodeState(node, 3));

				// Push right child onto the stack for processing
				if (node.right != null) {
					st.push(new NodeState(node.right, 1));
				}
			} else {
				// Postorder: Add node data
				post.add(node.data);
			}
		}

		// Return the traversals as a list of lists
		return Arrays.asList(in, pre, post);
	}

	public static void main(String[] args) {
		// Creating a sample binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		PreInPostAllInOneGo sol = new PreInPostAllInOneGo();
		List<List<Integer>> traversals = sol.treeTraversal(root);

		// Print Preorder traversal
		System.out.print("Preorder traversal: ");
		for (int val : traversals.get(0))
			System.out.print(val + " ");
		System.out.println();

		// Print Inorder traversal
		System.out.print("Inorder traversal: ");
		for (int val : traversals.get(1))
			System.out.print(val + " ");
		System.out.println();

		// Print Postorder traversal
		System.out.print("Postorder traversal: ");
		for (int val : traversals.get(2))
			System.out.print(val + " ");
		System.out.println();
	}
}
