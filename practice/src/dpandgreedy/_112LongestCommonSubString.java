package dpandgreedy;

public class _112LongestCommonSubString {

	public static void main(String[] args) {
		String s1 = "OldSite:GeeksforGeeks.org";
		String s2 = "NewSite:GeeksQuiz.com";
		solution(s1,s2);
			
	}

	private static void solution(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int ans = 0 ;
		for(int i = 1 ; i <= s1.length(); i++) {
			for(int j = 1 ; j <= s2.length() ;j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				ans = Math.max(ans, dp[i][j]);
			}
		}
		System.out.println(ans);
	}

}
