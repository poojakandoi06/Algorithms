package trees;

import trees.isBalance.Node;

public class largest_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	public static int largestBST(Node root) {
		pair pr=BST(root);
		return pr.size;
	}
	private static pair BST(Node root) {
		if(root==null) {
			pair p=new pair(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
			return p;
		}
		pair lp=BST(root.left);
		pair rp=BST(root.right);
		pair np=new pair(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
		np.max=	Math.max(rp.max, Math.max(root.data,lp.max));
		np.min=Math.min(root.data, Math.min(lp.min, rp.min));
		np.flag=false;
		if(root.data> lp.max && root.data<rp.min && lp.flag==true && rp.flag==true) {
			np.size=lp.size+rp.size+1;
			np.flag=true;
		}
		else {
			np.size=Math.max(lp.size, rp.size);
			np.flag=false;
		}
		return np;
		
	}
	public static class pair{
		int min;
		int max;
		int size;
		boolean flag;
		pair(int max, int min, int size){
			this.max=max;
			this.min=min;
			this.size=size;
			flag=true;
		}
	}

}
