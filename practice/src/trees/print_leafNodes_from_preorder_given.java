package trees;

import java.util.Stack;

import trees.isBalance.Node;

public class print_leafNodes_from_preorder_given {

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
	public static void print_leafNodes(int[] arr) {
		Stack<Integer> st=new Stack<Integer>();
		for(int i=1;i<arr.length;i++) {
			if(arr[i-1]>arr[i]) {
				st.push(arr[i-1]);
			}
			else {
				int count=0;
				while(st.size()>0 && st.peek()<arr[i]) {
					st.pop();
					count++;
				}
				if(count!=0) {
					System.out.println(arr[i-1]);
				}
			}
		}
		System.out.println(arr[arr.length-1]);
	}

}
