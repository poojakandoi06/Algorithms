package dp;

public class partition_set_into_k_subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     // bell numbers
	}
	public static int partition(int n, int k) {
		int[][] dp=new int[k+1][n+1];
		for(int i=0;i<=n;i++)
			dp[1][i]=1;
		for(int i=2;i<=k;i++) {
			for(int j=i;j<=n;j++) {
				dp[i][j]=dp[i-1][j-1]+k*dp[i-1][j];
			}
		}
		return dp[k][n];
	}

}
