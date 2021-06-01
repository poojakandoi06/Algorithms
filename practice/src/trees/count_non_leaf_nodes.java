package trees;

import trees.leaf_At_same_level.Node;

public class count_non_leaf_nodes {

	public static void main(String[] args) {
		// create the tree

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
	public static int count(Node root) {
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 0;
		int lc=count(root.left);
		int rc=count(root.right);
		if(root.left==null || root.right==null)
			return lc+rc+1;
		
		return lc+rc;
	}

}
