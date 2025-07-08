package binaryTrees.traversals;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import binaryTrees.TreeNode;



class Solution {
    public List<Integer> bottomView(TreeNode root) {
        // List to store the result
        List<Integer> ans = new ArrayList<>();

        // Check if the tree is empty
        if (root == null) {
            return ans;
        }

        // Map to store the bottom view nodes
        // based on their vertical positions
        Map<Integer, Integer> mpp = new TreeMap<>();

        // Queue for BFS traversal, each
        // element is a pair containing node
        // and its vertical position
        Queue<Map.Entry<TreeNode, Integer>> q = new LinkedList<>();

        // Push the root node with its vertical
        // position (0) into the queue
        q.add(new AbstractMap.SimpleEntry<>(root, 0));

        // BFS traversal
        while (!q.isEmpty()) {
            // Retrieve the node and its vertical
            // position from the front of the queue
            Map.Entry<TreeNode, Integer> it = q.poll();
            TreeNode node = it.getKey();
            int line = it.getValue();

            // Update the map with the node's data
            // for the current vertical position
            mpp.put(line, node.data);

            // Process left child
            if (node.left != null) {
                // Push the left child with a decreased
                // vertical position into the queue
                q.add(new AbstractMap.SimpleEntry<>(node.left, line - 1));
            }

            // Process right child
            if (node.right != null) {
                // Push the right child with an increased
                // vertical position into the queue
                q.add(new AbstractMap.SimpleEntry<>(node.right, line + 1));
            }
        }

        // Transfer values from the
        // map to the result list
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            ans.add(it.getValue());
        }

        return ans;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        Solution solution = new Solution();

        // Get the Bottom View traversal
        List<Integer> bottomView = solution.bottomView(root);

        // Print the result
        System.out.println("Bottom View Traversal: ");
        for (int node : bottomView) {
            System.out.print(node + " ");
        }
    }
}
