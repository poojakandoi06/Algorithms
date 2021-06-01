package trees;

import java.util.LinkedList;

import trees.largest_BST.Node;

public class BST_iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//calling next() will give the next smallest number
		

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
	public static class BSTiterator{
		LinkedList<Node> st=new LinkedList<Node>();
		public BSTiterator(Node root) {
			pushAll(root);
		}
		private void pushAll(Node n) {
			while(n!=null) {
				st.addFirst(n);
				n=n.left;
			}
		}
		public int next() {
			Node n=st.removeFirst();
			pushAll(n.right);
			return n.data;
			}
		public boolean hasNext() {
			return st.size()!=0;
		}
	}

}
