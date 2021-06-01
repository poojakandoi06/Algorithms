package trees;

import trees.isBalance.Node;

public class count_univalued_subtree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create the tree

	}

	public class Node {
		int data;
		Node left;
		Node right;
		boolean isUni;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;

		}
	}

	public static int count(Node root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			root.isUni = true;
			return 1;
		}
		int lc = count(root.left);
		int rc = count(root.right);
		root.isUni = (root.left == null || (root.left.data == root.data && root.left.isUni))
				&& (root.right == null || (root.right.data == root.data && root.right.isUni));
		if (root.isUni) {
			return lc + rc + 1;
		}
		return lc + rc;
		
	}

}
