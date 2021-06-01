package dp;

public class maxSum_increasing_subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int msis(int[] arr) {
		int[] dp = new int[arr.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++)
			dp[i] = arr[i];
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
					dp[i] = dp[j] + arr[i];
					if(max<dp[i])
						max=dp[i];
				}
			}
		}
		return max;
	}

}
