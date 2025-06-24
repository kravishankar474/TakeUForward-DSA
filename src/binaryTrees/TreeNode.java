package binaryTrees;

public class TreeNode {
	
	public int data;
    public TreeNode left;
    public TreeNode right;

    // Constructor to initialize the TreeNode with a value
    public TreeNode(int val) {
        setData(val);
        setLeft(null);
        setRight(null);
    }

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
}
