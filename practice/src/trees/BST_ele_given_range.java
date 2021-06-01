package trees;

import trees.leaf_At_same_level.Node;

public class BST_ele_given_range {

	public static void main(String[] args) {
		// create the tree

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
	public static void print_bst_ele_given_range(Node root, int start, int end) {
		if(root==null)
			return;
		if(root.data>start) {
			print_bst_ele_given_range(root.left, start, end);
		}
		if(root.data>=start && root.data<=end) {
			System.out.println(root.data+" ");
		}
		if(root.data<end) {
			print_bst_ele_given_range(root.right, start, end);
		}
	}

}
