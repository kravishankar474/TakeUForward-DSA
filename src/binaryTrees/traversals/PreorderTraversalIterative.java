package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import binaryTrees.TreeNode;

// TreeNode structure for the binary tree
/*
 * Link: "https://takeuforward.org/plus/dsa/binary-trees/theory-and-traversals/preorder-traversal"
 * Algorithm:

Step 1: Initialise an empty vector ‘preorder’ to store the preorder traversal result. Create a stack to store the nodes during traversal and push the root node onto the stack. Check if the root is null, return an empty traversal result if true.
Step 2: Push the root of the binary tree into the stack.
Step 3: While the stack is not empty:
	Get the current node from the top of the stack.
	Remove the node from the stack.
	Add the node’s value to the preorder traversal result.
	First, push the right child onto the stack if it exists.
	Secondly, push the left child onto the stack if it exists.
Step 4: Return the ‘preorder’ traversal result.
 * 
 */


class PreorderTraversalIterative {
 // Function to perform preorder traversal
 // of a binary tree iteratively
 public List<Integer> preorder(TreeNode root) {
     // Initialize list to store
     // the preorder traversal result
     List<Integer> preorder = new ArrayList<>();

     // If the root is null, return
     // an empty traversal result
     if (root == null) {
         return preorder;
     }

     // Create a stack to store
     // nodes during traversal
     Stack<TreeNode> st = new Stack<>();
     // Push the root node
     // onto the stack
     st.push(root);

     // Perform iterative preorder traversal
     while (!st.empty()) {
         // Get the current node
         // from the top of the stack
         root = st.pop();

         // Add the node's value to
         // the preorder traversal result
         preorder.add(root.data);

         // Push the right child
         // onto the stack if exists
         if (root.right != null) {
             st.push(root.right);
         }

         // Push the left child onto
         // the stack if exists
         if (root.left != null) {
             st.push(root.left);
         }
     }

     // Return the preorder
     // traversal result
     return preorder;
 }

 public static <PreOrderTraversalIterative> void main(String[] args) {
     // Creating a binary tree
     TreeNode root = new TreeNode(1);
     root.left = new TreeNode(2);
     root.right = new TreeNode(3);
     root.left.left = new TreeNode(4);
     root.left.right = new TreeNode(5);

     // Initializing the PreorderTraversalIterative class
     PreorderTraversalIterative sol = new PreorderTraversalIterative();

     // Getting the preorder traversal
     List<Integer> result = sol.preorder(root);

     // Displaying the preorder traversal result
     System.out.print("Preorder Traversal: ");
     for (int val : result) {
         System.out.print(val + " ");
     }
     System.out.println();
 }
}

