package dpandgreedy;

import java.util.*;

public class _15MaxSizeSubMatrixWithAllOnes {

	public static void main(String[] args) {
		int[][] arr = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		solution(arr);
	}

	private static void solution(int[][] arr) {
		int[][] dp = new int[arr.length + 1][arr[0].length + 1];
		int max = Integer.MIN_VALUE;
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
				if (arr[i][j] == 1) {
					dp[i][j] = Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
				} else {
					dp[i][j] = 0;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);
	}

}
