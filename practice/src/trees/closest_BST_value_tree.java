package trees;

import java.util.ArrayList;
import java.util.LinkedList;

import trees.count_non_leaf_nodes.Node;

public class closest_BST_value_tree {

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
	public static ArrayList<Integer> kclosest(Node root, int k, int target){
		ArrayList<Integer> ans=new ArrayList<Integer>();
		LinkedList<Integer> list=new LinkedList<Integer>();
		k_closest(root,k,target,list);
		while(list.size()>0) {
			ans.add(list.removeLast());
		}
		return ans;
		
	}
	private static void k_closest(Node root, int k, int target, LinkedList<Integer> list) {
		 if(root==null)
			 return;
		 k_closest(root.left, k, target, list);
		 if(list.size()<k) {
			 list.addLast(root.data);
		 }
		 else if(Math.abs(list.getFirst()-target)>Math.abs(root.data-target)) {
			 list.removeFirst();
			 list.add(root.data);
		 }
		 k_closest(root.right, k, target, list);
	}

}
