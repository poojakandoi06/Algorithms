package dp;

public class min_partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int minpartitionsum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];
		boolean[][] dp = new boolean[arr.length][sum / 2 + 1];
		for (int i = 0; i < dp.length; i++)
			dp[i][0] = true;
		for (int i = 0; i < dp[0].length; i++)
			dp[0][i] = false;

		for (int i = 1;	 i <= arr.length; i++) {
			for (int j = 1; j <= sum; j++) {
				dp[i][j] = dp[i - 1][j];
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]];
				}
			}
		}
		int diff = Integer.MAX_VALUE;
		for (int j = sum / 2; j >= 0; j--) {
			if (dp[arr.length][j] == true) {
				diff = sum - 2 * j;
				break;
			}
		}
		return diff;

	}

}
