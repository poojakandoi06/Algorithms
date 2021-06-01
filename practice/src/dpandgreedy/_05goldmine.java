package dpandgreedy;

import java.util.*;

public class _05goldmine {

	public static void main(String[] args) {
		int[][] arr = { { 2, 6, 0, 5 }, { 0, 7, 5, 2 }, { 3, 0, 3, 7 }, { 8, 0, 2, 3 } };
		solution(arr);
	}

	private static void solution(int[][] arr) {
		int[][] dp = new int[arr.length][arr[0].length];
		for (int row = 0; row < dp.length; row++) {
			dp[row][dp[0].length - 1] = arr[row][arr[0].length - 1];
		}

		for (int col = arr[0].length - 2; col >= 0; col--) {
			for (int row = 0; row < arr.length; row++) {
				if (row == 0) {
					dp[row][col] = arr[row][col] + Math.max(dp[row][col + 1], dp[row + 1][col + 1]);
				} else if (row == arr.length - 1) {
					dp[row][col] = arr[row][col] + Math.max(dp[row][col + 1], dp[row - 1][col + 1]);
				} else {
					dp[row][col] = arr[row][col]
							+ Math.max(dp[row][col + 1], Math.max(dp[row + 1][col + 1], dp[row - 1][col + 1]));
				}
			}
		}
		int ans = Integer.MIN_VALUE;
		for (int row = 0; row < dp.length; row++) {
			ans = Math.max(ans, dp[row][0]);
		}
		System.out.println(ans);
	}

}
