package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.List;

import binaryTrees.TreeNode;

// TreeNode structure for the binary tree

class InorderTraversalIterative {
    private void recursiveInorder(TreeNode root, List<Integer> arr) {
        // If the current Tree is NULL (base case for recursion), return
        if (root == null) {
            return;
        }
        // Recursively traverse the left subtree
        recursiveInorder(root.getLeft(), arr);
        // Push the current TreeNode's value into the vector
        arr.add(root.getData());
        // Recursively traverse the right subtree
        recursiveInorder(root.getRight(), arr);
    }

    // Function to initiate inorder traversal and return the resulting vector
    public List<Integer> inorder(TreeNode root) {
        // Create an empty vector to store inorder traversal values
        List<Integer> arr = new ArrayList<>();
        // Call the inorder traversal function
        recursiveInorder(root, arr);
        // Return the resulting vector containing inorder traversal values
        return arr;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().left = new TreeNode(4);
        root.getLeft().setRight(new TreeNode(5));

        InorderTraversalIterative sol = new InorderTraversalIterative();
        // Getting inorder traversal
        List<Integer> result = sol.inorder(root);

        // Displaying the inorder traversal result
        System.out.print("Inorder Traversal: ");
        // Output each value in the inorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
