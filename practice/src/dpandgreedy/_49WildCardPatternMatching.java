package dpandgreedy;

import java.util.*;

public class _49WildCardPatternMatching {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = "baaabab";
		String pattern = "*a?a?";
		solution(str, pattern);
	}

	private static void solution(String str, String pattern) {
		boolean[][] dp = new boolean[pattern.length() + 1][str.length() + 1];
		for(int i = dp.length - 1; i >= 0 ;i--) {
			for(int j = dp[0].length - 1; j >= 0; j--) {
				if(i == dp.length - 1 && j == dp[0].length - 1) {
					dp[i][j] = true;
				}else if(i == dp.length - 1) {
					dp[i][j] = false;
				}else if(j == dp[0].length - 1) {
					if(pattern.charAt(i) == '*') {
						dp[i][j] = dp[i + 1][j];
					}
				}else {
					if(pattern.charAt(i) == '?') {
						dp[i][j] = dp[i + 1][j + 1];
					}else if(pattern.charAt(i) == '*') {
						dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
					}else if(pattern.charAt(i) == str.charAt(j)) {
						dp[i][j] = dp[i + 1][j + 1];
					}else {
						dp[i][j] = false;
					}
				}
			}
		}
		
		System.out.println(dp[0][0]);
	}

}
