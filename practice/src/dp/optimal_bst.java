package dp;

public class optimal_bst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int optimalbst(int[] input, int[] freq) {
		return mincostrec(input, freq, 0, input.length - 1, 1);
	}

	// recursion
	private static int mincostrec(int[] input, int[] freq, int low, int high, int level) {
		if (low > high)
			return 0;
		int min = Integer.MAX_VALUE;
		for (int i = low; i <= high; i++) {
			int val = mincostrec(input, freq, low, i - 1, level + 1) + mincostrec(input, freq, i + 1, high, level + 1)
					+ level * freq[i];
			if (val < min)
				min = val;
		}
		return min;
	}

	// Dynammic Programming
	private static int mincostdp(int[] input, int[] freq) {
		int[][] dp = new int[input.length][input.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = freq[i];
		}
		for (int level = 2; level <= input.length; level++) {
			for (int i = 0; i <= input.length - level; i++) {
				int j = i + level - 1;
				dp[i][j] = Integer.MAX_VALUE;
				int sum = getsum(freq, i, j);
				for (int k = i; k <= j; k++) {
					int val = sum + (k - 1 < i ? 0 : dp[i][k - 1]) + (k + 1 > j ? 0 : dp[k + 1][j]);
					if (val < dp[i][j])
						dp[i][j] = val;
				}
			}
		}
		return dp[0][input.length - 1];
	}

	private static int getsum(int[] freq, int i, int j) {
		int sum = 0;
		for (int k = i; k <= j; k++) {
			sum += freq[k];
		}
		return sum;
	}

}
