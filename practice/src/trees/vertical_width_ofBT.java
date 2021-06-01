package trees;

import java.util.HashSet;

import trees.isBalance.Node;

public class vertical_width_ofBT {

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
	static HashSet<Integer> set;
	public static int verticalWidth(Node root) {
		set=new HashSet<Integer>();
		vwidth(root,0);
		return set.size();
	}
	private static void vwidth(Node root, int i) {
		if(root==null)
			return;
		if(!set.contains(i))
			set.add(i);
		vwidth(root.left,i-1);
		vwidth(root.right,i+1);
	}

}
