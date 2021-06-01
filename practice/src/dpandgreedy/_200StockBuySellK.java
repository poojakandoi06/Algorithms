package dpandgreedy;

import java.util.*;

public class _200StockBuySellK {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] price = new int[n];
		for (int i = 0; i < n; i++) {
			price[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		System.out.print(maxProfit(price, n, k));
	}

	static int maxProfit(int[] price, int n, int k) {
		int[][] dp = new int[k + 1][n + 1];
		for(int i = 1; i <= k; i++) {
			int prevdiff = Integer.MIN_VALUE;
			for(int j = 1; j < n; j++) {
				prevdiff = Math.max(prevdiff, dp[i - 1][j - 1] - price[j - 1]);
				dp[i][j] = Math.max(dp[i][j - 1], prevdiff + price[j]);
			}
		}
		return dp[dp.length - 1][dp[0].length - 2];
	}
}
