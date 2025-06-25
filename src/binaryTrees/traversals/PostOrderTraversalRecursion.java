package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.List;

import binaryTrees.TreeNode;

/*
 * 
 * Dry Run
Let's break down the steps and the data structures involved:

Step 1: Check if the current node is null. If it is, we've reached the end of a subtree, and the recursive function stops.
Step 2: Recursively traverse the left subtree. This means making a call to the postorder function on the left child of the current node.
Step 3: Recursively traverse the right subtree by calling the postorder function on the right child of the current node.
Step 4: Process the current node by adding its value to the postorder traversal array. This step is done after the left and right subtrees have been fully explored.

TC - O(n);
SC - O(n)
 */


class PostOrderTraversalRecursion {
    // Function to perform postorder traversal recursively
    private void recursivePostorder(TreeNode root, List<Integer> arr) {
        // Base case: if root is null, return
        if (root == null) {
            return;
        }
        // Traverse left subtree
        recursivePostorder(root.left, arr);
        // Traverse right subtree
        recursivePostorder(root.right, arr);
        // Visit the TreeNode (append TreeNode's data to the array)
        arr.add(root.data);
    }

    // Function to get the postorder traversal of a binary tree
    public List<Integer> postorder(TreeNode root) {
        // Create a list to store the traversal result
        List<Integer> arr = new ArrayList<>();
        // Perform postorder traversal starting from the root
        recursivePostorder(root, arr);
        // Return the postorder traversal result
        return arr;
    }

    static void printList(List<Integer> list) {
        // Iterate through the list and print each element
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PostOrderTraversalRecursion sol = new PostOrderTraversalRecursion();
        // Getting postorder traversal
        List<Integer> result = sol.postorder(root);

        // Printing the postorder traversal result
        System.out.print("Postorder traversal: ");
        printList(result);
    }
}

