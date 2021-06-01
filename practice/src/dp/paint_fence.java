package dp;

public class paint_fence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int ways(int n, int k) {
		int[] diff=new int[n];
		int[] same=new int[n];
		same[0]=0;
		diff[0]=k;
		for(int i=1;i<n;i++) {
			same[i]=diff[i-1];
			diff[i]=(k-1)*(same[i-1]+diff[i-1]);
		}
		return same[n-1]+diff[n-1];
	}
	

}
