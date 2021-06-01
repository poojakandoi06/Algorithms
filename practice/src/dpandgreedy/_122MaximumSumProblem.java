package dpandgreedy;

public class _122MaximumSumProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int maxSum(int n) {
	     if(n < 7){
	         return n;
	     }
	 	int[] dp = new int[n + 1];
	 	dp[1] = 1;
	 	dp[2]= 2;
	 	dp[3] = 3;
	 	dp[4] = 4;
	 	for(int i = 5; i <= n ;i++){
	 	    dp[i] = Math.max(dp[i/2] + dp[i / 3] + dp[i / 4], i);
	 	    
	 	}
	 	return dp[n];
	 }

}
