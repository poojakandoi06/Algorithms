package dp;

public class longest_palindromic_Sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int lps(String str) {
		int n = str.length();
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++)
			dp[i][i] = 1;

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (str.charAt(i) == str.charAt(j) && l == 2)
					dp[i][j] = 2;
				else if (str.charAt(i) == str.charAt(j))
					dp[i][j] = dp[i + 1][j - 1] + 2;
				else
					dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);

			}
		}
		return dp[0][n-1];
	}

}
