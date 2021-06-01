package trees;

import trees.largest_BST.Node;

public class check_sumtree {

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
	public static class pair{
		int sum;
		boolean ist; //isSUmTree
		pair(int s, boolean i){
			this.sum=sum;
			this.ist=i;
		}
	}
	public static boolean sumtree(Node root) {
		return isSumTreeH(root).ist;
	}
	private static pair isSumTreeH(Node root) {
		if(root==null)
			return new pair(0,true);
		if(root.left==null && root.right==null) {
			return new pair(root.data, true);
		}
		pair lr=isSumTreeH(root.left);
		if(lr.ist==false)
			return new pair(0,false);
		pair rr=isSumTreeH(root.right);
		if(rr.ist==false) {
			return new pair(0,false);
		}
		if(lr.ist && rr.ist && root.data==lr.sum+rr.sum)
			return new pair(lr.sum+rr.sum+root.data,true);
		return new pair(0,false);	
	}

}
