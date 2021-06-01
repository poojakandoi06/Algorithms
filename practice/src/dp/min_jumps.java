package dp;

public class min_jumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// O(n^2) solution
	public static int minjumps(int[] arr) {
		int[] dp = new int[arr.length];
		dp[dp.length - 1] = 0;
		for (int i = dp.length - 1; i >= 0; i--) {
			if (arr[i] == 0)
				dp[i] = Integer.MAX_VALUE;
			else {
				int min = Integer.MAX_VALUE;
				for (int j = i + 1; j < arr.length && j < arr[i] + i; j++) {
					if (min > dp[j])
						min = dp[j];
				}
				if (min != Integer.MAX_VALUE)
					dp[i] = min + 1;
				else
					dp[i] = min;
			}
		}

		return dp[0];
	}

	// O(n) solution
	public static int minjumps2(int[] arr) {
		if (arr.length <= 1)
			return 0;

		if (arr[0] == 0)
			return -1;

		int maxreach = arr[0];
		int steps = arr[0];
		int jump = 1;
		for (int i = 1; i < arr.length; i++) {
			if (i == arr.length - 1)
				return jump;

			maxreach = Math.max(maxreach, i + arr[i]);

			steps--;

			if (steps == 0) {
				jump++;
				if (i >= maxreach)
					return -1;
				steps = maxreach - i;
			}
		}
		return -1;

	}

}
