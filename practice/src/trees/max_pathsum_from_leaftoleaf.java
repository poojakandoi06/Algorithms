package trees;

import trees.largest_BST.Node;

public class max_pathsum_from_leaftoleaf {

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
	static int max=Integer.MIN_VALUE;
	public static int pathsum(Node root) {
		max=Integer.MIN_VALUE;
		helper(root);
		return max;
	}
	private static int helper(Node root) {
		if(root==null)
			return 0;
		int lsum=helper(root.left);
		int rsum=helper(root.right);
		
		int rv=Math.max(lsum,rsum)+root.data;
		max=Math.max(lsum+rsum+root.data, max);
		return rv;
		
	}
	

}
