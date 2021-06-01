package dpandgreedy;

public class _148PathsToReachOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 private static int countPaths(int n, int m) {
 	 	 int[][] dp = new int[n + 1][m + 1];
 	 	 for(int i = 0; i <= n; i++){
 	 	     for(int j = 0 ; j <= m; j++){
 	 	         if(i == 0 && j == 0){
 	 	             dp[i][j] = 0;
 	 	         }else if(i == 0 || j == 0){
 	 	             dp[i][j] = 1;
 	 	         }else{
 	 	             dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
 	 	         }
 	 	     }
 	 	 }
 	 	 return dp[n][m];
 	 }

}
