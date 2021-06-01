package dp;

public class climb_stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stairs(10);

	}
	public static void stairs(int n) {
		int[] dp=new int[n+1];
		dp[0]=dp[1]=1;
		for(int i=2;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		System.out.println(dp[n]);
	}

}
