package dpandgreedy;

import java.util.Arrays;

public class _123MinimalMovesToFormAString {

	public static void main(String[] args) {
		String str = "aaaaaaaa";
		solution(str, str.length());

	}
	
	public static void solution(String str, int n) {
		int[] dp = new int[n];
		
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 1;
		for(int i = 1; i < n; i++) {
			if(2 * i <= n && str.substring(0,i).equals(str.substring(i, 2 * i))) {
				dp[2 * i - 1] = Math.min(dp[i - 1] + 1, dp[2 * i - 1] + 1);
			}
			dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
		}
		System.out.println(dp[n - 1]);
	}

}
