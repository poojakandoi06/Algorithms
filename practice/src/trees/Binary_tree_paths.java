package trees;

import java.util.ArrayList;

import trees.leaf_At_same_level.Node;

public class Binary_tree_paths {

	public static void main(String[] args) {
		// create the tree

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
	public static ArrayList<String> paths(Node root){
		ArrayList<String> al=new ArrayList<String>();
		al=helper(root,al,"");
		return al;
	}
	private static ArrayList<String> helper(Node root, ArrayList<String> al, String psf) {
		if(root==null)
			return al;
		if(root.left==null && root.right==null) {
			psf+=root.data;
			al.add(psf);
			return al;
		}
		psf+=root.data+"->";
		al=helper(root.left,al,psf);
		al=helper(root.right,al,psf);
		return al;
	}
	

}
