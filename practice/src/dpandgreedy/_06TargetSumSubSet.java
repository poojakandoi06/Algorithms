package dpandgreedy;
import java.util.*;

public class _06TargetSumSubSet {
	public static void main(String[] args) {
		int[] arr  = {3, 34, 4, 12, 5, 2}; 
		int sum = 9;
		System.out.println(solution(arr,arr.length,sum));
	}

	private static boolean solution(int[] arr, int length, int sum) {
		boolean[][] dp = new boolean[arr.length + 1][sum + 1];
		for(int i = 0 ; i < dp.length ;i++) {
			dp[i][0] = true;
		}
		
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length ;j++) {
				if(dp[i - 1][j] == true) {
					dp[i][j] = true;
				}else {
					if(j - arr[i - 1] >= 0) {
						dp[i][j] = dp[i - 1][j - arr[i - 1]];
					}
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}
}
