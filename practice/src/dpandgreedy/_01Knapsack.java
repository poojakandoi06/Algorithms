package dpandgreedy;

import java.util.*;

public class _01Knapsack {

	public static void main(String[] args) {
		int[] weights = { 10, 20, 30 };
		int[] prices = { 60, 100, 120 };
		int capacity = 50;
		solution(weights, prices, capacity);
	}

	private static void solution(int[] weights, int[] prices, int capacity) {
		int[][] dp = new int[weights.length + 1][capacity + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j - weights[i - 1] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], prices[i - 1] + dp[i - 1][j - weights[i - 1]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[dp.length - 1][dp[0].length - 1]);
	}

}
