package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import trees.largest_BST.Node;

public class Boundary_BT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static List<Integer> BoundaryOfBT(Node root) {
		List<Integer> ans = new LinkedList<Integer>();
		if (root == null)
			return ans;
		ans.add(root.data);
		leftBoundary(ans, root.left);
		rightBoundary(ans, root.right);
		return ans;

	}

	private static void rightBoundary(List<Integer> ans, Node root) {
		if(root==null)
			return;
		if(root.right!=null) {
			bottomboundary(ans, root.left);
			rightBoundary(ans, root.right);
		}
		else {
			rightBoundary(ans, root.left);
		}
		ans.add(root.data);
	}

	private static void leftBoundary(List<Integer> ans, Node root) {
        if(root==null)
        	return;
        ans.add(root.data);
        if(root.left!=null) {
        	leftBoundary(ans, root.left);
        	bottomboundary(ans,root.right);
        }
        else {
        	leftBoundary(ans, root.right);
        }
        
	}

	private static void bottomboundary(List<Integer> ans, Node root) {
		if(root==null)
			return;
		if(root.left==null && root.right==null)
			ans.add(root.data);
		else {
			bottomboundary(ans, root.left);
			bottomboundary(ans, root.right);
		}
		
	}

}
