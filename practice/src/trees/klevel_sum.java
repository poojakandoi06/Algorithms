package trees;

import java.util.LinkedList;

import trees.isBalance.Node;

public class klevel_sum {

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
	public static long klevelsum(Node root, int k) {
		LinkedList<Node> queue=new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		int level=0;
		long sum=0;
		long ans=0;
		while(queue.size()>0) {
			Node temp=queue.removeFirst();
			if(temp==null) {
				if(level==k) {
					ans=sum;
					break;
				}
				sum=0;
				level++;
				if(queue.size()!=0) {
					queue.addLast(temp);
				}
			}
			else {
				sum+=root.data;
				if(temp.left!=null)
					queue.addLast(temp.left);
				if(temp.right!=null)
					queue.addLast(temp.right);
			}
		}
		return ans;
	}

}
