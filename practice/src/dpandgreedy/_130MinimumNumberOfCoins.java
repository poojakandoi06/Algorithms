package dpandgreedy;

import java.util.Arrays;

public class _130MinimumNumberOfCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int solution(int[] coins, int value) {
		int[] dp = new int[value + 1];
		dp[0] = 0;
		Arrays.fill(coins, Integer.MAX_VALUE);
		for(int i = 1; i <= value; i++) {
			for(int j = 0 ; j < coins.length; j++) {
				if(coins[j] <= i) {
					int v = dp[i - coins[j]];
					if(v != Integer.MAX_VALUE && v + 1 < dp[i]) {
						dp[i] = v;
					}
				}
			}
		}
		return dp[value];
		
	}

}
