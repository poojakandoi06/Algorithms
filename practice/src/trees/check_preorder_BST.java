package trees;

import java.util.Stack;

import trees.largest_BST.Node;

public class check_preorder_BST {

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
	public static boolean preorder(int[] pre) {
		int root=Integer.MIN_VALUE;
		Stack<Integer> st=new Stack<Integer>();
		for(int i=0;i<pre.length;i++) {
			if(pre[i]<root)
				return false;
			else {
				if(st.size()==0) {
					st.push(pre[i]);
				}
				else {
					if(pre[i]<st.peek())
						st.push(pre[i]);
					else {
						while(st.size()>0 && st.peek()<pre[i])
							root=st.pop();
						st.push(pre[i]);
					}
				}
			}
		}
		return true;
	}

}
