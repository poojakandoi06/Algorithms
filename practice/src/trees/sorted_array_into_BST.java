package trees;

import trees.largest_BST.Node;

public class sorted_array_into_BST {

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
	public static Node sortedArrayIntoBST(int[] arr) {
		return arrtoBST(0,arr.length-1,arr);
	}
	private static Node arrtoBST(int start, int end, int[] arr) {
		if(end<start)
			return null;
		if(start==end) {
			Node leaf=new Node(arr[start]);
			return leaf;
		}
		int mid=(start+end)/2;
		Node node=new Node(arr[mid]);
		node.left=arrtoBST(start, mid-1, arr);
		node.right=arrtoBST(mid+1, end, arr);
		return node;
	}
}
