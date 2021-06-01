package trees;

import trees.isBalance.Node;

public class foldable_binary_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub/
		//create the tree

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
	public static boolean is_foldable(Node a,Node b) {
		if(a==null && b==null)
			return true;
		if(a!=null && b!=null) {
			return is_foldable(a.left, b.right)&& is_foldable(a.right, b.left);
		}
	    else
		return false;
}

}
