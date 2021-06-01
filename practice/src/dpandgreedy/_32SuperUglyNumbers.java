package dpandgreedy;

import java.util.*;

public class _32SuperUglyNumbers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int p = scn.nextInt();
		int[] primes = new int[p];
		for (int i = 0; i < p; i++) {
			primes[i] = scn.nextInt();
		}
		int n = scn.nextInt();
		solution(primes, p, n);
	}

	private static void solution(int[] primes, int p, int n) {
		int[] multiples = new int[p];
		int[] dp = new int[n + 1];
		dp[1] = 1;
		Arrays.fill(multiples, 1);
		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < p; j++) {
				min  = Math.min(min, primes[j] * dp[multiples[j]]);
			}
			dp[i] = min;
			for(int j = 0 ; j < p; j++) {
				if(primes[j] * dp[multiples[j]] == min) {
					multiples[j]++;
				}
			}
		}
		System.out.println(dp[n]);
	}

}
