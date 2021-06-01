package dpandgreedy;
import java.util.*;

public class _147PathInMAtrix {

	public static void main(String[] args) {
		 Scanner scn = new Scanner(System.in);
	 	 	 int size = scn.nextInt();
	 	 	 int[][] mat = new int[size][size];
	 	 	 for (int i = 0; i < mat.length; i++) {
	 	 	 	 for (int j = 0; j < mat[0].length; j++) {
	 	 	 	 	 mat[i][j] = scn.nextInt();
	 	 	 	 }
         }
         pathInMat(mat, size);

	}

	static void pathInMat(int[][] arr, int size) {
		int[][] dp = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == 0) {
					dp[i][j] = arr[i][j];
				} else if (j == 0) {
					dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j + 1]);
				} else if (j == dp[0].length - 1) {
					dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
				} else {
					dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j], Math.max(dp[i - 1][j + 1], dp[i - 1][j - 1]));
				}
			}
		}
		int ans = Integer.MIN_VALUE;
	 	 for(int i = 0 ; i < dp[0].length; i++){
	 	     ans = Math.max(ans,dp[dp.length - 1][i]);
	 	 }
	 	 System.out.println(ans);
	}

}
