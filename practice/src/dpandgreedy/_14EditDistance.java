package dpandgreedy;

import java.util.*;

public class _14EditDistance {

	public static void main(String[] args) {
		String str1 = "sunday";
		String str2 = "saturday";
		solution(str1, str2);
	}

	public static void solution(String str1, String str2) {
		int n1 = str1.length();
		int n2 = str2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];
		for (int i = 0; i <= n1; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= n2; i++) {
			dp[0][i] = i;
		}
		
		for(int i = 1; i <= n1; i++) {
			for(int j = 1; j <= n2; j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				}else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][ j - 1])) + 1;
				}
			}
		}
		System.out.println(dp[n1][n2]);
	}

}
