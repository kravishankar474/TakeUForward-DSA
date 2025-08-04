package binaryTrees.traversals;

import java.util.HashMap;
import java.util.Map;

import binaryTrees.TreeNode;

/*
 * Algorithm
1. Create an empty map to store the indices of elements in the inorder traversal. 
	Iterate through each element in the inorder traversal and store its index in the map (inMap) using the element as the key and its index as the value.
2. Create a recursive helper function buildTree with the following parameters:
	1. Preorder vector
	2. Start index of preorder (preStart), initially set to 0
	3. End index of preorder (preEnd), initially set to preorder.size() - 1
	4. Inorder vector
	5. Start index of inorder (inStart), initially set to 0
	6. End index of inorder (inEnd), initially set to inorder.size() - 1
	7. Map for efficient root index lookup in the inorder traversal
3. Base Case: Check if preStart is greater than preEnd or inStart is greater than inEnd. If true, return NULL, indicating an empty subtree/node.
4. The root node for the current subtree is the first element in the preorder traversal (preorder[preStart]). Find the index of this root node in the inorder traversal using the map (inMap[rootValue]). This is the rootIndex.
5. The left subtree ranges from inStart to rootIndex. Subtracting these indexes gives the leftSubtreeSize.
6. Make two recursive calls to buildTree to build the left and right subtrees:
	1. For the left subtree:
		1. Update preStart to preStart + 1 (moving to the next element in preorder)
		2. Update preEnd to preStart + leftSubtreeSize (end of left subtree in preorder)
		3. Update inEnd to rootIndex - 1 (end of left subtree in inorder)
	2. For the right subtree:
		1. Update preStart to preStart + leftSubtreeSize + 1 (moving to the next element after the left subtree)
		2. Update preEnd to the original preEnd (end of right subtree in preorder)
		3. Update inStart to rootIndex + 1 (start of right subtree in inorder)
7. Return the root node constructed for the current subtree. The function returns the root of the entire binary tree constructed from the preorder and inorder traversals.

 */

/*
 * Complexity Analysis:
Time Complexity : The time complexity is O(N), where N is the number of nodes in the Binary Tree. 
	This is because each node of the Binary Tree is visited once.

Space Complexity: O(N), where N is the number of nodes in the Binary Tree. 
	The inorder hashmap used to store the inorder array for fast lookup takes up space proportional to the input nodes. 
	Additionally, an auxiliary stack space of approximately O(H) is used, where H is the height of the Binary Tree.
 */
public class BuildBinaryTree1 {

	// Function to build a binary tree
	// from preorder and inorder traversals
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// Create a map to store indices
		// of elements in the inorder traversal
		Map<Integer, Integer> inMap = new HashMap<>();

		// Populate the map with indices
		// of elements in the inorder traversal
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}

		// Call the private helper function
		// to recursively build the tree
		TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);

		return root;
	}

	// Recursive helper function to build the tree
	private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			Map<Integer, Integer> inMap) {
		// Base case: If the start indices
		// exceed the end indices, return null
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		// Create a new TreeNode with value
		// at the current preorder index
		TreeNode root = new TreeNode(preorder[preStart]);

		// Find the index of the current root
		// value in the inorder traversal
		int inRoot = inMap.get(root.data);

		// Calculate the number of
		// elements in the left subtree
		int numsLeft = inRoot - inStart;

		// Recursively build the left subtree
		root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);

		// Recursively build the right subtree
		root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

		// Return the current root node
		return root;
	}

	// Function to print the
	// inorder traversal of a tree
	private void printInorder(TreeNode root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}

	// Function to print the
	// given array
	private void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] preorder = { 3, 9, 20, 15, 7 };

		BuildBinaryTree1 sol = new BuildBinaryTree1();

		System.out.print("Inorder Array: ");
		sol.printArray(inorder);

		System.out.print("Preorder Array: ");
		sol.printArray(preorder);

		TreeNode root = sol.buildTree(preorder, inorder);

		System.out.println("Inorder of Unique Binary Tree Created:");
		sol.printInorder(root);
		System.out.println();
	}
}
