package trees;

import trees.largest_BST.Node;

public class add_one_row_toTree {

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
	public static Node addOneRow(Node root,int v, int d) {
		helper(root,v,1,d);
		if(d==1) {
			Node node=new Node(v);
			node.left=root;
			root=node;
		}
		return root;
	}
	private static void helper(Node root, int v, int l, int d) {
		if(root==null)
			return;
		helper(root.left,v,l+1,d);
		helper(root.right, v, l+1, d);
		if(l==d-1) {
			Node node=new Node(v);
			node.left=root.left;
			root.left=node;
			Node n=new Node(v);
			n.right=root.right;
			root.right=n;
		}
		
	}
	

}
