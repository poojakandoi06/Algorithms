package trees;

import trees.largest_BST.Node;

public class maxpathsum_from_anyNode {

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
	public static int max=Integer.MIN_VALUE;
	public static int findMax(Node root) {
		maxpath(root);
		return max;
	}
	private static int maxpath(Node root) {
		if(root==null)
			return 0;
		int ls=maxpath(root.left);
		int rs=maxpath(root.right);
		
		max=Math.max(max, root.data);
		max=Math.max(max, Math.max(ls+root.data, rs+root.data));
		max=Math.max(root.data+ls+rs, max);
		
		int rv=Math.max(root.data, Math.max(ls+root.data, rs+root.data));
		return rv;
		
	}

}
