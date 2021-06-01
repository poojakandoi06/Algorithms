package dpandgreedy;

import java.util.*;

public class _40MinInsertionsToFormaPalindrome {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

	private static void solution(String str) {
		int n = str.length();
		int[][] dp = new int[n][n];
		int ans = Integer.MIN_VALUE;
		for (int gap = 0; gap < n; gap++) {
			int si = 0, ei = gap;
			while (ei < n) {
				if (gap == 0) {
					dp[si][ei] = 1;
				} else {
					if (str.charAt(si) == str.charAt(ei)) {
						dp[si][ei] = dp[si + 1][ei - 1] + 2;
					} else {
						dp[si][ei] = Math.max(dp[si + 1][ei], dp[si][ei - 1]);
					}
				}
				ans = Math.max(ans, dp[si][ei]);
				si++;
				ei++;
			}
		}
		System.out.println(str.length() - ans);
	}

}
