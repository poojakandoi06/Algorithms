package dpandgreedy;
import java.util.*;

public class _31UglyNumbers {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		solution(n);
	}

	private static void solution(int n) {
		int[] dp = new int[n + 1];
		int p2 = 1, p3 = 1, p5 = 1;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			int min = Math.min(2 * dp[p2], Math.min(3 * dp[p3], 5 * dp[p5]));
			dp[i] = min;
			if(min == 2 * dp[p2]) {
				p2++;
			}
			if(min == 3 * dp[p3]) {
				p3++;
			}
			if(min ==  5 * dp[p5]) {
				p5++;
			}
		}
		System.out.println(dp[n]);
	}
}
