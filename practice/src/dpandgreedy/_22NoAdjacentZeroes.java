package dpandgreedy;

import java.util.Scanner;

public class _22NoAdjacentZeroes {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println(solution(scn.nextInt()));
	}

	public static int solution(int n) {
		int zero = 0;
		int one = 1;
		for (int i = 1; i <= n; i++) {
			int temp = zero;
			zero = one;
			one += temp;
		}
		return zero + one;
	}
}
