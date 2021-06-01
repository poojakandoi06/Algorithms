package dpandgreedy;

public class _108LargestZigZagSequence {

	public static void main(String[] args) {
		int[][] arr = { { 1,-2}, {4,1} };
		solution(arr);

	}

	public static void solution(int[][] arr) {
		int[][] dp = new int[arr.length][arr[0].length];
		int max = Integer.MIN_VALUE;
		int smax = Integer.MIN_VALUE;

		for (int i = 0; i < arr[0].length; i++) {
			if (arr[arr.length - 1][i] >= max) {
				smax = max;
				max = arr[arr.length - 1][i];
			} else if (arr[arr.length - 1][i] < max && arr[arr.length - 1][i] > smax) {
				smax = arr[arr.length - 1][i];
			}
			dp[arr.length - 1][i] = arr[arr.length - 1][i];
		}

		for (int i = arr.length - 2; i >= 0; i--) {
			int pmax = max;
			int psmax = smax;
			for (int j = arr[0].length - 1; j >= 0; j--) {
				
				if (dp[i + 1][j] != pmax) {
					dp[i][j] = arr[i][j] + pmax;
				} else {
					dp[i][j] = arr[i][j] + psmax;
				}
				
				if (dp[i][j] >= max) {
					smax = max;
					max = dp[i][j];
				} else if (dp[i][j] < max && dp[i][j] > smax) {
					smax = dp[i][j];
				}
			}
		}

		int ans = 0 ;
		for(int i = 0 ; i < arr[0].length - 1;i++) {
			ans = Math.max(ans, dp[0][i]);
		}
		System.out.println(ans);
	}

}
