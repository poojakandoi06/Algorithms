package dp;

import java.util.ArrayList;

public class Combination_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3};
		int target=5;
		System.out.println(targetsum(arr,target));

	}

	// permutation
	public static int targetsum(int[] arr, int target) {
		int[] dp = new int[target + 1];
		ArrayList<String>[] ways = new ArrayList[target + 1];
		dp[0] = 1;
		for (int i = 0; i < ways.length; i++)
			ways[i] = new ArrayList<String>();
		ways[0].add("");
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] <= i) {
					dp[i] += dp[i - arr[j]];
					for(String str:ways[i-arr[j]]) {
						String nstr=str+arr[j];
						ways[i].add(nstr);
					}
				}
			}
		}
		System.out.println(ways[target]);
		return dp[target];
	}

}
