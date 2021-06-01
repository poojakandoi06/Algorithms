package dpandgreedy;

import java.util.*;

public class _189StockBuySellWithTransaction {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = scn.nextInt();
		}
		int fee = scn.nextInt();
		System.out.print(maxProfit(prices, fee));
	}

	public static int maxProfit(int[] prices, int fee) {
		if (prices.length < 2)
			return 0;

		// meaning - buy[i]:
		// what is the max profit that for subarray [0, i] where
		// the operations end with a buy
		int[] buy = new int[prices.length];
		buy[0] = 0 - prices[0];

		// meaning - sell[i]:
		// what is the max profit that for subarray [0, i] where
		// the operations end with a sell
		int[] sell = new int[prices.length];

		for (int i = 1; i < prices.length; ++i) {
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
			buy[i] = Math.max(buy[i - 1], 0 - prices[i] + sell[i - 1]);
		}

		return sell[prices.length - 1];
	}
}
