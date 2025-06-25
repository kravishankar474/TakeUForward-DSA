package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import binaryTrees.TreeNode;

/*
 * Approach:

1. Push the root node onto the stack to begin traversal.
2. Process nodes in a modified preorder order (Root → Right → Left) by popping a node, storing its value, and pushing its left and right children onto the stack (right first, then left).
3. Continue until the stack is empty, ensuring all nodes are processed in this modified order.
4. Reverse the stored result at the end to transform it into the correct postorder sequence (Left → Right → Root).
5. Return the final postorder traversal list.
 */

public class PostOrderTraversalIterative {
	
	public List<Integer> postorder(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // to store the result

        Stack<TreeNode> nodeStack = new Stack<>(); // stack to process the nodes
        if (root != null) nodeStack.push(root); // push the root initially
        
        // Until the stack is empty 
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop(); // get the top node 

            result.add(node.data); // add it to the list
            
            // Add its left child if it exists
            if (node.left != null) nodeStack.push(node.left);
            
            // Add its right child if it exists
            if (node.right != null) nodeStack.push(node.right);
        }
        
        // Reverse the list to get the postorder traversal
        Collections.reverse(result);

        return result; // Return the result
    }

    public static void main(String[] args) {
        // Create a simple binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Create PostOrderTraversalIterative object and call postorder method
        PostOrderTraversalIterative sol = new PostOrderTraversalIterative();
        List<Integer> result = sol.postorder(root);
        
        // Print the result
        for (int val : result) {
            System.out.print(val + " ");  // Output: 4 5 2 6 3 1
        }
        System.out.println();
    }
}
