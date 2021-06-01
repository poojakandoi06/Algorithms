package dpandgreedy;

import java.util.*;

public class _37PartitionInTwoSets {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			solution(arr, n);
		}
	}

	private static void solution(int[] arr, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		if (sum % 2 != 0) {
			System.out.println("NO");
			return;
		}

		boolean[][] dp = new boolean[n + 1][(sum / 2) + 1];
		dp[0][0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum / 2; j++) {
				dp[i][j] = dp[i - 1][j];
				if (dp[i][j] == false && j - arr[i - 1] >= 0) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]];
				}
			}
		}
		if(dp[dp.length - 1][dp[0].length - 1]) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

}
