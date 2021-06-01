package trees;

import java.util.HashSet;

import trees.leaf_under_budget.Node;

public class binaryTree_cameras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//will be using the greedy appraoch here.

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
	static int count=0;
		public static int mincamera(Node root) {
				HashSet<Node> set=new HashSet<Node>();
				set.add(null);
				helper(root,null,set);
				return count;
				
		}
		private static void helper(Node root, Node parent, HashSet<Node> set) {
			if(root==null)
				return;
			helper(root.left,root,set);
			helper(root.right,root,set);
			if((parent==null && !set.contains(root))||!set.contains(root.left) || !set.contains(root.right))
			{
				count++;
				set.add(root);
				set.add(parent);
				set.add(root.left);
				set.add(root.right);
				
			}
			
		}
	
}
