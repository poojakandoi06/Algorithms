package dpandgreedy;

import java.util.*;

public class _113LongestPathInMatrix {

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 9 }, { 5, 3, 8 }, { 4, 6, 7 } };
		solution(arr);
	}

	public static void solution(int[][] arr) {
		int ans = 1;
		int n = arr.length;
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(dp[i], -1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] == -1) {
					findLongestFromACell(i, j, arr, dp, n);
				}
				ans = Math.max(ans, dp[i][j]);
			}
		}
		System.out.println(ans);
	}

	private static int findLongestFromACell(int i, int j, int[][] arr, int[][] dp, int n) {
		if (i < 0 || i >= n || j < 0 || j >= n) {
			return 1;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int a = Integer.MIN_VALUE;
		int b = Integer.MIN_VALUE;
		int c = Integer.MIN_VALUE;
		int d = Integer.MIN_VALUE;

		if (j < n - 1 && ((arr[i][j] + 1) == arr[i][j + 1]))
			a = dp[i][j] = 1 + findLongestFromACell(i, j + 1, arr, dp, n);

		if (j > 0 && ((arr[i][j] + 1) == arr[i][j - 1]))
			b = dp[i][j] = 1 + findLongestFromACell(i, j - 1, arr, dp, n);

		if (i < n - 1 && ((arr[i][j] + 1) == arr[i + 1][j]))
			c = dp[i][j] = 1 + findLongestFromACell(i + 1, j, arr, dp, n);

		if (i > 0 && ((arr[i][j] + 1) == arr[i - 1][j]))
			d = dp[i][j] = 1 + findLongestFromACell(i - 1, j, arr, dp, n);

		return dp[i][j] = Math.max(a, Math.max(b, Math.max(c, Math.max(d, 1))));

	}

}
