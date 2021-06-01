package dpandgreedy;

import java.util.*;

public class _190StockBuySell2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = scn.nextInt();
		}
		System.out.print(maxProfit(prices));
	}

	public static int maxProfit(int prices[]) {
		int n = prices.length;
		int[] profit = new int[n];
		profit[n - 1] = 0;
		int maxPrice = prices[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (prices[i] > maxPrice) {
				maxPrice = prices[i];
			}
			profit[i] = Math.max(profit[i + 1], maxPrice - prices[i]);
		}
		int minPrice = prices[0];
		for (int i = 1; i < n; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}
			profit[i] = Math.max(profit[i - 1], profit[i] + prices[i] - minPrice);
		}
		return profit[n - 1];
	}
}
