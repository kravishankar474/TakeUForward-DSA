package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import binaryTrees.TreeNode;

// Define the TreeNode structure


class InorderTraversalRecursion {
    // Function to perform inorder traversal
    // of a binary tree iteratively
    public List<Integer> inorder(TreeNode root) {
        // Initialize a stack to track nodes
        Stack<TreeNode> st = new Stack<>();
        // Start from the root node
        TreeNode node = root;
        // Initialize a list to store
        // inorder traversal result
        List<Integer> inorder = new ArrayList<>();

        // Start an infinite
        // loop for traversal
        while (true) {
            // If the current node is not NULL
            if (node != null) {
                // Push the current
                // node to the stack
                st.push(node);
                // Move to the left child
                // of the current node
                node = node.left;
            } else {
                // If the stack is empty,
                // break the loop
                if (st.isEmpty()) {
                    break;
                }
                // Retrieve a node from the stack
                node = st.pop();
                // Add the node's value to
                // the inorder traversal list
                inorder.add(node.data);
                // Move to the right child
                // of the current node
                node = node.right;
            }
        }
        // Return the inorder
        // traversal result
        return inorder;
    }

    public static void main(String[] args) {
        // Creating a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Initializing the InorderTraversalIterative class
        InorderTraversalIterative sol = new InorderTraversalIterative();

        // Getting the inorder traversal
        List<Integer> result = sol.inorder(root);

        // Displaying the inorder traversal result
        System.out.print("Inorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
