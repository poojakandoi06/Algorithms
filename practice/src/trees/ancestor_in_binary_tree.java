package trees;

import trees.symmetric_tree.Node;

public class ancestor_in_binary_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

	public static boolean ancestor(Node root, int key) {
		if(root==null)
			return false;
		if(root.data==key)
			return true;
		boolean ans=ancestor(root.left, key);
		if(ans==true) {
			System.out.println(root.data);
			return true;
		}
		else {
		ans=ancestor(root.right, key);
		if(ans==true) {
			System.out.println(root.data);
			return true;
		}
			return false;
		}
	}
}
