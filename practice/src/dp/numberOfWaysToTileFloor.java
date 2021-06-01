package dp;

public class numberOfWaysToTileFloor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int ways(int n, int m) {  // floor dimention== n*m    tile dimention ==1*m
		int[] dp=new int[n+1];
		for(int i=0;i<=n;i++) {
			if(i<m)
				dp[i]=1;
			else if(i==m)
				dp[i]=2;
			else
			dp[i]=dp[i-1]+dp[i-m];
		}
		return dp[n];
	}

}
