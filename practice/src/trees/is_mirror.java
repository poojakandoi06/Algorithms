package trees;

import trees.isBalance.Node;

public class is_mirror {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create the tree

	}
	public static boolean isMirror(Node a, Node b) {
		if(a==null && b==null)
			return true;
		if(a==null || b==null)
			return false;
		boolean lr=isMirror(a.left, b.right);
		boolean rr=isMirror(a.right,b.left);
		return a.data==b.data && lr&&rr;
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

}
