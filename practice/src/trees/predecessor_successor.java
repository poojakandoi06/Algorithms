package trees;

import trees.is_mirror.Node;

public class predecessor_successor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create the tree

	}

	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	public static void predecessor__successor(Node root, int key,result r) {
		if(root==null)
			return;
		predecessor__successor(root.left, key, r);
		if(root.data<key) {
			r.pre=root;
		}
		if(root.data>key) {
			if(r.suc==null)
				r.suc=root;
		}
		predecessor__successor(root.right, key, r);
	}
	public class result{
		Node pre;
		Node suc;
	}

}
