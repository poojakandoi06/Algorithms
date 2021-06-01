package dpandgreedy;

import java.util.*;

public class _67CountDistinctSubSeq {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

	public static void solution(String str) {
		int[] previdx = new int[26];
		Arrays.fill(previdx, -1);
		int[] dp = new int[str.length() + 1];
		dp[0] = 1;
		for (int i = 1; i <= str.length(); i++) {
			dp[i] = 2 * dp[i - 1];
			if (previdx[str.charAt(i - 1) - 'a'] != -1) {
				dp[i] -= dp[previdx[str.charAt(i - 1) - 'a']];
			}
			previdx[str.charAt(i - 1) - 'a'] = i - 1;
		}

		System.out.println(dp[str.length()]);
	}

}
