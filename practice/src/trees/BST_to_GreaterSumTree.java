package trees;

import trees.largest_BST.Node;

public class BST_to_GreaterSumTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	public static int sum=0;
	public static Node bstTOGst(Node root) {
		helper(root);
		return root;
	}
	private static void helper(Node root) {
		if(root==null)
			return;
		helper(root.right);
		root.data+=sum;
		sum=root.data;
		helper(root.left);
	}
	

}
