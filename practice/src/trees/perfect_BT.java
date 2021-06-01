package trees;

import trees.largest_BST.Node;

public class perfect_BT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//perfect BT==all leaf node at same level
		// every internal node has both left child as well as right child.

	}
	public static  class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	public static int finddepth(Node root) {
			int d=0;
			while(root!=null) {
				d++;
				root=root.left;
			}
			return d;
	}
	public static boolean isPerfect(Node root, int d, int level) {
		if(root.left==null && root.right==null) {
			if(level!=d-1) {
				return false;
			}
			return true;
			
		}
		if(root.left==null || root.right==null)
			return false;
		
		return isPerfect(root.left, d, level+1) && isPerfect(root.right, d, level+1);
	}

}
