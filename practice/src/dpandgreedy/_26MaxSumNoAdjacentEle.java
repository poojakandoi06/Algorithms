package dpandgreedy;

public class _26MaxSumNoAdjacentEle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,2,3};
		System.out.println(solution(arr));
	}

	public static int solution(int[] arr) {

		int[][] dp = new int[2][arr.length];
		dp[0][0] = arr[0];
		dp[1][0] = 0;

		for (int i = 1; i < arr.length; i++) {

			dp[0][i] = dp[1][i - 1] + arr[i];
			dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1]);

		}

		return Math.max(dp[0][arr.length - 1], dp[1][arr.length - 1]);
		
	}

}
