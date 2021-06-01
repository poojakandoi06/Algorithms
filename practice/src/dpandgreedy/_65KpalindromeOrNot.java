package dpandgreedy;
import java.util.*;

public class _65KpalindromeOrNot {

	public static void main(String[] args) {
		String str = "abcdeca";
		int k = 2;
		System.out.println(solution(str, k));
	}
	
	private static int lps(String str) {
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
		return (dp[0][str.length() - 1]);
	}
	
	public static boolean solution(String str, int k) {
		int lps = lps(str);
		return str.length() - k <= lps; 
	}

}
