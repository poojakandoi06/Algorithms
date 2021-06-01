package dpandgreedy;

public class _149PerfectSquares {

	public static void main(String[] args) {
		System.out.println(count(20));

	}

	private static int count(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 1;
		for (int i = 5; i <= n; i++) {
			if((int)Math.sqrt(i) * (int)Math.sqrt(i) == i) {
				dp[i] = 1;
				continue;
			}
			int lo = 1, hi = i - 1;
			int min = Integer.MAX_VALUE;
			while (lo <= hi) {
				min = Math.min(min, dp[lo] + dp[hi]);
				lo++;
				hi--;
			}
			dp[i] = min;
		}
		return dp[n];
	}

}
