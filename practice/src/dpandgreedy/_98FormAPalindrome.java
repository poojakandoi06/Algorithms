package dpandgreedy;

public class _98FormAPalindrome {

	public static void main(String[] args) {
		String str = "geeks";
		System.out.println(solution(str));
			
	}
	
	public static int solution(String str) {
		int n = str.length();
		int[][] dp = new int[n][n];
		for(int gap = 0 ; gap < n; gap++) {
			int si = 0, ei = gap;
			while(ei < n) {
				if(gap == 0) {
					dp[si][ei] = 0;
				}else{
					if(str.charAt(si) == str.charAt(ei)) {
						dp[si][ei] = dp[si + 1][ei - 1];
					}else {
						dp[si][ei] = Math.min(dp[si + 1][ei], dp[si][ei - 1]) + 1;
					}
				}
				si++;
				ei++;
			}
		}
		return dp[0][dp[0].length - 1];
	}

}
