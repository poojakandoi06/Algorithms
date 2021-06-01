package dpandgreedy;

public class _139NumberOfways {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void countpath(int r, int c) {
	 	 int[][] dp = new int[r][c];
	 	 for(int i = 0 ; i < dp.length; i++){
	 	     for(int j = 0; j < dp[0].length; j++ ){
	 	         if(i == 0 || j == 0){
	 	             dp[i][j] = 1;
	 	         }else{
	 	             dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
	 	         }
	 	     }
	 	 }
	 	 System.out.println(dp[dp.length - 1][dp[0].length - 1]);
	 }

}
