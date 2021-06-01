package dpandgreedy;

public class _125MinCostOfTickets {

	public static void main(String[] args) {
		int[] days = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 };
		int[] costs = { 2, 7, 15 };
		System.out.println(solution(days, costs));

	}

	public static int minOfThree(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

	public static int solution(int[] days, int[] costs) {
		if (days.length == 1)
			return costs[0];
		int i;
		int k = 0;
		int[] dp = new int[366];
		dp[0] = 0;
		for (i = 1; i < 366; i++) {
			if (k < days.length && i == days[k] ) {
				dp[i] = minOfThree(dp[i - 1] + costs[0], i >= 7 ? (dp[i - 7] + costs[1]) : costs[1],
						i >= 30 ? (dp[i - 30] + costs[2]) : costs[2]);
				k++;
			}
			else
				dp[i] = dp[i - 1];
			
		}

		return dp[days[days.length - 1]];
	}

}
