package trees;

import trees.binaryTree_cameras.Node;

public class unique_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//use catalan---unique bst out of n nodes

	}
	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	public static int unique_BST(int n) {
		if(n==0 || n==1)
			return 1;
		if(n==2)
			return 2;
		int[] arr=new int[n+1];
		arr[0]=1;
		arr[1]=1;
		arr[2]=2;
		for(int i=3;i<=n;i++) {
			int left=0;
			int right=i-1;
			while(left!=i) {
				arr[i]+=arr[left]*arr[right];
				left++;
				right--;
						
			}
		}
		return arr[n];
	}
	

}
