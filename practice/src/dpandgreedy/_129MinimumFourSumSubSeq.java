package dpandgreedy;

public class _129MinimumFourSumSubSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int solution(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		for(int i = 0 ; i < 4; i++) {
			dp[i] = arr[i];
		}
		for(int i = 4; i < n; i++) {
			dp[i] = arr[i] + Math.min(Math.min(dp[i - 1], dp[ i - 2]), Math.min(dp[i - 3], dp[ i - 4]));
		}
		int ans = Integer.MAX_VALUE;
		for(int i = n - 4; i < n; i++) {
			ans = Math.min(ans, dp[i]);
		}
		return ans;
	}

}
