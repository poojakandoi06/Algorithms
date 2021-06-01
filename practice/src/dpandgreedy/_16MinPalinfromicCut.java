package dpandgreedy;

import java.util.*;

public class _16MinPalinfromicCut {

	public static void main(String[] args) {
		solution("abccbc");
	}

	public static void solution(String s) {
		boolean[][] dp1 = new boolean[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			int si = 0, ei = gap;
			while (ei < s.length()) {
				if (gap == 0) {
					dp1[si][ei] = true;
				} else if (gap == 1) {
					dp1[si][ei] = s.charAt(si) == s.charAt(ei);
				} else {
					if (s.charAt(si) == s.charAt(ei)) {
						dp1[si][ei] = dp1[si + 1][ei - 1];
					} else {
						dp1[si][ei] = false;
					}
				}
				si++;
				ei++;
			}
		}

		int[][] dp = new int[s.length()][s.length()];
		for (int gap = 0; gap < s.length(); gap++) {
			int si = 0, ei = gap;
			while (ei < s.length()) {
				if (gap == 0) {
					dp[si][ei] = 0;
				} else if (gap == 1) {
					dp[si][ei] = s.charAt(si) == s.charAt(ei) ? 0 : 1;
				} else {
					if (dp1[si][ei]) {
						dp[si][ei] = 0;
					} else {
						dp[si][ei] = Integer.MAX_VALUE;
						for (int cp = si; cp < ei; cp++) {
							dp[si][ei] = Math.min(dp[si][ei], dp[si][cp] + dp[cp + 1][ei]);
						}
						dp[si][ei] += 1;
					}
				}
				si++;
				ei++;
			}
		}
		
		System.out.println(dp[0][dp[0].length - 1]);
	}

}
