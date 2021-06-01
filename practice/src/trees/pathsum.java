package trees;

import trees.largest_BST.Node;

public class pathsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static class Node{
		int data;
		Node left;
		Node right;
		public Object val;
		public Node(int data) {
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	public static boolean check_pathsum(Node root, int sum) {
		if(root==null)
			return false;
		return hasPathsum(root,sum,root.data);
	}
	private static boolean hasPathsum(Node root, int sum, int val) {
		if(sum==val) {
			if(root.left==null && root.right==null)
				return true;
		}
		boolean res1=false;
		boolean res2=false;
		if(root.left!=null) {
			res1=hasPathsum(root.left, sum, val+root.left.data);
		}
		if(root.right!=null) {
			res2=hasPathsum(root.right, sum, val+root.right.data);
		}
		return res1||res2;
	}
	

}
