package dp;

public class no_of_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberOfBST(10));

	}
	public static int numberOfBST(int n) {
		int res=0;
		if(n<=1) {
			return 1;
		}
		for(int i=0;i<n;i++) {
			res+=numberOfBST(i)*numberOfBST(n-i-1);	
		}
		return res;
	}

}
