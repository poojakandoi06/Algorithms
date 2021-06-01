package dpandgreedy;

public class _128MinimumFallingPathSum {

	public static void main(String[] args) {
		int[][] arr = { { 2, 5, 7, 1 }, { 6, 6, 2, 1 }, { 8, 4, 1, 7 }, { 2, 6, 7, 3 } };
		solution(arr);

	}

	public static void solution(int[][] arr) {
		int n = arr.length;
		int[][] dp = new int[n][n];
		int min = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int lmin = Integer.MAX_VALUE;
			int lsmin = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (i == 0) {
					dp[i][j] = arr[i][j];
				} else {
					if (dp[i - 1][j] == min) {
						dp[i][j] = arr[i][j] + smin;
					} else {
						dp[i][j] = arr[i][j] + min;
					}
				}
				if (dp[i][j] <= lmin) {
					lsmin = lmin;
					lmin = dp[i][j];
				} else if (dp[i][j] > lmin && dp[i][j] < lsmin) {
					lsmin = dp[i][j];
				}
				
			}
			min = lmin;
			smin = lsmin;
		}
		System.out.println(min);
	}

}
