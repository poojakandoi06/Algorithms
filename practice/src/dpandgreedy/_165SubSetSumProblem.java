package dpandgreedy;

public class _165SubSetSumProblem {

	public static void main(String[] args) {
		

	}
	
	public static boolean solution(int[] arr) {
		
		int sum = 0;
		for(int i = 0; i < arr.length ;i++) {
			sum += arr[i];
		}
		if(sum % 2 != 0) {
			return false;
		}
		int tar = sum / 2;
		boolean[][] dp = new boolean[arr.length + 1][tar + 1];
		
		for(int i = 0 ; i < dp.length ;i++) {
			dp[i][0] = true;
		}
		
		for(int i = 1; i < dp.length ; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i - 1][j];
				if(dp[i][j] == false && j - arr[i - 1] >= 0) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]];
				}
			}
		}
		
		return dp[dp.length - 1][dp[0].length - 1];
	}

}
