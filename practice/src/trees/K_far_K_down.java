package trees;

import java.util.ArrayList;

import trees.leaf_At_same_level.Node;

public class K_far_K_down {

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
	public static Node find(Node root, int data) {
		if(root==null)
			return null;
		if(data<root.data)
			return find(root.left,data);
		if(data==root.data)
			return root;
		if(data>root.data)
			return find(root.right,data);
		
		return  null;
	}
	public static ArrayList<Integer> k_down(Node root, int data,int k){
	Node target=find(root,data);
	int depth=0;
	ArrayList<Integer> res=new ArrayList<Integer>();
	res=helper(target,depth,res,k);
	return res;
	
	}
	private static ArrayList<Integer> helper(Node node, int depth, ArrayList<Integer> res, int k) {
		if(node==null)
			return res;
		if(depth==k) {
			res.add(node.data);
			return res;
		}
		res=helper(node.left,depth+1,res,k);
		res=helper(node.right,depth+1,res,k);
		return res;
	}
	static ArrayList<Integer> l;
	public static ArrayList<Integer> k_far(Node root, int data, int k){
		l=new ArrayList<Integer>();
		ArrayList<Node> list=new ArrayList<>();
		Node tar=find(root,data);
		list=find_paths(root, tar);
		for(int i=0;i<list.size();i++) {
			Node node=list.get(i);
			if(i!=0) {
				if(i==k) {
					l.add(node.data);
				}
				if(list.get(i-1)==node.right) {
					ArrayList<Integer> ll=k_down(node.left, 0, k-i-1);
					for(int j=0;j<ll.size();j++) {
						l.add(ll.get(j));
					}
				}
				else {
					ArrayList<Integer> ll2=k_down(node.right, 0, k-i-1);
					for(int j=0;j<ll2.size();j++) {
						l.add(ll2.get(j));
					}
				}
			}
			else {
				ArrayList<Integer> ll3=k_down(node, 0, k-i);
				for(int j=0;j<ll3.size();j++) {
					l.add(ll3.get(j));
				}
			}
		}
		return l;
		
	}
	public static ArrayList<Node> find_paths(Node node, Node target){
		if(node==null) {
			return new ArrayList<Node>();
		}
		if(node.data==target.data) {
			ArrayList<Node> al=new ArrayList<Node>();
			al.add(node);
			return al;
		}
		ArrayList<Node> left=find_paths(node.left, target);
		if(left.size()>0) {
			left.add(node);
			return left;
		}
		ArrayList<Node> right=find_paths(node.right, target);
		if(right.size()>0) {
			right.add(node);
			return right;
		}
		return new ArrayList<Node>();
	}
	

}
