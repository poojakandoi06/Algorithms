package trees;

import java.util.LinkedList;

import trees.isBalance.Node;

public class max_nodeLevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create the tree
		//width of binary tree is also number of max node at any level

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
	public static int maxNodeLevel(Node root) {
		LinkedList<Node> queue=new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		int count=0;
		int maxnode=0;
		int maxnodelevel=0;
		int level=0;
		while(queue.size()>0) {
			Node temp=queue.removeLast();
			if(temp==null) {
				if(maxnode<count) {
					maxnode=count;
					maxnodelevel=level;
				}
				count=0;
				level++;
				if(queue.size()!=0) {
					queue.addLast(temp);
				}
			}
			else {
				count++;
			    if(temp.left!=null)
			    	queue.add(temp.left);
			    if(temp.right!=null)
			    	queue.add(temp.right);
			}
		}
		return maxnodelevel;
	}

}
