package dpandgreedy;
import java.util.*;

public class _70HighwayBillBoard {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
	}
	
	public static void solution(int m , int[] x, int[] rev, int t) {
		int[] dp = new int[m + 1];
		int j = 0;
		for(int i = 1; i <= m; i++) {
			if(x[i] == j) {
				dp[i] = Math.max(dp[i - 1], dp[i - t - 1]) + rev[j];
				j++;
			}else {
				dp[i] = dp[ i - 1];
			}
		}
	}

}
