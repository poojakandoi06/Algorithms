package dpandgreedy;

public class _11lcs {
	public static void main(String[] args) {
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		lcs(str1,str2);	
	}

	private static void lcs(String str1, String str2) {
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[dp.length - 1][dp[0].length - 1]);
		
	}
	
}
