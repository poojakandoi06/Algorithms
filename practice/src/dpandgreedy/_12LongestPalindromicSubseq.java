package dpandgreedy;
import java.util.*;

public class _12LongestPalindromicSubseq {
	public static void main(String[] args) {
		String str = "aaa";
//		solution(str);
		countPalindromicSubSeq(str);
	}

	private static void solution(String str) {
		int[][] dp = new int[str.length()][str.length()];
		for(int gap = 0 ; gap < str.length(); gap++) {
			int si = 0 ;
			int ei = gap;
			while(ei < str.length()) {
				if(gap == 0) {
					dp[si][ei] = 1;
				}else {
					if(str.charAt(si) == str.charAt(ei)) {
						dp[si][ei] = dp[si + 1][ei - 1] + 2;
					}else {
						dp[si][ei] = Math.max(dp[si + 1][ei], dp[si][ei - 1]);
					}
				}
				si++;
				ei++;
			}
		}
		System.out.println(dp[0][str.length() - 1]);
	}
	
	private static void countPalindromicSubSeq(String str) {
		int n = str.length();
		int[][] dp = new int[n][n];
		for(int gap = 0; gap < n; gap++) {
			int si = 0, ei = gap;
			while(ei < n) {
				if(gap == 0) {
					dp[si][ei] = 1;
				}else {
					dp[si][ei] += dp[si][ei - 1] + dp[si + 1][ei] - dp[si + 1][ei - 1];
					if(str.charAt(si) == str.charAt(ei)) {
						dp[si][ei] += dp[si + 1][ei - 1] + 1;
					}
				}
				si++;
				ei++;
			}
		}
		System.out.println(dp[0][dp[0].length - 1]);
	}
}
