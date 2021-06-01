package lru;

import java.util.LinkedList;
import java.util.Queue;

public class almug {
	public static class node{
		int val;
		node left;
		node right;
		public node(int val) {
			this.val=val;
			this.left=null;
			this.right=null;
			
		}
	}

	public static void main(String[] args) {
		
	   node root=new node(10);
	   root.left=new node(20);
	   root.right=new node(30);
	   root.left.left=new node(40);
	   root.right.left=new node(50);
	   root.right.right=new node(60);
	   root=insert(root,70);
	   inorder(root);

	}
	public static void inorder(node root) {
		if(root==null)
			return;
		System.out.print(root.val+" ");
		inorder(root.left);
		inorder(root.right);
	}
	
	public static int reverse(int n) {
		int res=0;
		while(n>0) {
			res=res*10+(n%10);
			n=n/10;
		}
		return res;
	}
	public static int maxreverese() {
		int max=0;
		for(int i=100;i<=999;i++) {
			for(int j=100;j<=999;j++) {
				int val=(i*j);
				if((i*j)==reverse(i*j))
					max=Math.max(max, val);
			}
		}
		return max;
	}
	// -10 -3 5 6 -2
	 

public static node insert(node root, int val) {
	    	if(root==null) {
	    		root=new node(val);
	    		return root;
	    	}
	    	Queue<node> q=new LinkedList<node>();
	    	q.add(root);
	    	while(!q.isEmpty()) {
	    		node n=q.poll();
	    		if(n.left!=null)
	    			q.add(n.left);
	    		else {
	    			n.left=new node(val);
	    			return root;
	    		}
	    		if(n.right!=null)
	    			q.add(n.right);
	    			else {
	    				n.right=new node(val);
	    				return root;
	    			}
	    			
	    	}
	    	return root;
	    }

}
