package trees;

import java.util.LinkedList;
import java.util.TreeMap;

import trees.BST_ele_given_range.Node;

public class top_view_of_BinaryTree {

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
	public static class qnode{
		Node n;
		int cl;
		qnode(Node n, int cl){
			this.n=n;
			this.cl=cl;
		}
	}
	static TreeMap<Integer,Integer> map;
	public static void printTopView(Node root) {
		map=new TreeMap<Integer,Integer>();
		qnode xnode=new qnode(new Node(Integer.MIN_VALUE),0);
		LinkedList<qnode> queue=new LinkedList<qnode>();
		queue.addLast(new qnode(root,0));
		queue.addLast(xnode);
		while(queue.size()>0) {
			qnode rm=queue.pop();
			if(rm.n==null) {
				if(queue.size()>0) {
					queue.addLast(xnode);
				}
			}
			else {
				if(!map.containsKey(rm.cl)) {
					map.put(rm.cl, rm.n.data);
				}
				if(rm.n.left!=null) {
					queue.addLast(new qnode(rm.n.left,rm.cl-1));
				}
				if(rm.n.right!=null) {
					queue.addLast(new qnode(rm.n.right,rm.cl+1));
				}
			}
		}
		for(int i:map.keySet()) {
			System.out.print(map.get(i)+" ");
		}
		
		
		
	}

}
