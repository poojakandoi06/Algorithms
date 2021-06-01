package dpandgreedy;

import java.util.*;

public class _48InterleavingOfTwoStrings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String a = scn.next();
		String b = scn.next();
		String c = scn.next();
		solution(a, b, c);
	}

	private static void solution(String a, String b, String c) {
		if (a.length() + b.length() != c.length()) {
			System.out.println("false");
			return;
		}
		boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];
		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				int k = i + j - 1;
				if(i == 0 && j == 0) {
					//Both A and B are empty
					dp[i][j] = true;
				}else if(i == 0) {
					// A is empty
					if(b.charAt(j - 1) == c.charAt(j - 1)) {
						dp[i][j] = dp[i][j - 1];
					}
				}else if( j == 0) {
					// B is empty
					if(a.charAt(i - 1) == c.charAt(i - 1)) {
						dp[i][j] = dp[i - 1][j];
					}
				}else {
					dp[i][j] = ((a.charAt(i - 1) == c.charAt(k)) ? dp[i-1][j] : false) || ((b.charAt(j - 1) == c.charAt(k)) ? dp[i][j-1] : false);
				}
			}
		}
		
		System.out.println(dp[dp.length - 1][dp[0].length - 1]);

	}
}
