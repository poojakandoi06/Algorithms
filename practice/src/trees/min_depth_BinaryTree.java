package trees;

import trees.count_non_leaf_nodes.Node;

public class min_depth_BinaryTree {

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
	public static int min_depth(Node root) {
		 if(root==null)
			 return 0;
		 int lh=min_depth(root.left);
		 int rh=min_depth(root.right);
		 if(root.left!=null && root.right==null)
			 return lh+1;
		 else if(root.left==null && root.right!=null)
			 return rh+1;
		 else {
			 return Math.min(lh, rh)+1;
		 }
		
	}

}
