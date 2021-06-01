package trees;

import trees.largest_BST.Node;

public class BST_to_sortedCircularDoublyLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public  static class Node{
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
		Node head;
		Node tail;
		pair(Node h, Node t){
			this.head=h;
			this.tail=t;
		}
	}
	public static Node treetoDoublyLL(Node root) {
		pair p=TtoDLL(root);
		if(p.head!=null && p.tail!=null) {
			p.head.left=p.tail;
			p.tail.right=p.head;
		}
		return p.head;
	}
	private static pair TtoDLL(Node root) {
		if(root==null)
			return new pair(null,null);
		if(root.left==null && root.right==null) {
			return new pair(root,root);
		}
		pair lp=TtoDLL(root.left);
		pair rp=TtoDLL(root.right);
		pair cp=new pair(null,null);
		if(lp.tail==null) {
			cp.head=root;
		}
		else if(lp.tail!=null) {
			lp.tail.right=root;
			root.left=lp.tail;
			cp.head=lp.head;
			
		}
		if(rp.head==null) {
			cp.tail=root;
			
		}
		else {
			root.right=rp.head;
			rp.head.left=root;
			cp.tail=rp.tail;
		}
		return cp;
	}

}
