package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.largest_BST.Node;

public class BT_from_linkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static class LinkedlistNode {
		int data;
		LinkedlistNode next;

		LinkedlistNode(int d) {
			this.data = d;
			this.next = null;
		}
	}

	public static class binaryTree {
		public Node convert(LinkedlistNode head, Node node) {
			Queue<Node> q = new LinkedList<Node>();
			if (head == null) {
				node = null;
				return null;
			}
		node=new Node(head.data);
		q.add(node);
		head=head.next;
		while(head!=null) {
			Node parent=q.poll();
			Node leftchild=null;
			Node rightchild=null;
			leftchild=new Node(head.data);
			q.add(leftchild);
			head=head.next;
			if(head!=null) {
				rightchild=new Node(head.data);
				q.add(rightchild);
				head=head.next;
			}
			parent.left=leftchild;
				parent.right=rightchild;
		}
		return node;

		}
	}

}
