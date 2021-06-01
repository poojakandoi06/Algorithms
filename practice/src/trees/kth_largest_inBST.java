package trees;

import java.util.ArrayList;

import trees.kth_smallest_inBST.Node;

public class kth_largest_inBST {

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

	public static int kthLargest(Node root, int k) {
		// Add your code here.

		ArrayList<Integer> arr = kth_largest(root, k, new ArrayList<Integer>());
		return arr.get(arr.size()-k);

	}

	public static ArrayList<Integer> kth_largest(Node root, int k, ArrayList<Integer> list) {
		if (root == null)
			return list;
		list = kth_largest(root.left, k, list);
		list.add(root.data);
		list = kth_largest(root.right, k, list);
		return list;
	}

}
