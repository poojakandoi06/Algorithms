package dpandgreedy;

public class _58CountPossibleDecodings {

	public static void main(String[] args) {
		solution("1234");
	}
	
	public static void solution(String str) {
		int[] dp = new int[str.length() + 1];
		dp[0] = dp[1] = 1;
		for(int i = 2; i < dp.length ;i++) {
			char ch = str.charAt(i - 1);
			char chm1 = str.charAt(i - 2);
			if(ch > '0') {
				dp[i] = dp[i - 1];
			}
			if(chm1 == '1' || chm1 == '2' && ch < '7') {
				dp[i] += dp[i - 2];
			}
		}
		System.out.println(dp[str.length()]);
	}

}
