package trees;

import trees.Binary_tree_paths.Node;

public class diameter {

	public static void main(String[] args) {
		//create the tree

	}
	private static class diapair{
		int dia;
		int ht;
		 diapair() {
			this.dia=0;
			this.ht=0;
		}
	}
	public static int diameter(Node root) {
		diapair dp=helper(root);
		return dp.dia;
	}
	private static diapair helper(Node root) {
		if(root==null) {
			diapair ll=new diapair();
			return ll;
		}
		diapair lp=helper(root.left);
		diapair rp=helper(root.right);
		diapair mp=new diapair();
		mp.dia=Math.max(lp.ht+rp.ht+1, Math.max(lp.dia, rp.dia));
		mp.ht=Math.max(lp.ht, rp.ht)+1;
		return mp;
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
