package trees;

import trees.count_non_leaf_nodes.Node;

public class isBalance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create the tree

	}
	public class pair{
		int ht;
		boolean bal;
	}
	public boolean isBalance(Node root) {
		pair res=check(root);
		return res.bal;
	}
	
	
	private pair check(Node root) {
		if(root==null) {
			pair bp=new pair();
			bp.ht=0;
			bp.bal=true;
			return bp;
		}
		pair lp=check(root.left);
		pair rp=check(root.right);
		pair mp=new pair();
		mp.ht=Math.max(lp.ht, rp.ht)+1;
		mp.bal=Math.abs(lp.ht-rp.ht)<=1 &&lp.bal&& rp.bal;
		return mp;
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
