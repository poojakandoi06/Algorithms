package trees;

import java.util.LinkedList;

import trees.isBalance.Node;

public class leaf_under_budget {

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
	public static int no_ofLeafUnderBudget(Node root, int budget) {
			LinkedList<Node> queue =new LinkedList<Node>();
			queue.add(root);
			queue.add(null);
			int count=0;
			int level=1;
			while(queue.size()>0) {
				Node temp=queue.removeFirst();
				if(temp==null) {
					level++;
					if(queue.size()!=0) {
						queue.add(temp);
					}
				}
				else {
					if(temp.left==null && temp.right==null && budget-level>=0) {
						budget-=level;
						count++;
						continue;
					}
					if(temp.left!=null)
						queue.addLast(temp.left);
					if(temp.right!=null)
						queue.addLast(temp.right);
				}
			}
			return count;
	}
	

}
