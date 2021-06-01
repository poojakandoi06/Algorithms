package dpandgreedy;

import java.util.*;

public class _04MInCostPath {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		int dr = scn.nextInt();
		int dc = scn.nextInt();
		solution(arr, n, dr, dc);
	}

	private static void solution(int[][] arr, int n, int dr, int dc) {
		int[][] dp = new int[dr + 1][dc + 1];
		for(int r = dr; r >= 0;r--) {
			for(int c = dc; c >= 0; c--) {
				if(c == dc && r == dr) {
					dp[dr][dc] = arr[dr][dc];
				}else if(r == dr) {
					dp[r][c] = dp[r][c + 1] + arr[r][c];
				}else if(c == dc) {
					dp[r][c] = dp[r + 1][c] + arr[r][c];
				}else {
					dp[r][c] = arr[r][c] + Math.min(dp[r + 1][c], dp[r][c + 1]);
				}
			}
		}
		System.out.println(dp[0][0]);
	}

}
