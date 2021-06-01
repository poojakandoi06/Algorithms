package trees;

import trees.binaryTree_cameras.Node;

public class construct_String__from_btree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String in preorder manner

	}
	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	public static String BST(Node root) {
		if(root==null)
			return "";
		if(root.left==null && root.right==null)
			return root.data+"";
		if(root.right==null) {
			return root.data+"("+BST(root.left)+")";
			
		}
		return root.data+"("+BST(root.left)+")"+"("+BST(root.right)+")";
	}

}
