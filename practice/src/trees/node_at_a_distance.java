package trees;

import java.util.ArrayList;
import java.util.HashSet;

import trees.isBalance.Node;

public class node_at_a_distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create the tree

	}
	public static int kdistancefromleaf(Node root, int k) {
		int count=0;
		helper(root,k,0,new ArrayList<Node>(), new HashSet<Node>());
		return count;
	}
	static int count=0;
	private static void helper(Node root, int k, int l, ArrayList<Node> psf, HashSet<Node> visited) {
		if(node==null)
			return;
		
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
