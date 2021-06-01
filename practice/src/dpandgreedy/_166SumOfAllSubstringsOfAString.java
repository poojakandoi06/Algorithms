package dpandgreedy;

import java.util.*;

public class _166SumOfAllSubstringsOfAString {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String n = scn.next();
		long res = sumOfSubstrings(n);
		System.out.println(res);

	}

	public static long sumOfSubstrings(String str) {
		int n = str.length();
		long[] dp = new long[n];

		dp[0] = str.charAt(0) - '0';
		long ans = dp[0];
		for (int i = 1; i < n; i++) {
			long no = (long) (str.charAt(i) - '0');
			dp[i] = ((i + 1) * no) + (10 * dp[i - 1]);
			ans += dp[i];
		}
		return ans;
	}

}
