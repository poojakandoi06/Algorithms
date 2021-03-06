package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class coinCHange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] denoms = { 1, 2, 3 };
		int amount = 5;
		System.out.println(coinchange2(denoms, amount));

	}

	// combination
	public static int coinchange(int[] coins, int target) {
		Arrays.sort(coins);
		int[] dp = new int[target + 1];
		ArrayList<String>[] ways = new ArrayList[target + 1];
		dp[0] = 1;
		for (int i = 0; i < ways.length; i++) {
			ways[i] = new ArrayList<String>();
		}
		ways[0].add("");
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= target; j++) {
				dp[j] += dp[j - coins[i]];
				for (String str : ways[j - coins[i]]) {
					String nstr = str + coins[i];
					ways[j].add(nstr);
				}
			}
		}
		System.out.println(ways[target]);
		return dp[target];

	}

	// permutation
	public static int coinchange2(int[] coins, int target) {
		int[] dp = new int[target + 1];
		ArrayList<String>[] ways = new ArrayList[target + 1];

		dp[0] = 1;
		for (int i = 0; i < ways.length; i++) {
			ways[i] = new ArrayList<String>();
		}
		ways[0].add("");
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j]) {
					dp[i] += dp[i - coins[j]];
					for (String str : ways[i - coins[j]]) {
						String nstr = str + coins[j];
						ways[i].add(nstr);
					}
				}
			}
		}
		System.out.println(ways[target]);

		return dp[target];
	}

}
