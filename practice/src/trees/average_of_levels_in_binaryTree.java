package trees;

import java.util.ArrayList;
import java.util.LinkedList;

import trees.isBalance.Node;

public class average_of_levels_in_binaryTree {

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
    public static ArrayList<Double> averageOfLevels(Node root){
    	ArrayList<Double> ans=new ArrayList<Double>();
    	LinkedList<Node> queue=new LinkedList<Node>();
    	queue.add(root);
    	queue.add(null);
    	long sum=0;
    	int count=0;
    	while(queue.size()>0) {
    		Node temp=queue.removeFirst();
    		if(temp==null) {
    			ans.add(sum*1.0/count);
    			sum=0;
    			count=0;
    			if(queue.size()!=0)
    				queue.add(temp);
    		}
    		else {
    			sum+=temp.data;
    			count++;
    			if(temp.left!=null)
    				queue.addLast(temp.left);
    			if(temp.right!=null)
    				queue.addLast(temp.right);
    		}
    	}
    	return ans;
    }
	
}
