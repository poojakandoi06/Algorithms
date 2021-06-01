package dp;

import java.util.Arrays;

public class Knapsack01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int knapsack(int[] weights, int[] prices, int capacity) {
		int[][] dp=new int[weights.length+1][capacity+1];
		Arrays.fill(dp, 0);
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(j>=weights[i-1])
				dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]]+prices[i-1]);
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}

}
