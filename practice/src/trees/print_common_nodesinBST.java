package trees;

import java.util.Stack;

import trees.isBalance.Node;

public class print_common_nodesinBST {

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
	public static void print_common_nodes(Node root1, Node root2) {
		Stack<Node> st1=new Stack<Node>();
		Stack<Node> st2=new Stack<Node>();
		addleft(root1,st1);
		addleft(root2,st2);
		while(st1.size()>0 && st2.size()>0) {
			if(st1.peek().data==st2.peek().data) {
				System.out.print(st1.peek().data+" ");
				addleft(st1.pop().right,st1);
				addleft(st2.pop().right,st2);
			}
			else if(st1.peek().data<st2.peek().data) {
				addleft(st1.pop().right,st1);
			}
			else {
				addleft(st2.pop().right,st2);
			}
		}
	}
	private static void addleft(Node root, Stack<Node> st) {
		while(root!=null) {
			st.push(root);
			root=root.left;
		}
	}

}
