package DP;

import java.util.Arrays;
import java.util.Scanner;

public class ABA12C_BuyingApples {

	public static void main(String[] args) {
		try {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0) {
		int n = s.nextInt();
		int k = s.nextInt();
		int[] arr = new int[k];
		for (int i = 0; i < k; i++)
			arr[i] = s.nextInt();
		long[] dp = new long[k + 1];
		Arrays.fill(dp, -1);
		int res=(int) dfs(arr, k, dp);
		if(res>=Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(res);
		}
		}catch(Exception e)
		{
		System.out.println(e);
		return;
		}

	}

	public static long dfs(int[] arr, int k, long[] dp) {
		if (k == 0)
			return 0;

		if (dp[k] != -1)
			return dp[k];
		long max = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if ((i + 1) <= k && arr[i] != -1) {
				max = Math.min(arr[i] + dfs(arr, k - (i + 1), dp), max);
			} else
				continue;
		}

		return dp[k] = max;
	
	}

}
