package trees;

import java.util.TreeMap;

import trees.isBalance.Node;

public class vertical_sum {

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
	static TreeMap<Integer,Integer> map;
	public static void printverticalsum(Node root) {
		map=new TreeMap<Integer,Integer>();
		vsum(root,0);
		for(int i:map.keySet()) {
			System.out.print(map.get(i));
		}
	}
	private static void vsum(Node root, int i) {
		if(root==null)
			return;
		if(!map.containsKey(i)) {
			map.put(i,root.data);
		}
		else {
			map.put(i,map.get(i)+root.data);
		}
		vsum(root.left,i-1);
		vsum(root.right,i+1);
	}

}
