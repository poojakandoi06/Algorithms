package trees;

import trees.BST_ele_given_range.Node;

public class min_dist_btw_BST_nodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // min diff btw any two nodes(values) of the BST
	
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
	public static int min_dis(Node root) {
		diff=Integer.MAX_VALUE;
		helper(root);
		return diff;
		
	}
	private static pair helper(Node root) {
		if(root==null) {
			pair p=new pair();
			p.max=Integer.MIN_VALUE;
			p.min=Integer.MAX_VALUE;
			return p;
		}
		if(root.left==null && root.right==null) {
			pair p=new pair();
			p.max=root.data;
			p.min=root.data;
			return p;
		}
		pair lp=helper(root.left);
		pair rp=helper(root.right);
		pair np=new pair();
		np.max=Math.max(rp.max,Math.max(root.data, lp.max));
		np.min=Math.min(root.data, Math.min(lp.min, rp.min));
		int d1=root.left!=null?Math.abs(lp.max-root.data):Integer.MAX_VALUE;
		int d2=root.right!=null?Math.abs(rp.min-root.data):Integer.MIN_VALUE;
		diff=Math.min(diff, Math.min(d1, d2));
		return np;
		
	}
	static int diff=Integer.MAX_VALUE;
	
	public static class pair{
		int max;
		int min;
		
	}

}
