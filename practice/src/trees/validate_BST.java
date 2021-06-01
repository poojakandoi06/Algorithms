package trees;

import trees.isBalance.Node;

public class validate_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static boolean validBST(Node root) {
		if(root==null)
			return true;
		if(root.left==null && root.right==null)
			return true;
		boolean lres=validBST(root.left);
		boolean rres=validBST(root.right);
		boolean myres=true;
		if(root.left!=null) {
			Node rmax=lmax(root.left);
			myres=myres&&root.left.data<root.data && root.data>rmax.data;
		}
		if(root.right!=null) {
			Node lmin=rmin(root.right);
			myres=myres&&root.right.data>root.data && root.data<lmin.data;
		}
		myres=myres&&lres&&rres;
		return myres;
		

	}
	public static Node lmax(Node root) { //max value in node.left subtree
		while(root.right!=null) {
			root=root.right;
		}
		return root;
	}
	public static Node rmin(Node root) { //min value in node.right subtree
		while(root.left!=null)
			root=root.left;
		
		return root;
	}

}
