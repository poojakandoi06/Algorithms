package trees;

import trees.isBalance.Node;

public class longest_consec_sequence_inBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	static int maxlen=0;
	public static int longest_cons_inBST(Node root) {
		int maxlen=0;
		helper(root,null,0);
		if(maxlen==0) {
			return -1;
		}
		else 
			return maxlen+1;
	}
	private static void helper(Node root, Node parent, int len) {
		if(root==null)
			return;
		len=parent!=null && root.data-1==parent.data?len+1:0;
		maxlen=Math.max(len, maxlen);
		helper(root.left,root,len);
		helper(root.right,root,len);
		
	}

}
