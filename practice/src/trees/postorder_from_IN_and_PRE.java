package trees;

import trees.binaryTree_cameras.Node;

public class postorder_from_IN_and_PRE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//pre == NLR
		//in=LNR
		int[] in= {4,2,5,1,3,6};
		int[] pre= {1,2,4,5,3,6};
		printPOST(in, pre, 6);

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
	public static void printPOST(int[] in, int[] pre, int n) {
		printpost(in,in.length-1,0,pre,0,pre.length-1);
	}
	public static void printpost(int[] in, int ine, int ins, int[] pre, int prs, int pree) {
		 if(pree<prs || ins>ine) return;
		
		
		int root=search(in, pre[prs],ins, ine);
		int lhs=root-ins;
		printpost(in, root-1, ins,pre, prs+1, prs+lhs);
		printpost(in, ine, root+1, pre, prs+lhs+1, pree);
		System.out.print(pre[prs]+" ");
		
	}
	
	public static int search(int[] in, int x, int ins, int ine) {
		for(int i=ins;i<=ine;i++) {
			if(in[i]==x)
				return i;
		}
		return -1;
	}

}
