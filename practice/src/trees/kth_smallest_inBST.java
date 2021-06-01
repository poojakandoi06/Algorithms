package trees;

import java.util.ArrayList;

import trees.is_mirror.Node;

public class kth_smallest_inBST {

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
	
	public static int kthSmallest(Node root,int k)
    {
        //Add your code here.
        
        ArrayList<Integer> arr=kth_smallest(root, k,new ArrayList<Integer>());
		return arr.get(k-1);
       
    }
    
	
	public static ArrayList<Integer> kth_smallest(Node root, int k, ArrayList<Integer> list) {
		if(root==null)
		return list;
		list=kth_smallest(root.left,k,list);
		list.add(root.data);
		list=kth_smallest(root.right,k,list);
		return list;
	}

}
