package binaryTrees;

import java.util.ArrayList;
import java.util.List;

// TreeNode structure for the binary tree
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    // Constructor to initialize the TreeNode with a value
    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class InorderTraversalRecursion {
    private void recursiveInorder(TreeNode root, List<Integer> arr) {
        // If the current Tree is NULL (base case for recursion), return
        if (root == null) {
            return;
        }
        // Recursively traverse the left subtree
        recursiveInorder(root.left, arr);
        // Push the current TreeNode's value into the vector
        arr.add(root.data);
        // Recursively traverse the right subtree
        recursiveInorder(root.right, arr);
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        InorderTraversalRecursion sol = new InorderTraversalRecursion();
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
