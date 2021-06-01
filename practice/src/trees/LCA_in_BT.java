package trees;

import trees.largest_BST.Node;

public class LCA_in_BT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Lowest Common Ancestor

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
	//if one num is not found return false;
	public static Node lca(Node root, int n1, int n2) {
		if(root==null)
			return null;
		if(root.data==n1 || root.data==n2) {
			return root;}
			Node leftlca=lca(root.left,n1,n2);
			Node rightlca=lca(root.right,n1,n2);
			
		if(leftlca!=null && rightlca!=null)
			return root;
		return (leftlca!=null)?leftlca:rightlca;
	}

}
