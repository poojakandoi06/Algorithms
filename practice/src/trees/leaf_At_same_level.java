package trees;

public class leaf_At_same_level {

	public static void main(String[] args) {
//create the tree		

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
	static int level=-1;
	public static boolean count(Node root) {
		int level=-1;
		return helper(root,level);
	}
	private static boolean helper(Node root, int level2) {
		if(root==null) {
			return true;
		}
		if(root.left==null && root.right==null) {
			if(level==-1) {
				level=level2;
			}
			else {
				if(level2!=level) {
					return false;
				}
				
			}
			return true;
		}
		boolean lres=helper(root.left,level2+1);
		if(lres==false)
			return false;
		boolean rres=helper(root.right,level2+1);
		return rres;
	}
	

}
