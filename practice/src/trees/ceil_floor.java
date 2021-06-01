package trees;

import trees.count_non_leaf_nodes.Node;

public class ceil_floor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create a generic tree

	}
	private static Integer ceil;
	private static Integer floor;
	public static void ceilfloor(Node root,int data) {
		ceil=null;
		floor=null;
		ceilfloor1(root,data);
		System.out.println("ceil: "+ceil);
		System.out.println("floor: "+floor);
	}
	private static void ceilfloor1(Node root, int data) {
		for(Node child: root.children) {
			ceilfloor1(child,data);
		}
		if(root.data>data) {
			ceil=ceil==null?root.data:Math.min(ceil, root.data);
		}
		if(root.data<data) {
			floor=floor==null?root.data:Math.max(ceil, root.data);
		}
	}
	public class Node{
		int data;
		Node[] children;
		public Node(int data) {
			this.data=data;
			children=null;
		}
	}

}
