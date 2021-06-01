package dpandgreedy;
import java.util.*;

public class _54FindWaterInGlass {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();
		int i = scn.nextInt();
		int j = scn.nextInt();
		solution(tc,i,j);
	}

	private static void solution(int tc, int row, int col) {
		double[][] dp = new double[row + 1][col + 1];
		dp[1][1] = tc;
		for(int i = 1 ; i <= row; i++) {
			for(int j = 1; j <= col; j++) {
				if(i < row && dp[i][j] > 1) {
					// calculate spare
					double spare = dp[i][j] - 1;
					dp[i][j] = 1;
					dp[i + 1][j] = spare / 2.0;
					dp[i + 1][j + 1] = spare / 2.0;
					
				}
			}
		}
		System.out.println(dp[row][col] > 1 ? 1 : dp[row][col]);
	}

}
