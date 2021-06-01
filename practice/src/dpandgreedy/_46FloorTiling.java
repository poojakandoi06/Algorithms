package dpandgreedy;

import java.util.*;

public class _46FloorTiling {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-- > 0) {
			int n = scn.nextInt();
			int m = scn.nextInt();
			int[] dp = new int[n + 1];
			dp[1] = 1;
			for(int i = 2; i <= n ; i++) {
				if(i == m)
				dp[i] = 2;
				else if(i > m)
					dp[i] = dp[i - 1] + dp[i - m];
				else
					dp[i] = dp[i - 1];
			}
			System.out.println(dp[n]);
		}
	}

}
