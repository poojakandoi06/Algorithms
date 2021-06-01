package trees;

import trees.largest_BST.Node;

public class LCA_in_BST {

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
	public static Node lcaBST(Node root, int n1, int n2) {
		if((root.data>=n1 && root.data<=n2)||(root.data>=n2 && root.data<=n1))
			return root;
		if(root.data>=n1 && root.data>=n2) {
			return lcaBST(root.left, n1, n2);
		}
		if(root.data<=n1 && root.data<=n2)
			return lcaBST(root.right, n1, n2);
		
		return null;
		
	}

}
