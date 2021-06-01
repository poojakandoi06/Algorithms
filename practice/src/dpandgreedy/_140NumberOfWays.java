package dpandgreedy;

public class _140NumberOfWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static void numberOfWays(int n){
	 	 long[] dp = new long[n + 1];
	 	 dp[1] = dp[2] = dp[3] = 1;
	 	 dp[4] = 2;
	 	 for(int i = 5; i <= n; i++){
	 	     dp[i] = dp[i - 1] + dp[ i - 4];
	 	 }
	 	 System.out.println(dp[n]);
	 }

}
