package trees;

import trees.largest_BST.Node;

public class BT_tilt {

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
	public static  int tsum=0;
	public static int findTilt(Node root) {
		helper(root);
		return tsum;
		
	}
	private static int helper(Node root) {
		if(root==null)
			return 0;
		int ls=helper(root.left);
		int rs=helper(root.right);
		tsum+=Math.abs(ls-rs);
		return ls+rs+root.data;
		
	}

}
