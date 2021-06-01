package dpandgreedy;
import java.util.*;

public class _09UnboundedKnapsack {
	public static void main(String[] args) {
		int[] weights = { 10, 20, 30 };
		int[] prices = { 60, 100, 120 };
		int capacity = 50;
		solution(weights, prices, capacity);
	}

	// just like coin change combinbations
	private static void solution(int[] weights, int[] prices, int capacity) {
		int[] dp = new int[capacity + 1];
		for(int i = 0 ;i <= capacity; i++) {
			for(int j = 0 ; j < weights.length; j++) {
				if(weights[j] <= i) {
					dp[i] = Math.max(dp[i], dp[i - weights[j]] + prices[j]);
				}
			}
		}
		System.out.println(dp[capacity]);
	}
}
