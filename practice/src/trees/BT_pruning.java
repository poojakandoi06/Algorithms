package trees;

import trees.largest_BST.Node;

public class BT_pruning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//all roots have value either 0 or 1, remove all subtree having no node as 1.

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
	public static class pair{
		Node node;
		int count;
		public pair(Node n, int c) {
			this.node=n;
			this.count=c;
		}
	}
	public static Node prune_tree(Node root) {
		pair rp=helper(root);
		return rp.node;
	}
	private static pair helper(Node root) {
		if(root==null)
			return new pair(null,0);
		pair lp=helper(root.left);
		root.left=lp.node;
		pair rp=helper(root.right);
		root.right=rp.node;
		if(lp.count==0 && rp.count==0 && root.data==0) {
			return new pair(null,0);
		}
		return new pair(root,lp.count+rp.count+root.data);
	}

}
