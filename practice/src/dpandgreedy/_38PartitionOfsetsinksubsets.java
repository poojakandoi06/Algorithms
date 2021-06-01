package dpandgreedy;
import java.util.*;

public class _38PartitionOfsetsinksubsets {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		solution(n,k);
	}

	private static void solution(int n, int k) {
		int[][] dp = new int[k + 1][n + 1];
		for(int j = 0 ; j <= n; j++) {
			dp[1][j] = 1;
		}
		for(int i = 2; i <= k; i++) {
			for(int j = i; j <= n; j++) {
				dp[i][j] = dp[i - 1][j - 1] + (i) * dp[i][j - 1];
			}
		}
		System.out.println(dp[k][n]);
	}

}
