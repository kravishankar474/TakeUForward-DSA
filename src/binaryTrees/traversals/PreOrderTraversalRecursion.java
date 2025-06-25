package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.List;

import binaryTrees.TreeNode;

// Definition for a binary tree node

class PreOrderTraversalRecursion {
    // Helper function to perform preorder traversal
    private void func(TreeNode node, List<Integer> ans) {
        // If the current node is null, return (base case for recursion)
        if (node == null) {
            return;
        }

        // Append the current node's value to the list
        ans.add(node.data);
        // Recursively traverse the left subtree
        func(node.left, ans);
        // Recursively traverse the right subtree
        func(node.right, ans);
    }

    // Function to initiate preorder traversal and return the resulting list
    public List<Integer> preorder(TreeNode root) {
        // Create an empty list to store preorder traversal values
        List<Integer> ans = new ArrayList<>();
        // Call the helper function with the root node and the list
        func(root, ans);
        // Return the resulting list containing preorder traversal values
        return ans;
    }

    // Main method to test the preorder traversal
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Create an instance of the PreOrderTraversalRecursion class
        PreOrderTraversalRecursion PreOrderTraversalRecursion = new PreOrderTraversalRecursion();
        // Getting preorder traversal
        List<Integer> result = PreOrderTraversalRecursion.preorder(root);

        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
