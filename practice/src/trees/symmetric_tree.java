package trees;

import trees.isBalance.Node;

public class symmetric_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create the tree
		//same as mirror tree

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
	public static boolean is_symmetric(Node a,Node b) {
		if(a==null && b==null)
			return true;
		if(a==null && b==null)
			return true;
		if(a==null || b==null)
			return false;
		boolean lr=is_symmetric(a.left, b.right);
		boolean rr=is_symmetric(a.right, b.left);
		return lr&&rr&&a.data==b.data;
	}

}
