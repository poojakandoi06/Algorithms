package trees;

import java.util.ArrayList;

import trees.leaf_At_same_level.Node;

public class pth_common_ancestor_in_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	public static int pthCommonAncestor(Node root,int x, int y, int p) {
		ArrayList<Integer> xlist=find(root,x);
		ArrayList<Integer> ylist=find(root,y);
		int i=xlist.size()-1;
		int j=ylist.size()-1	;
		int k=0;
		for(;i>=0 && j>=0;i--,j--) {
			if(xlist.get(i)!=ylist.get(j)) {
				break;
			}
		}
		if(i+p<xlist.size()) {
			return xlist.get(i+p);
		}
		else {
			return -1;
		}
		
		
	}
	public static ArrayList<Integer> find(Node root, int target){
		if(root==null) {
			return new ArrayList<Integer>();
		}
		if(root.data==target) {
			ArrayList<Integer> arr=new ArrayList<Integer>();
			arr.add(target);
			return arr;
		}
		ArrayList<Integer> al=find(root.left,target);
		if(al.size()>0) {
			al.add(root.data);
			return al;
		}
		ArrayList<Integer> ar=find(root.left,target);
		if(ar.size()>0) {
			ar.add(root.data);
			return ar;
		}
		return new ArrayList<Integer>();
		
	}
}
