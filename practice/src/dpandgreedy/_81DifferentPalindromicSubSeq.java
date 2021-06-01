package dpandgreedy;

public class _81DifferentPalindromicSubSeq {

	public static void main(String[] args) {
		String str = "bccb";
		solution(str);
	}

	public static void solution(String str) {
		int n = str.length();
		int[][] dp = new int[n][n];
		char[] arr = str.toCharArray();
		for (int gap = 0; gap < n; gap++) {
			int si = 0;
			int ei = gap;
			while (ei < n) {
				if (gap == 0) {
					dp[si][ei] = 1;
				} else if (arr[si] != arr[ei]) {
					dp[si][ei] += dp[si + 1][ei] + dp[si][ei - 1] - dp[si + 1][ei - 1];
				} else {
					int lo = si + 1;
					int hi = ei - 1;
					while (lo <= hi && arr[lo] != arr[ei]) {
						lo++;
					}
					while (lo <= hi && arr[hi] != arr[ei]) {
						hi--;
					}
					if (lo == hi) {
						dp[si][ei] = dp[si + 1][ei - 1] + 1;
					} else if (lo > hi) {
						dp[si][ei] = dp[si + 1][ei - 1] * 2 + 2; // why not clear??????
					} else {
						dp[si][ei] = (2 * dp[si + 1][ei - 1]) - dp[lo + 1][hi - 1];
					}
				}
				dp[si][ei] = dp[si][ei] < 0 ? dp[si][ei] + 1000000007 : dp[si][ei] % 1000000007;
				si++;
				ei++;

			}
		}

		System.out.println(dp[0][n - 1]);
	}

}
