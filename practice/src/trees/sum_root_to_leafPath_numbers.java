package trees;

import trees.largest_BST.Node;

public class sum_root_to_leafPath_numbers {

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
	public static int sumNumbers(Node root) {
		return sum(root,0,0);
	}
	public static int sum(Node root,int total, int mysum) {
		if(root==null)
			return total;
		if(root.left==null && root.right==null) {
			mysum+=root.data;
			total+=mysum;
			return total;
		}
		mysum+=root.data;
		total=sum(root.left,total,mysum*10);
		total=sum(root.right,total,mysum*10);
		return total;
	}

}
