package trees;

import trees.isBalance.Node;

public class create_mirror_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void mirror(Node root) {
		if(root==null)
			return;
		mirror(root.left);
		mirror(root.right);
		Node temp=root.left;
		root.left=root.right;
		root.right=temp;
		
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

}
