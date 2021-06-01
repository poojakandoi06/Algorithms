package dpandgreedy;
import java.util.*;

public class _ClimbStairs {
	public static void main(String args[]) {
		solution(4);
	}
	
	public static void solution(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for(int i = 2 ; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(dp[n]);
	}
}
