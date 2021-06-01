package trees;

import trees.isBalance.Node;

public class univalued_BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create the tree

	}
	
	public class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}

	public static boolean check_univalued(Node root) {
		if(root==null)
			return true;
		boolean lc=check_univalued(root.left);
		boolean rc=check_univalued(root.right);
		if(lc && rc&& (root.left==null || (root.left.data==root.data))&& (root.right==null || (root.right.data==root.data)))
			return true;
		return false;
	}
}
