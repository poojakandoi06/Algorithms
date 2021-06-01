package trees;

import java.util.LinkedList;

import trees.BST_ele_given_range.Node;

public class right_sideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	public static void print_right_sideView(Node root) {
		LinkedList<Node> queue=new LinkedList<Node>();
		queue.addLast(root);
		queue.add(null);
		Node prev=root;
		while(queue.size()>0) {
			Node nn=queue.pop();
			if(nn==null) {
				System.out.print(prev.data+" ");
				if(queue.size()!=0) {
					queue.add(null);
				}
			}
			else {
				if(nn.left!=null)
					queue.add(nn.left);
				if(nn.right!=null)
					queue.add(nn.right);
			}
			
			prev=nn;

		}
		
	}

}
