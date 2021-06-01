package dp;

import java.util.LinkedList;
import java.util.Queue;

public class min_costPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int mincostPath(int[][] arr) {
		int[][] dp = new int[arr.length + 1][arr[0].length + 1];
		for (int i = dp.length - 2; i >= 0; i--) {
			for (int j = dp[0].length - 2; j >= 0; j--) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + arr[i + 1][j + 1];

			}
		}
		printpath(dp, arr);
		return dp[0][0];
	}

	public static void printpath(int[][] dp, int[][] arr) {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				int val = dp[i][j] - arr[i][j];

			}
		}
	}

}
