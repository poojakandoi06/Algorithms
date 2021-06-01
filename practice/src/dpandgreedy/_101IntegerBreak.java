package dpandgreedy;

public class _101IntegerBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void solution(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 0;
        dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int lo = 1;
			int hi = i - 1;

			while (lo <= hi) {
				dp[i] = Math.max(dp[i], Math.max(lo * hi, lo * dp[hi]));
				lo++;
				hi--;
			}
		}
		System.out.println(dp[n]);
	}

}
