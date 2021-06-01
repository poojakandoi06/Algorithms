package dpandgreedy;
import java.util.*;

public class _45SolutionOfLinearEquations {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] coeff = new int[n];
		for(int i = 0 ; i < coeff.length ; i++) {
			coeff[i] = scn.nextInt();
		}
		int rhs = scn.nextInt();
		solution(coeff, n, rhs);
	}

	private static void solution(int[] coeff, int n, int rhs) {
		int[] dp = new int[rhs + 1];
		dp[0] = 1;
		for(int i = 0 ; i < coeff.length; i++) {
			for(int j = coeff[i]; j <= rhs; j++) {
				dp[j] += dp[j - coeff[i]];
			}
		}
		System.out.println(dp[rhs]);
	}

}
